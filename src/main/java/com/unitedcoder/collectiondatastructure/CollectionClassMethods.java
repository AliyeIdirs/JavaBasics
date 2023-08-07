package com.unitedcoder.collectiondatastructure;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class CollectionClassMethods {
    public static void main(String[] args) {
        List<Integer> list= Arrays.asList(100,40,90,50,200);
        System.out.println(Collections.max(list));
        System.out.println(Collections.min(list));
        Collections.sort(list);
        System.out.println(list);
        Collections.reverse(list);
        System.out.println(list);
    }
}
