package com.company.ch3_1_符号表;

/**
 * 符号表API
 */
public interface ST<Key extends Comparable<Key>, Value> {
    void put(Key key, Value value);//将键值对存入表中（value为空则将key删除）

    Value get(Key key);//获取key对应的value（若key不存在则返回空）

    void delete(Key key);//从表中删除key

    boolean contains(Key key);//key是否存在于表中

    boolean isEmpty();//表是否为空

    int size();//表中键值对数量

    Key min();//最小的键

    Key max();//最大的键

    Key floor(Key key);//小于等于key的最大键

    Key ceiling(Key key);//大于等于key的最小键

    int rank(Key key);//小于key的键数量

    Key select(int k);//排名为k的键

    void deleteMin();//删除最小的键

    void deleteMax();//删除最大的键

    int size(Key lo, Key hi);//[lo..hi]之间键的数量

    Iterable<Key> keys(Key lo, Key hi);//[lo..hi]之间的所有键，已排序

    Iterable<Key> keys();//表中所有的键，已排序
}
