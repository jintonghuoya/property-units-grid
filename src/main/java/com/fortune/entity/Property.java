package com.fortune.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Property implements Serializable {
    //名字
    private String name;
    //总面积
    private double totalArea;
    //管理面积
    private double manageArea;
    //总楼层数
    private int floorCount;
    //楼层列表
    private List<Floor> floors;
}
