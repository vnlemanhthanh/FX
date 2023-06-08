package Lab11.Lab93;

public class HarvardLawyer extends Lawyer {
    public HarvardLawyer() {
    }

    public double getSalary() {
        return super.getSalary() * 1.2;
    }

    public int getVacationDays() {
        return super.getVacationDays() + 3;
    }

    public String getVacationForm() {
        String s = "";
        for (int i = 0; i < 4; i++) {
            s += super.getVacationForm();
        }
        return s;
    }
}
