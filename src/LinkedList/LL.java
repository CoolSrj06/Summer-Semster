/* These are the code coded by me after studying from lectures by Kunal Kushwaha
* some codes may be different from what he has taught */

package LinkedList;

import javax.swing.*;

public class LL {
    private Node head;
    private Node tail;
    public int size;
    public LL(){
        this.size=0;
    }

    //'LL' is a class and 'Node' is class inside LL.If LL is for complete Linked List then Node is for a single Node.
    private static class Node{
        int val;
        Node next;
        public Node(){
            this.next=null;
        }

        public Node(int val){
            this.val=val;
        }
        public Node(int val,Node next){
            this.val=val;
            this.next=next;
        }
    }
    //add a value in link list from start
    public void insertFirst(int val){
        Node node = new Node(val);
        node.next=head;
        head=node;

        if(tail==null){
            tail=head;
        }
        size+=1;
    }

    //insert last method
    public void insertLast(int val){
        Node node = new Node(val);
        if (tail==null) {//if the linked list is purely empty, it checks, if yes it directly inserts node in the tail
            tail=head=node;
        }else {
            tail.next = node;//if there is a node already then it inserts in the last
            tail = node;
        }
        size+=1;
    }

    //insert value in linked list using recursion
    public void insert (int val,int index){
        Node node=head;
        insertVal (val,index,node);
    }
    private void insertVal(int val,int index,Node node){
        if(index==0){
            insertFirst(val);
            return;
        }
        if(index==1){
            node.next=new Node(val,node.next);
            return;
        }

        insertVal(val,index-1,node.next);
    }

//    merge two sorted array,LL return type is to return a complete merged linked list
    public static LL merge(LL list1,LL list2) {
        Node f = list1.head;
        Node s = list2.head;

        LL ans = new LL();

        while (f != null && s != null) {
            if (f.val < s.val) {
                ans.insertLast(f.val);
                f=f.next;
            }else {
                ans.insertLast(s.val);
                s=s.next;
            }
        }
        while (f!=null){
            ans.insertLast(f.val);
            f=f.next;
        }

        while (s!=null){
            ans.insertLast(s.val);
            s=s.next;
        }
        return ans;
    }

    //if return type is a single node
    public static Node mergedHead(LL list1,LL list2) {
        Node f = list1.head;
        Node s = list2.head;

        LL ans = new LL();

        while (f != null && s != null) {
            if (f.val < s.val) {
                ans.insertLast(f.val);
                f=f.next;
            }else {
                ans.insertLast(s.val);
                s=s.next;
            }
        }
        while (f!=null){
            ans.insertLast(f.val);
            f=f.next;
        }

        while (s!=null){
            ans.insertLast(s.val);
            s=s.next;
        }
        return ans.head;
    }
    public void display(){
        Node node=head;
        while(node!=null){
            System.out.print(node.val+" --> ");
            node=node.next;
        }
        System.out.println("END");
    }


    //returns the sorted Linked list with no duplicate elements in it.
    public static void duplicate(Node Head) {
        if(Head==null) {
            System.out.println("END");
            return;
        }
        System.out.print(Head.val + " --> ");
        while (Head.next!= null && Head.val == Head.next.val) {
            Head = Head.next;
        }
        duplicate(Head.next);
    }

    //circular link list
    public boolean checkCircular(){
        Node s=head;
        Node f=head;
        while (f!=null&&f.next!=null) {
            s = s.next;
            f = f.next.next;
            if (s == f)
                return true;
        }
        return false;
    }

    //length of linked list cycle
    public int circularLength(Node head){
        Node s=head;
        Node f=head;
        int length=0;
        while (f!=null&&f.next!=null) {
            s = s.next;
            f = f.next.next;
            if (s == f) {
                Node temp=s.next;
                while (temp!=s){
                    length+=1;
                    temp=temp.next;
                }
                return length+1;
            }
        }
        return 0;
    }
    public static void main(String[] args) {

        LL list1=new LL();
        list1.insertLast(1);
        list1.insertLast(2);
        list1.insertLast(3);
        list1.insertLast(4);

        LL list2 = new LL();
        list2.insertLast(5);
        list2.insertLast(6);
        list2.insertLast(7);
        list2.insertLast(8);



//        list1.display();
//        list2.display();
//        System.out.println(mergedHead(list1,list2).val);

        LL list=new LL();
        list.insertLast(3);
        list.insertLast(3);
        list.insertLast(3);
        list.insertLast(3);
        list.insertLast(3);

       duplicate(list.head);
    }
}
