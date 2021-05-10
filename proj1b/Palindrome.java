/**
 * @author Boyu Chen
 * @date 5/10/21
 */
public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque<Character> wordToDeque = new ArrayDeque<>();
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            wordToDeque.addLast(c);
        }
        return wordToDeque;
    }

    /*
    private Deque<Character> wordToReversedDeque(String word) {
        Deque<Character> wordToReversedDeque = new ArrayDeque<>();
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            wordToReversedDeque.addFirst(c);
        }
        return wordToReversedDeque;
    }*/

    /*
    public boolean isPalindrome(String word) {
        if (word.length() <= 1) {
            return true;
        }
        word = word.toLowerCase();
        Deque<Character> wordDeque = this.wordToDeque(word);
        for (int i = 0; i < word.length(); i++) {
            if (word.charAt(i) != word.charAt(word.length() - i - 1)) {
                return false;
            }
        }
        return true;
    }*/

    /** Uses recursion. */
    public boolean isPalindrome(String word) {
//        word = word.toLowerCase();
        return isPalindromeHelper(word, 0);
    }

    private boolean isPalindromeHelper(String word, int index) {
        int indexSymmetrical = word.length() - index - 1;
        if (index >= indexSymmetrical) {
            return true;
        } else {
            if (word.charAt(index) == word.charAt(indexSymmetrical)) {
                return isPalindromeHelper(word, index + 1);
            }
            return false;
        }
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
//        word = word.toLowerCase();
        return isPalindromeHelper(word, cc, 0);
    }

    private boolean isPalindromeHelper(String word, CharacterComparator cc, int index) {
        int indexReversed = word.length() - index - 1;
        if (index >= indexReversed) {
            return true;
        } else {
            if (cc.equalChars(word.charAt(index), word.charAt(indexReversed))) {
                return isPalindromeHelper(word, cc, index + 1);
            }
            return false;
        }
    }
}
