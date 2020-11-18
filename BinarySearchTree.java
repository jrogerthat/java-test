import java.util.LinkedList; 
import java.util.Queue; 
import java.util.List;
import java.util.ArrayList;

public class BinarySearchTree {

    class Node{
        int key;
        Node left;
        Node right;

        public Node(int data){
            key = data;
            left = null;
            right = null;
        }
    }

    Node root;

    BinarySearchTree(){ root = null; }

    List<List<Integer>> levelOrderBottom(Node root) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        if(root == null) return res;
        Queue<Node> queue = new LinkedList<>();
        queue.offer(root);
        while(!queue.isEmpty()) {
            List<Integer> list = new ArrayList();
            int size = queue.size();
            for(int i = 0; i<size; i++) {
                Node node = queue.poll();
                list.add(node.key);
                if(node.left != null) queue.add(node.left);
                if(node.right != null) queue.add(node.right);
            }
            res.add(0, list);
        }
        return res;
    }

    void bfsPrint(Node node){
        int h = getHeight(node);
        for(int i = 1; i <= h; i++){
            printLevel(node, i);
        }
    }

    int getHeight(Node node){
        if(node == null){
            return 0;
        }else{
            int leftH = getHeight(node.left);
            int rigH = getHeight(node.right);

            if(leftH > rigH) return (leftH + 1);
            else return(rigH + 1);
        }
    }

    void printLevel(Node node, int in){
        if(node ==  null){
            return;
        }
        if(in == 1){
            System.out.println(node.key + " ");
        }else if(in > 1){
            printLevel(node.left, in-1);
            printLevel(node.right, in-1);
        }
    }

    Node mirror(Node node){
        if(node == null){
            return node;
        }
        Node left = mirror(node.left);
        Node right = mirror(node.right);

        node.left = right;
        node.right = left;

        return node;
    }

    void insert(int key){
        root = insertRec(root, key);
    }

    Node insertRec(Node node, int key){
        if(node == null){
            node = new Node(key);
            return node;
        }
        if(key < node.key){
            node.left = insertRec(node.left, key);
        }
        if(key > node.key){
           node.right = insertRec(node.right, key);
        }
        return node;
    }

    void inOrder(){
        inOrderRec(root);
    }
//TRAVERSE THAT BITCH
    void inOrderRec(Node node){
        if(node != null){
            inOrderRec(node.left);
            System.out.println(node.key + " ");
            inOrderRec(node.right);
        }
    }
    public static void main(String[] args){

        BinarySearchTree tree = new BinarySearchTree();

        tree.insert(50);
        tree.insert(40);
        tree.insert(70);
        tree.insert(100);
        tree.insert(20);
        tree.insert(44);

        tree.inOrder();

        int h = tree.getHeight(tree.root);
        System.out.println("h:  " + h);

        // tree.mirror(tree.root);

        // System.out.println("reverse reverse: ");
        // tree.inOrder();

        // System.out.println("testing BFS: ");

        // tree.bfsPrint(tree.root);

        List<List<Integer>> test = tree.levelOrderBottom(tree.root);

        System.out.println(test + " " + test.get(0));

        for(int i = 0; i < test.size(); i++){
            String s = "";
            for(int j = 0; j < test.get(i).size(); j++){
                s = s+ ", " +test.get(i).get(j);
            }
            System.out.println("level" + s);
        }
      

    }
    
}
