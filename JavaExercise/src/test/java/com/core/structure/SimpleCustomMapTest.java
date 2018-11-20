package com.core.structure;


import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class SimpleCustomMapTest {

    @Test
    public void testMyMap(){

        Map<String,String> map1 = new HashMap<String,String>();

        SimpleCustomMap<Integer,Integer> map = new SimpleCustomMap<Integer, Integer>();
        map.put(1,10);
        map.put(2,20);
        map.put(3,30);
        map.put(4,40);
        map.put(5,50);

        Assert.assertTrue(map.get(4)==40);
        System.out.print(map);
    }

}
