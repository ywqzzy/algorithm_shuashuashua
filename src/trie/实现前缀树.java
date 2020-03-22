package trie;

public class 实现前缀树 {
    class Trie {
        class TrieNode {
            private TrieNode[] links;

            private final int R = 26;

            private boolean isEnd;

            public TrieNode() {
                links = new TrieNode[R];
            }

            public boolean containsKey(char ch) {
                return links[ch - 'a'] != null;
            }

            public TrieNode get(char ch) {
                return links[ch - 'a'];
            }

            public void put(char ch, TrieNode node) {
                links[ch-'a'] = node;
            }

            public void setEnd() {
                isEnd = true;
            }

            public boolean isEnd() {
                return isEnd;
            }
        }

        private TrieNode root;

        /**
         * Initialize your data structure here.
         */
        public Trie() {
            root = new TrieNode();
        }

        /**
         * Inserts a word into the trie.
         */
        public void insert(String word) {
            TrieNode node = root;
            for(int i = 0; i < word.length(); i++) {
                char cur = word.charAt(i);
                if(!node.containsKey(cur)) {
                    node.put(cur, new TrieNode());
                }
                node = node.get(cur);
            }
            node.setEnd();
        }

        private TrieNode searchPredix(String word) {
            TrieNode node = root;
            for(int i = 0; i < word.length(); i++) {
                char cur = word.charAt(i);
                if(node.containsKey(cur)) node = node.get(cur);
                else return null;
            }
            return node;
        }
        /**
         * Returns if the word is in the trie.
         */
        public boolean search(String word) {
            TrieNode node = searchPredix(word);
            if(node != null && node.isEnd()) return true;
            else return false;
        }

        /**
         * Returns if there is any word in the trie that starts with the given prefix.
         */
        public boolean startsWith(String prefix) {
            TrieNode node = searchPredix(prefix);
            return node != null;
        }
    }
}
