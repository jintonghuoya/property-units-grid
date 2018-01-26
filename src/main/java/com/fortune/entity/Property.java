package com.fortune.entity;

import lombok.Data;

import java.util.List;

@Data
public class Property {
    //名字
    private String name;
    //总面积
    private double totalArea;
    //管理面积
    private double manageArea;
    //所在楼层
    private int totalFloor;
    //楼层列表
    private List<Floor> floors;
}
