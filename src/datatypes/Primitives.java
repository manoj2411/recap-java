package datatypes;

import java.math.BigInteger;

public class Primitives {

    public static void main(String[] args) {
        byte aByte = 24;        // 1 byte ~= 8 bits
        short aShort = 1024;    // 2 bytes
        int i = 42;             // 4 bytes
        long aLong = 999999990; // 8 bytes
        BigInteger aBigInt = new BigInteger("22");

        boolean aBool = true;

        char aChar = 'x'; // chars must be in single quote

        System.out.println("byte: " + aByte);
        System.out.println("short: " + aShort);
        System.out.println("int: " + i);
        System.out.println("long: " + aLong);
        System.out.println("bigInt : " + (aBigInt.byteValue() + 10));
    }
}
