package cn.itxdl.circle;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class ListTest {
    public static void main(String[] args) {
        CircleLinkedList<Integer> list = new CircleLinkedList();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.addFirst(6);
        list.add(0,7);
        list.add(2,11);
        System.out.println(list);
        list.add(9,88);
        System.out.println(list);
        Integer a = list.remove(0);
        System.out.println(a);
        System.out.println(list);
        Integer c = list.set(6, 44);
        System.out.println(c);
        System.out.println(list);


//        Integer data = list.get(7);
//        System.out.println(data);
//        list.addFirst(2);
//        list.add(0,6);
//        int size = list.size();
//        System.out.println(size);
//        List<Object> list1 = new LinkedList<Object>();
//        List<Object> list2 = new ArrayList<Object>();

    }
}
