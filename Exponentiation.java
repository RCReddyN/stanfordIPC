/*
ID: rcreddyn
TASK: Exponentiation
LANG: JAVA
*/
import java.io.*; 
import java.util.*;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.lang.*;

public class Exponentiation{
    public static void main(String args[]){
        Scanner cin = new Scanner(System.in);
        while(cin.hasNext()){
            BigDecimal ans = cin.nextBigDecimal();
            int n = cin.nextInt();
            String res = ans.pow(n).stripTrailingZeros().toPlainString();
            if(res.startsWith("0")){
                res = res.substring(1);
            }
            System.out.println(res);
        }
        cin.close();
    }
}