Google Calendar 

#### Requirements of Google Calendar
1. We need producer to generate messages and pass it to given topic name.
2. Consumer can consume message from single topic, although consumer within a group can consume from multiple partitions, but
   at a time consume from one partition.
3. ConsumerGroup can have multiple consumers.
4. Single Consumer maps to Single Partition.