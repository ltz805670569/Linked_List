package cn.itxdl.array;

import java.util.Arrays;

public class MyArrayList<E> {
    Object[]  elementData;
    private int size;
    private static final Object[] DEFAULTCAPACITY_EMPTY_ELEMENTDATA = {};
    private static final int DEFAULT_CAPACITY = 10;
    protected transient int modCount = 0;
    public MyArrayList() {
        this.elementData = DEFAULTCAPACITY_EMPTY_ELEMENTDATA;
    }

    public boolean add(E e) {
        ensureCapacityInternal(size + 1);
        elementData[size++] = e;
        return true;
    }

    private void ensureCapacityInternal(int minCapacity) {
        ensureExplicitCapacity(calculateCapacity(elementData,  minCapacity));
    }

    private static int calculateCapacity(Object[] elementData, int minCapacity) {
        if (elementData == DEFAULTCAPACITY_EMPTY_ELEMENTDATA) {
            return Math.max(DEFAULT_CAPACITY, minCapacity);
        }
        return minCapacity;
    }

    private void ensureExplicitCapacity(int minCapacity) {
        modCount++;

        //如果最小容量减去数组长度大小大于0
        if (minCapacity - elementData.length > 0)

            //执行扩容方法
            grow(minCapacity);
    }

    private void grow(int minCapacity) {
        //将数组的原先长度大小赋值给oldCapacity
        int oldCapacity = elementData.length;

        //新的数组长度大小为oldCapacity+oldCapacity二进制向右移一位
        int newCapacity = oldCapacity + (oldCapacity >> 1);

        //新的数组长度大小减去最小默认值10，如果小于0，将最小默认值10赋值给新的数组长度大小
        if (newCapacity - minCapacity < 0)
        newCapacity = minCapacity;

        //通过数组copy方法，copy出新数组
        elementData = Arrays.copyOf(elementData,newCapacity);
    }



}
