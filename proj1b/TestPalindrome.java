import org.junit.Test;
import static org.junit.Assert.*;

public class TestPalindrome {
    // You must use this palindrome, and not instantiate
    // new Palindromes, or the autograder might be upset.
    static Palindrome palindrome = new Palindrome();
    static CharacterComparator cc0 = new OffByN(0);
    static CharacterComparator cc1 = new OffByN(1);
    static CharacterComparator cc2 = new OffByN(2);
    static CharacterComparator cc3 = new OffByN(3);
    @Test
    public void testWordToDeque() {
        Deque d = palindrome.wordToDeque("persiflage");
        StringBuilder actual = new StringBuilder();
        for (int i = 0; i < "persiflage".length(); i++) {
            actual.append(d.removeFirst());
        }
        assertEquals("persiflage", actual.toString());
    }
    private boolean isPalindromeAns(String word) {
         String reversed_word = new StringBuilder(word).reverse().toString();
         return reversed_word.equals(word);
    }
    @Test
    public void testIsPalindrome() {
        In reader = new In("C:\\Users\\wh030917\\Desktop\\GitHub\\fa20-s2002\\library-fa20\\data\\words.txt");
        while (!reader.isEmpty()) {
            String data = reader.readString();
            assertEquals(isPalindromeAns(data), palindrome.isPalindrome(data));
        }
    }
    @Test
    public void testIsPalindrome_generic() {
        assertTrue(palindrome.isPalindrome("flake", cc1));
        In reader = new In("C:\\Users\\wh030917\\Desktop\\GitHub\\fa20-s2002\\library-fa20\\data\\words.txt");
        while (!reader.isEmpty()) {
            String data = reader.readString();
            if (data.length() > 4) {
                if (palindrome.isPalindrome(data, cc0))
                    StdOut.println("cc0: "+data);
                else if (palindrome.isPalindrome(data, cc1))
                    StdOut.println("cc1: "+data);
                else if (palindrome.isPalindrome(data, cc2))
                    StdOut.println("cc2: "+data);
                else if (palindrome.isPalindrome(data, cc3))
                    StdOut.println("cc3: "+data);
                }
            }
    }
}