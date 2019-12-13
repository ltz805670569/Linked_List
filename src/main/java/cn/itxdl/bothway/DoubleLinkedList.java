package cn.itxdl.bothway;

/**
 * 双向链表
 */
public class DoubleLinkedList<E> {
    private Node<E> head;
    private Node<E> end;

    /**
     * 从头部添加
     * @param e
     * @return
     */
    public void addFirst(E e){
        Node<E> newNode = new Node(e);
        if(head == null){
            end = newNode;
        }else{
            head.pre = newNode;
            newNode.next = head;
        }
        head = newNode;
    }

    /**
     * 从尾部添加节点
     * @param e
     */
    public void addLast(E e){
        Node<E> newNode = new Node(e);
        if(head == null){
            head = newNode;
        }else{
            end.next = newNode;
            newNode.pre = end;
        }
        end = newNode;
    }

    /**
     * 指定元素添加到链表末尾
     * @param e
     */
    public void add(E e){
        Node<E> newNode = new Node(e);
        if(end != null){
            end.next = newNode;
            newNode.pre = end;
        }else{
            head = newNode;
        }
        end = newNode;
    }

    /**
     * 删除链表头一个节点,并返回该节点的值
     * @return
     */
    public E removeFirst(){
        E e = null;
        if(head == null){
            throw new RuntimeException("链表不存在");
        }
        Node<E> temp = head;
        if(head.next == null){
            end = null;
        }else{
            head.next.pre = null;
        }
        head = temp.next;
        e = temp.data;
        return e;
    }

    /**
     * 删除链表最后一个节点，并返回该节点的值
     * @return
     */
    public E removeLast(){
        E e = null;
        if(head == null){
            throw new RuntimeException("链表不存在");
        }
        Node<E> temp = end;
        if (head.next == null){
            head = null;
            end = null;
        }else{
            end.pre.next = null;
        }
        end = temp.pre;
        e = temp.data;
        return e;
    }

    public E remove(int index){
        E e = null;
        if(head == null){
            throw new RuntimeException("链表不存在");
        }
        if(index <0 || index > size()-1){
            throw new RuntimeException("下角标越界");
        }
        Node<E> upNode = head;
        Node<E> downNode = head;
        for(int i = 0;i<index-1;i++){
            upNode = head.next;
        }
        for(int i = 0;i<index+1;i++){
            downNode = head.next;
        }
        if(downNode == null){
//            e = upNode.next.data;
            return e;
        }else{
             return e;
        }
    }

    public int size(){
        int size = 1;
        if(head == null){
            return 0;
        }
        if(head.next == null){
            return size;
        }else{
            while(head.next != null){
                size++;
            }
            return size;
        }
    }




}
