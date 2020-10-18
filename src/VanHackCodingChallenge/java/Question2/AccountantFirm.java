package vanHackCodingChallenge.java.Question2;

public class AccountantFirm extends EngineerFirm {

    public AccountantFirm(int n) {
        super(n);
    }


    public void assignSalaries(int[] salaries) {
        super.assignIncome(salaries);
        printMessages(0, "", "accountants");
    }


    public void maxSalary() {
        printMessages(super.MaxSalary(), "max", "accountants");
    }


    public void minSalary() {
        printMessages(super.MinSalary(), "min", "accountants");
    }


    public void averageSalary() {
        printMessages(super.AveSalary(), "ave", "accountants");
    }

}
