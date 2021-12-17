/*
ID: rcreddyn
Implementing MinHeap
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

public class MinHeap{
    private int [] arr;
    private int size;
    private int capacity;

    MinHeap(int capacity){
        this.capacity = capacity;
        this.size = 0;
        arr = new int[capacity];
    }

    int getParentIndex(int n){
        return (n - 1) / 2;
    }

    int getLeftChildIndex(int n){
        return 2 * n + 1;
    }

    int getRightChildIndex(int n){
        return 2 * n + 2;
    }

    boolean isFull(){
        return size == capacity;
    }

    boolean isEmpty(){
        return size == 0;
    }

    boolean isLeaf(int n){
        return n >= size/2 && n < size;
    }

    void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    void insertNode(int v){
        if(isFull()){
            return;
        }
        arr[size] = v;
        int curr = size;
        while(arr[curr] < arr[getParentIndex(curr)]){
            swap(curr, getParentIndex(curr));
            curr = getParentIndex(curr);
        }
        size++;
    }

    int peek(){
        if(isEmpty()){
            return Integer.MAX_VALUE;
        }
        return arr[0];
    }

    void deleteNode(){
        if(isEmpty()){
            return;
        }
        arr[0] = arr[size-1];
        size--;
        minHeapify(0);
    }

    void minHeapify(int n){
        if(isLeaf(n)){
            return;
        }

        if(arr[n] > arr[getLeftChildIndex(n)] || arr[n] > arr[getRightChildIndex(n)]){
            if(arr[getLeftChildIndex(n)] < arr[getLeftChildIndex(n)]){
                swap(n, getLeftChildIndex(n));
                minHeapify(getLeftChildIndex(n));
            }
            else{
                swap(n, getRightChildIndex(n));
                minHeapify(getRightChildIndex(n));
            }
        }
    }

    void print(FastIO io){
        for(int i=0; i<size; i++){
            io.write(arr[i] + " ");
        }
        io.write("\n");
    }
	public static void main(String [] args){
		FastIO io = new FastIO();
        MinHeap minHeap = new MinHeap(15);
 
        // Inserting nodes
        // Custom inputs
        minHeap.insertNode(5);
        minHeap.print(io);
        minHeap.insertNode(3);
        minHeap.print(io);
        minHeap.insertNode(17);
        minHeap.print(io);
        minHeap.insertNode(10);
        minHeap.print(io);
        minHeap.insertNode(84);
        minHeap.print(io);
        minHeap.insertNode(19);
        minHeap.print(io);
        minHeap.insertNode(6);
        minHeap.print(io);
        minHeap.insertNode(22);
        minHeap.print(io);
        minHeap.insertNode(9);
        minHeap.print(io);
        io.write("The min val is " + minHeap.peek()+"\n");
        minHeap.deleteNode();
        minHeap.print(io);
		io.close();
	}
}