package com.example.demo.collection;

import com.google.common.collect.Lists;

import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 测试list set 遍历是否是有序的
 *
 * @author : coder
 * @create 2021/1/13 15:57
 */
public class Test {


    public static void main(String[] args) {

        Set<Integer> set = new HashSet<>() {
            {
                add(9);
                add(1);
                add(2);
                add(8);
                add(3);
                add(4);
                add(5);
                add(6);
            }
        };
        for (Integer num : set) {
            System.out.println(num);
        }
        System.out.println("==========================");
        List<Integer> integers = Arrays.asList(9, 1, 8, 2, 3, 4, 5, 6);
        for (Integer num : integers) {
            System.out.println(num);
        }
    }
    //set是无序的  list是有序输出

}
