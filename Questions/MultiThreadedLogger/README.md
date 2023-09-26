#### Requirements of Multithreaded Logger 
1. The Logger System should support different logging levels like error, info, debug, warning pointing to different logging mediums
    File Based logging, DB logging, network logs etc.
2. Use Producer and Consumer to publish and consume to the queue simultaneously.
3. An application level message can support multiple logging mediums at a time.

#### Needed
- We need a queue service to handle operations of blocking Queue.
- We need producers and consumers which implements runnable interfaces.
- we need two types of messages
  
    - Application Level Messages generated by application with multiple logging medium supported. - ApplicationGeneratedMessage
    - Messages that are written to respective logging Mediums. - PrintableMessage

#### Elements
- ArrayBlockingQueue<?> to produce and consume tasks asynchronously, it's a fixed-sized array holds elements inserted by 
producers and extracted by consumers.
- Executors to create a thread pool of size 100 for producers and consumers. [Understand Executors from here](https://github.com/code123-tech/Basics_Java_With_OOP_Concepts/blob/main/Concurrency/ExecutorsHansOn.java)
- ApplicationGeneratedMessage: Supports for application to generate message with multiple Mediums supported.
- PrintableMessage: the message holds level, medium, applicationGeneratedMessage object and this printableMessage gets 
produced and printed/consumed by arrayBlockingQueue.
- QueueService: deals with ArrayBlockingQueue operations, publish and consume.
- InternalLogger: to log the printableMessage.
- ApplicationConstants/DEFAULT_PUBLISH_TIMEOUT_MS: the time for each, the arrayBlockingQueue waits to push element into queue
if queue is full, and waits for queue to be freed for this time.
- ApplicationConstants/DEFAULT_CONSUME_TIMEOUT_MS: if queue is empty, waits for this timeout that during this wait time, any new 
element is pushed or not.