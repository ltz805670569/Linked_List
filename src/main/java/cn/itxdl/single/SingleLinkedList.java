package cn.itxdl.single;

import cn.itxdl.single.Node;

/**
 * 单向链表
 */
public class SingleLinkedList<E> {

    private Node head;

    /**
     * 新增元素,从链表末尾
      * @param e
     * @return
     */
    public boolean add(E e){
        Node newNode = new Node(e);
        if(head == null){
            head = newNode;
            return true;
        }else if(head != null){
            Node temp = head;
            while(temp.next != null){
                temp = temp.next;
            }
            temp.next = newNode;
            return true;
        }else{
            return false;
        }
    }

    /**
     * 从链表头添加元素
     * @param e
     */
    public void addFirst(E e){
        Node newNode = new Node(e);
        newNode.next = head;
    }

    /**
     * 向链表中插入元素
     * @param index
     * @param e
     * @return
     */
    public boolean insert(int index,E e){
        Node newNode = new Node(e);
        if(index < 0 || index > length()){
            return false;
        }
        Node upTemp = head;
        Node downTemp = head;
        for(int i=0; i<index-1;i++){
            upTemp = upTemp.next;
        }
        for(int i=0; i<index;i++){
            downTemp = downTemp.next;
        }
        if(downTemp != null){
            upTemp.next = newNode;
            newNode.next = downTemp;
            return true;
        }else{
            upTemp.next = newNode;
            return true;
        }
    }

    /**
     *  打印链表
     */
    public String toString(){
        Node curNode = head;
        StringBuilder sb = new StringBuilder("[");
        sb.append(head.data).append(",");
        while ((curNode = curNode.next) != null){
            if(curNode.next == null){
                sb.append(curNode.data).append("]");
                return sb.toString();
            }
            sb.append(curNode.data).append(",");
        }
        return null;
    }

    /**
     *  获取链表大小
     * @return
     */
    public int length(){
        int length = 1;
        Node temp = head;
        while(temp.next != null) {
            length++;
            temp = temp.next;
        }
        return length;
    }

    /**
     * 根据索引下标查找
     * @param index
     * @return
     */
    public Object get(int index){
        if(index<0 || index>length()-1){
            return null;
        }
        if(index == 0){
           return head.data;
        }
        Node temp = head;
        for(int i=0;i<index;i++){
            temp = temp.next;
        }
        return temp.data;
    }

    /**
     *  判断是否包含该元素
     * @param e
     * @return
     */
    public boolean contains(E e){
        if(head.data.equals(e)){
           return true;
        }
        Node temp = head;
        while(temp.next != null){
            if(temp.next.data.equals(e)){
                return true;
            }
            temp = temp.next;
        }
        return false;
    }

    /**
     * 根据索引删除元素,并返回删除的元素值
     * @param index
     * @return
     */
    public Object delete(int index){
        Node e = null;
        if(index<0 || index>length()-1){
            return null;
        }
        if(index == 0){
            head = head.next;
            return head.data;
        }
        Node upTemp = head;
        Node downTemp = head;
        for(int i = 0;i<index-1;i++){
            upTemp = upTemp.next;
        }
        for(int j=0;j<index+1;j++){
            downTemp = downTemp.next;
            if(j == index-1){
                e = downTemp;
            }
        }
        if(downTemp != null){
            upTemp.next = downTemp;
        }else{
            upTemp.next = null;
        }
        return e.data;
    }

    /**
     * 根据索引修改元素值，返回新值
     * @param index
     * @param e
     * @return
     */
    public Object set(int index,E e){
        if (index <0 || index > length()-1){
            return null;
        }
        Node temp = head;
        for(int i=0; i<index;i++){
            temp = temp.next;
        }
        Object obj = temp.data;
        temp.data = e;
        return obj;
    }
}
