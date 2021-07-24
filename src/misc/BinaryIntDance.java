package misc;

public class BinaryIntDance {
    public static void main(String[] args) {
        String bin_str = "1010";
        System.out.println(bin_str + " to int: " + Integer.parseInt(bin_str, 2));

        bin_str = Integer.toBinaryString(12);
        System.out.println("12 bin: " + bin_str);
    }
}
