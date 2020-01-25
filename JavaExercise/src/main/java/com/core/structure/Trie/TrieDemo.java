package com.core.structure.Trie;

import java.util.Arrays;

class TrieDemo {
    public static void main(String args[]) {
        // Input keys (use only 'a' through 'z' and lower case)
        String keys[] = {"the","there", "a",  "answer", "any",
                "by", "bye", "their", "abc"};
        String output[] = {"Not present in trie", "Present in trie"};
        Trie t = new Trie();

        System.out.println("Keys to insert: " + Arrays.toString(keys) + "\n");

        // Construct trie
        int i;
        for (i = 0; i < keys.length; i++) {
            t.insert(keys[i]);
            System.out.println("\"" + keys[i] + "\"" + "Inserted.");
        }

        System.out.print(t.search("the"));
        System.out.print(t.search("th"));
        System.out.print(t.search("ans"));
        System.out.print(t.search("any"));
    }
}