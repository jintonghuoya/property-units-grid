package com.fortune.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Property {
    //名字
    private String name;
    //面积
    private double totalArea;
    //所在楼层
    private int totalFloor;
}
