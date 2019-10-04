package com.company.ch3_1_符号表;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * 符号表API
 */
public interface ST<Key extends Comparable<Key>, Value> {
    void put(Key key, Value val);//将键值对存入表中（value为空则将key删除）

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

    default void deleteMin() {//删除最小的键
        delete(min());
    }

    default void deleteMax() {//删除最大的键
        delete(max());
    }

    default int size(Key lo, Key hi) {//[lo..hi]之间键的数量
        if (hi.compareTo(lo) < 0) return 0;
        else if (contains(hi))
            return rank(hi) - rank(lo) + 1;
        else return rank(hi) - rank(lo);
    }

    Iterable<Key> keys(Key lo, Key hi);//[lo..hi]之间的所有键，已排序

    default Iterable<Key> keys() {//表中所有的键，已排序
        return keys(min(), max());
    }

    /**
     * 行为测试用例
     */
    static void stTestCase(ST<String, Integer> st) {
        String[] inputs = "SEARCHEXAMPLE".split("");
        for (int i = 0; i < inputs.length; i++)
            st.put(inputs[i], i);
        for (String s : st.keys())
            System.out.println(s + " " + st.get(s));
    }

    /**
     * 性能测试用例
     */
    static void stFrequencyCounter(ST<String, Integer> st) throws FileNotFoundException {
        int minLen = 1;
        Scanner scanner = new Scanner(new FileInputStream("asset/tale.txt"));
        while (scanner.hasNext()) {
            String word = scanner.next();
            if (word.length() < minLen) continue;
            if (!st.contains(word)) st.put(word, 1);
            else st.put(word, st.get(word) + 1);
        }
        String max = "";
        st.put(max, 0);
        for (String word : st.keys())
            if (st.get(word) > st.get(max))
                max = word;
        System.out.println(max + " " + st.get(max));

    }
}
