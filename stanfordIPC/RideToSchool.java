/*
ID: rcreddyn
TASK: RideToSchool
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

public class RideToSchool{
	public static void main(String [] args){
		FastIO io = new FastIO();
        String line;
        while(!"0".equals(line = io.nextLine())){
            int n = Integer.parseInt(line);
            double minTimeTaken = Double.MAX_VALUE;
            for(int i=0; i<n; i++){
                int speed = io.nextInt();
                int time = io.nextInt();
                double timeTaken = 0;
                if(time >= 0){
                    timeTaken = (4.5/speed)*(60*60) + time;
                    if(timeTaken < minTimeTaken){
                        minTimeTaken = timeTaken;
                    }
                }
            }
            io.write((int)(Math.ceil(minTimeTaken))+"\n");
        }
		io.close();
	}
}