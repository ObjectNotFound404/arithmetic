package com.xq;

import com.xq.util.ArrayList;
import org.junit.Test;

public class ListTest {
    @Test
    public void arraylistTest(){
        ArrayList<Integer> list = new ArrayList<>();
        for (int i = 0; i < 11; i++) {
            list.add(i);
        }
        list.set(5,456);
        list.indexOf(50)
        System.out.println(list);
    }
}
