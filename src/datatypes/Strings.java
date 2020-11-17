package datatypes;

public class Strings {

    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder("hello world");
        s1.append("dfgdfg".substring(1));
        System.out.println("substring(1,1): " + s1.substring(1, s1.length() - 1));
    }
}
