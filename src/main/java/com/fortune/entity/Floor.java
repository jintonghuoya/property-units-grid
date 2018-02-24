package com.fortune.entity;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class Floor implements Serializable {
    //楼层名字
    private String name;
    //面积，不可编辑，应该根据unit来统计
    private double area;
    //Unit列表
    private List<Unit> units;
}
