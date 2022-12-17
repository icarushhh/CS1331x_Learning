public class PrimitiveOperations {
    public static void main(String[] args) {

        int anInt = 5;
        double anDouble = 121.38;
        System.out.println(anInt);
        System.out.println(anDouble);

        double product = anInt * anDouble;
        System.out.println(product);

        float anFloat = (float)anInt;
        System.out.println(anFloat);

        int anotherInt = (int)anFloat;
        System.out.println(anotherInt);

        char aChar = 'S';
        System.out.println(aChar);

//        计算时会自动转化成 int
        aChar = (char)(aChar+32);
        System.out.println(aChar);

    }
}