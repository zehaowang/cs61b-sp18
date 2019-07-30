public class Palindrome {
    public Deque<Character> wordToDeque(String word) {
        Deque d = new LinkedListDeque();
        for (int i = 0; i < word.length(); i++) {
            d.addLast(word.charAt(i));
        }
        return d;
    }

    public boolean isPalindrome(String word) {
        Deque d = wordToDeque(word);
        return isPalindrome(d);
    }

    private boolean isPalindrome(Deque<Character> d) {
        if (d.size() == 1 || d.size() == 0) {
            return true;
        }
        Character a = d.removeFirst();
        Character b = d.removeLast();
        return a.equals(b) && isPalindrome(d);
    }

    public boolean isPalindrome(String word, CharacterComparator cc) {
        Deque d = wordToDeque(word);
        return isPalindrome(d, cc);

    }

    private boolean isPalindrome(Deque<Character> d, CharacterComparator cc) {
        if (d.size() == 1 || d.size() == 0) {
            return true;
        }
        char a = d.removeFirst();
        char b = d.removeLast();
        return cc.equalChars(a, b) && isPalindrome(d, cc);
    }
}
