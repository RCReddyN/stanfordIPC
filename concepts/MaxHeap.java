/*
ID: rcreddyn
Implementing MaxHeap
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

public class MaxHeap{
    private int [] arr;
    private int size;
    private int capacity;
    MaxHeap(int capacity){
        this.capacity = capacity;
        this.size = 0;
        arr = new int[capacity];
    }
    int getLeftChildIndex(int n){
        return 2*n+1;
    }

    int getRightChildIndex(int n){
        return 2*n+2;
    }

    int getParentIndex(int n){
        return (n-1)/2;
    }

    boolean isFull(){
        return size == capacity;
    }

    void insertNode(int v){
        if(isFull()){
            return;
        }
        arr[size] = v;
        int curr = size;
        while(arr[curr] > arr[getParentIndex(curr)]){
            swap(curr, getParentIndex(curr));
            curr = getParentIndex(curr);
        }
        size++;
    }

    boolean isEmpty(){
        return size == 0;
    }

    void deleteNode(){
        if(isEmpty()){
            return;
        }
        arr[0] = arr[size-1];
        size--;
        maxHeapify(0);
    }

    void swap(int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    boolean isLeaf(int n){
        return n >= size/2 && n < size;
    }

    void maxHeapify(int n){
        if(isLeaf(n)){
            return;
        }
        if(arr[n] < arr[getLeftChildIndex(n)] || arr[n] < arr[getRightChildIndex(n)]){
            if(arr[getLeftChildIndex(n)] > arr[getRightChildIndex(n)]){
                swap(n, getLeftChildIndex(n));
                maxHeapify(getLeftChildIndex(n));
            }
            else{
                swap(n, getRightChildIndex(n));
                maxHeapify(getRightChildIndex(n));
            }
        }
    }

    int peek(){
        if(isEmpty()){
            return Integer.MIN_VALUE;
        }
        return arr[0];
    }

    void print(FastIO io){
        for(int i=0; i<size; i++){
            io.write(arr[i]+" ");
        }
        io.write("\n");
    }
	public static void main(String [] args){
		FastIO io = new FastIO();
        MaxHeap maxHeap = new MaxHeap(15);
 
        // Inserting nodes
        // Custom inputs
        maxHeap.insertNode(5);
        maxHeap.print(io);
        maxHeap.insertNode(3);
        maxHeap.print(io);
        maxHeap.insertNode(17);
        maxHeap.print(io);
        maxHeap.insertNode(10);
        maxHeap.print(io);
        maxHeap.insertNode(84);
        maxHeap.print(io);
        maxHeap.insertNode(19);
        maxHeap.print(io);
        maxHeap.insertNode(6);
        maxHeap.print(io);
        maxHeap.insertNode(22);
        maxHeap.print(io);
        maxHeap.insertNode(9);
        maxHeap.print(io);
        io.write("The max val is " + maxHeap.peek()+"\n");
        maxHeap.deleteNode();
        maxHeap.print(io);
		io.close();
	}
}