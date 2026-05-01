# Low-Level-Design-Questions — Claude Guide

LLD problems, design patterns, and SOLID principles — all in Java.

## Structure

```
Behavioral_Desing_pattern/     # (sic) — preserve folder spelling
creational_Desing_pattern/     # (sic) — preserve folder spelling
Structural_Desing_pattern/     # (sic) — preserve folder spelling
SOLID_PRINCIPALS/              # (sic) — preserve folder spelling
Questions/                     # LLD interview problems
```

**Do not rename these folders.** The root `README.md` and other docs link to them by their current names.

## Completed-question layout (the template to mirror)

Look at `Questions/SplitWise/` and `Questions/ElevatorSystem/` as the canonical structure:

```
Questions/<QuestionName>/
├── README.md                  # Requirements, models, UML (see format below)
├── <QuestionName>UML.png      # or UML.jpg
├── Main.java OR <Name>Controller.java   # Entry point / driver
├── controller/                # Orchestration classes
├── model/  or  models/        # Domain entities
├── enums/                     # Enum types
├── Factory/                   # Factories if used
├── strategies/                # Strategy implementations if used
└── Dispatchers/               # Dispatchers/handlers if used
```

Not every question needs every sub-folder — include what the problem requires.

## README format for a question

Mirror `Questions/SplitWise/README.md`. Minimum sections:

1. `### Index` — linked ToC
2. `### What is <Name>?` — one-paragraph description
3. `### Let's understand a basic operations / Requirements` — numbered list of functional requirements
4. `### Questions (With Scope of improvement)` — bullet list of extensions
5. `### Models/Entities` — bullet list of classes/enums
6. `### Diagrams` → `##### UML Diagram` → embedded UML image

## Status table in root README

When a question transitions between states, update `README.md`:
- Not started: `&#9744;`
- In progress: `:construction:`
- Completed: `:white_check_mark:`

## Design pattern folder layout

Mirror `Behavioral_Desing_pattern/Observer/`:
```
<PatternName>/
├── README.md
├── Main.java              # Runnable demo
├── <SupportingClasses>/   # Package folders for the pattern's roles
└── <Diagram>.png          # Optional pattern diagram
```

## Code style

- Java, plain — no framework dependencies unless the problem requires one.
- One public class per file. Package declarations match folder path where used.
- Keep `main` small — it should read like a script that exercises the design.
- Favor interfaces + strategy/factory over `if/else` chains (the point of these exercises).

## Helpers

- Scaffolding a new question? Use the `lld-question-scaffolder` skill or run `/new-lld <Name>`.
- Checking progress across all questions? Run `/status-report`.

## Cross-repo links

- Java fundamentals → `../Basics_Java_With_OOP_Concepts/`
- System-design equivalents → `../High-Level-Design/Questions/`
