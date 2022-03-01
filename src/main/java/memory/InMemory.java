package memory;

import java.util.HashMap;

public class InMemory {
    public static void main(String[] args) {
        int a=10;
        int b=20;
        int c=152;
        int k=565;
        a=b;
        String x="xx";
        String s="avc"+x;
        System.out.println();
        sum(a,b);
        HashMap hashMap=new HashMap();
        hashMap.put(1,1);
        hashMap.put(2,1);
        System.out.println(String.valueOf(1));
        System.out.println(hashMap.get(1));
        System.out.println(hashMap.get(2));
    }
    public  static int[] sum(int x,int y){
        return new int[20];
    }
}
