package com.jxgm.util;

import java.util.Comparator;

import com.jxgm.entities.Province;

public class MyIntComparator implements Comparator {
    public int compare(Object o1, Object o2) {
        Long i1 = ((Province)o1).getId();
        Long i2 = ((Province)o2).getId();
        if (i1 > i2) {
            return 1;
        }
        if (i1 < i2) {
            return -1;
        }
        return 0;
    }
}