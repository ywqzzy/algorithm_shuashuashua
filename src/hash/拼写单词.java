package hash;

public class 拼写单词 {
    public int countCharacters(String[] words, String chars) {
        int[] map = count(chars);
        int cnt = 0;
        for(String s: words) {
            int[] smap = count(s);
            if(contains(map, smap)) cnt += s.length();
        }
        return cnt;
    }

    boolean contains(int[] chars_count, int[] word_count) {
        for(int i = 0; i < 26; i++)
            if(chars_count[i] < word_count[i]) return false;
        return true;
    }

    int[] count(String word) {
        int[] res = new int[26];
        for(int i = 0; i < word.length(); i++) res[word.charAt(i) - 'a']++;
        return res;
    }
}
