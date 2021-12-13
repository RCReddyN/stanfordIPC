/*
ID: rcreddyn
TASK: AddingReversedNumbers
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

public class AddingReversedNumbers{
	public static void main(String [] args){
		FastIO io = new FastIO();
        int t = io.nextInt();
        while(t-- > 0){
            int n1 = io.nextInt();
            int n2 = io.nextInt();
            int ans = reverse(reverse(n1) + reverse(n2));
            io.write(ans +"\n");
        }
		io.close();
	}

    static int reverse(int n){
        int rev = 0;
        while(n>0){
            int d = n % 10;
            rev = rev * 10 + d;
            n = n/10;
        }
        return rev;
    }
}