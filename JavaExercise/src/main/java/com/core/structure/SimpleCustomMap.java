package com.core.structure;


public class SimpleCustomMap<K, V> {

    private final static int INITIAL_CAPACITY = 1 << 4; //16
    private final float DEFAULT_LOAD_FACTOR = 0.75f;

    private int size;
    private int bucketCount;

    private Entry<K, V>[] buckets;

    public SimpleCustomMap(int initialCapacity) {
        this.buckets = new Entry[initialCapacity];
    }

    public SimpleCustomMap() {
        this(INITIAL_CAPACITY);
    }

    public V put(K key, V value) {

        if(hasThresholdReached()){
            resizeBuckets();
        }

        int hashcode = getHashCode(key);
        int position = hashcode % this.buckets.length;
        Entry currentEntry = buckets[position];

        if (currentEntry == null) {
            buckets[position] = new Entry<K, V>(key, value, null);
            size++;
            bucketCount++;
        } else {

            while (currentEntry.next != null) {
                if (currentEntry.key == key) {
                    currentEntry.value = value;
                    return value;
                }
                currentEntry = currentEntry.next;
            }

            if (currentEntry.key == key) {
                currentEntry.value = value;
            } else {
                currentEntry.next = new Entry(key, value, null);
                size++;
            }
        }

        return value;
    }

    private boolean hasThresholdReached() {
        float currentLoad = (float)bucketCount/(float)buckets.length;
        return DEFAULT_LOAD_FACTOR < currentLoad;
    }

    private void resizeBuckets() {
        Entry<K, V>[] tmpBuckets  = new Entry[buckets.length*2];
        for(int i=0;i<buckets.length;i++){
            tmpBuckets[i] = buckets[i];
        }
        buckets = tmpBuckets;
    }

    public V get(K key) {

        int hashcode = getHashCode(key);
        int position = hashcode % this.size;
        Entry<K, V> currentEntry = buckets[position];

        while (currentEntry != null) {
            if (currentEntry.key == key) {
                return currentEntry.value;
            }
            currentEntry = currentEntry.next;
        }

        return null;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder("");
        for (Entry entry : buckets) {
            if (entry != null) {
                sb.append("[");
                while (entry != null) {
                    sb.append(entry);
                    if (entry.next != null) {
                        sb.append(", ");
                    }
                    entry = entry.next;
                }
                sb.append("]");
            }
        }

        return "{" + sb.toString() + "}";
    }

    private int getHashCode(K key) {
        return key == null ? 0 : Math.abs(key.hashCode());
    }

    public static class Entry<K, V> {

        private final K key;
        private V value;
        private Entry<K, V> next;

        public Entry(K k, V v, Entry n) {
            this.key = k;
            this.value = v;
            this.next = n;
        }

        public K getKey() {
            return key;
        }

        public V getValue() {
            return value;
        }

        public Entry<K, V> getNext() {
            return next;
        }

        @Override
        public String toString() {
            return "key=" + key +
                    ", value=" + value;
        }

        @Override
        public boolean equals(Object obj) {
            if (obj == this) return true;
            if (obj instanceof Entry) {
                Entry entry = (Entry) obj;
                return key.equals(entry.getKey()) &&
                        value.equals(entry.getValue());
            } else {
                return false;
            }
        }

        @Override
        public int hashCode() {
            int hash = 13;
            hash = 17 * hash + ((key == null) ? 0 : key.hashCode());
            hash = 17 * hash + ((value == null) ? 0 : value.hashCode());
            return hash;
        }

    }


}
