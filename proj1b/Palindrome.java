/**
 * @Auther: yza03@mail.ustc.edu.cn
 * @Date: 2022/8/7
 * @Description:
 * @Version: 1.0
 */

public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        if (word == null || word.length() == 0)
            return null;
        Deque<Character> queue = new ArrayDeque<>();
        for (int i = 0; i < word.length(); i++)
            queue.addLast(word.charAt(i));
        return queue;
    }
    public boolean isPalindrome(String word) {
        Deque<Character> word_queue = wordToDeque(word);
        if (word_queue == null) return true;
        int size = word_queue.size();
        char left, right;
        for (int i = 0; i < size/2; i++) {
            left = word_queue.get(i);
            right = word_queue.get(size - i - 1);
            if (left != right) return false;
        }
        return true;
    }
    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque<Character> word_queue = wordToDeque(word);
        if (word_queue == null) return true;
        int size = word_queue.size();
        char left, right;
        for (int i = 0; i < size/2; i++) {
            left = word_queue.get(i);
            right = word_queue.get(size - i - 1);
            if (!cc.equalChars(left, right)) return false;
        }
        return true;
    }
}
