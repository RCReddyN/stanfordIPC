/*
ID: rcreddyn
Implementing FenwickTree
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

public class FenwickTree{
    int [] bit;
    private int [] arr;
    private int n;

    FenwickTree(int [] arr, int n){
        this.arr = arr;
        bit = new int[n+1];
        for(int i=1; i<=arr.length; i++){
            add(i, arr[i-1]);
        }
    }

    int sum(int i){
        int res = 0;
        while(i > 0){
            res += bit[i];
            i -= (i & -i); 
        }
        return res;
    }

    int sum(int l, int r){
        l++;
        r++;
        if(l == 1){
            return sum(r);
        }
        return sum(r) - sum(l-1);
    }

    void add(int i, int diff){
        while(i < bit.length){
            bit[i] += diff;
            i += (i & -i);
        }
    }

    void update(int i, int val){
        add(i+1, val - arr[i]);
        arr[i] = val;
    }
	public static void main(String [] args){
		FastIO io = new FastIO();
        int [] arr = {4, 8, 5, 2, 6, 1, 0, 8, 1, 5};
        FenwickTree ft = new FenwickTree(arr, arr.length);
        System.out.println("Sum of values in given range = " + ft.sum(1, 4));
        ft.update(1, 10);
        System.out.println("Sum of values in given range = " + ft.sum(1, 4));
        io.write("\n");
		io.close();
	}
}