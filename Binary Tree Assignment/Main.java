public class Main {
    public static void main(String []args){

        BTree oak = new BTree();
        oak.add(50);
        oak.add(30);
        oak.add(80);
        oak.add(40);
        oak.add(100);
        oak.add(70);
        oak.add(60);
        oak.add(75);
        oak.add(35);
        oak.add(37);
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


    public void display() {
        
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
    public BNode getLeft(){
        return left;
    }
    public BNode getRight(){
        return right;
    }
    public void setVal(int v){
        val=v;
    }
    public void setLeft(BNode lf){
        left=lf;
    }
    public void setRight(BNode r){
        right=r;
    }

}
