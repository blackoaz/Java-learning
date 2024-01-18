# **Java Basics**

Ever java application contains at least one class definition.

   **public static void** main( String[ ] args) {

This is an entry point method (defined by its name and signature ** public static void** main( String [ ] args)) from which jvm can run your program. Every java program should have on.

- **public -** meaning that the method can be accessed from anywhere, from outside the program as well.
- **static -** means, it exists and can run by itself(at the class level without creating an object.)
- **void -** it returns no value.

The name args is a variable, so it can be called anything you want, although it is typically called args.

Whether its parameter type is an array (String [] args) or varargs(String...) does not matter because arrays can be passed into varargs.

**Note:** A single Application may have multiple classes containing an entry point(main) method. The entry point of the application is determined by the class name passed as an argument to the java command.

-> Each statement in Java must end with a semicolon.

## Type Conversion
### Numeric Primitive Casting
Numeric primitive casting can be done in two ways:
- Implicit casting and
- Explicit casting.

Implicit casting happens when the source type has smaller range than the target type.

    //implicit casting
    byte byteVar = 42;
    short shortVar = byteVar;
    int intVar = shortVar;
    long longVar = intVar;
    float floatVar = longVar;
    double doubleVar = floatVar

Explicit Casting has to be done when the source type has a larger range than the target type.
    
    //Explicit casting
    double doubleVar = 42.0d;
    float floatVar = (float) doubleVar;
    long LongVar = (long) floatVar;
    int intVar = (int) LongVar;
    short shortVar = (short) intVar;
    byte byteVar = (byte) shortVar

-> When casting a floating point primitives (float, double) to whole number primitives the number is rounded down.

### Basic Numeric Promotion

