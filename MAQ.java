import java.util.Arrays;
import java.util.Scanner;

public class MAQ{
    public static void main(String args[]) {
        String s;
        Scanner sc = new Scanner(System.in);
        s = sc.nextLine();
        sc.close();
        StringBuffer sb = new StringBuffer();
        var l = s.length();
        for(int i=0;i<l;i++){
            var f=0;
            for(int j=i+1;j<l;j++){
                if(s.charAt(i)==s.charAt(j)){
                    f = 1;
                    break;
                }
            }
            if(f==0) sb.append(s.charAt(i));
        }


        System.out.println(sb);

    }
}