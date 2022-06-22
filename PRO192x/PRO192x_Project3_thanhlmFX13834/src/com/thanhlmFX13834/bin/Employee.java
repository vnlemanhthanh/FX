/*
 * Copyright (c)  vnlemanhthanh 2022.
 ******************************************************************************/

package com.thanhlmFX13834.bin;

public class Employee extends Staff implements ICalculator {

    /**
     * Số giờ làm thêm */
    private double overtimeHours;

    /**
     * Constructor */
    public Employee() {
    }

    /**
     * Constructor */
    public Employee(String staffId,
                    String name,
                    int age,
                    double coefficientSalary,
                    String entryDate,
                    Department department,
                    int vacationDays,
                    double overtimeHours) {
        super(staffId, name, age, coefficientSalary, entryDate, department, vacationDays);
        this.overtimeHours = overtimeHours;
    }

    /**
     * Getter */
    public double getOvertimeHours() {
        return overtimeHours;
    }

    /**
     * Setter */
    public void setOvertimeHours(double overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    /**
     * implement từ ICaculate interface,
     * Hàm tính lương theo hệ số lương và số giờ làm thêm */
    @Override
    public double calculateSalary() {
        return (getCoefficientSalary() * 3000000) + (getOvertimeHours() * 200000);
    }

    /**
     * extends từ class Staff,
     * Hàm hiển thị thông tin nhân viên  */
    @Override
    public String displayInfomation() {
        String toString = "Employee{" +
                "staffId='" + getStaffId() + '\'' +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", coefficientSalary=" + getCoefficientSalary() +
                ", entryDate=" + getEntryDate() +
                ", departmentName=" + getDepartment().getName() +
                ", vacationDays=" + getVacationDays() +
                ", overtimeHours=" + getOvertimeHours() +
                ", salary=" + calculateSalary() +
                '}';
        System.out.println(toString);
        return  toString;
    }

}
