- Singleton Pattern is one of the useful creational design pattern which ensures that a class can have only one instance, and that
    one instance is used all over the project, no other instance creation is allowed for that class.
Ex: In Our Projects, we are allowed to create/use only one instance of the DBConnection Instance to interact with DB. It is not like
    for each db interaction, a new db instance is being created. 
    Similarly, for some helper classes also, we need only one instance of those helper classes. Helper classes can be like 
    EventObjectCreationHelper, Algorithms etc.

It solves two problem:
1. Generally, it changes the class design in such a way that even you want to create multiple instance of class, each time it 
    will return same instance only.
2. It provides global access point to that instance.

**Steps to create Builder Pattern**
1. Make class constructor private, so that it can't be accessed, and client can't create instance of a class. 
2. create a static method inside class, which will be getInstance() of the class, and keep a static field which is instance of 
    the class itself.
   1. Very first time on calling method, the above field is null, so create instance of the class and return it.
   2. now if second time, it being called again, if it is not null, we do not create instance of the class again.

- The above state has problem, if multiple threads are trying to access the class very first time, and it may be possible
    that for each thread a new instance of the class will be created, which will break this design pattern.

Learn more of this pattern here. [Learn More here](https://refactoring.guru/design-patterns/singleton)
