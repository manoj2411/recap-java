 package datatypes;

import java.util.*;

public class StringSplit {
    public static void main(String[] args) {
        String[] arr = "Hey.World.!!".split("\\.");
        System.out.println("split by '.' : " + Arrays.toString(arr));

        arr = "Hey  World !!".split("\\s+");
        System.out.println("split by space ' '  : " + Arrays.toString(arr));

		String[] arr = "hey  there  bye ".split(" ");
		// String[] arr = "hey  there  bye ".split("\\s+");
		System.out.println("splitted: " + Arrays.toString(arr));

    }
}
