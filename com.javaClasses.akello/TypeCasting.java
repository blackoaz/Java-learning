public class TypeCasting {

    public static void main(String[] args) {
        /*
implicit casting
        byte byteVar = 42;
        short shortVar = byteVar;
        int intVar = shortVar;
        long longVar = intVar;
        float floatVar = longVar;
        double doubleVar = floatVar;
*/

        double doubleVar = 42.0d;
        float floatVar = (float) doubleVar;
        long LongVar = (long) floatVar;
        int intVar = (int) LongVar;
        short shortVar = (short) intVar;
        byte byteVar = (byte) shortVar;

        System.out.println(doubleVar);
    }
}
