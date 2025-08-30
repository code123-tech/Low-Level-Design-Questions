### Index
1. [What is Traffic Signal System](#what-is-traffic-signal-system)
2. [Let's understand a basic operations / Requirements](#lets-understand-a-basic-operations--requirements)
3. [Questions (With scope of improvement)](#questions-with-scope-of-improvement)
4. [Models/Entities](#modelsentities)
5. [Diagrams](#diagrams)
    * [Class Diagram](#class-diagram)
    * [State Flows](#state-flows)

### What is Traffic Signal System
A concurrent traffic-signal controller that coordinates multiple intersections ("circles"). Each circle alternates right-of-way between North/South and East/West using the State pattern at two levels:
- Circle-level states toggle which pair of directions gets the green phase.
- Per-signal light states model RED → GREEN → YELLOW transitions.

### Let's understand a basic operations / Requirements
- Manage multiple circles with independent timings.
- For each circle: grant GREEN to one pair (N/S or E/W), others RED.
- Respect configured durations for GREEN and YELLOW per circle.
- Transition lights deterministically using state machines.
- Start/stop all circles concurrently and shutdown gracefully.

### Questions (With scope of improvement)
- Dynamic/adaptive timing based on traffic density and time-of-day.
- Pedestrian crossings and protected turns (e.g., dedicated left-turn phases).
- Emergency vehicle preemption and priority rules across adjacent circles.
- Fault tolerance (node failure, clock skew) and centralized coordination.
- Simulation clock abstraction for deterministic testing (avoid `Thread.sleep`).

### Models/Entities
- `TrafficSignalController` (singleton):
  - Holds a list of `CircleContext`.
  - Starts circles via a fixed thread pool; stops with graceful shutdown.

- `CircleContext` (Runnable):
  - Fields: `id`, `Map<TrafficSignalDirection, TrafficLightContext> trafficSignals`, `greenLightDuration`, `yellowLightDuration`.
  - State machine via `ICircleState currentState`:
    - `NorthSouthGreenState` → `EastWestGreenState` toggling which pair is GREEN.
    - Each state drives per-direction `TrafficLightContext` and sleeps according to durations.

- `TrafficLightContext`:
  - Fields: `TrafficSignalDirection direction`, `int circleId`, `LightColor currentColor`, `ITrafficLightState currentState`, `ITrafficLightState nextState`.
  - Methods: `startGreenLight()`, `transitionToNextState()`, `setCurrentColor(LightColor)`, `setNextState(ITrafficLightState)`.
  - Per-light State pattern:
    - `RedLightState`, `GreenLightState`, `YellowLightState` implement `ITrafficLightState` and set `currentColor` and `nextState`.

- Enums:
  - `TrafficSignalDirection`: `NORTH`, `SOUTH`, `EAST`, `WEST`.
  - `LightColor`: `RED`, `GREEN`, `YELLOW`.

### Diagrams
##### Class Diagram
```mermaid
classDiagram
  direction LR

  class TrafficSignalController {
    - List<CircleContext> circles
    - ExecutorService executorService
    + static TrafficSignalController getInstance()
    + void addCircle(int, long, long)
    + void startTrafficSignal()
    + void stopTrafficSignal()
  }

  class CircleContext {
    - int id
    - Map<TrafficSignalDirection, TrafficLightContext> trafficSignals
    - long greenLightDuration
    - long yellowLightDuration
    - ICircleState currentState
    + void setState(ICircleState)
    + void state()
    + void stop()
    + TrafficLightContext getTrafficLight(TrafficSignalDirection)
  }

  class ICircleState {
    <<interface>>
    + void handleChange(CircleContext)
  }
  class NorthSouthGreenState
  class EastWestGreenState

  class TrafficLightContext {
    - TrafficSignalDirection direction
    - int circleId
    - LightColor currentColor
    - ITrafficLightState currentState
    - ITrafficLightState nextState
    + void startGreenLight()
    + void transitionToNextState()
    + void setCurrentColor(LightColor)
    + void setNextState(ITrafficLightState)
  }

  class ITrafficLightState {
    <<interface>>
    + void handleChange(TrafficLightContext)
  }
  class RedLightState
  class GreenLightState
  class YellowLightState

  class TrafficSignalDirection {
    <<enum>> NORTH, SOUTH, EAST, WEST
  }
  class LightColor {
    <<enum>> RED, GREEN, YELLOW
  }

  TrafficSignalController o--> CircleContext : manages[]
  CircleContext *-- ICircleState : currentState
  ICircleState <|.. NorthSouthGreenState : implements
  ICircleState <|.. EastWestGreenState : implements

  %% CircleContext --> "Map<Direction, TrafficLightContext>" : trafficSignals
  TrafficLightContext --> TrafficSignalDirection
  TrafficLightContext --> LightColor
  TrafficLightContext *-- ITrafficLightState : currentState
  ITrafficLightState <|.. RedLightState : implements
  ITrafficLightState <|.. GreenLightState : implements
  ITrafficLightState <|.. YellowLightState : implements
```

##### State Flows
Per-light state machine:
```mermaid
stateDiagram-v2
  [*] --> Red
  Red --> Green: startGreenLight()
  Green --> Yellow: transitionToNextState()
  Yellow --> Red: transitionToNextState()
```

Circle-level coordination:
```mermaid
stateDiagram-v2
  [*] --> NorthSouthGreen
  
  NorthSouthGreen --> EastWestGreen: after green+yellow
  note right of NorthSouthGreen
    N,S = GREEN
    E,W = RED
  end note

  EastWestGreen --> NorthSouthGreen: after green+yellow
  note right of EastWestGreen
    E,W = GREEN
    N,S = RED
  end note
```

##### Sequence Diagram
```mermaid
sequenceDiagram
  autonumber
  actor Main
  participant Controller as TrafficSignalController
  participant Circle as CircleContext
  participant NS as NorthSouthGreenState
  participant EW as EastWestGreenState
  participant T_N as TrafficLightContext(NORTH)
  participant T_S as TrafficLightContext(SOUTH)
  participant T_E as TrafficLightContext(EAST)
  participant T_W as TrafficLightContext(WEST)

  Main->>Controller: getInstance()
  Main->>Controller: addCircle(1, greenMs, yellowMs)
  Main->>Controller: startTrafficSignal()
  Controller->>Circle: start (submit/run)

  loop continuous until stop
    Circle->>NS: handleChange()
    NS->>T_N: startGreenLight()
    NS->>T_S: startGreenLight()
    NS->>T_E: setCurrentColor(RED)
    NS->>T_W: setCurrentColor(RED)
    Note right of NS: wait greenMs
    NS->>T_N: transitionToNextState() (YELLOW)
    NS->>T_S: transitionToNextState() (YELLOW)
    Note right of NS: wait yellowMs
    NS->>T_N: transitionToNextState() (RED)
    NS->>T_S: transitionToNextState() (RED)
    NS->>Circle: setState(EastWestGreenState)

    Circle->>EW: handleChange()
    EW->>T_E: startGreenLight()
    EW->>T_W: startGreenLight()
    EW->>T_N: setCurrentColor(RED)
    EW->>T_S: setCurrentColor(RED)
    Note right of EW: wait greenMs then yellowMs
    EW->>T_E: transitionToNextState() (YELLOW -> RED)
    EW->>T_W: transitionToNextState() (YELLOW -> RED)
    EW->>Circle: setState(NorthSouthGreenState)
  end

  Main->>Controller: stopTrafficSignal()
  Controller->>Circle: stop()
```


