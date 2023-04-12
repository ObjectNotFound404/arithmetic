package com.xq.util;

public class ArrayList<E> implements List<E> {
    private int size;
    private E[] elementData;
    private static final int DEFAULT_CAPACITY = 10;

    public ArrayList() {
        this(10);
    }

    public ArrayList(int initCapacity) {
        if (initCapacity <= 0) {
            throw new IllegalArgumentException("非法的容量:" + initCapacity);
        } else {
            initCapacity = initCapacity <= 10 ? 10 : initCapacity;
            this.elementData = (E[]) new Object[initCapacity];
        }
    }

    public void add(E element) {
        this.add(this.size, element);
    }

    public void add(int index, E element) {
        this.rangeCheckForAdd(index);
        this.ensureCapacity();

        for(int i = this.size; i > index; --i) {
            this.elementData[i] = this.elementData[i - 1];
        }

        this.elementData[index] = element;
        ++this.size;
    }

    private void ensureCapacity() {
        if (this.size == this.elementData.length) {
            int oldCapacity = this.elementData.length;
            int newCapacity = oldCapacity + (oldCapacity >> 1);
            E[] newElementData = (E[]) new Object[newCapacity];

            for(int i = 0; i < oldCapacity; ++i) {
                newElementData[i] = this.elementData[i];
            }

            this.elementData = newElementData;
        }

    }

    private void rangeCheckForAdd(int index) {
        if (index < 0 || index > this.size) {
            throw new IndexOutOfBoundsException("索引非法:" + index + ",集合长度为:" + this.size);
        }
    }

    public E set(int index, E element) {
        this.rangeCheck(index);
        E oldElement = this.elementData[index];
        this.elementData[index] = element;
        return oldElement;
    }

    private void rangeCheck(int index) {
        if (index < 0 || index >= this.size) {
            throw new IndexOutOfBoundsException("索引非法:" + index + ",集合长度为:" + this.size);
        }
    }

    public E get(int index) {
        this.rangeCheck(index);
        return this.elementData[index];
    }

    public boolean remove(int index) {
        this.rangeCheck(index);

        for(int i = index + 1; i < this.size; ++i) {
            this.elementData[i - 1] = this.elementData[i];
        }

        this.elementData[--this.size] = null;
        return true;
    }

    public boolean remove(E element) {
        int index = this.indexOf(element);
        return index != -1 ? this.remove(index) : false;
    }

    public int indexOf(E element) {
        int i;
        if (element != null) {
            for(i = 0; i < this.size; ++i) {
                if (element.equals(this.elementData[i])) {
                    return i;
                }
            }
        } else {
            for(i = 0; i < this.size; ++i) {
                if (this.elementData[i] == null) {
                    return i;
                }
            }
        }

        return -1;
    }

    public int size() {
        return this.size;
    }

    public boolean isEmpty() {
        return this.size == 0;
    }

    public boolean contains(E element) {
        return this.indexOf(element) != -1;
    }

    public void clear() {
        for(int i = 0; i < this.size; ++i) {
            this.elementData[i] = null;
        }

        this.size = 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("size:").append(this.size).append(" {");

        for(int i = 0; i < this.size; ++i) {
            if (i != 0) {
                sb.append(",");
            }

            sb.append(this.elementData[i]);
        }

        return sb.append("}").toString();
    }
}
