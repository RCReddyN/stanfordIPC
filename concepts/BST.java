/*
ID: rcreddyn
Implementing BST
LANG: JAVA
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

class FastIO{
    private BufferedReader input;
    private StringTokenizer st;
    private BufferedWriter output;
    
    FastIO(){
        input = new BufferedReader(new InputStreamReader(System.in));
        output = new BufferedWriter(new OutputStreamWriter(System.out));
    }

    String nextLine(){
        String str = "";
        try{
            str = input.readLine();
        }
        catch(IOException e){
            e.printStackTrace();
        }
        return str;
    }

    String next(){
        while(st == null || !st.hasMoreTokens()){
            st = new StringTokenizer(nextLine());
        }
        return st.nextToken();
    }
    
    int nextInt(){
        return Integer.parseInt(next());
    }

    double nextDouble(){
        return Double.parseDouble(next());
    }

    long nextLong(){
        return Long.parseLong(next());
    }

    void write(String content){
        try{
            output.append(content+"");
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }

    void close(){
        try{
            output.flush();
            input.close();
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}

public class BST{
    class Node{
        int val;
        Node left;
        Node right;
        Node(int val){
            this.val = val;
        }
    }

    Node root;
    
    BST(){
        root = null;
    }

    Node find(int val){
        return find(root, val);
    }

    private Node find(Node node, int val){
        if(node.val == val){
            return node;
        }
        if(node.val < val){
            return find(node.right, val);
        }
        return find(node.left, val);
    }

    void insert(int val){
        root = insert(root, val);
    }
    
    Node insert(Node node, int val){
        if(node == null){
            node = new Node(val);
            return node;
        }
        if(node.val < val){
            node.right = insert(node.right, val);
        }
        else{
            node.left = insert(node.left, val);
        }
        return node;
    }
    
    void delete(int val){
        root = delete(root, val);
    }

    Node delete(Node node, int val){
        if(node == null){
            return node;
        }
        if(node.val < val){
            node.right = delete(node.right, val);
        }
        else if(node.val > val){
            node.left = delete(node.left, val);
        }
        else{
            if(node.left == null){
                return node.right;
            }
            else if(node.right == null){
                return node.left;
            }
            node.val = inOrderSuccessor(node.right);
            node.right = delete(node.right, node.val);
        }
        return node;
    }

    void inOrder(FastIO io){
        inOrder(root, io);
        io.write("\n");
    }

    void inOrder(Node node, FastIO io){
        if(node == null){
            return;
        }
        inOrder(node.left, io);
        io.write(node.val+" ");
        inOrder(node.right, io);
    }

    int inOrderSuccessor(Node node){
        int minValueOnRight = node.val;
        while(node.left != null){
            minValueOnRight = node.left.val;
            node = node.left;
        }
        return minValueOnRight;
    }
	public static void main(String [] args){
		FastIO io = new FastIO();
        BST tree = new BST();
        tree.insert(50);
        tree.insert(30);
        tree.insert(20);
        tree.insert(40);
        tree.insert(70);
        tree.insert(60);
        tree.insert(80);
 
        io.write("Inorder traversal of the given tree\n");
        tree.inOrder(io);
        io.write("\nDelete 20\n");
        tree.delete(20);
        io.write("Inorder traversal of the modified tree\n");
        tree.inOrder(io);
        io.write("\nDelete 30\n");
        tree.delete(30);
        io.write("Inorder traversal of the modified tree\n");
        tree.inOrder(io);
        io.write("\nDelete 50\n");
        tree.delete(50);
        io.write("Inorder traversal of the modified tree\n");
        tree.inOrder(io);
        io.close();
	}
}