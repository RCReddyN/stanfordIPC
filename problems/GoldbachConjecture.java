/*
ID: rcreddyn
TASK: GoldbachConjecture
LANG: JAVA
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.List;
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

public class GoldbachConjecture{
	public static void main(String [] args){
		FastIO io = new FastIO();
        String line;
        List<Integer> p = new ArrayList<Integer>();
        int m = 1000000;
        boolean [] cache = new boolean [m];
        for(int i =2; i<m; i++){
            cache[i] = true;
        }
        for(int i=2; i*i<m; i++){
            if(cache[i]){
                if(i != 2){
                    p.add(i);
                }
                for(int j=i*i; j<m; j+=i){
                    cache[j] = false;
                }
            }
        }
        while(!"0".equals(line = io.nextLine())){
            int n = Integer.parseInt(line);
            String ans = "Goldbach's conjecture is wrong.";
            int in = -1;
            for(int i=3; i<n; i++){
                if(cache[i] && cache[n-i]){
                    in = i;
                    break;
                }
            }
            if(in != -1){
                ans = n +" = "+ in +" + "+ (n-in);
            }
            io.write(ans+"\n");
        }
		io.close();
	}
}