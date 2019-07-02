package com.jxgm.util;

import java.util.Comparator;

import com.jxgm.entities.Province;

public class MyIntComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        int i1 = Integer.parseInt(((Province)o1).getId());
        int i2 = Integer.parseInt(((Province)o2).getId());
        if (i1 > i2) {
            return 1;
        }
        if (i1 < i2) {
            return -1;
        }
        return 0;
    }
}