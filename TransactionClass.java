package training;

import java.util.Scanner;

public class TransactionClass {
    public static void main(String[] args){
        Transaction t = new Transaction();
        int choice,amount;
        long phone;
        String name,address;
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the amount ");
        amount=sc.nextInt();
        while(true){
        System.out.println("enter the number :1.To open the new account,2.To do the withdraw the amount," +
                "3.To do the deposit,4.to close the account 5.enter the 9 to quit" );
        System.out.println("enter the choice");
        choice=sc.nextInt();


            if (choice == 1) {
                System.out.println("enter the name");
                name = sc.next();
                System.out.println("enter the address");
                address = sc.next();
                System.out.println("enter the phone number");
                phone = sc.nextLong();
                System.out.println("bank account is successfully created");
            } else if (choice == 2) {
                new Thread() {
                    @Override
                    public void run() {
                        t.withdraw(amount);
                    }
                }.start();
            } else if (choice == 3) {
                new Thread() {
                    @Override
                    public void run() {
                        t.deposit(amount);
                    }
                }.start();
            } else if (choice == 4) {
                System.out.println("account is closed");
            } else if (choice==9) {
                break;
            }
        }
    }
}
