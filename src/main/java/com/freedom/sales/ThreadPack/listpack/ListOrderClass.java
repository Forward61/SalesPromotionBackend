package com.freedom.sales.ThreadPack.listpack;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * @Author: freedom
 * @Date: 2022-02-11 21:19
 **/
public class ListOrderClass {
    public static void main(String[] args) {

        List<String> originsList =new ArrayList<String>();
        originsList.add("202201");
        originsList.add("202212");
        originsList.add("202211");
        originsList.add("202206");

        for (String line : originsList){
            System.out.println(line+"\n");
        }


        System.out.println("换行"+"\n");
        Collections.sort(originsList, new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {
                if(Integer.parseInt(o1) > Integer.parseInt(o2)){
                    return 1;
                }else{
                    return -1;
                }
            }
        });
        for (String line : originsList){
            System.out.println(line+"\n");
        }
    }
}
