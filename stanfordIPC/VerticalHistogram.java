/*
ID: rcreddyn
TASK: VerticalHistogram
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

public class VerticalHistogram{
	public static void main(String [] args){
		FastIO io = new FastIO();
        int numberOfLines = 4;
        int [] cache = new int[26];
        for(int i=0; i<numberOfLines; i++){
            String line = io.nextLine();
            for(int j=0; j<line.length(); j++){
                char ch = line.charAt(j);
                if(isLetter(ch)){
                    cache[ch - 'A']++;
                }
            }
        }
        int max = Integer.MIN_VALUE;
        for(int i=0; i<26; i++){
            max = Math.max(max, cache[i]);
        }
        for(int i=max; i>0; i--){
            for(int j=0; j<26; j++){
                if(cache[j] == i){
                    io.write("*");
                    cache[j]--;
                }
                else{
                    io.write(" ");
                }
                io.write(" ");
            }
            io.write("\n");
        }
        for(int j=0; j<26; j++){
            io.write((char)('A' + j)+" ");
        }
        io.write("\n");
		io.close();
	}

    static boolean isLetter(char ch){
        if(ch>= 'A' && ch <='Z'){
            return true;
        }
        return false;
    }
}