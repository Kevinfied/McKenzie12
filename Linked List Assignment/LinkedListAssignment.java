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

        System.out.println(nums);
    }
}

class LList{
    private LNode head;
    public LList(){
        head = null;
    }

    public void push(int v){
        LNode tmp = new LNode(v, head);
        head = tmp;

    }

    public int pop() {
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
    private LNode next;

    public LNode(int v, LNode n){
        val = v;
        next = n;
    }

    public int getVal(){
        return val;
    }

    public LNode getNext(){
        return next;
    }

    public void setVal(int v){
        val = v;
    }

    public void setNext(LNode n){
        next = n;
    }

    public String toString(){
        return ""+val;
    }

}
