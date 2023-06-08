package Lab10.Lab93;

// A class to represent lawyers.
public class Lawyer extends Employee {
    // overrides getVacationDays from Employee class
    public int getVacationDays() {
        return super.getVacationDays() + 5;
    }

    // overrides getVacationForm from Employee class
    public String getVacationForm() {
        return lawyerVacationForm;
    }

    // this is the Lawyer's added behavior
    public void sue() {
        System.out.println("I'll see you in court!");
    }


    // these are so that test cases can change the Lawyer values
    // and make sure that subclasses also change
    private String lawyerVacationForm = "pink";

    public final void setVacationForm(String form) {
        lawyerVacationForm = form;
    }
}

