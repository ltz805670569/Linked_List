package cn.itxdl.single;

import java.util.LinkedList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
	    cn.itxdl.single.SingleLinkedList<String> list = new cn.itxdl.single.SingleLinkedList();
	    list.add("张三");
	    list.add("李四");
	    list.add("王五");
		System.out.println(list);
		/*boolean b = list.contains("李四");
		System.out.println(b);*/
//		Object o = list.delete(0);
//		System.out.println(o);
//		System.out.println();
//		list.toString();
		System.out.println("------------------------");
		list.set(2,"孙六");
		System.out.println(list);
		System.out.println("------------------------");
		list.insert(2,"王二麻子");
		System.out.println(list);
		List<String> list1 = new LinkedList();


	}
}
