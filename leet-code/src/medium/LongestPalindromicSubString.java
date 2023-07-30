package medium;

/**
 * Given a string s, return the longest palindromic substring in s.
 */
public class LongestPalindromicSubString {

    public static void main(String[] args) {
        String word = "madam";
        LongestPalindromicSubString object = new LongestPalindromicSubString();
        System.out.println(object.longestPalindrome(word));
    }
    int low = 0;
    int maxLength = 0;
    public String longestPalindrome(String word) {

        char[] charArr = word.toCharArray();

        for (int i=0; i<word.length(); i++) {
            findPalindromeLength(charArr, i, i);
            findPalindromeLength(charArr, i, i+1);
        }

        return word.substring(low, maxLength+low);
    }

    public void findPalindromeLength(char[] arr, int start, int end) {

        while(start >= 0 && end < arr.length && arr[start] == arr[end]) {
            start--;
            end ++;
        }

        if (maxLength < (end - start - 1)) {
            maxLength = end - start - 1;
            low = start + 1;
        }
    }
}
