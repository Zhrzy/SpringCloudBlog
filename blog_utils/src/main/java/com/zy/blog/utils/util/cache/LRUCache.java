package com.zy.blog.utils.util.cache;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * LRU算法实现
 * 本LRU定义：尾节点是最新的节点
 *
 * @author 小章鱼
 * @date 2022/7/10 19:51
 */
public class LRUCache<K, V> {

    private final int capacity;
    private CacheNode<K, V> dummy; //dummy哨兵节点 pre指向尾节点 next指向头节点
    private Map<K, CacheNode<K, V> > cache;

    /*构造*/
    public LRUCache(int capacity) {
        this.capacity = capacity;
        this.cache = new ConcurrentHashMap<K, CacheNode<K, V> >();
        this.dummy = new CacheNode<>();
    }
    /**
    添加缓存数据方法 添加到尾部
    * */
    private void add(CacheNode<K,V> node){
        dummy.pre.next=node;
        node.pre=dummy.pre;
        node.next = dummy;
        dummy.pre = node;
    }
    /**
     移除节点
     * */
    private void remove(CacheNode<K,V> node) {
        node.pre.next = node.next;
        node.next.pre = node.pre;
    }
    /**获取节点 都需要将获取的节点移动到尾部
    * */
    public V get(K key) {
        CacheNode<K,V> node = cache.get(key);
        if (node == null) return null;
        remove(node);
        add(node);
        return node.value;
    }
    /**
     * 新增节点，需要新增到尾部
     * */
    public void put(K key, V value) {
        CacheNode<K,V> node = cache.get(key);
        if (node == null) {
            if (cache.size() >= capacity) {
                cache.remove(dummy.next.key);
                remove(dummy.next);
            }
            node = new CacheNode<K,V>(key, value);
            cache.put(key, node);
            add(node);
        } else {
            cache.remove(node.key);
            remove(node);
            node = new CacheNode(key, value);
            cache.put(key, node);
            add(node);
        }
    }

}
