package com.bill.Entity;


/**
 * @Classname Category
 * @Description TODO
 * @Date 2019/10/10 15:55
 * @Created by HeYu5
 */
public class Category {
    public int id;
    public String name;

    public int recordNumber;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRecordNumber() {
        return recordNumber;
    }

    public void setRecordNumber(int recordNumber) {
        this.recordNumber = recordNumber;
    }

    /*
    * 这里提供一个toString方法，用于显示分类的名称
    * */
    public String toString(){
        return name;
    }
}