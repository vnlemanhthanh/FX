/*
 * Copyright (c)   2022.
 * @author @vnlemanhthanh
 ******************************************************************************/

package com.thanhlmFX13834.bin;

public class Manager extends Staff implements ICalculator {
    /**
     * Enum chức vụ */
    public enum PositionEnum {
        Business_Leader, Project_Leader, Technical_Leader;
    }

    /** Thuộc tính: chức vụ quản lý*/
    private PositionEnum position;

    /**
     * Constructor */
    public Manager() {
    }

    /**
     * Constructor */
    public Manager(String staffId,
                   String name,
                   int age,
                   double coefficientSalary,
                   String entryDate,
                   Department department,
                   int vacationDays,
                   PositionEnum position) {
        super(staffId, name, age, coefficientSalary, entryDate, department, vacationDays);
        this.position = position;
    }

    /**
     * Getter */
    public PositionEnum getPosition() {
        return position;
    }

    /**
     * Setter */
    public void setPosition(PositionEnum position) {
        this.position = position;
    }

    /**
     * implement từ ICaculate interface,
     * Hàm tính lương theo hệ số lương và số giờ làm thêm */
    @Override
    public double calculateSalary() {
        // lương chức vụ
        double responsibilitySalary = 0;

        // hàm tính lương theo chức vụ
        switch (getPosition()) {
            case Business_Leader: // chức danh
                responsibilitySalary = 8000000;
                break;
            case Project_Leader:  // chức danh
                responsibilitySalary = 5000000;
                break;
            case Technical_Leader:  // chức danh
                responsibilitySalary = 6000000;
                break;
            default:
        }

        return getCoefficientSalary() * 5000000 + responsibilitySalary;
    }

    /**
     * extends từ class Staff,
     * Hàm hiển thị thông tin nhân viên  */
    @Override
    public String displayInfomation() {
        String toString =   "Manager{" +
                "staffId='" + getStaffId() + '\'' +
                ", name='" + getName() + '\'' +
                ", age=" + getAge() +
                ", coefficientSalary=" + getCoefficientSalary() +
                ", entryDate=" + getEntryDate() +
                ", departmentName=" + getDepartment().getName() +
                ", vacationDays=" + getVacationDays() +
                ", position='" + getPosition() + '\'' +
                ", salary='" + calculateSalary() + '\'' +
                '}';
        System.out.println(toString);
        return  toString;
    }
}
