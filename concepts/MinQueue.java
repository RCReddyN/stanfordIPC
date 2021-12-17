/*
ID: rcreddyn
Implementing MinQueue
LANG: JAVA
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
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

class Pair{
    int first;
    int second;

    Pair(int first, int second){
        this.first = first;
        this.second = second;
    }
}

public class MinQueue{
    Stack<Pair> s1;
    Stack<Pair> s2;
    MinQueue(){
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    int getMin(){
        if(s1.empty() || s2.empty()){
            return s1.empty() ? s2.peek().second : s1.peek().second;
        }
        return Math.min(s1.peek().second, s2.peek().second);
    }

    void enqueue(int val){
        int min = s1.empty()? val : Math.min(val, s1.peek().second);
        s1.push(new Pair(val, min));
    }

    void dequeue(){
        if(s2.empty()){
            while(!s1.empty()){
                int element = s1.peek().first;
                s1.pop();
                int min = s2.isEmpty()? element : Math.min(element, s2.peek().second);
                s2.push(new Pair(element, min));
            }
        }
        s2.pop();
    }
	public static void main(String [] args){
		FastIO io = new FastIO();
        MinQueue arr = new MinQueue();
        arr.enqueue(1);
        arr.enqueue(2);
        arr.enqueue(4);
        System.out.println(arr.getMin());
        arr.dequeue();
        System.out.println(arr.getMin());
		io.close();
		io.close();
	}
}