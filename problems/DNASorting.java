/*
ID: rcreddyn
TASK: DNASorting
LANG: JAVA
*/
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Comparator;
import java.util.StringTokenizer;
import java.util.Arrays;

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

public class DNASorting{
	public static void main(String [] args){
		FastIO io = new FastIO();
        int lengthOfStrings = io.nextInt();
        int numberOfStrings = io.nextInt();
        DNA [] dnastrings = new DNA[numberOfStrings];
        for(int i=0; i<numberOfStrings; i++){
            String currDNA = io.next();
            dnastrings[i] = new DNA(currDNA, lengthOfStrings);
        }
        Arrays.sort(dnastrings, new Comparator<DNA>() {
            @Override
            public int compare(DNA a, DNA b){
                return a.inversions - b.inversions;
            }
        });

        for(int i=0; i<numberOfStrings; i++){
            io.write(dnastrings[i].sequence+"\n");
        }
		io.close();
	}
}

class DNA{
    String sequence;
    int length;
    int inversions;
    DNA(String sequence, int length){
        this.sequence = sequence;
        this.length = this.sequence.length();
        this.inversions = countInversions();
    }

    int countInversions(){
        int [] seq = new int [length];
        for(int i=0; i<length; i++){
            seq[i] = sequence.charAt(i) - 'A';
        }
        int l = 0;
        int r = seq.length -1;
        int c = sort(seq, l, r);
        return c; 
    }

    int sort(int [] s, int l, int r){
        int c = 0;
        if(l < r){
            int m = l + (r-l)/2;
            c+= sort(s, l, m);
            c+= sort(s, m+1, r);
            c+= merge(s, l, m, r);
        }
        return c;
    }

    int merge(int [] s, int l, int m, int r){
        int n1 = m - l + 1;
        int n2 = r-m;
        int [] L = new int[n1];
        for(int i=0; i<n1; i++){
            L[i] = s[l+i];
        }
        int [] R = new int[n2];
        for(int i=0; i<n2; i++){
            R[i] = s[m+1+i];
        }
        int i = 0;
        int j = 0;
        int k = l;
        int c = 0;
        while(i<n1 && j<n2){
            if(L[i] <= R[j]){
                s[k] = L[i]; 
                i++;
            }
            else{
                s[k] = R[j];
                c+= (m+1)-(l+i);
                j++;
            }
            k++;
        }
        while(i<n1){
            s[k] = L[i]; 
            i++;
            k++;
        }
        while(j<n2){
            s[k] = R[j];
            j++;
            k++;
        }
        return c;
    }
}