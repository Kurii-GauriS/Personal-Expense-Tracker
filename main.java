import java.util.ArrayList;
import java.util.Scanner;

public class main {

    static class Expense {
        String title;
        double amount;
        String category;

        Expense(String title, double amount, String category) {
            this.title = title;
            this.amount = amount;
            this.category = category;
        }
    }

    static ArrayList<Expense> expenses = new ArrayList<>();
    static Scanner sc = new Scanner(System.in);

    /**
     * @param args
     */
    public static void main(String[] args) {

        while (true) {
            System.out.println("\n===== EXPENSE TRACKER =====");
            System.out.println("1. Add Expense");
            System.out.println("2. View Expenses");
            System.out.println("3. Total Spending");
            System.out.println("4. Search by Category");
            System.out.println("5. Delete Expense");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    addExpense();
                    break;

                case 2:
                    viewExpenses();
                    break;

                case 3:
                    totalSpending();
                    break;

                case 4:
                    searchCategory();
                    break;

                case 5:
                    deleteExpense();
                    break;

                case 6:
                    System.out.println("Thank you for using Expense Tracker!");
                    return;

                default:
                    System.out.println("Invalid choice!");
            }
        }
    }

    static void addExpense() {
        System.out.print("Enter expense name: ");
        String title = sc.nextLine();

        System.out.print("Enter amount: ₹");
        double amount = sc.nextDouble();
        sc.nextLine();

        System.out.print("Enter category: ");
        String category = sc.nextLine();

        expenses.add(new Expense(title, amount, category));

        System.out.println("Expense added successfully!");
    }

    static void viewExpenses() {

        if (expenses.isEmpty()) {
            System.out.println("No expenses found.");
            return;
        }

        System.out.println("\n----- EXPENSES -----");

        for (int i = 0; i < expenses.size(); i++) {

            Expense e = expenses.get(i);

            System.out.println(
                (i + 1) + ". " +
                e.title + " | ₹" +
                e.amount + " | " +
                e.category
            );
        }
    }

    static void totalSpending() {

        double total = 0;

        for (Expense e : expenses) {
            total += e.amount;
        }

        System.out.println("Total Spending: ₹" + total);
    }

    static void searchCategory() {

        System.out.print("Enter category: ");
        String category = sc.nextLine();

        boolean found = false;

        for (Expense e : expenses) {

            if (e.category.equalsIgnoreCase(category)) {

                System.out.println(
                    e.title + " | ₹" +
                    e.amount + " | " +
                    e.category
                );

                found = true;
            }
        }

        if (!found) {
            System.out.println("No expenses found in this category.");
        }
    }

    static void deleteExpense() {

        viewExpenses();

        if (expenses.isEmpty()) {
            return;
        }

        System.out.print("Enter expense number to delete: ");
        int number = sc.nextInt();

        if (number >= 1 && number <= expenses.size()) {

            expenses.remove(number - 1);

            System.out.println("Expense deleted successfully!");

        } else {
            System.out.println("Invalid expense number!");
        }
    }
}