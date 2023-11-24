/*
 * LinkedListAssignment.java
 * Kevin Xu
 */

import java.util.*;

class LinkedListAssignment {
    public static void main(String[] args) {
        LList nums = new LList();

//        nums.push(1);
//        nums.push(2);
//        nums.push(3);
//        nums.push(4);
//        nums.push(5);
//        nums.push(6);
//
//        System.out.println(nums);
//        // System.out.println(nums.pop());
//        // System.out.println(nums);
//        System.out.println(nums.dequeue());
//        System.out.println(nums);
//        System.out.println(nums.getTail());
//        nums.enqueue(5);
//        nums.enqueue(6);
//        System.out.println(nums);
//        System.out.println(nums.getTail());

        for (int i=10; i>0; i--) {
            nums.enqueue(i);
            nums.enqueue(i);
        }

//        nums.enqueue(14);

        nums.sortedInsert(7);
        nums.sortedInsert(13);
        nums.sortedInsert(0);
        nums.sortedInsert(13);
        System.out.println(nums);
        nums.removeDuplicates();
        System.out.println(nums);

        nums.reverse();
        System.out.println(nums);

        LList nums2 = nums.clone();
        nums2.deleteAt(4);
        System.out.println(nums2);
        nums2.delete(9);
        System.out.println(nums2);
        nums2.delete(11);
        System.out.println(nums2);
        

    }
}

class LList{
    private LNode head, tail;

    public LList(){
        head = null;
        tail = null;
    }


// PROBLEM 1 -----------------------------------------------------------------------------------------------------------
    public void push(int v){
        // edge case - no nodes
        if (head == null && tail == null) {
            LNode tmp = new LNode(null, v, null);
            head = tmp;
            tail = tmp;
        }
        // normal
        else {
            LNode tmp = new LNode(null, v, head);
            head.setPrev(tmp);
            head = tmp;
        }
    }

    public int pop() {
        int ret = head.getVal();

        // edge case - one node
        if (head == tail) {
            head = null;
            tail = null;
            return ret;
        }
        else { // normal
            head = head.getNext();
            head.setPrev(null);
            return ret;
        }
    }




// PROBLEM 2 -----------------------------------------------------------------------------------------------------------
    public void enqueue(int v){

        if (head == null && tail == null) {
            LNode tmp = new LNode(null, v, null);
            head = tmp;
            tail = tmp;
        }
        else {
            LNode tmp = new LNode(tail, v, null);
            tail.setNext(tmp);
            tail = tmp;
        }

    }

    // same as pop (?)
    public int dequeue() {
        int ret = head.getVal();


        // edge case - one node
        if (head == tail) {
            head = null;
            tail = null;
            return ret;
        }

        else { // normal
            head = head.getNext();
            head.setPrev(null);
            return ret;
        }
    }



// PROBLEM 3 -----------------------------------------------------------------------------------------------------------
    public void delete(LNode node) {
        if (node == head) {
            head = head.getNext();
            head.setPrev(null);
        }
        else if (node == tail) {
            tail = tail.getPrev();
            tail.setNext(null);
        }
        else {
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
        }
    }

    public void delete(int num) {


        LNode tmp = head;
        while (tmp != null) {
            if (tmp.getVal() == num) {
                delete(tmp);
                return;
            }
            tmp = tmp.getNext();
        }

    }

    public void deleteAt(int index) {

        LNode tmp = head;
        for (int i = 0; i < index; i++) {
            tmp = tmp.getNext();
        }

        delete(tmp);

    }



// PROBLEM 4 -----------------------------------------------------------------------------------------------------------
    public void sortedInsert(int num) {
        // insert into a sorted list. in ascending order from tail to head
        // {6, 5, 4, 3, 2, 1}

        LNode tmp = head;

        if (head == null) {
            enqueue(num);
            return;
        }

        if (num > head.getVal()) {
            push(num);
            return;
        }

        if (num < tail.getVal()) {
            enqueue(num);
            return;
        }

        while (tmp != null) {
            if (tmp.getVal() < num) {
                LNode tmpNode = new LNode(tmp.getPrev(), num, tmp);
                tmp.getPrev().setNext(tmpNode);
                tmp.setPrev(tmpNode);
                return;
            }
            else {
                tmp = tmp.getNext();
            }
        }

    }


// PROBLEM 5 -----------------------------------------------------------------------------------------------------------
    public void removeDuplicates() {

        if (head == null) {
            return;
        }

        LNode tmp = head;
        while (tmp != null) {
            LNode tmp2 = tmp.getNext();
            while (tmp2 != null) {
                if (tmp.getVal() == tmp2.getVal()) {
                    delete(tmp2);
                }
                tmp2 = tmp2.getNext();
            }
            tmp = tmp.getNext();
        }

    }

// PROBLEM 6 -----------------------------------------------------------------------------------------------------------

    public void reverse() {
        LList temp = new LList();
        LNode cur = head;

        while (cur != null) {
            temp.push(cur.getVal());
            cur = cur.getNext();
        }

        head = temp.getHead();
        tail = temp.getTail();

    }

// PROBLEM 7 -----------------------------------------------------------------------------------------------------------
    public LList clone() {
        LList nlist = new LList();
        LNode cur = head;

        while (cur != null) {

            nlist.enqueue(cur.getVal());

            cur = cur.getNext();

        }

        return nlist;
    }

// ---------------------------------------------------------------------------------------------------------------------

    // OTHER METHODS
    public String toString(){
        String ans = "";
        LNode tmp = head;

        while(tmp != null){
            if(tmp.getNext() == null){
                ans += tmp;
            }
            else{
                ans += tmp + ", ";
            }
            tmp = tmp.getNext();
        }
        return "{" + ans +"}";
    }

    public LNode getHead() {
        return head;
    }
    public LNode getTail() {
        return tail;
    }

}

class LNode{

    private int val;
    private LNode next, prev;
    // previous value next
    public LNode(LNode p, int v, LNode n){
        prev = p;
        val = v;
        next = n;
    }

    public int getVal(){
        return val;
    }

    public LNode getNext(){
        return next;
    }

    public LNode getPrev(){
        return prev;
    }

    public void setVal(int v){
        val = v;
    }

    public void setNext(LNode n){
        next = n;
    }

    public void setPrev(LNode p){
        prev = p;
    }



    public String toString(){
        return ""+val;
    }

}
