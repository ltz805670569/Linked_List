package cn.itxdl.circle;

/**
 * 单向循环链表
 * @param <E>
 */
public class CircleLinkedList<E> {

    private Node<E> head;

    /**
     * 从头部添加
     * @param e
     */
    public void addFirst(E e){
        Node<E> newNode = new Node(e);
        Node<E> temp = head;
        if(head == null){
            head = newNode;
            return;
        }else if(head.next == null){
            newNode.next = temp;
            head = newNode;
            temp.next = head;
            return;
        }else{
            while(temp.next != head){
                temp = temp.next;
            }
            newNode.next = head;
            head = newNode;
            temp.next = head;
        }

    }

    /**
     * 从末尾添加
     * @param e
     */
    public void add(E e){
        Node<E> newNode = new Node(e);
        Node<E> temp = head;
        if(head == null){
            newNode.next = head;
            head = newNode;
        }else if(head.next == null){
            head.next = newNode;
            newNode.next = head;
        }else{
            while(temp.next != head){
                temp = temp.next;
            }
            temp.next = newNode;
            newNode.next = head;
        }
    }

    /**
     * 通过索引，从中间或尾部或头部插入添加
     * @param index
     * @param e
     */
    public void add(int index,E e){
        if(index == 0){
            addFirst(e);
            return;
        }
        Node<E> newNode = new Node(e);
        Node<E> upNode = get(index);
        Node<E> downNode = get(index+1);
        newNode.next = downNode;
        upNode.next = newNode;


        //        if(index<0 || index>(size()-1)){
//            throw new RuntimeException("下角标越界");
//        }
//        Node<E> upNode = head;
//        Node<E> downNode = head;
//        for(int i=0;i<index-1;i++){
//            upNode = upNode.next;
//        }
//        for(int i=0;i<index;i++){
//            downNode = downNode.next;
//        }
//        if(downNode == head){
//            upNode.next = newNode;
//            newNode.next = head;
//        }else{
//            upNode.next = newNode;
//            newNode.next = downNode;
//        }

    }

    /**
     * 通过索引，获取元素
     * @param index
     * @return
     */
    public Node get(int index){
        Node e = null;
        Node<E> temp = head;
        int lt = index%size();
        if(lt == 0){
            while(temp.next != head){
                temp = temp.next;
            }
            e = temp;
        }else if(lt == 1){
            e = head;
        }else{
            for(int i = 1;i<lt;i++){
                temp = temp.next;
            }
            e = temp;
        }
        return e;



//        if(index<0 || index>(size()-1)){
//            throw new RuntimeException("下角标越界");
//        }
//        if(index == 0){
//            e = head;
//            return e;
//        }
//        Node<E> temp = head;
//        for(int i=0;i<index;i++){
//            temp = temp.next;
//        }
//        e = temp;
//        return e;
    }

    /**
     * 通过索引，删除元素，返回删除的元素值
     * @param index
     * @return
     */
    public E remove(int index){
        E e = null;
//        Node<E> temp = head;
//        while (temp.next != head){
//            temp = temp.next;
//        }
        if(index == 0){
            e = head.data;
            head = head.next;
//            temp.next = head;
            return e;
        }
        Node<E> rmNode = get(index);
        Node<E> upNode = get(index-1);
        Node<E> downNode = get(index+1);
        e = rmNode.data;
        rmNode = null;
        upNode.next = downNode;
        return e;

//        if(index<0 || index>(size()-1)){
//            throw new RuntimeException("下角标越界");
//        }

//        else if(index == (size()-1)){
//            Node<E> pre = head;
//            for(int i=0;i<index-1;i++){
//                pre = pre.next;
//            }
//            pre.next = head;
//            e = temp.data;
//            return e;
//        }else{
//            Node<E> upNode = head;
//            Node<E> downNode = head;
//            Node<E> rmNode = head;
//            for(int i=0;i<index-1;i++){
//                upNode = upNode.next;
//            }
//            for(int i=0;i<index+1;i++){
//                downNode = downNode.next;
//            }
//            for(int i=0;i<index;i++){
//                rmNode = rmNode.next;
//            }
//            upNode.next = downNode;
//            e = rmNode.data;
//            return e;
//        }
    }

    /**
     *
     * @param index
     * @param data
     * @return
     */
    public E set(int index,E data){
        E e = null;
        if(index == 0){
            e = head.data;
            head.data = data;
            return e;
        }else{
            Node<E> temp = head;
            for(int i=0;i<index;i++){
                temp = temp.next;
            }
            e = temp.data;
            temp.data = data;
            return e;
        }



//        if(index<0 || index>(size()-1)){
//            throw new RuntimeException("下角标越界");
//        }
    }

    /**
     * 获取链表大小
     * @return
     */
    public int size(){
        int size = 1;
        Node<E> temp = head;
        if(temp == null){
            return 0;
        }else if(temp.next == null){
            return size;
        }else{
            while(true){
               if(temp.next == head){
                   return size;
               }
               temp = temp.next;
               size++;
            }
        }
    }

    /**
     * 打印链表
     * @return
     */
    public String toString(){
        Node<E> curNode = head;
        StringBuilder sb = new StringBuilder("[");
        sb.append(head.data);
        if(head.next == null){
            sb.append("]");
        }else{
            sb.append(",");
            while ((curNode = curNode.next) != head){
                if(curNode.next == head){
                    sb.append(curNode.data).append("]");
                    return sb.toString();
                }
                sb.append(curNode.data).append(",");
            }
        }
        return sb.toString();
    }
}
