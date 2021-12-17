/*
ID: rcreddyn
Implementing MinStack
LANG: JAVA
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Stack;
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

public class MinStack{
    private Stack<Pair> st;

    MinStack(){
        st = new Stack<>();
    }

    void push(int val){
        int new_min = val;
        if(!st.empty()){
            new_min = Math.min(new_min, st.peek().second);
        }
        st.push(new Pair(val, new_min));
    }

    void pop(){
        if(st.empty()){
            return;
        }
        st.pop();
    }

    int peek(){
        if(st.empty()){
            return Integer.MIN_VALUE;
        }
        return st.peek().first;
    }

    int getMin(){
        if(st.empty()){
            return Integer.MAX_VALUE;
        }
        return st.peek().second;
    }
	public static void main(String [] args){
		FastIO io = new FastIO();
        MinStack s = new MinStack();
        s.push(3);
        s.push(5);
        io.write("curr min: " + s.getMin()+"\n");
        s.push(2);
        s.push(1);
        io.write("curr min: " + s.getMin()+"\n");
        io.write("popped: " + s.peek()+"\n");
        s.pop();
        io.write("curr min: " + s.getMin()+"\n");
        io.write("popped: " + s.peek()+"\n");
        s.pop();
        io.write("curr top: " + s.peek()+"\n");
        
		io.close();
	}
}

class Pair{
    int first;
    int second;

    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}