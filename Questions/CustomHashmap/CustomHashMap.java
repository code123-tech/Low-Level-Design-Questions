package Questions.CustomHashmap;

/**
 * 1. Why hashmap bucket size is taken in terms of power of two?
 * 2. Why maximum capacity size of hashmap is 1 << 30?
 * 3. When we are giving manually entry of capacity, how next power of two is calculated?
 * Go through this playlist: https://www.youtube.com/playlist?list=PLsdq-3Z1EPT2UnueESBLReaVSLIo_BuAc
 * https://zhuanlan.zhihu.com/p/21673805
 * Why we can take capacity of bucket array as prime number: https://blog.csdn.net/liuqiyao_01/article/details/14475159
 */
public class CustomHashMap<K, V>{
    private static final int INITIAL_CAPACITY = 1 << 4;
    private static final int MAXIMUM_CAPACITY = 1 << 30;

    private Entry[] hashtable;

    public CustomHashMap(){
        hashtable = new Entry[INITIAL_CAPACITY];
    }

    public CustomHashMap(Integer capacity){
        int cap = tableSizeFor(capacity);
        hashtable = new Entry[cap];
    }

    private int tableSizeFor(Integer cap){
        int n = -1 >>> numberOfLeadingZeros(cap-1);
        return n < 0 ? 1 : (n >= MAXIMUM_CAPACITY ? MAXIMUM_CAPACITY: n + 1);
    }

    private int numberOfLeadingZeros(int i){
        if (i <= 0)
            return i == 0 ? 32 : 0;
        int n = 31;
        if (i >= 1 << 16) { n -= 16; i >>>= 16; }
        if (i >= 1 <<  8) { n -=  8; i >>>=  8; }
        if (i >= 1 <<  4) { n -=  4; i >>>=  4; }
        if (i >= 1 <<  2) { n -=  2; i >>>=  2; }
        return n - (i >>> 1);
    }

    class Entry<K, V>{
        public K key;
        public V value;
        public Entry next;

        Entry(K key, V value){
            this.key = key;
            this.value = value;
        }
    }
    final int hash(Object key){
        int h;
        return (key == null) ? 0 : (h = key.hashCode()) ^ (h >>> 16);
    }

    public void put(K key, V value){
        int hashCode = hash(key) & (hashtable.length - 1);
        Entry node = hashtable[hashCode];
        if(node == null){
            Entry newNode = new Entry(key, value);
            hashtable[hashCode] = newNode;
        }else{
            Entry prevNode = node;
            while (node != null){
                if(node.key == key){
                    node.value = value;
                    return;
                }
                prevNode = node;
                node = node.next;
            }
            Entry newNode = new Entry(key, value);
            prevNode.next = newNode;
        }
    }

    public V get(K key){
        int hashCode = hash(key) & (hashtable.length - 1);
        Entry node = hashtable[hashCode];
        while(node != null){
            if(node.key.equals(key)){
                return (V) node.value;
            }
            node = node.next;
        }
        return null;
    }
    private Integer hashing(K key){
        return key.hashCode()%hashtable.length;
    }
}
