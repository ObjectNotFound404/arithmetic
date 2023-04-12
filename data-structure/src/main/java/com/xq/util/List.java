package com.xq.util;

public interface List<E> {
    /*
    * 向集合中添加元素
    * @param element 需要添加的元素
    */
    void add(E element);

    /*
    * 向集合指定索引处添加元素
    * @param index 集合的索引
    * @param element 需要添加的元素
    */
    void add(int index,E element);

    /*
    * 获取指定索引处的元素
    */
    E get(int index);

    /*
    * 修改集合指定索引处的值
    * @param index 集合的索引
    * @param element 需要添加索引位置的元素
    * @return 修改前索引位置原来的值
    */
    E set(int index,E element);

    /*
    * 删除集合中指定索引处的元素
    */
    boolean remove(int index);

    /*
    * 删除集合中指定的元素
    * @return 是否删除成功，成功返回true，失败返回false
    */
    boolean remove(E element);

    /*
    * 查找元素在集合中的位置，找到后返回元素的索引
    * @return 元素所在位置的索引
    */
    int indexOf(E element);

    /*
    * 集合的长度
    */
    int size();

    /*
    * 判断当前集合中是否为空集合
    */
    boolean isEmpty();

    /*
    * 判断集合中是否包含指定元素
    */
    boolean contains(E element);

    /*
    * 清空集合中的元素
    */
    void clear();
}

