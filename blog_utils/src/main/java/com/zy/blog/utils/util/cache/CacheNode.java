package com.zy.blog.utils.util.cache;

/**
 * LRU算法实现
 *
 * @author 小章鱼
 * @date 2022/7/10 19:51
 */
public class CacheNode<K,V> {
    K key;
    V value;
    CacheNode<K,V> pre;
    CacheNode<K,V> next;
    public CacheNode(K k,V v){
        this.key=k;
        this.value=v;
        pre=this;
        next=this;
    }
    public CacheNode(){
        pre=this;
        next=this;
    }
}
