package com.serenitydojo.exceptions;

import org.junit.Test;

public class Record{

    private final String empName ;
    private final int empNumbner ;

    public Record(String empName, int empNumbner){
        this.empName = empName;
        this.empNumbner = empNumbner;

    }

    public String getEmpName() {
        return empName;
    }

    public int getEmpNumbner() {
        return empNumbner;
    }

    public String toString(){
        return "empname = "+empName+" empnumber = " +empNumbner;
    }





}
