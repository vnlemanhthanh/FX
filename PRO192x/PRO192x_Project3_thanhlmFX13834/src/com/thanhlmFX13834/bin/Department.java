/*
 * Copyright (c)   2022.
 * @author @vnlemanhthanh
 ******************************************************************************/

package com.thanhlmFX13834.bin;

/**
 * Department chứa thông tin chung về bộ phận làm viêc của nhân viên,
 * - Thuộc tính: mã bộ phận, tên bộ phận, số lượng nhân viên hiện tại,
 * - Phương thức: toString() hiển thị thông tin về bộ phận. */
public class Department {
    /** Mã bộ phận làm việc */
    private String id;
    /** Tên bộ phận */
    private String name;
    /** Số lượng nhân viên hiện tại */
    private int staffNumbers;

    /**
     * Constructor */
    private Department() {
    }

    /**
     * Constructor */
    private Department(String id, String name, int staffNumbers) {
        this.id = id;
        this.name = name;
        this.staffNumbers = staffNumbers;
    }

    /**
     * Constructor */
    public Department(String id, String name) {
        this.id = id;
        this.name = name;
    }

    /** Getter */
    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getStaffNumbers() {
        return staffNumbers;
    }

    /**
     * Setter */
    public void setStaffNumbers(int staffNumbers) {
        this.staffNumbers = staffNumbers;
    }

    /**
     * Hiển thị thông tin bộ phận: mã, tên, số nhân viên hiện tại. */
    @Override
    public String toString() {
        String toString = "Department{" +
                "departmentId='" + getId() + '\'' +
                ", name='" + getName() + '\'' +
                ", numbersOfDepartment=" + getStaffNumbers() +
                '}';
        System.out.println(toString);
        return  toString;
    }
}
