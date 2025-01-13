package com.clinicexa.clinic;

import java.util.ArrayList;
import java.util.List;

public class Test {
public static void main(String[] args){
    Object[] objArr = new Object[5];
    objArr[0] = 1;
    objArr[1] = 2;
    //System.out.println(Integer.parseInt(String.valueOf(objArr[0])));
    List<Object[]> dataList = new ArrayList<>();
    dataList.add(objArr);
    dataList.forEach(dataone -> {
        System.out.println(Integer.parseInt(String.valueOf(dataone[0])));
    });
}
}

