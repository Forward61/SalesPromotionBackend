package com.freedom.sales.ThreadPack;

/**
 * @Author: freedom
 * @Date: 2022-01-05 09:33
 **/
public class Test1 {
    public static void main(String[] args) {
        int n=0;
        while(n<5){
            switch(n){
                case 0:
                case 3:
                    n=n+3;
                    System.out.println("n+3后的值" + n);

                case 1:
                case 2:
                    n=n+2;
                    System.out.println("n+2后的值" + n);

                default:
                    n=n+10;
                    System.out.println("n+10后的值" + n);


            }
        }
        System.out.println(n);

        //int i=0,s=0;
        //do{
        //    if(i%2==0){
        //        i++;
        //        System.out.println("if里的i:" +i+",s:"+s);
        //        continue;
        //    }
        //    i++;
        //    s=s+i;
        //    System.out.println("do里的i" +i+",s:"+s);
        //
        //}while(i<6);
        //System.out.println(s);
    }
}
