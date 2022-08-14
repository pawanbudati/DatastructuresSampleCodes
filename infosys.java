import java.util.Scanner;

public class infosys {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        String str = sc.nextLine();
        sc.close();
        var l = str.length();
        var s=0;
        for(var i=0; i<l;i++){
            var f=0;
            for(var j=i+1;j<l;j++)
                if(str.charAt(i)==str.charAt(j)){
                    f=1;
                    break;
                }
            if(f==0){
                System.out.println(i+1);
                s = 1;
                break;
            }
        }
        if(s==0) System.out.println(-1);
    }
}
