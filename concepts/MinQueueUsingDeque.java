/*
ID: rcreddyn
Implementing MinQueueUsingDeque
LANG: JAVA
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Deque;
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

public class MinQueueUsingDeque{
    private Deque<Pair> q;
    private int addedCount;
    private int removedCount;
    MinQueueUsingDeque(){
        q = new ArrayDeque<>();
        addedCount = 0;
        removedCount = 0;
    }

    int getMin(){
        return q.peekFirst().first;
    }

    void enqueue(int val){
        while(!q.isEmpty() && q.peekLast().first > val){
            q.pollLast();
        }
        q.add(new Pair(val, addedCount));
        addedCount++;
    }

    void dequeue(int val){
        if(!q.isEmpty() && q.peekFirst().second == removedCount){
            q.pollFirst();
        }
        removedCount++;
    }
	public static void main(String [] args){
		FastIO io = new FastIO();
        MinQueueUsingDeque arr = new MinQueueUsingDeque();
        arr.enqueue(1);
        arr.enqueue(2);
        arr.enqueue(4);
        System.out.println(arr.getMin());
        arr.dequeue(1);
        System.out.println(arr.getMin());
		io.close();
	}
}