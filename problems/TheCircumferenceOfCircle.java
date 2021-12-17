/*
ID: rcreddyn
TASK: TheCircumferenceOfCircle
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

public class TheCircumferenceOfCircle{
	public static void main(String [] args){
		FastIO io = new FastIO();
        String line;
        while((line = io.nextLine()) != null){
            StringTokenizer st = new StringTokenizer(line);
            double x1 = Double.parseDouble(st.nextToken());
            double y1 = Double.parseDouble(st.nextToken());
            double x2 = Double.parseDouble(st.nextToken());
            double y2 = Double.parseDouble(st.nextToken());
            double x3 = Double.parseDouble(st.nextToken());
            double y3 = Double.parseDouble(st.nextToken());
            Point A = new Point(x1, y1);
            Point B = new Point(x2, y2);
            Point C = new Point(x3, y3);
            
            Line ab = new Line(A, B);
            Line bc = new Line(B, C);
            Line ca = new Line(C, A);

            double sinC = bc.cross(ca)/(bc.len*ca.len);
            double ans = Math.abs(Math.PI*(ab.len/sinC));
            io.write(String.format("%.2f", ans)+"\n");
        }
		io.close();
	}
}

class Point{
    double x, y;
    Point(double x, double y){
        this.x = x;
        this.y = y;
    }
}

class Line{
    double x, y, len;
    Line(Point p1, Point p2){
        this.x = p2.x - p1.x;
        this.y = p2.y - p1.y;
        this.len = Math.sqrt(x*x + y*y);
    }

    double cross(Line l){
        return this.x*l.y - this.y*l.x;
    }
}