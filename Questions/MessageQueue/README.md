### What is Message Queue, and its applications?
* Message Queue (It's not a Data Structure) is a kind of data structure or medium which takes messages (Publishing of messages 
to queue), and those messages are read by others (can be some service/consumer/subscriber).
* These are based on very famous model known as Published-Subscriber Model (Pub-Sub Model). 
* Message queue are based on producer and consumer, producer responsible for publishing messages to queue, and consumer are for
  consuming messages from the queue.
* Message Queue can be of
  * One-to-One communication or Point-to-Point Communication: Here Each message is processed only once by a single consumer only.
  * When Multiple consumer consumes a single message, it means multiple consumer are subscriber to receive that message, so we 
  can consider this Message queue as Pub-Sub Messaging System.

### Requirements
Now, Let's go through some requirements of Message Queue.
* Message Queue should support topic based system, where a topic cam be created.
* Multiple Messages can be published to a single topic (Publisher).
* Consumer should be able to subscribe to a topic, so that whenever a new message arrives to a topic, that message can be sent to
    all the consumers who have subscribed to that topic.
* Consumers/Subscriber should run in Parallel to achieve concurrency for a better performance of the application.
* We can reset the offset for a subscriber and subscriber would start reading messages from that offset (Replay of messages).

### Questions (With Scope of improvement)
* Since Consumers are reading Messages Parallel, it doesn't mean if we have thousands consumers, they can go parallel. We can't
create thousands threads. Should we use a thread-pool and restrict application to use this amount of threads only, and internally
thread-pool manages tasks asynchronously?    
* Is it like queue can be full or out of size? If it is, what should happen if user wants to create a new topic or 
want to publish a new Message?
* Currently, can I assume that we are publishing string type of messages? If it is, what could be the upper limit of message size?
* What is upper limit for number of subscriber for each topic? is this upper limit same for all the topic, or it differs topic-wise?

### Possible Use cases
* creates a topic --> createTopic()
* Publisher publishes message to topic.  --> publishToTopic()
* Subscriber subscribes to topic.  ---> subscribeToTopic()
* All subscriber receives messages as soon as publisher publishes message to particular topic.
* reset offset for the given subscriber for the topic. --> resetOffsetForSubscriber()

### Models/Entities
* Topic
* Message
* TopicSubscriberRelation --> to show subscriber of the topic, and offset for that subscriber for the topic.
* Publisher  (Not needed actually as currently we ourselves are producing messages and publishing)
* Subscribers/SleepSubscriberImpl  --> (Subscriber)



