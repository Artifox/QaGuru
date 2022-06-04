package lesson4;

public class DataTypes {
    public static void main(String[] args) {
        int a = 1;
        int b = 2;
        int c = 3;
        int d = 4;
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("b / a = " + (b / a));
        System.out.println("b % a = " + (b % a));
        System.out.println("c % a = " + (c % b));
        System.out.println("a++   = " +  (a++));
        System.out.println("b--   = " +  (a--));
        System.out.println("d++   = " +  (d++));
        System.out.println("++d   = " +  (++d));

        byte maxByte = 127;
        byte minByte = -128;
        byte overloadedByte = (byte) (maxByte * 2);
        System.out.println("overloadedByte = " + overloadedByte);
        overloadedByte = (byte) (minByte - 1);
        System.out.println("overloadedByte = " + overloadedByte);

        int maxInt = 2147483647;
        int overloadedIntWithCast = (int) maxInt + 1;
        System.out.println(overloadedIntWithCast);

        int overloadedIntWithoutCast = maxInt + 1;
        System.out.println(overloadedIntWithoutCast);


        int myInt = 2;
        short myShort = 3;
        short castedShort = (short) (myInt + myShort);
        System.out.println(castedShort);

        long myLong = 2L;

        int castedInt = (int) (myLong + myInt);
        System.out.println(castedInt);

        boolean trueBool = true;
        boolean falseBoole = false;

        System.out.println("a && b = " + (trueBool && falseBoole));

        System.out.println("a || b = " + (trueBool || falseBoole));
        System.out.println("a || b = " + (falseBoole || trueBool));

        System.out.println("!(a && b) = " + !(trueBool && falseBoole));

    }
}
