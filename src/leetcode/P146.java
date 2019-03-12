package leetcode;

import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 携程2018秋招笔试第三题
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.

 get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity,
 it should invalidate the least recently used item before inserting a new item.

        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
        cache.get(2);       // returns -1 (not found)
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4


 题解：

 可以通过HashMap 和 Double LinkedList来完成。每个key, value用一个Node 来储存，按照添加顺序一个一个放在list 的head后面。
 同时把<key, node>放在HashMap中。

 get时看HashMap中是否有这个key, 有的话就找到对应的node, 在node里取出对应的value. 同时更新该node 在list中的位置。

 putt时分三种情况：1. 看HashMap中是否有这个key, 有的话说明本来就有这个key对应的node,
 只需要把原有node的value更改并且更新该node 在list中位置即可。

 2. HashMap中没有这个key, 同时HashMap的size未达到capacity, 那么新建一个node, 加入HashMap 和 list中即可。

 3. HashMap中没有这个key, 同时HashMap的size已经等于capacity, 多加就要溢出，
 所以按照2中完成添加后要从HashMap 和 list中都去掉最老的node.

 Time Complexity: get, O(1). put O(1).

 Space: O(n).

 */
public class P146 {

    public static void main(String[] args) {
        LRUCache cache=new LRUCache(2);
        cache.put(1, 1);
        cache.put(2, 2);
        cache.get(1);       // returns 1
        cache.put(3, 3);    // evicts key 2
//        cache.get(2);       // returns -1 (not found)
        System.out.println(cache.get(2));
        cache.put(4, 4);    // evicts key 1
        cache.get(1);       // returns -1 (not found)
        cache.get(3);       // returns 3
        cache.get(4);       // returns 4

    }

}
//更短写法。。。
class LRUCache3<K, V> extends LinkedHashMap<K, V> {
    private static final int MAX_ENTRIES = 3; //最大缓存数

    protected boolean removeEldestEntry(Map.Entry eldest) {
        return size() > MAX_ENTRIES;
    }

    LRUCache3() {
        super(MAX_ENTRIES, 0.75f, true);
    }
}

//linkedhashmap ，比较懒得仿佛
class LRUCache2 {
    private LinkedHashMap<Integer, Integer> map;
    private final int MAX_CACHE_SIZE;
    private final float loadFactor=0.75f;
    public LRUCache2(int cacheSize) {
        MAX_CACHE_SIZE = cacheSize;

        // 这块就是设置一个hashmap的初始大小，同时最后一个true指的是让linkedhashmap按照访问顺序来进行排序
        // ，最近访问的放在头，最老访问的就在尾
        map = new LinkedHashMap<Integer, Integer>((int)Math.ceil(cacheSize / loadFactor) + 1, loadFactor, true){

            // 这个意思就是说当map中的数据量大于指定的缓存个数的时候，就自动删除最老的数据
            protected boolean removeEldestEntry(Map.Entry eldest) {
                return size() > MAX_CACHE_SIZE;
            }
        };
    }

    public int get(int key) {
        return map.get(key);
    }


    public void set(int key, int value) {
        map.put(key, value);
    }


//        public int get(int key) {
//            return map.getOrDefault(key, -1);
//        }
}



class LRUCache {
    private Map<Integer,Node> map;
    private int count;
    private int capacity;
    private Node head;
    private Node tail;

    public LRUCache(int capacity) {
        map=new HashMap<>();
        this.count = 0;
        this.capacity = capacity;
        head = new Node();
        tail = new Node();
        head.pre = null;
        head.next = tail;
        tail.next = null;
        tail.pre = head;
    }

    public int get(int key) {
        Node node=map.get(key);
        //查找到后，把node移动到第一个,并把原先位置的删除
        if(node!=null){
            deleteNode(node);
            addToHead(node);
            return node.value;
        }
        else {
            return -1;
        }

    }

    public void put(int key, int value) {
        Node node=map.get(key);
        //node存在，更新值，并移动到第一个
        if(node!=null){
            node.value=value;
            deleteNode(node);
            addToHead(node);
        }
        else {
            Node newNode=new Node(key,value);
            map.put(key,newNode);
            //如果没满，则把新node移到第一个
            if(count<capacity){
                addToHead(newNode);
                count++;
            }
            //如果满了，则把最后一个node删掉，新node移动到第一个
            else {
                Node lastNode=tail.pre;
                deleteNode(lastNode);
                map.remove(lastNode.key);
                addToHead(newNode);
            }
        }
    }

    private void deleteNode(Node node){
       node.pre.next=node.next;
       node.next.pre=node.pre;
    }

    public void addToHead(Node node) {
        //移动node前，先把原先位置的node删掉
        node.next = head.next;
        node.next.pre = node;
        node.pre = head;
        head.next = node;
    }

}

class Node {
    int key;
    int value;
    Node pre;
    Node next;
    public Node(){}
    public Node(int key,int value){
        this.key=key;
        this.value=value;
    }
}


