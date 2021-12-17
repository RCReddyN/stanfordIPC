/*
ID: rcreddyn
Implementing UnionFind
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

public class UnionFind{
    private int [] arr;
    private int capacity;

    UnionFind(int capacity){
        this.capacity = capacity;
        arr = new int[this.capacity];
        for(int i=0; i<capacity; i++){
            arr[i] = i;
        }
    }
    int getID(int n){
        return arr[n];
    }

    int find(int p){
        if(p == arr[p]){
            return p;
        }
        int root = find(arr[p]);
        arr[p] = root;
        return root;
    }

    void union(int p, int q){
        arr[find(p)] = find(q);
    }
	public static void main(String [] args){
		FastIO io = new FastIO();
		io.close();
	}
}