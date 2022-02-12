package com.freedom.sales.ThreadPack.listpack;

import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class TestJunit {
    @Test
    public void test() {
        User u1=new User(202202, 5, "A");
        User u2=new User(202201, 2, "B");
        User u3=new User(202212, 3, "C");
        User u4=new User(202201, 4, "D");
        User u5=new User(202208, 5, "E");
        ArrayList<User> list=new ArrayList<User>();
        list.add(u2);
        list.add(u5);
        list.add(u3);
        list.add(u4);
        list.add(u1);
        System.out.println("排序前：");
        for(int i=0;i<list.size();i++)
        {
            System.out.println("id："+list.get(i).getId() +" age:"+list.get(i).getAge() +"  name:"+list.get(i).getName());
        }
        System.out.println("排序后：");
        //id升序，age降序排序
        Collections.sort(list);
        for(int i=0;i<list.size();i++)
        {
            System.out.println("id："+list.get(i).getId() +" age:"+list.get(i).getAge() +"  name:"+list.get(i).getName());
        }
        System.out.println("");
        HashMap map = new HashMap();
        map.put(202208,"202208");
        ArrayList<User> list2=new ArrayList<User>();
        User u6=new User(202208, 5, "E");
        if(map.containsKey(u6.getId())){
            System.out.println("包含");
        }else{
            System.out.println("不包含");
            list2.add(u6);
        }


    }

}
