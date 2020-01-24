import java.util.*;
/**
 * Created by Yang on 1/23/20.
 */
public class StringArrayUtils {
    /**
     * @param array array of String objects
     * @return first element of specified array
     */ // TODO
    public static String getFirstElement(String[] array) {
        return array[0];
    }

    /**
     * @param array array of String objects
     * @return second element in specified array
     */
    public static String getSecondElement(String[] array) {
        return array[1];
    }

    /**
     * @param array array of String objects
     * @return last element in specified array
     */ // TODO
    public static String getLastElement(String[] array) {
        return array[array.length-1];
    }

    /**
     * @param array array of String objects
     * @return second to last element in specified array
     */ // TODO
    public static String getSecondToLastElement(String[] array) {
        return array[array.length-2];
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return true if the array contains the specified `value`
     */ // TODO
    public static boolean contains(String[] array, String value) {
        int n = array.length;
        for (int i=0; i < n; ++i) {
            if (array[i] == value) return true;
        }
        return false;
    }

    /**
     * @param array of String objects
     * @return an array with identical contents in reverse order
     */ // TODO
    public static String[] reverse(String[] array) {
        int n = array.length;
        List<String> output = new ArrayList<String>();
        for (int i=n-1; i >= 0; --i) {
            output.add(array[i]);
        }
        int m = output.size();
        String[] outArray = new String[m];
        return output.toArray(outArray);
    }

    /**
     * @param array array of String objects
     * @return true if the order of the array is the same backwards and forwards
     */ // TODO
    public static boolean isPalindromic(String[] array) {
        int n = array.length;
        for (int i=0, j=n-i-1; i < j; ++i, --j) {
            if (array[i] != array[j]) return false;
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @return true if each letter in the alphabet has been used in the array
     */ // TODO
    public static boolean isPangramic(String[] array) {
        int n = array.length;
        Boolean[] alphaBooleans = new Boolean[26];
        Arrays.fill(alphaBooleans, false);
        String joined = "";
        for (int i=0; i < n; ++i) {joined += array[i];}
        
        int m = joined.length();
        for (int i=0; i < m; ++i) {
            /** ignore whitespaces **/
            if (joined.charAt(i) == ' ') continue;
            char ch = joined.charAt(i);
            int idx = Character.isLowerCase(ch) == true ? ch - 'a' : ch - 'A' ;
            if (alphaBooleans[idx] == false) alphaBooleans[idx] = true;
        }
        for (int i=0; i < 26; ++i) {
            if (alphaBooleans[i] == false) return false;
        }
        return true;
    }

    /**
     * @param array array of String objects
     * @param value value to check array for
     * @return number of occurrences the specified `value` has occurred
     */ // TODO
    public static int getNumberOfOccurrences(String[] array, String value) {
        int count = 0;
        for (int i=0; i < array.length; ++i) {
           if (value == array[i]) count++;
        }
        return count;
    }

    /**
     * @param array         array of String objects
     * @param valueToRemove value to remove from array
     * @return array with identical contents excluding values of `value`
     */ // TODO
    public static String[] removeValue(String[] array, String valueToRemove) {
        int n = array.length;
        List<String> output = new ArrayList<String>();
        for (int i=0; i < n; ++i) {
            if (array[i] != valueToRemove) output.add(array[i]);
        }
        int m = output.size();
        String[] outArray = new String[m];
        return output.toArray(outArray);
    }

    /**
     * @param array array of chars
     * @return array of Strings with consecutive duplicates removes
     */ // TODO
    public static String[] removeConsecutiveDuplicates(String[] array) {
        if (array.length < 2) return array;
        int n = array.length;
        List<String> output = new ArrayList<String>();
        String s = array[0];
        output.add(s);
        for (int i=1; i < n; ++i) {
            if (s == array[i]) continue;
            else {
                output.add(array[i]);
                s = array[i];
            }
        }
        int m = output.size();
        String[] outArray = output.toArray(new String[0]);
        return outArray;
    }

    /**
     * @param array array of chars
     * @return array of Strings with each consecutive duplicate occurrence concatenated as a single string in an array of Strings
     */ // TODO
    public static String[] packConsecutiveDuplicates(String[] array) {
        int n = array.length;
        List<String> output = new ArrayList<String>();
        String sequence = array[0];
        for (int i=1; i < n; i++) {
            char ch = sequence.charAt(0);
            if (array[i].charAt(0) == ch) {
                sequence += array[i];
            }
            else {
                output.add(sequence);
                sequence = array[i];
            }
            if (i == array.length-1) output.add(sequence);
        }
        /** must consider last character **/
        int m = output.size();
        String[] outArray = output.toArray(new String[0]);
        return outArray;
    }

}
