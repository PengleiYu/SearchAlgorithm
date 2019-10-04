package com.company.ch3_1_符号表;

/**
 * 符号表API
 */
public interface ST<Key, Value> {
    void put(Key key, Value value);

    Value get(Key key);

    void delete(Key key);

    boolean contains(Key key);

    boolean isEmpty();

    int size();

    Iterable<Key> keys();
}
