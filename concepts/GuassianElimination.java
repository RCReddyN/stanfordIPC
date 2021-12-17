/*
ID: rcreddyn
Implementing GuassianElimination
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

public class GuassianElimination{
	public static void main(String [] args){
		FastIO io = new FastIO();
        int t = io.nextInt();
        while(t-- > 0){
            int n = io.nextInt();
            double [][] A = new double [n][n+1];
            for(int i=0; i<n; i++){
                for(int j=0; j<=n; j++){
                    A[i][j] = io.nextDouble(); 
                }
            }
            int row = forwardeliminate(A, n);
            printMatrix(A, n, io);
            if(row == -1){
                backSubstitute(A, n, io);
            }
            else{
                io.write("singluar\n");
            } 
        }
		io.close();
	}

    static void backSubstitute(double [] [] A, int n, FastIO io){
        double [] ans = new double[n];
        for (int i = n - 1; i >= 0; i--){
            ans[i] = A[i][n];
            for (int j = i + 1; j < n; j++){
                ans[i] -= A[i][j] * ans[j];
            }
            ans[i] = ans[i] / A[i][i];
        }
        for(int i=0; i<n; i++){
            io.write(ans[i]+" ");
        }
        io.write("\n");
    }

    static void printMatrix(double [] [] A, double n, FastIO io){
        for(int i=0; i<n; i++){
            for(int j=0; j<=n; j++){
                io.write(A[i][j]+" ");
            }
            io.write("\n");
        }
    }

    static void swap(double [] [] A, int i, int j, int n){
        for(int k=0; k<=n; k++){
            double temp = A[i][k];
            A[i][k] = A[j][k];
            A[j][k] = temp;
        }
    }

    static int forwardeliminate(double [][] A, int n){
        System.out.println("eliminating");
        for(int i=0; i<n; i++){
            int max_index = i;
            double max_value = A[max_index][i];
            for(int j=i+1; j<n; j++){
                if(Math.abs(A[j][i]) > max_value){
                    max_index = j;
                    max_value = A[j][i];
                }
            }
            if(A[i][max_index] == 0){
                return i;
            }
            if(i != max_index){
                swap(A, i, max_index, n);
            }
            for(int j = i+1; j<n; j++){
                double factor = A[j][i]/A[i][i];
                for(int k = i; k<=n; k++){
                    A[j][k] -= A[i][k]*factor;
                }
            }
        }
        return -1;
    }
}