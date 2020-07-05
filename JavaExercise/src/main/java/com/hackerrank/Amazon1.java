package com.hackerrank;

import java.util.*;

public class Amazon1 {

    public static void main(String[] args) {

        /*for(int i = 0 ; i < arr.length ; i++){

        }*/
        List<String> toys = new ArrayList<>();
        toys.add("anacell");
        toys.add("anacell");
        toys.add("anacell");
        toys.add("anacell");
        toys.add("anacell");
        //System.out.println(popularNToys(5,2,));

        "sdas".split("",2);
    }

    static class ToyPopularity {

        String toy;
        int popularity;

        @Override
        public String toString() {
            return "ToyPopularity{" +
                    "toy='" + toy + '\'' +
                    ", popularity=" + popularity +
                    '}';
        }
    }


    public ArrayList<String> popularNToys(int numToys,
                                          int topToys,
                                          List<String> toys,
                                          int numQuotes,
                                          List<String> quotes) {

        if (numToys == 0 || numQuotes == 0) {
            return new ArrayList<String>();
        }


        // WRITE YOUR CODE HERE
        Trie trie = new Trie();
        for (String toy : toys) {
            toy = toy.toLowerCase();
            trie.insert(toy);
        }

        List<ToyPopularity> toyPopularity = initPopularityMap(toys);

        for (String quote : quotes) {

            quote = quote.toLowerCase();
            Map<String, Boolean> toyFound = initMap(toys);
            for (int i = 0; i < quote.length(); i++) {
                findSmallString(quote, i, trie, toyFound, toyPopularity);
            }

        }

        Collections.sort(toyPopularity, new Comparator() {

            public int compare(Object o1, Object o2) {

                Integer y1 = ((ToyPopularity) o1).popularity;
                Integer y2 = ((ToyPopularity) o2).popularity;
                int sComp = y1.compareTo(y2);

                if (sComp != 0) {
                    return sComp;
                }
                String x1 = ((ToyPopularity) o1).toy;
                String x2 = ((ToyPopularity) o2).toy;
                return x1.compareTo(x2);

            }
        });

        ArrayList<String> result = new ArrayList<>();
    /*    SortedSet<Map.Entry<String, Integer>> set = entriesSortedByValues(toyPopularity);
        ArrayList<String> result = new ArrayList<>();

        Iterator<Map.Entry<String, Integer>> itr = set.iterator();
        while(itr.hasNext()){
            Map.Entry<String, Integer> e = itr.next();
            System.out.println("Result :"+e.getKey()+" "+e.getValue());
        }

        Iterator<Map.Entry<String, Integer>> it = set.iterator();*/

        for (int i = 0; i < topToys; i++) {

            if (i < toyPopularity.size())
                result.add(toyPopularity.get(i).toy);

        }
        return result;


    }
    // METHOD SIGNATURE ENDS

    static <K, V extends Comparable<? super V>>
    SortedSet<Map.Entry<K, V>> entriesSortedByValues(Map<K, V> map) {
        SortedSet<Map.Entry<K, V>> sortedEntries = new TreeSet<Map.Entry<K, V>>(
                new Comparator<Map.Entry<K, V>>() {
                    @Override
                    public int compare(Map.Entry<K, V> e1, Map.Entry<K, V> e2) {
                        int res = e2.getValue().compareTo(e1.getValue());
                        return res != 0 ? res : 1;
                    }
                }
        );
        sortedEntries.addAll(map.entrySet());
        return sortedEntries;
    }

    private void findSmallString(String quote, int j, Trie trie, Map<String, Boolean> toyFound, List<ToyPopularity> toyPopularities) {

        int startIndex = j;
        TrieNode node = trie.root;

        for (int i = startIndex; i < quote.length(); i++) {


            if (node.children.containsKey(quote.charAt(i))) {
                node = node.children.get(quote.charAt(i));
            } else {
                break;
            }

            if (node.children.containsKey(Trie.endSymbol)) {

                if (!toyFound.get(node.word)) {
                    toyFound.put(node.word, true);
                    String wordHere = node.word;
                    ToyPopularity toyPopularity = toyPopularities.stream().filter(t -> t.toy.equalsIgnoreCase(wordHere)).findFirst().orElse(null);
                    if (toyPopularity != null) {
                        int prevCount = toyPopularity.popularity;
                        toyPopularity.popularity = prevCount + 1;
                    }


                }


            }


        }

    }

    private Map<String, Boolean> initMap(List<String> toys) {

        Map<String, Boolean> map = new HashMap<>();
        for (String toy : toys) {
            toy = toy.toLowerCase();
            map.put(toy, false);
        }
        return map;
    }

    private List<ToyPopularity> initPopularityMap(List<String> toys) {
        List<ToyPopularity> result = new ArrayList<>();
        for (String toy : toys) {
            toy = toy.toLowerCase();
            ToyPopularity toyPopularity = new ToyPopularity();
            toyPopularity.toy = toy;
            result.add(toyPopularity);
        }

        return result;
    }
    // METHOD SIGNATURE ENDS

    static class Trie {


        TrieNode root = new TrieNode();
        final static Character endSymbol = '*';

        void insert(String str) {

            TrieNode current = this.root;

            for (int i = 0; i < str.length(); i++) {

                if (!current.children.containsKey(str.charAt(i))) {
                    current.children.put(str.charAt(i), new TrieNode());
                }

                current = current.children.get(str.charAt(i));
            }

            current.word = str;
            current.children.put(endSymbol, null);
        }


    }

    static class TrieNode {

        Map<Character, TrieNode> children = new HashMap<>();
        String word;
        int wordCount = 0;
    }
}
