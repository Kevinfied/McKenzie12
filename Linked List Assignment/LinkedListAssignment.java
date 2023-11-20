/*
 * LinkedListAssignment.java
 * Kevin Xu
 */



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
        System.out.println(nums.pop());
        System.out.println(nums);
        System.out.println(nums.dequeue());
        nums.enqueue(5);
        nums.enqueue(6);
        System.out.println(nums);
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

        // no nodes
        if (head == null && tail == null) {
            LNode tmp = new LNode(null, v, null);
            head = tmp;
            tail = tmp;
        }
        else {
            LNode tmp = new LNode(null, v, head);
            head.setPrev(tmp);
            head = tmp;
        }


    }

    public int pop() {
        int ret = head.getVal();
        head = head.getNext();

        return ret;
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


    public int dequeue() {
        int ret = head.getVal();
        head = head.getNext();

        return ret;
    }








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
