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
Explicit casting has to be done when the source type is extended or implemented by the target type(casting to a subtype). This can produce a runtime exception(classCastException) when the object being cast is not of the target type(or targets subtype).

```java
Float floatVar = new Float(42.0f);
Number n = floatVar;   // Implicit: Float implements number
Float floatVar2 = (Float) n; // Explicit
Double doubleVar = (Double) n; // ThrowsException (the object is not Double)
```
// ### Testing if An Object can be Cast Using instanceof

# GETTERS AND SETTERS
### Using a Setter or getter to Implement constraint

Setters and Getters allow for an object to contain private variables which can be accessed and change with restrictions.

```java
public class Person {
    private String name;
    
    public String getName (){
        return this.name;
        
    }
    public void setName(String name){
        if( name != null && name.length() > 2){
            this.name = name;
        }

    }
}
```

### Importance of Getters and Setters
- Getters and setters allows you to interact with a class internal nature as it dictates.
- Getters and setters makes access synchronization simple.

### ADDING GETTERS AND SETTERS
Encapsulation is a basic concept in Object Oriented-Programming, it's about wrapping data and code as a single unit.
It's a good practice to declare the variables as private and the access them through getters and setters to view and/or modify.
With private variables, they cannot be accessed from outside the class. Hence they are protected from unauthorized access. But if you want to view or modify them, you can use getters and setters.

# REFERENCE DATA TYPES
### Dereferencing

Dereferencing happens with the . (dot) operator.

```java
Object obj = new Object();
String text = obj.toString(); // 'obj' is dereferenced
```
Dereferencing  follows the memory address stored in a reference, to the place in memory where the actual object resides.
When an object has been found, the requested method is called (toString in this case).
When a reference has the value null, dereferencing results in a NullPointerException.

### Instantiating a Reference Type
````java
Object obj = new Object(); 
````
- Object is  reference type
- obj is the variable in which to store the new reference
- Object() is the call to constructor of ana Object
What Happens:
- space in memory is located for the object
- The constructor Object() is called to initialize that memory space
- The memory address is stored in the obj.,so that it reference the newly  created object
This is different in primitives where int i = 10, value 10 is stored in i.

# Documenting Java Code

For later update
# Command Line Argument Processing

# Literals

A java literal is a syntatic element

### Using underscore to improve readability
It is possible sinve java 7 to use one or more underscore (_) for seperating groups of didgits in a primitive number literal to improve readability. e.g

    int i1 123456;
    int i2 = 123_456;
    System.out.println(i1 == 12); // true

Use of underscore can be applied to all primitive number literals.

    byte color = 1_2_3;
    short yearsAnnoDomini= 2_016;
    int socialSecurtyNumber = 999_99_9999;
    long creditCardNumber = 1234_5678_9012_3456L; float piFourDecimals = 3.14_15F;
    double piTenDecimals = 3.14_15_92_65_35;

The underscore also works with:
    short binary= 0b0_1_0_1;
    int octal = 07_7_7_7_7_7_7_7_0; long hexBytes = 0xFF_EC_DE_5E;

To work with underscores, the following rules has to be abided by:

- It cannot be used at the beginning or end of a number(_123 - is not valid)
- Underscores cannot be used adjacent to decimal point in a floating point literal(1._23 or 1_.123 - is not valid)
- Underscores cannot be used prior to an L of F suffix(1.23F or 99999_L - is not valid)
- cannot be used where a string of didigts is expected(0_xFFFF is not valid).

### Hexadecimal, Octal and Binary literals
- A hexadecimal numvber is avalue in base 16. Tgere are 16 digits, 0-9 and letters A-F(case does not matter). A-F represents 10-15.
- An Octal number is a value in base-8 and uses the digits 0-7.
- A binary number is a value in base-2 and uses the digits 0 and 1.

All the above numbers result in the same value, 110.

    int dec = 110; // no prefix --> decimal literal
    int bin = 0b1101110; // '0b' prefix --> binary literal
    int oct = 0156 // '0' prefix --> octal literal;
    int hex = 0x6E // '0x' prefix --> hexadecimal literal.

The Octal literal can easily be a trap for semantic errors. If you define a leading '0' to your decimal literals you will get the wrong value.

    int a = 0100; // Instead of 100, a == 64

### Boolean literals
Boolean literals are the simplest literals in java, with two possible boolean value, true and false.

### String Literals

Provides the most convenient way to represents string values in java. A string literal consist of:
 - An opening double quote Character.
 - Zero or more other characters that are neither a double-quote or a line-break character.
 - Closing double quote character.

 ### The Null Literal

 The null literal(null) represents the one and only value of the null type.The null type has no name so you cannot express it in java, and has no runtime representation either.
 The sole purpose of the null type is to be of null. It is assignment compstible with all reference type, and can be type cast to any reference type.(in the later case, the cast does not entail a runtime type check.)
 Null has the property that null **instanceof** ``<SomereferenceType>`` will evaluate to false, no matter what the type is.

 ### Escape Sequence Literal

 String character literals provide an escape mechanism that allows express character codes that would otherwise not be allowed in the literal. An escape sequence consists of a backlash character(\\) followed by one or more other character. The same sequence are valid in both character and string literals. 

 ### Character Literals

 Provides the most convenient way to express char values in java source code.  A character literal consist of:
  - An opening single-quote(') character.
  - A representation of s character. This representation cannot be a singlr-quote or a line-break character, but it can be an escape sequence introduced by a backlash(\\) character.
  - A closing single quote(') character.

A line-break in a character literal is acompilation error.
    char newLine = '
    // compilation error in previous line
    char newLine = '\n' // correct

### Decimal Integer Literals

Integer literals provide values that can be used where you need a byte, short, int, long or char instance.
#### Ordinary Integer literals
The simplest and most common form of integer literal is a decimal integer literal
    0 // decimal number zero (type 'int')
    1 // The decimal number one (type 'int')
    42 // The decimal number forty two (type 'int')

Leading zeros cause an integer literal to be intepreted as octal not decimal.
    077 // this literal means 7 * 7 + 8 ... or 63 decimal!

Integer literals are unsigned. values like -10 or +10 are actually expressions using the unary -  and unary + operators
The range of integer literals of this form have an intrinsic type of int, and must fall in the range zero to 231 or 2,147,482,648 

231 is 1 greater than Integer.MAX_VALUE. Literals from 0 through to 2147483647 can be used anywhere, but is a compilation error to use 2147483648 without preceeding unary - uperator.(it is reserved for expressing the value of Integer.MIN_VALUE.)

    int max = 2147483647; // OK
    int min = -2147483648; // OK
    int tooBig = 2147483648; // ERROR
#### Long integer literals

Literals of type long are expressed by adding an L suffix.
    0L // The decimal number zero (type 'long')
    1L // The decimal number one (type 'long')
    2147483648L // The value of Integer.MAX_VALUE + 1
    long big = 2147483648; // Error
    long big2 = 2147483648L; //OK

The distinction between int and long literals is significant in other places

```java
int i = 2147483647;
long I = i + 1;  // Produces a negative value 
                // because the operation 
                // is performed using 32 bit 
                // arithmetic, and the 
                // addidtion overflows
long I2 = i + 1L // Produces the (intuitively correct value)
```

### Floating Point Literals

Floating point literals provide values that can be used where you need a float or double instance. The are three kinds of floating point literal.
 - Simple decimal forms
 - Scaled decimal forms
 - Hexadecimal forms

There are distinct literal  types for float and double literals, expressed using suffixes. The various forms use letters to express different things. These letters are case sensitive.

#### Simple Decimal Forms
The simplest form of floating point literal consists of one or more decimal digits  and a decimal point(.) and an optional suffix (f,F,d or D). The suffix helps in specifying if the literal is float(f or F) or double (d or D) value. The default(when no suffix is specified) is double.
Decimal digits followed by a suffix is also a floating point literal.

#### Scaled Decimal Forms

Scaled decimal forms consist of simple decimal with an exponent part introduced by an E or e, and followed by a signed integer. The exponent part is a short hand for multiplying the decimal form by a power ten. There is also an optional suffix to distinguish float and double literals.

    1.0E1 // this means 1.0 * 10^1 ... or 10.0 (double)
    1E-1D // this means 1.0 * 10^(-1) ... or 0.1(double)
    1.0e10f // this means 1.0 * 10^(10) ... or 10000000000.0(float)

The size ofnthe literal is limited by the representation (float or double). It is a compilation error if the scale factor results in a value that is too large or too small.

#### HexaDecimal Forms

From java 6, it is possible to express floating point literals in hexadecimal. The hexadecimal form have an analogous sysntax to the simple and scaled decimal forms with the following differences.

 1. Every hexadecimal floating pont value starts with a 0 and then x or X
 2. The digits of the number(but not the exponent part!) also includes the hexadecimal digits a through f and their uppercase equivalents.
 3. The exponent is manadatory, and is introduced by the letter p(or P) instead of an e or E. the exponent represents a scaling factor that is power of 2 instead of a power of 10.

    0x0.0p0f // this is zero expressed in hexadecimal form ('float')
    0xff.0p19 // this 255.0 * 2^19 ('double')

# PRIMITIVE DATA TYPES