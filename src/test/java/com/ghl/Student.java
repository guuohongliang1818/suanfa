package com.ghl;

import com.alibaba.excel.annotation.ExcelProperty;

public class Student {
    @ExcelProperty({"学号"})
    private String no;
    @ExcelProperty({"姓名"})
    private String name;
    @ExcelProperty({"生日"})
    private String birthday;
    public Student(String no, String name, String birthday) {
        super();
        this.no = no;
        this.name = name;
        this.birthday = birthday;
    }
    public String getNo() {
        return no;
    }
    public void setNo(String no) {
        this.no = no;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }
}
