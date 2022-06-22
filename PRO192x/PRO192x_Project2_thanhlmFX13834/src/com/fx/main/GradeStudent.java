package com.fx.main;

import java.util.Scanner;

public class GradeStudent {
    /** 
     * Điểm hệ 100 */
    static final int MAX_GRADE = 100;

    /** 
     * Nhận giá trị nhập vào từ người dùng*/
    static Scanner sc = new Scanner(System.in);

    /** 
     * Trọng số tính cho các học phần. */
    static int[] weightTerms = new int[3];

    /**
     * Điểm số của các học phần. */
    static int[] pointTerms = new int[3];

    /** 
     * Giá trị nhập vào phải là 1 số nguyên */
    static int checkIntegerInput() {
        while (!sc.hasNextInt()) {
            System.out.println("Please enter an integer number!");
            sc.next(); // Xóa bộ đệm bàn phím
        }
        return sc.nextInt();
    }

    /**
     *  Nhận giá trị nhập vào là số nguyên từ 0 đến MAX_GRADE */
    static int getInput() {
        int number = checkIntegerInput();
        while ((number < 0) || (number > MAX_GRADE)) {
            System.out.print("Please enter an integer in range 0 - 100 ");
            number = checkIntegerInput();
        }
        return number;
    }

    /** 
     * Nhập trọng số của học phần */
    static int getWeight() {
        System.out.print("Weight (0 - 100)? ");
        return getInput();
    }

    /**
     * Kiểm tra tổng tọng số 3 phần điểm thi có bằng điểm hệ MAX_GRADE */
    static double checkWeight() {
        int scale = 0;
        for (int weight: weightTerms) {
            scale += weight;
        }
        return (double) scale / MAX_GRADE;
    }

    /** 
     * Nhập điểm số mà người dùng đạt được */
    static int getScoreEarned() {
        System.out.print("Score earned? ");
        return getInput();
    }

    /**
     * Nhập điểm thi được tăng (hoặc không tăng) */
    static int shiftedScore() {
        System.out.print("Were score shifted (1=yes, 2=no)? ");
        String inputShifted = sc.next();
        int shiftedScore = 0;
        switch (inputShifted) {
            case "1": // Điểm được tăng
                System.out.print("Shift amount? ");
                shiftedScore = getInput();
                break;
            case "2": // Điểm không được tăng
            default:
                break;
        }
        return shiftedScore;
    }

    /**
     * Tính tổng điểm kỳ thi
     * Tổng số điểm, bao gồm điểm ban đầu và số điểm được tăng thêm.
     * Điểm tối đa của kỳ thi là @MAX_GRADE */
    static int totalPointTerm(int score) {
        // Điểm được tăng thêm hoặc không
        int shiftedScore = shiftedScore();
         // Nếu tổng điểm lớn hơn MAX_GRADE thì chỉ tính là MAX_GRADE */
        return Math.min(score + shiftedScore, MAX_GRADE);
    }

    /**
     * Tính điểm đã có trọng số
     * (thang điểm trọng số) */
    static double weightedScore(int point, int max, int weight) {
        double percentage = (double)point / (double)max; // Quy đổi ra phần trăm
        double weightedScore = percentage * weight; // Nhân với trọng số
        weightedScore = Math.round(weightedScore * 10) / 10.0; // Làm tròn 1 chữ số thập phân

        System.out.println("Weighted score = " + weightedScore + " / " + weight);
        System.out.println();
        return weightedScore;
    }

    /**
     * Nhập điểm bài tập về nhà
     */
    static int[] getAssignmentPoints() {
         System.out.print("Number of assignments? ");
         int numsAssignment = checkIntegerInput(); // Số bài Assignment
         int[][] assignmentPointsList = new int[numsAssignment][2]; //Mảng điểm assignment và điểm tối đa tương ứng
         int assignmentPoints = 0; //Tổng điểm
         int maxPoints = 0; // Tổng điểm tối đa

        for (int i = 0; i < numsAssignment ; i++) {
            // Array[i] là điểm bài assignment và điểm tối đa của bài đó
            boolean checkValue;
            do {
                System.out.print("Assignment " + (i + 1) + " score and max? ");
                // Nhập điểm bài assignment
                assignmentPointsList[i][0] = getInput();

                // Nhập điểm tối đa của bài assignment tương ứng
                assignmentPointsList[i][1] = getInput();
                if (assignmentPointsList[i][0] > assignmentPointsList[i][1]) {
                    checkValue = false;
                    System.out.println("Điểm tối đa không được nhỏ hơn điểm bài assignment ");
                } else {
                    checkValue = true;
                    assignmentPoints += assignmentPointsList[i][0]; // Cộng vào tổng điểm
                    maxPoints += assignmentPointsList[i][1]; // Cộng vào tổng điểm tối đa
                }
            } while (!checkValue); // Điểm tối đa không được nhỏ hơn điểm bài assignment
        }

        maxPoints = Math.min(maxPoints, 150); // Tổng điểm tối đa không lớn hơn 150
        assignmentPoints = Math.min(assignmentPoints, 150); // Tổng điểm không lớn hơn 150
        return new int[] {assignmentPoints, maxPoints};
    }

    /**
     * Nhập điểm chuyên cần */
    static int[] getSectionPoints() {
        System.out.print("How many section did you attend? ");
        int numsSection = getInput(); // Số buổi được điểm danh
        int sectionPoints = 5 * numsSection; // Điểm chuyên cần
        sectionPoints = Math.min(sectionPoints, 30); // Điểm chuyên cần tối đa là 30

        System.out.println("Section points = " + sectionPoints + " / " + 30);
        return new int[] {sectionPoints, 30};
    }

    /** 
     * Hàm hiển thị thông điệp chào mừng. */
    static void begin() {
        System.out.println("This program reads exam/homework scores and reports your overall course grade.");
        System.out.println();
    }

    /** 
     * Hàm nhập và tính điểm thi giữa kỳ. */
    static double midTerm() {
        System.out.println("Midterm: ");
        // Nhập trọng số bài thi giữa kỳ
        weightTerms[0] = getWeight();

        // Nhập điểm bài thi giữa kỳ
        int scoreEarned = getScoreEarned();

        // Điểm tăng thêm => điểm tổng bài thi
        pointTerms[0] = totalPointTerm(scoreEarned);

        System.out.println("Total points = " + pointTerms[0] + " / " + MAX_GRADE);
        return weightedScore(pointTerms[0], MAX_GRADE, weightTerms[0]);
    }

    /** 
     * Hàm nhập và tính điểm thi cuối kỳ. */
    static double finalTerm() {
        System.out.println("Final:");
        // Nhập trọng số bài thi cuối kỳ
        weightTerms[1] = getWeight();
        while (checkWeight() > 1) {
            System.out.println("Total weighted of 3 term must not bigger than: " + MAX_GRADE);
            weightTerms[1] = getWeight();
        }

        // Nhập điểm bài thi cuối kỳ
        int scoreEarned = getScoreEarned();

        // Điểm tăng thêm => điểm tổng bài thi
        pointTerms[1] = totalPointTerm(scoreEarned);
        System.out.println("Total points = " + pointTerms[1] + " / " + MAX_GRADE);

        //Quy ra điểm trên thang trọng số
        return weightedScore(pointTerms[1], MAX_GRADE, weightTerms[1]);
    }

    /** 
     * Hàm nhập và tính điểm bài tập về nhà. */
    static double homework() {
        System.out.println("Homework:");
        // Nhập trọng số Homework
        weightTerms[2] = getWeight();
        while (checkWeight() != 1) {
            System.out.println("Total weighted of 3 term must be: " + MAX_GRADE);
            weightTerms[2] = getWeight();
        }

        // Điểm các bài Assignmnet
        int[] assignmentPoints = getAssignmentPoints();

        // Điểm chuyên cần
        int[] sectionPoints = getSectionPoints();

        // Tổng điểm Homework
        pointTerms[2] = assignmentPoints[0] + sectionPoints[0];

        // Tổng điểm Homework tối đa
        int maxPointHomework = assignmentPoints[1] + sectionPoints[1];

        System.out.println("Total points = " + pointTerms[2] + " / " + maxPointHomework);

        //Quy ra điểm trên thang trọng số
        return weightedScore(pointTerms[2], maxPointHomework, weightTerms[2]);
    }

    /** 
     * Hàm tính toán về hiển thị kết quả GPA cũng như thông báo nhận xét. */
    static void report(double overallPercentage) {
        double minGPA;
        System.out.println("Overall percentage = " + overallPercentage);
        if (overallPercentage == 100) {
            minGPA = 4;
            System.out.println("Your grade will be at : " + minGPA);
        } else if (overallPercentage >= 85) {
            minGPA = 3;
            System.out.println("Your grade will be at least: " + minGPA);
        } else if (overallPercentage >= 75) {
            minGPA = 2;
            System.out.println("Your grade will be at least: " + minGPA);
        } else if (overallPercentage >= 60) {
            minGPA = 1;
            System.out.println("Your grade will be at least: " + minGPA);
        } else {
            minGPA = 0;
            System.out.println("Your grade will be at least: " + minGPA);
        }
    }

    /**
     * Hàm main. */
    public static void main(String[] args) {
        begin();
        double weightedMidtermScore = midTerm();
        double weightedFinaltermScore = finalTerm();
        double weightedHomeworkScore = homework();

        double overallPercentage = weightedMidtermScore + weightedFinaltermScore + weightedHomeworkScore;
        report(overallPercentage);
    }
}