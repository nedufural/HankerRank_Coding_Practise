package vanHackCodingChallenge.java.Question2;

import java.util.Arrays;
import java.util.IntSummaryStatistics;
import java.util.List;
import java.util.stream.Collectors;

public class EngineerFirm implements Company {

    private final int[] income;

    public EngineerFirm(int n) {
        income = new int[n];
        for (int i = 0; i < n; i++) {
            income[i] = 0;
        }
    }

    public static void printMessages(double salaryAmount, String salarySpecification, String profession) {
        switch (salarySpecification) {
            case "max":
                System.out.print("Maximum salary amongst " + profession);
                System.out.printf(" is %d" ,(int)salaryAmount);
                System.out.println("");
                break;
            case "min":
                System.out.print("Minimum salary amongst " + profession);
                System.out.printf(" is %d" ,(int)salaryAmount);
                System.out.println("");
                break;
            case "ave":
                System.out.print("Average salary of " + profession);
                System.out.printf(" is %.2f", salaryAmount);
                System.out.println("");
                break;
            default:
                System.out.println("Incomes of " + profession + " credited");
                break;
        }
    }

    @Override
    public void assignSalaries(int[] salaries) {
        if (salaries != null) {
            assignIncome(salaries);
            printMessages(0, "", "engineers");
        }
    }

    @Override
    public void maxSalary() {
        printMessages(MaxSalary(), "max", "engineers");
    }

    @Override
    public void minSalary() {
        printMessages(MinSalary(), "min", "engineers");
    }

    @Override
    public void averageSalary() {
        printMessages(AveSalary(), "ave", "engineers");

    }

    public Integer MaxSalary() {
        List<Integer> list = Arrays.stream(income).boxed().collect(Collectors.toList());
        return list.stream().max(Integer::compare).get();
    }

    public Integer MinSalary() {
        List<Integer> list = Arrays.stream(income).boxed().collect(Collectors.toList());
        return list.stream().min(Integer::compare).get();
    }

    public double AveSalary() {
        List<Integer> list = Arrays.stream(income).boxed().collect(Collectors.toList());

        IntSummaryStatistics stats = list.stream()
                .mapToInt((x) -> x)
                .summaryStatistics();
        return stats.getAverage();
    }

    public void assignIncome(int[] salaries) {
        System.arraycopy(salaries, 0, income, 0, Math.min(income.length, salaries.length));
    }
}
