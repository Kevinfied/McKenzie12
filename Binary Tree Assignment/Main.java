
import java.util.*;
import java.io.*;

public class Main {
    public static void main(String []args){
        BTree oak = new BTree();
        BTree spruce = new BTree();

        oak.add(10);
        oak.add(15);
        oak.add(3);
        oak.add(15);
        oak.add(11);
        oak.add(17);
        oak.add(7);
//        oak.graph();
        System.out.println("Leaves: " + oak.countLeaves());

        /*
        oak.add(4);
        oak.add(2);
        oak.add(6);
        oak.add(1);
        oak.add(3);
        oak.add(5);
        oak.add(7);
        oak.add(8);
        oak.graph();
        System.out.println(oak);
        oak.display(Order.INORDER);
        oak.display(Order.PREORDER);
        oak.display(Order.POSTORDER);

        oak.delete(4);
        System.out.println(oak);

        spruce.add(4);
        spruce.add(9);
        spruce.add(123908);


        oak.add(spruce);
        System.out.println(oak);
        System.out.println(oak.isAncestor(2, 1));
        System.out.println(oak.countLeaves()); */
//        oak.graph();

    }

    public void println(Object o) {
        System.out.println(o);
    }

    public void print(Object o) {
        System.out.print(o);
    }

}

enum Order {
    INORDER, PREORDER, POSTORDER
};

class BTree{
    private BNode root;



    public BTree(){
        root=null;
    }

    public void add(int v){
        if(root == null){
            root = new BNode(v);
        }
        else{
            add(root, v);
        }
    }

    public void add(BNode branch, int v) {
        if(v < branch.getVal()) {
            if(branch.getLeft()==null) {
                branch.setLeft(new BNode(v));
            }
            else {
                add(branch.getLeft(), v);
            }
        }
        if (v > branch.getVal()) {
            if(branch.getRight()==null) {
                branch.setRight(new BNode(v));
            }
            else{
                add(branch.getRight(), v);
            }
        }
    }

// QUESTION 1 - depth
    public int depth(int num) { // takes an integer and returns the depth of where its found.
        // returns -1 if not found.

        return depth(root, num, 0);
    }

    public int depth(BNode branch, int num, int depth) {
        if (branch == null) {
            return -1;
        }
        if (branch.getVal() == num) {
            return depth;
        }
        if (num < branch.getVal()) {
            return depth(branch.getLeft(), num, depth + 1);
        }
        if (num > branch.getVal()) {
            return depth(branch.getRight(), num, depth + 1);
        }
        return -1;
    }

// QUESTION 2 - display

    public void display() {
        display(Order.INORDER);
    }
    public void display(Order order) {

        if (order == Order.INORDER) {
            System.out.println("<" + inorder(root).substring(0, inorder(root).length()-2) + ">");
        }
        if (order == Order.PREORDER) {
            System.out.println("<" + preorder(root).substring(0, preorder(root).length()-2) + ">");
        }
        if (order == Order.POSTORDER) {
            System.out.println("<" + postorder(root).substring(0, postorder(root).length()-2) + ">");
        }
    }

    public String inorder(BNode branch) {
        if (branch == null) {
            return "";
        }
        return inorder(branch.getLeft()) + branch.getVal() + ", " + inorder(branch.getRight());
    }

    public String preorder(BNode branch) {
        if (branch == null) {
            return "";
        }
        return branch.getVal() + ", " + preorder(branch.getLeft()) + preorder(branch.getRight());
    }

    public String postorder(BNode branch) {
        if (branch == null) {
            return "";
        }
        return postorder(branch.getLeft()) + postorder(branch.getRight()) + branch.getVal() + ", ";
    }


// QUESTION 3 - countLeaves
    public int countLeaves() {
        return countLeaves(root);
    }

    public int countLeaves(BNode branch) {
        if (branch == null) {
            return 0;
        }
        if (branch.getLeft() == null && branch.getRight() == null) {
            return 1;
        }
        return countLeaves(branch.getLeft()) + countLeaves(branch.getRight());
    }



// QUESTION 4 - height
    public int height() {
        return height(root);
    }

    public int height(BNode branch) {
        if (branch == null) {
            return 0;
        }

        if (branch.isLeaf()) {
            return 1;
        }

        return 1 + Math.max(height(branch.getLeft()), height(branch.getRight()));
    }

// QUESTION 5 - isAncestor
    public boolean isAncestor(int a, int b) {

        BNode ancestor = find(a);

        if (find(ancestor, b) != null) {
            return true;
        }

        return false;
    }

// QUESTION 6 - delete
    // keep inorder?
    public void delete(int val) {
        root = delete(root, val);
    }

    public BNode delete(BNode branch, int val) {
        if (branch == null) { // base case
            return null;
        }

        if (val < branch.getVal()) {
            branch.setLeft(delete(branch.getLeft(), val));
        }
        else if (val > branch.getVal()) {
            branch.setRight(delete(branch.getRight(), val));
        }

        else {

            if (branch.getLeft() == null) {
                return branch.getRight();
            }
            else if (branch.getRight() == null) {
                return branch.getLeft();
            }

            branch.setVal(getMin(branch.getRight()).getVal());

            branch.setRight(delete(branch.getRight(), branch.getVal()));

        }

        return branch;
    }

    public BNode getMin(BNode branch) {
        if (branch.getLeft() == null) {
            return branch;
        }
        return getMin(branch.getLeft());
    }


// QUESTION 7 - isBalanced
    public boolean isBalanced() {
        return isBalanced(root);
    }

    public boolean isBalanced(BNode branch) {
        if (branch == null) {
            return true;
        }
        if (Math.abs(height(branch.getLeft()) - height(branch.getRight())) <= 1) {
            return isBalanced(branch.getLeft()) && isBalanced(branch.getRight());
        }
        return false;
    }

// QUESTION 8 - add
    // overload add so that it takes a BTree as a parameter. Add copies of all the nodes of the BTree to
    // the current tree.

    // recurse to add all the nodes of the tree to the current tree


    public void add(BTree tree) {
        add(tree.getRoot());
    }

    public void add(BNode branch) {
        if (branch == null) {
            return;
        }
        add(branch.getLeft());
        add(branch.getRight());
        add(branch.getVal());
    }

// ----------------------------------------------

    public BNode find(int val) {
        return find(root, val);
    }

    public BNode find(BNode branch, int val) {
        if (branch == null || branch.getVal() == val) {
            return branch;
        }

        else if (val < branch.getVal()) {
            return find(branch.getLeft(), val);
        }

        else if (val > branch.getVal()) {
            return find(branch.getRight(), val);
        }

        return null;
    }



    public void graph() {
        graph(root, 0);
    }

    private void graph(BNode node, int depth) {
        if (node == null) {
            return;
        }

        graph(node.getRight(), depth + 1);

        for (int i = 0; i < depth; i++) {
            System.out.print("   ");
        }

        System.out.println(node.getVal());

        graph(node.getLeft(), depth + 1);
    }







    @Override
    public String toString(){
        String str = stringify(root);
        return "<" + str.substring(0, str.length()-2) + ">";
    }



    public String stringify(BNode branch){
        if(branch==null){
            return "";
        }
        return stringify(branch.getLeft()) + branch.getVal()+", "+ stringify(branch.getRight());
    }

    public BNode getRoot() {
        return root;
    }

    public void setRoot(BNode r) {
        root = r;
    }


}

class BNode{
    private int val;
    private BNode left, right;

    public BNode(int v){
        left = null;
        right = null;
        val = v;
    }

    public int getVal(){
        return val;
    }
    public void setVal(int v){
        val=v;
    }
    public BNode getLeft(){
        return left;
    }
    public BNode getRight(){
        return right;
    }

    public void setLeft(BNode lf){
        left=lf;
    }
    public void setRight(BNode r){
        right=r;
    }

    public boolean isLeaf(){
        return (left==null && right==null);
    }

}
