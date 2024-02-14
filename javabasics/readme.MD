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
    char char1 = 1, char2 = 2;
    short short1 = 1, short2 = 2;
    int int1 = 1, int2 = 2;
    float float1 = 1.0f, float2 = 2.0f;

    // char1 = char1 + char2; // Error cannot convert from int to char.
    // short1 = short1 + short2 // Error cannot convert from int to char.
    int1 = char1 + char2 // char is promoted to int.
    int1 = short1 + short2 //short is promoted to int.
    int1 = char1 + short1 // both short and int is promoted to int.
    float1 = float1 + short1 // short is promoted to float


### Non-Numeric Primitive Casting

 - The boolean type cannot be cast from/to any other primitive type.
 - A char can be cast to/from any numeric type by using the code points mapping specified by Unicode.
 - A char is represented in memory as an unsigned 16-bit integer value(2-bytes), so casting to a bit will drop 8-bits(safe for ASCII characters).
 - The utility methods of the character class use int(4 bytes) to transfer to/from code-point values, but a short (2 bytes) would also suffice for storing s Unicode code-point.

 ```
 int badInt = (int) true // Compiler Error: Incompatible types
 char char1 = (char) 65; // A
 byte byte1 = (byte) 'A'; // 65
 short short1 = (short) 'A'; // 65
 int int1 = (int) 'A'; // 65
 
 char char2 = (char) 8253; // ?
 byte byte2 = (byte) '?' // 61 (Truncated code-point into ASCII range) 
 short short2 = (short) '?' // 8253
 int int2 = (int) '?' // 8253
 ```

### Object Casting

As with primitives, objects can be cast both explicitly and implicitly.
Implicit casting happens when the source type extends or implements the target type(casting to a super class or an interface).
Explicit casting has to be done when the source type 


