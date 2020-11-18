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

        tree.inOrder();
      

    }
    
}
