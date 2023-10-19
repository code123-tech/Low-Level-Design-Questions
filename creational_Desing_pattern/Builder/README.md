- Builder Pattern is a creational design pattern that allows us to create an instance of complex class that contains a large 
number of fields, and we want to set some fields at a time. 
- Builder Pattern constructs instance with set of steps like for a House Building, steps are buildWalls, buildWindows etc.

We can do like, 
1. Create constructor of fields, but this has some problems
   1. Not always we need to create instance of constructor with all fields, in that we need to pass null to those fields.
   2. Constructor with a lot of parameters are also not a good.
   3. Now, if we say, need some fields, then will create constructor with those fields. Now someone comes again with some other
      fields and will create one more constructor. This is not a good way.
2. Using setter methods.
   1. Now create instance, and use setter method to set the fields value.
   2. For this, need to create instance first, and set one by one each field.

- To overcome this issue, we can use Builder Pattern. Builder is like a person to whom client say that, take these parameters and
   using these parameters build the instance of it.

**Steps to create Builder Pattern**
1. The class for which you want to create builder pattern, make the constructor of that class as private as we will say 
builder to create it.
2. Now, we will create a builder for that class which will and that class has-A builder.
3. Now, an outsider client say to builder to create the class for me by taking these details.

- For example, We want to create a House, for one person the requirements are different, for other it is different. 
  One person needs windows in house and AC in house, and other not needs it. So, 
  - Using constructor, we can't do like
     * constructor(field1, null);  // for one person
     * constructor(field1, field2);  // for other person

So, we will ask Builders to take these requirements and build house for us. [Learn More here](https://refactoring.guru/design-patterns/builder)

