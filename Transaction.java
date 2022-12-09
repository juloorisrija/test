package training;

public class Transaction {
    int amt,balance=10000;

    synchronized void withdraw(int amt){
        System.out.println("going to withdraw...");
        //System.out.println(this.amt);
        if(amt<balance){
            System.out.println("Less balance; waiting for deposit...");
            try{wait();}catch(Exception e){}
        }
        balance=balance-amt;
        System.out.println("withdraw completed..."+amt);
        System.out.println("total balance after the withdraw :"+balance);
    }

    synchronized void deposit(int amt) {
        System.out.println("going to deposit...");
        this.amt += amt;
        balance = balance + amt;
        System.out.println("deposit completed... " + amt);
        System.out.println("total amount after deposit:" + balance);
        notify();
    }
}


