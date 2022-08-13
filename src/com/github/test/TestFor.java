package com.github.test;

public class TestFor {
    public static void main(String[] args) {
        int[][] wim = {
                {1, 2, 3, 4,},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 0}
        };
        for(var i :wim)
            for(var j : i)
                System.out.println(j);
    }
}
