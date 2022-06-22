/* 
 * Copyright (c)  vnlemanhthanh 2022.
 ******************************************************************************/

package com.thanhlmFX13834;

import com.thanhlmFX13834.bin.*;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Quản lý nhân sự công ty,
 * danh sách nhân viên không trùng mã nhân viên,
 * danh sách bộ phận không trùng mã bộ phận,
 * mỗi nhân viên (staff) has-a 1 bộ phận,
 * abstact staff gồm có 2 loại: Employee và Manager
 * interface ICaculator được implements để tính lương theo loại nhân viên */
public class HumanResources {

    /**
     * Class Company */
    private static class Company {
        /** Danh sách Department. */
        ArrayList<Department> departmentList = new ArrayList<>();
        /** Danh sách Staff. */
        ArrayList<Staff> staffList = new ArrayList<>();

        /**
         * Constructor */
        private Company() {
        }

        /**
         * Nhập nhân viên từ người dùng */
        Staff setStaff(Staff staff) {

            // Nhận thông tin từ người dùng
            Scanner sc = new Scanner(System.in);

            /** Mã nhân viên (không trùng nhau) */
            System.out.print("Nhập mã nhân viên: ");

            // Mã nhân viên
            String staffId;

            // Kiểm tra mã nhân viên đã tồn tại chưa, nếu chưa thì mới chấp nhận
            while (true) {
                // Thu input người dùng
                staffId = sc.nextLine().toUpperCase();

                boolean isExistant = false;

                // Lặp tìm nhân viên trùng mã nhân viên với mã vừa nhập
                for (Staff st : staffList) {
                    isExistant = st.getStaffId().equalsIgnoreCase(staffId);
                    if (isExistant) break; // Thoát for loop
                }

                if (isExistant) { // Mã đã tồn tại
                    System.out.println("Trùng mã, nhập mã khác!");
                    System.out.print("Nhập mã nhân viên: ");
                }

                // Nếu không tồn tại thoát while loop
                if (!isExistant) {
                    break;
                }
            }
            //set staffId
            staff.setStaffId(staffId);

            /** Tên nhân viên */
            System.out.print("Nhập tên nhân viên: ");
            String name = sc.nextLine();
            staff.setName(name);

            /** Tuổi nhân viên */
            System.out.print("Nhập tuổi nhân viên: ");
            int age = Integer.parseInt(sc.nextLine());
            staff.setAge(age);

            /** Hệ số lương */
            System.out.print("Nhập hệ số lương: ");
            double coefficientSalary = Double.parseDouble(sc.nextLine());
            staff.setCoefficientSalary(coefficientSalary);

            /** Ngày vào làm */
            System.out.print("Nhập ngày vào làm việc: ");
            String entryDate = sc.nextLine();
            staff.setEntryDate(entryDate);

            /** số ngày nghỉ phép */
            System.out.print("Nhập số ngày nghỉ phép: ");
            int vacationDays = Integer.parseInt(sc.nextLine());
            staff.setVacationDays(vacationDays);

            /** Bộ phận làm việc
             * - Kiểm tra nễu bộ phân làm việc đã có trong công ty thì tăng số nhân viên của bộ phận lên 1,
             * - Nếu bộ phận làm việc là mới, thì nhập tên bộ phận mới, số nhân viên của bộ phận set là 1,
             *   lưu bộ phận mới lập này vào danh sách departmentList */
            System.out.println("Nhập bộ phận làm việc: ");
            Department department = null;

            // Mã bộ phận làm việc không trùng nhau
            System.out.print("Nhập mã bộ phận làm việc: ");
            String departmentId = sc.nextLine();
            boolean isExistant = false;

            // Lặp kiểm tra mã bộ phận làm việc trong công ty đã tồn tại chưa
            for (int i = 0; i < departmentList.size(); i++) {
                if (departmentList.get(i).getId().equalsIgnoreCase(departmentId)) {
                    isExistant = true; // Đã tồn tại
                    department = departmentList.get(i);
                    //set số nhân viên của bộ phận tăng lên 1
                    department.setStaffNumbers(department.getStaffNumbers() + 1);
                    // Lưu lại vào danh sách bộ phận
                    departmentList.set(i,department);
                    break;
                }
            }

            // Mã bộ phận là mới, ghi nhận và nhập tên bộ phận vào
            if (!isExistant) {
                System.out.print("Nhập tên bộ phận làm việc: ");
                String departmentName = sc.nextLine();

                /* Thêm, Lưu department vào departmentList*/
                department = new Department(departmentId, departmentName); // Tạo mới 1 instance bộ phận
                department.setStaffNumbers(department.getStaffNumbers() + 1); //set số nhân viên là 1
                departmentList.add(department); //thêm bộ phận vào danh sách bộ phận
            }
            //set bộ phận vào thuộc tính bộ phận của nhân viên
            staff.setDepartment(department);


            /** Nếu nhân viên staff instanceof Employee  */
            if (staff instanceof Employee) {
                System.out.println("Nhập số giờ làm thêm: ");
                Double overtimeHours = Double.parseDouble(sc.nextLine());
                //set số giờ làm thêm
                ((Employee) staff).setOvertimeHours(overtimeHours);
            }

            /** Nếu nhân viên staff instanceof Manager  */
            if (staff instanceof Manager) {
                System.out.println("Nhập chức danh quản lý: ");
                Manager.PositionEnum position = null; // chức danh

                int choice;
                do {
                    System.out.println("    1. Business_Leader");
                    System.out.println("    2. Project_Leader");
                    System.out.println("    3. Technical_Leader");
                    choice = Integer.parseInt(sc.nextLine());

                    switch (choice) {
                        case 1:
                            position = Manager.PositionEnum.Business_Leader;
                            break;
                        case 2:
                            position = Manager.PositionEnum.Project_Leader;
                            break;
                        case 3:
                            position = Manager.PositionEnum.Technical_Leader;
                            break;
                        default:
                            System.out.println("Vui lòng chọn lại");
                            break;
                    }
                } while ((choice != 1) && (choice != 2) && (choice != 3));

                // set chức danh quản lý
                ((Manager) staff).setPosition(position);
            }

            /** return staff */
            return staff;
        }

        /**
         * Hàm thêm nhân viên mới. */
        void addStaff() {
            Scanner sc = new Scanner(System.in);

            int choice;

            do {
                System.out.println("--------------Nhập nhân viên---------------");
                System.out.println("1. Nhập nhân viên thông thường: ");
                System.out.println("2. Nhập nhân viên cấp quản lý: ");
                System.out.println("**. Trở về MENU: ");

                choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Nhập nhân viên thông thường: ");

                        Staff employee = new Employee();
                        setStaff(employee);  //set thuộc tính của nhân viên
                        staffList.add(employee); //thêm nhân viên vào danh sach
                        break;
                    case 2:
                        System.out.println("Nhập nhân viên cấp quản lý: ");

                        Staff manager = new Manager();
                        setStaff(manager); // set thuộc tính của quản lý
                        staffList.add(manager); // thêm quản lý vào danh sách
                        break;
                    default:
                        break;
                }
            } while (choice == 1 || choice == 2);
        }

        /**
         * Hàm thêm bộ phận mới (mã bộ phận không trùng nhau) */
        void addDepartment() {
            Scanner sc = new Scanner(System.in);
            System.out.println("--------------Nhập bộ phận---------------");

            System.out.print("Nhập mã bộ phận: ");
            String id;
            while (true) {
                id = sc.nextLine().toUpperCase();
                boolean isExistant = false;
                for (Department department : departmentList) {
                    isExistant = department.getId().equalsIgnoreCase(id);
                    if (isExistant) break; // Thoát for loop
                }

                if (isExistant) {
                    System.out.println("Trùng mã, nhập mã khác!");
                    System.out.print("Nhập mã bộ phận: ");
                }

                // Nếu không tồn tại thoát while loop
                if (!isExistant) {break;}
            }

            System.out.print("Nhập tên bộ phận: ");
            String name = sc.nextLine();

            // Thêm, Lưu department vào departmentList
            departmentList.add(new Department(id, name));
        }
    }


    /**
     * Hiển thị danh sách nhân viên hiện có trong công ty,
     * Dùng vòng lặp duyệt qua mảng,
     * và mỗi phần tử thì dùng phương thức displayInformation() để hiển thị thông tin.. */
    static void showAllStaff(Company company) {
        System.out.println("=========================================================================================");

        for (Staff staff : company.staffList) {
            staff.displayInfomation();
        }

        System.out.println("=========================================================================================");
    }

    /**
     * Hiển thị các bộ phận trong công ty.
     * Dùng vòng lặp duyệt qua mảng,
     * và mỗi phần tử thì dùng toString() để hiển thị thông tin.. */
    static void showAllDepartment(Company company) {
        System.out.println("=========================================================================================");

        for (Department department : company.departmentList) {
            department.toString();
        }

        System.out.println("=========================================================================================");
    }

    /**
     * Hiển thị các nhân viên theo từng bộ phận,
     * Dùng vòng lặp duyệt qua mảng,
     * và mỗi phần tử thì dùng phương thức displayInformation() để hiển thị thông tin.. */
    static void showStaffOfDepartment(Company company) {
        System.out.println("=========================================================================================");

        for (Department department : company.departmentList) {
            System.out.println("======================================================================================");
            department.toString();
            for (Staff staff : company.staffList) {
                if (staff.getDepartment().getId().equalsIgnoreCase(department.getId())) {
                    staff.displayInfomation();
                }
            }
        }

        System.out.println("=========================================================================================");
    }

    /** Hàm findStaff,
     * Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên,
     * Dùng lệnh điều kiện để kiểm tra thông tin nhân viên có tồn tại hay không. */
    static void findStaff(Company company) {
        Scanner sc = new Scanner(System.in);
        System.out.println("=========================================================================================");
        System.out.println("Nhập mã hoặc tên nhân viên cần tìm: ");

        String input = sc.nextLine();
        boolean isFind = false;

        for (Staff staff : company.staffList) {
            if(staff.getStaffId().equalsIgnoreCase(input) || input.equalsIgnoreCase(staff.getName())) {
                isFind = true;
                staff.displayInfomation();
            }
        }
        if(!isFind) {
            System.out.println("Không tìm thấy nhân viên cần tìm: ");
        }

        System.out.println("=========================================================================================");
    }

    /**
    * Hàm Hiển thị bảng lương của nhân viên toàn công ty theo thứ tự giảm dần,
     * Dùng vòng lặp duyệt qua mảng, và mỗi phần tử thì dùng phương thức displayInformation() để hiển thị thông tin.
     **/
    static void showDecreaseSalary(Company company) {
        System.out.println("=========================================================================================");

        company.staffList.sort((o1, o2) ->
                (int) (((ICalculator)o2).calculateSalary() - ((ICalculator)o1).calculateSalary()));

        for (Staff staff : company.staffList) {
            staff.displayInfomation();
        }

        System.out.println("=========================================================================================");
    }

    /** Hàm Hiển thị bảng lương của nhân viên theo thứ tự tăng dần,
     * Dùng vòng lặp duyệt qua mảng, và mỗi phần tử thì dùng phương thức displayInformation() để hiển thị thông tin. */
    static void showIncreaseSalary(Company company) {
        System.out.println("=========================================================================================");

        company.staffList.sort((o1, o2) ->
                (int) (((ICalculator)o1).calculateSalary() - ((ICalculator)o2).calculateSalary()));

        for (Staff staff : company.staffList) {
            staff.displayInfomation();
        }

        System.out.println("=========================================================================================");
    }

    /** Dữ liệu mẫu 1 công ty. */
    static Company dataSample() {
        Company company = new Company();

        Department d1 = new Department("1", "Department 1");
        Department d2 = new Department("2", "Department 2");
        Department d3 = new Department("3", "Department 3" );

        company.staffList.add(new Manager( "1","M1", 22, 2.2, "01/01/2022" , d2, 2, Manager.PositionEnum.Business_Leader ));
        company.staffList.add(new Manager( "2","M2", 24, 2.4, "01/01/2024" , d1, 4, Manager.PositionEnum.Project_Leader ));
        company.staffList.add(new Manager( "3","M3", 26, 2.6, "01/01/2026" , d3, 6, Manager.PositionEnum.Business_Leader ));
        company.staffList.add(new Manager( "4","M1", 28, 2.8, "01/01/2028" , d2, 8, Manager.PositionEnum.Technical_Leader ));

        company.staffList.add(new Employee( "5","E5", 21, 1.1, "01/01/2021" , d1, 1, 11 ));
        company.staffList.add(new Employee( "6","E6", 23, 1.3, "01/01/2023" , d3, 3, 33 ));
        company.staffList.add(new Employee( "7","E7", 25, 1.5, "01/01/2025" , d2, 5, 55 ));
        company.staffList.add(new Employee( "8","E8", 27, 1.7, "01/01/2027" , d1, 7, 77 ));
        company.staffList.add(new Employee( "9","E5", 29, 1.9, "01/01/2029" , d2, 9, 99 ));

        d1.setStaffNumbers(3);
        d2.setStaffNumbers(4);
        d3.setStaffNumbers(2);
        company.departmentList.add(d1);
        company.departmentList.add(d2);
        company.departmentList.add(d3);

        return company;
    }

    /** Hàm hiển thị Menu */
    static void showMenu() {
        System.out.println("-----------------MENU-------------------");
        System.out.println("1. Hiển thị danh sách nhân viên hiện có trong công ty");
        System.out.println("2. Hiển thị các bộ phận trong công ty ");
        System.out.println("3. Hiển thị các nhân viên theo từng bộ phận ");
        System.out.println("4. Thêm nhân viên mới vào công ty ");
        System.out.println("5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên ");
        System.out.println("6. Hiển thị bảng lương của nhân viên toàn công ty ");
        System.out.println("7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần ");
        System.out.println("8. Thêm bộ phận mới ");
        System.out.println("9. Tạo data mẫu cho công ty");
        System.out.println("0. Thoát. ");
    }

    /** ====== Hàm main ====== */
    public static void main(String[] args){
        Company company = new Company();

        // Nhận dữ liệu người dùng nhập vào.
        Scanner sc = new Scanner(System.in);
        int choice;

        /** Vòng lặp do..while */
        do {
            showMenu(); //Hiển thị Menu
            choice = Integer.parseInt(sc.nextLine());

            switch (choice) {
                case 1:
                    /** "1. Hiển thị danh sách nhân viên hiện có trong công ty" */
                    showAllStaff(company);
                    break;
                case 2:
                    /** "2. Hiển thị các bộ phận trong công ty" */
                    showAllDepartment(company);
                    break;
                case 3:
                    /** 3. Hiển thị các nhân viên theo từng bộ phận " */
                    showStaffOfDepartment(company);
                    break;
                case 4:
                    /** "4. Thêm nhân viên mới vào công ty "*/
                    company.addStaff();
                    break;
                case 5:
                    /** 5. Tìm kiếm thông tin nhân viên theo tên hoặc mã nhân viên " */
                    findStaff(company);
                    break;
                case 6:
                    /** "6. Hiển thị bảng lương của nhân viên toàn công ty " */
                    showDecreaseSalary(company);
                    break;
                case 7:
                    /** "7. Hiển thị bảng lương của nhân viên theo thứ tự tăng dần " */
                    showIncreaseSalary(company);
                    break;
                case 8:
                    /** "8. Thêm bộ phận mới "*/
                    company.addDepartment();
                    break;
                case 9:
                    /** 9. Chạy thử 1 data công ty mẫu */
                    company = dataSample();
                    break;

                case 0:
                    /** Thoát */
                    System.out.println("----------------KẾT THÚC----------------");
                    break;
                default:
                    System.err.println("Vui lòng Nhập lại: ");
            }
        } while (choice != 0);
    }

}