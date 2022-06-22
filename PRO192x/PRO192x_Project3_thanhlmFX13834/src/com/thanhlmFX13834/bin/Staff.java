/*
 * Copyright (c)   2022.
 * @author @vnlemanhthanh
 ******************************************************************************/

package com.thanhlmFX13834.bin;

/**
 * Staff là class abstract chứa các thông tin cơ bản của nhân viên,
 * hàm displayInformation() là hàm abstract,
 * các class kế thừa triển khai hiển thị thông tin phù hơp.
 * Thuộc tính: mã nhân viên, tên nhân viên, tuổi nhân viên,
 * hệ số lương, ngày vào làm, bộ phận làm việc, số ngày nghỉ phép. */
public abstract class Staff {

    /** Mã nhân viên */
    private String staffId;

    /**
     * Tên nhân viên */
    private String name;

    /**
     * Tuổi nhân viên */
    private int age;

    /**
     * Hệ số lương */
    private double coefficientSalary;

    /**
     * Ngày vào làm */
    private String entryDate;

    /**
     * Mỗi staff has-a department - Bộ phận làm việc */
    private Department department;

    /**
     * Số ngày nghỉ phép */
    private int vacationDays;

    /**
     * Constructor */
    protected Staff() {
    }

    /**
     * Constructor */
    Staff(String staffId,
          String name,
          int age,
          double coefficientSalary,
          String entryDate,
          Department department,
          int vacationDays) {
        this.staffId = staffId;
        this.name = name;
        this.age = age;
        this.coefficientSalary = coefficientSalary;
        this.entryDate = entryDate;
        this.department = department;
        this.vacationDays = vacationDays;
    }

    /**
     * Getter */
    public String getStaffId() {
        return staffId;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public double getCoefficientSalary() {
        return coefficientSalary;
    }

    public String getEntryDate() {
        return entryDate;
    }

    public Department getDepartment() {
        return department;
    }

    public int getVacationDays() {
        return vacationDays;
    }

    /**
     * Setter */
    public void setStaffId(String staffId) {
        this.staffId = staffId;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public void setCoefficientSalary(double coefficientSalary) {
        this.coefficientSalary = coefficientSalary;
    }

    public void setEntryDate(String entryDate) {
        this.entryDate = entryDate;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setVacationDays(int vacationDays) {
        this.vacationDays = vacationDays;
    }

    /**
     * hàm displayInformation() là hàm abstract,
     * các class kế thừa triển khai hiển thị thông tin phù hợp. */
    public abstract String displayInfomation();
}
