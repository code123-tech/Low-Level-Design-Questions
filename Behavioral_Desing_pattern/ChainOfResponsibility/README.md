- It is one of the useful Behavioural Design Pattern.
- It is based on Chain of Objects, means objects are present in form of chain. It's like linked list, where a node has current
    element, and next element. If current Chain object does not fulfill the request, process goes for next object in the chain.
- This pattern becomes useful when a process needs to go from a chain of operations until and unless an operation fulfills the 
  request.
- This pattern promotes loose coupling and allows you to build a flexible and extensible processing pipeline.
- For example, In Spring's Security Filter chain, when request comes, it goes through multiple chain of filter objects, and 
    each filter validate the request, and stops if validation goes wrong.


    Request ---------------------->  HandlerInterface/HandlerAbstractClass
    HandlerInterface/HandlerAbstractClass   -----------------Implemented By -----------> ConcreteHandler1, ConcreteHandler2,...etc.


#### Key components of the Chain of Responsibility pattern include:
1. _**Handler:**_ An abstract or interface representing a handler in the chain. It defines a method to handle requests and has a 
reference to the next handler in the chain.
2. _**Concrete Handler:**_ Concrete classes that implement the Handler interface. Each concrete handler has a specific 
responsibility and can either handle a request or pass it to the next handler in the chain.
3. **_Client:_** The object or system that generates requests and sends them to the first handler in the chain.


The Chain of Responsibility design pattern is most appropriate to use when you have a processing pipeline or a chain of handlers, and you want to decouple the sender of a request from its receiver. It is useful in various scenarios, especially when you need to handle requests or events with multiple handlers or processors in a flexible and extensible way.
#### Here are some conditions and use cases where the Chain of Responsibility principle is particularly beneficial:
1. **_Multiple Handlers:_** When you have a series of handlers or processors, and you want to pass a request through each handler until one of them can handle it. This is common in scenarios where you have a sequence of processing steps, such as data validation, authentication, authorization, and so on.
2. _**Dynamic Order of Handling:**_ When the order or number of handlers that need to process a request can change dynamically at runtime. With the Chain of Responsibility pattern, you can easily add, remove, or reorder handlers without modifying the client code.
3. _**Loose Coupling:**_ When you want to minimize the coupling between the sender of a request (client code) and its receivers (handlers). This promotes flexibility and makes it easier to maintain and extend the system.
4. _**Error Handling:**_ When you want to handle errors or exceptions in a graceful and structured manner. Each handler can choose to handle an error or pass it to the next handler, allowing for different error-handling strategies.
5. _**Middleware and Filters:**_ In web development, the Chain of Responsibility pattern is commonly used in middleware and filter pipelines. Each middleware component can process an HTTP request and response and choose to continue processing or stop the request/response flow.
6. _**Event Handling:**_ When dealing with events in GUI frameworks or event-driven systems, the Chain of Responsibility can be used to process events through a series of event handlers or listeners.
7. _**Logging and Monitoring:**_ In logging and monitoring systems, different log processors can be organized as a chain. Each processor can decide whether to log the message, transform it, or pass it to the next processor in the chain.
8. _**Workflow and State Machines:**_ In workflow or state machine implementations, different states or transitions can be handled by a chain of state handlers.

It's important to note that the Chain of Responsibility pattern may not always be the best choice. It should be used when there is a clear need for a chain of handlers with dynamic processing order. In some cases, simpler alternatives like a switch statement or a conditional chain of if-else statements may be more appropriate. The choice of pattern depends on the specific requirements of your application and the complexity of the processing logic.