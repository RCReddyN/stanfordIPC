/*
ID: rcreddyn
Implementing ArrQueue
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

public class ArrQueue{
    private int head;
    private int tail;
    private int capacity;
    private int size;
    private int [] arr;

    ArrQueue(int capacity){
        head = 0;
        tail = -1;
        this.capacity = capacity;
        arr = new int[capacity];
    }

    boolean isFull(){
        return size == capacity;
    }

    boolean isEmpty(){
        return size == 0;
    }

    void enqueue(int val){
        if(isFull()){
            return;
        }
        tail = (tail + 1) % capacity;
        arr[tail] = val;
        size = size + 1;
    }

    void dequeue(){
        if(isEmpty()){
            return;
        }
        head = (head + 1) % capacity;
        size = size - 1;
    }

    int front(){
        if(isEmpty()){
            return Integer.MIN_VALUE;
        }
        return arr[head];
    }

    int rear(){
        if(isEmpty()){
            return Integer.MIN_VALUE;
        }
        return arr[tail];
    }

    void print(FastIO io){
        if(isEmpty()){
            return;
        }
        for(int i=head; i<=tail; i++){
            io.write(arr[i]+" ");
        }
        io.write("\n");
    }
	public static void main(String [] args){
		FastIO io = new FastIO();
        ArrQueue queue = new ArrQueue(1000);
        queue.enqueue(10);
        queue.print(io);
        queue.enqueue(20);
        queue.print(io);
        queue.enqueue(30);
        queue.print(io);
        queue.enqueue(40);
        queue.print(io);
        
        int val = queue.front();
        queue.dequeue();
        io.write(val + " dequeued from queue\n");
        queue.print(io);
        io.write("Front item is " + queue.front()+"\n");
        io.write("Rear item is " + queue.rear()+"\n");
		io.close();
	}
}