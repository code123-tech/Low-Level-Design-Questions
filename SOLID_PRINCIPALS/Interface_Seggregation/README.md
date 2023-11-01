===Interface Segregation Principle===
The Principle states "Interfaces should be so grained that client should not be forced to implement interface, even client
does not want to use it."

Suppose, You have a project which is responsible for making shapes on the screen, whatever shape you give as input.
Interface IShape has four methods => drawCircle(), drawSquare(), drawOval() etc.
Now, Circle class implements above interface, which only want to implement drawCircle(), but need to implement two extra methods
drawSquare, and drawOval.
Similarly, goes for Square class, and Oval class.
Problem is, if suppose we introduced a method, drawTriangle(). Now client need to implement this method also in each
of class where the IShape interface is implemented.


So, Here Interface Segregation principle breaks, so we will create interface for each shape.

ICircleShape
ISquareShape
IOvalShape
ITriangleShape
now each will be implemented by its own respective class.

### Pros of Using the Interface Segregation Principle
- Using this principle, the code structure becomes modular where behavior/operations are categorized with the help of an 
  interface and further implemented by their own classes.
- It reduces coupling as a client does need not implement unwanted methods in the implementation classes.

### Cons of Using the Interface Segregation Principle
- Strict following of this principle can lead to a large number of small interfaces that are more complex to maintain.