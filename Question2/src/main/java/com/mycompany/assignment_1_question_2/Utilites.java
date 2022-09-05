package com.mycompany.assignment_1_question_2;

import java.util.ArrayList;
import java.util.Scanner;

public class Utilites {

    public static void writeMessage(String message) {
        /* 
            common method that we use to display output
         */
        System.out.println(message);
    }

    static ArrayList<String> BudgetAllocation = new ArrayList<>();
    static ArrayList<String> BudgetAllocationSummary = new ArrayList<>();

    public static Scanner readInput() {
        /* 
            common method that we use to read input
         */
        Scanner input = new Scanner(System.in);
        return input;
    }

    public void DisplayWelcomeMessage() {
        writeMessage("Welcome to Budget Allocation by Seroosan Naidoo");
        writeMessage("***********************************************");
    }

    public long AskForSalary() {
        writeMessage("Please enter your take home salary:");
        return Long.parseLong(readInput().next());
    }

    public void BudgetAllocationProcess() {
        DisplayWelcomeMessage();
        var salary = AskForSalary();
        var budgetAllocationTitle = "0";
        while (!"1".equals(budgetAllocationTitle)) {
            writeMessage("Please enter a BugetAllocation and please press 1 to stop the allocation when ready");
            budgetAllocationTitle = readInput().next();
            BudgetAllocation.add(budgetAllocationTitle);
        }
        var expenses = 00000000000000000000000000000000.0000;
        for (int i = 0; i < BudgetAllocation.size(); i++) {
            writeMessage("Please enter an amount for this " + BudgetAllocation.get(i) + " that you want to allocate for your budegt.");
            var amountInput = readInput().next();
            if (Double.parseDouble(amountInput) > 0) {
                expenses += Long.parseLong(amountInput);
                BudgetAllocationSummary.add(BudgetAllocation.get(i) + ": R" + amountInput + "\n");
            }

        }
        for (int i = 0; i < BudgetAllocationSummary.size(); i++) {
            writeMessage(BudgetAllocationSummary.get(i));
        }
        DisplayReport(salary, expenses);
    }

    public void DisplayReport(Long salary, Double expenses) {
        writeMessage("YOUR TOTAL SALARY: R" + salary);
        writeMessage("YOUR TOTAL EXPENSES: R" + expenses);
        writeMessage("YOUR TOTAL SAVINGS AMOUNT TO : R" + (salary - expenses));
    }
}
