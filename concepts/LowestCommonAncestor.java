/*
ID: rcreddyn
Implementing LowestCommonAncestor
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

public class LowestCommonAncestor{

    class Node{
        int val;
        Node left;
        Node right;
        int depth;
        Node parent;

        Node(int val){
            this.val = val;
        }
        Node(int val, int depth, Node parent){
            this(val);
            this.depth =depth;
            this.parent = parent;
        }
    }
    Node root;
    LowestCommonAncestor(){
        root = null;
    }

    void insert(int val){
        root = insert(root, val, 0, new Node(-1));
    }

    Node insert(Node node, int val, int d, Node parent){
        if(node == null){
            return new Node(val, d, parent);
        }
        if(node.val < val){
            node.right = insert(node.right, val, d+1, node);
        }
        else{
            node.left = insert(node.left, val, d+1, node);
        }
        return node;
    }

    Node search(int val){
        return search(root, val);
    }

    Node search(Node node, int val){
        if(node.val == val){
            return node;
        }
        if(node.val < val){
            return search(node.right, val);
        }
        return search(node.left, val);
    }

    int getLCA(int n1, int n2){
        Node u = search(n1);
        Node v = search(n2);
        while(u.depth != v.depth){
            if(u.depth > v.depth){
                u = u.parent;
            }
            else{
                v = v.parent;
            }
        }
        while(!u.equals(v)){
            u = u.parent;
            v = v.parent;
        }
        return u.val;
    }
	public static void main(String [] args){
		FastIO io = new FastIO();
        LowestCommonAncestor tree = new LowestCommonAncestor();
        tree.insert(20);
        tree.insert(8);
        tree.insert(22);
        tree.insert(4);
		tree.insert(12);
        tree.insert(10);
        tree.insert(14);
        io.write(tree.getLCA(10, 14)+"\n");
        io.write(tree.getLCA(14, 8)+"\n");
        io.write(tree.getLCA(10, 22)+"\n");
		io.close();
	}
}