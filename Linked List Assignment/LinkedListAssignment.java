/*
 * LinkedListAssignment.java
 * Kevin Xu
 */

import java.util.*;

class LinkedListAssignment {
    public static void main(String[] args) {
        LList nums = new LList();

        nums.push(1);
         nums.push(2);
         nums.push(3);
         nums.push(4);
         nums.push(5);
         nums.push(6);

        System.out.println(nums);
        // System.out.println(nums.pop());
        // System.out.println(nums);
        System.out.println(nums.dequeue());
        System.out.println(nums);
        System.out.println(nums.getTail());
        nums.enqueue(5);
        nums.enqueue(6);
        System.out.println(nums);
        System.out.println(nums.getTail());

    }
}

class LList{
    private LNode head, tail;

    public LList(){
        head = null;
        tail = null;
    }


    // PROBLEM 1
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




    // PROBLEM 2
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

    // PROBLEM 3


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

        for (int i = 0; i < index; i++) {
            head = head.getNext();

            head.setPrev(null);
        }
    }

    // PROBLEM 4

    public void insertAt(int index, int num) {

    }


    // PROBLEM 5

    public void removeDuplicates() {

    }



    // PROBLEM 6
    public void reverse() {

    }


    // PROBLEM 7
    // ?????

    public void clone(LList list) {

    }




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
