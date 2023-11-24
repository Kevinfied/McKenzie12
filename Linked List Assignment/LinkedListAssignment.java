/*
 * LinkedListAssignment.java
 * Kevin Xu
 *
 * Linked List class that allows for the following:
 * 1. push() - adds a node to the front of the list
 * 2. pop() - removes the top node and returns its value
 * 3. enqueue() - adds a node to the back of the list
 * 4. dequeue() - removes the top node and returns its value
 * 5. delete() - takes either a node or an integer value and deletes the first instance of it
 * 6. deleteAt() - takes an integer index and deletes the node at that position
 * 7. sortedInsert() - takes an integer value and inserts it into a descending sorted list
 * 8. removeDuplicates() - removes all duplicates in the list
 * 9. reverse() - reverses the list
 * 10. clone() - returns a copy of the list
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
    private LNode head, tail; // head and tail pointers. point to the first node and the last node, respectively

    // constructor
    public LList(){
        head = null;
        tail = null;
    }


// PROBLEM 1 -----------------------------------------------------------------------------------------------------------
    public void push(int v){ // adds a node to the front of the list
        // O(1)
        // edge case - no nodes
        if (head == null && tail == null) {
            // if there are no nodes, then just have "head" and "tail" point to the new node
            LNode tmp = new LNode(null, v, null);
            head = tmp;
            tail = tmp;
        }
        // normal
        else {
            // create a new node, set the next nodes "prev" to the new node, and make "head" point to the new node
            LNode tmp = new LNode(null, v, head);
            head.setPrev(tmp);
            head = tmp;
        }
    }

    public int pop() { // removes the top node and returns its value
        // O(1)
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
    public void enqueue(int v){ // adds a node to the back of the list
        // O(1)
        // edge case - no nodes
        if (head == null && tail == null) {
            // if there are no nodes, then just have head and tail point to the new node
            LNode tmp = new LNode(null, v, null);
            head = tmp;
            tail = tmp;
        }
        else {
            // general case

            // create a new node, set the last node's next to the new node, and make tail point to the new node
            LNode tmp = new LNode(tail, v, null);
            tail.setNext(tmp);
            tail = tmp;
        }

    }

    // same as pop (?)
    public int dequeue() { // removes the top node and returns its value
        // O(1)
        int ret = head.getVal(); // return value

        // edge case - one node
        if (head == tail) {
            // if there is only one node, make head and tail point to null.
            head = null;
            tail = null;
            return ret;
        }
        else { // general case

            // make head point to the next node, and make the next node's prev point to null
            head = head.getNext();
            head.setPrev(null);
            return ret;
        }
    }

// PROBLEM 3 -----------------------------------------------------------------------------------------------------------
    public void delete(LNode node) { // deleting a node
        // O(1) 🤯
        if (node == head) { // if deleting the first node
            head = head.getNext();
            head.setPrev(null);
        }
        else if (node == tail) { // if deleting the last node
            tail = tail.getPrev();
            tail.setNext(null);
        }
        else { // general case

            // very simple. just make the prev and next nodes point to each other
            node.getPrev().setNext(node.getNext());
            node.getNext().setPrev(node.getPrev());
        }
    }

    public void delete(int num) { // deleting the first instance of an integer value
        // O(N)
        LNode tmp = head;
        while (tmp != null) {
            // loop until the value is found and delete it.
            if (tmp.getVal() == num) {
                delete(tmp);
                return;
            }
            tmp = tmp.getNext();
        }
    }

    public void deleteAt(int index) { // deleting a node at a given index. ZERO INDEXED
        // O(N)
        LNode tmp = head;
        // just loop through and delete the value at the given index
        for (int i = 0; i < index; i++) {
            tmp = tmp.getNext();
        }
        delete(tmp);
    }


// PROBLEM 4 -----------------------------------------------------------------------------------------------------------
    public void sortedInsert(int num) {
        // inserts a value into a sorted list. in ascending order from tail to head
        // {6, 5, 4, 3, 2, 1}

        // O(log N) is impossible 😢
        // have to go with O(N)
        LNode tmp = head;

        if (head == null) { // if there are no nodes, just add it to the list
            enqueue(num);
            return;
        }
        if (num > head.getVal()) { // if the value is greater than the top node, add it to the front
            push(num);
            return;
        }
        if (num < tail.getVal()) { // if the value is less than the last node, add it to the back
            enqueue(num);
            return;
        }

        // general case
        while (tmp != null) {
            // loop through until the value is less than a node and add it there
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
    public void removeDuplicates() { // removes all duplicates in the list
        if (head == null) { // if there are no nodes, nothing happens
            return;
        }

        LNode tmp = head;
        // O(N^2)
        // very efficient!
        while (tmp != null) {
            // loop through all values and delete all repeating instances of said value after its position
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
    public void reverse() { // reverses list
        // O(N)
        LList temp = new LList();
        LNode cur = head;

        // grabs all values and pushes them to a new list
        // effectively creating a new list that is in reverse order of the original
        while (cur != null) {
            temp.push(cur.getVal());
            cur = cur.getNext();
        }

        // make head and tail point to the new list's first node and last node
        head = temp.getHead();
        tail = temp.getTail();
    }

// PROBLEM 7 -----------------------------------------------------------------------------------------------------------
    public LList clone() { // returns a copy of list
        // O(N)
        LList nlist = new LList();
        LNode cur = head;

        // same as reverse, but i enqueue instead of push
        // effectively making a new list in the same order as the original
        while (cur != null) {
            nlist.enqueue(cur.getVal());
            cur = cur.getNext();
        }

        return nlist;
    }

// ---------------------------------------------------------------------------------------------------------------------


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
