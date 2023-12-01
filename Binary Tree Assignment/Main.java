
import java.util.*;

public class Main {
    public static void main(String []args){

        BTree oak = new BTree();
//        oak.add(50);
//        oak.add(30);
//        oak.add(80);
//        oak.add(40);
//        oak.add(100);
//        oak.add(70);
//        oak.add(60);
//        oak.add(75);
//        oak.add(35);
//        oak.add(37);

        oak.add(4);
        oak.add(2);
        oak.add(6);
        oak.add(1);
        oak.add(3);
        oak.add(5);
        oak.add(7);

        System.out.println(oak);
//        System.out.println(oak.preOrder(oak.getRoot()));
//        System.out.println(oak.postOrder(oak.getRoot()));
//        oak.countLeaves(oak.getRoot());
//       System.out.println(oak.Height(oak.getRoot()));
        System.out.println(oak.isAncestor(2, 1));
        System.out.println(oak.countLeaves(oak.getRoot()));
        System.out.println(oak);
    }
}

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

    public void add(BNode branch, int v){
        if(v < branch.getVal()){
            if(branch.getLeft()==null){
                branch.setLeft(new BNode(v));
            }
            else{
                add(branch.getLeft(), v);
            }
        }
        if(v > branch.getVal()){
            if(branch.getRight()==null){
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

//    public void delete(int val) {
//        root = delete(root, val);
//
//    }
//
//    public BNode delete(BNode branch, int val) {
//        if (branch == null) {
//            return null;
//        }
//        if (val < branch.getVal()) {
//            branch.setLeft(delete(branch.getLeft(), val));
//        }
//        else if (val > branch.getVal()) {
//            branch.setRight(delete(branch.getRight(), val));
//        }
//        else {
//            if (branch.getLeft() == null) {
//                return branch.getRight();
//            }
//            else if (branch.getRight() == null) {
//                return branch.getLeft();
//            }
//            branch.setVal(min(branch.getRight()));
//            branch.setRight(delete(branch.getRight(), branch.getVal()));
//        }
//        return branch;
//    }



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

    @Override
    public String toString(){
        return "<" + stringify(root) + ">";
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

}
