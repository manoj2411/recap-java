package datatypes;

import java.util.*;

public class Strings {

    public static void main(String[] args) {
        StringBuilder s1 = new StringBuilder("hello world");
        String str = "abcdc";

        /*  substring   */
        System.out.println("substring(1,1): " + s1.substring(1, s1.length() - 1));
        System.out.println("substring: " + str.substring(1, 2));

        /*  replace :  replace all ch1 to ch2  */
        System.out.println("replace: " + str.replace('c', 'x'));

        /*  trim: remove leading and trailing white spaces      */
        System.out.println("trim: " + "   aaa   b   ".trim() + ".");


        /*  join: join string with delimiter */
        System.out.println(String.join("-", "This", "is", "a", "String"));

        List<String> list = Arrays.asList("Dog", "Cat", "Cow", "Rat");
        System.out.println(String.join(", ", list));



        /*  other methods:

         boolean equalsIgnoreCase(String anotherString)

         int compareToIgnoreCase() : similar to compareTo with ignoring case

         boolean contains(CharSequence str) : its case sensitive

         String substring(int beginIndex)
         String substring(int beginIndex, int endIndex)

         boolean endsWith(String suffix)

         boolean startsWith(String str)
         boolean startsWith(String str, index fromIndex) : "Hi there".startsWith("there", 3)

         int indexOf(int ch)
         int indexOf(int ch, int fromIndex)
         int indexOf(String str)
         int indexOf(String str, int fromIndex)

         int lastIndexOf(int ch)
         int lastIndexOf(int ch, int fromIndex)
         int lastIndexOf(String str)
         int lastIndexOf(String str, int fromIndex)

         String replace(char oldChar, char newChar) : replaces all the occurrences of a oldChar
         String replaceFirst(String regex, String replacement)
         String replaceAll(String regex, String replacement)

         String[] split(String regex)
         String[] split(String regex, int limit)

         boolean isEmpty()

         boolean matches(String regex)

         boolean regionMatches(int toffset, String other, int ooffset, int len) : Tests if two string regions are equal, compare toffset+len with ooffset+len.
         boolean regionMatches(boolean ignoreCase, int toffset, String other, int ooffset, int len)

         char[] toCharArray()

         String join(CharSequence delimiter, CharSequence... elements)

         void getChars(int srcBegin, int srcEnd, char[] dest, int destBegin)

         String copyValueOf(char[] data): It copies the whole array (data) to the string
         String copyValueOf(char[] data, int offset, int count)copies only specified characters to the string using the specified offset and count values

        */
    }
}
