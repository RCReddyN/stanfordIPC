/*
ID: rcreddyn
Implementing SegmentTree
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

public class SegmentTree{
    int st[];

    SegmentTree(int [] arr, int n){
        int h = (int)(Math.ceil(Math.log(n)/Math.log(2)));
        int size = 2*(int)Math.pow(2,h) - 1;
        st = new int[size];
        construct(arr, 0, n-1, 0);
    }

    int getMid(int l, int r){
        return l + (r-l)/2;
    }

    int getSum(int n, int l, int r){
        if(l < 0 || r >= n || l > r){
            return -1;
        }
        return getSum(0,n-1, l, r,0);
    }

    int getSum(int sl, int sr, int l, int r, int s){
        if(l <= sl && r >= sr){
            return st[s];
        }
        if(sr < l || sl > r){
            return 0;
        }
        int m = getMid(sl, sr);
        return getSum(sl, m, l, r, 2*s+1) + getSum(m+1, sr, l, r, 2*s+2);
    }

    int construct(int [] arr, int l, int r, int s){
        if(l == r){
            st[s] = arr[l];
            return arr[l];
        }

        int m = getMid(l, r);
        st[s] = construct(arr, l, m, 2*s+1)+construct(arr, m+1, r, 2*s+2);
        return st[s];
    }

    void update(int [] arr, int n, int i, int val){
        if(i < 0 || i > n-1){
            return;
        }
        int diff = val - arr[i];
        arr[i] = val;
        update(0, n-1, i, diff, 0);
    }

    void update(int sl, int sr, int i, int diff, int s){
        if(i < sl || i > sr){
            return;
        }
        st[s] = st[s] + diff;
        if(sl != sr){
            int m = getMid(sl, sr);
            update(sl, m, i, diff, 2*s+1);
            update(m+1, sr, i, diff, 2*s+2);
        }
    }
	public static void main(String [] args){
		FastIO io = new FastIO();
        int [] arr = {4, 8, 5, 2, 6, 1, 0, 8, 1, 5};
        FenwickTree ft = new FenwickTree(arr, arr.length);
        System.out.println("Sum of values in given range = " + ft.sum(1, 4));
        ft.update(1, 10);
        System.out.println("Sum of values in given range = " + ft.sum(1, 4));
        io.close();
	}
}