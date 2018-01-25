package com.fortune.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Unit {
    //名字
    private String name;
    //面积
    private double area;
    //所在楼层
    private int floor;
    //是否已经租出去
    private int rentOut;
    //租赁类型
    private int type;
    //租约开始时间
    private Date startTime;
}
