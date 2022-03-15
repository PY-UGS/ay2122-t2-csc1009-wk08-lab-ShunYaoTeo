import java.util.Scanner;

public class CheckingAccount {
    private double balance = 0;
    private double number;
    Scanner input = new Scanner(System.in);


    public void selection(){
        System.out.println("Welcome! Please select the following operations");
        System.out.println("1.Deposit");
        System.out.println("2.Withdraw");
        System.out.println("3.Check Balance");
        System.out.println("4.Exit");
        int choice = input.nextInt();
        switch(choice){
            case 1:
                this.deposit();
                this.selection();
            case 2:
                this.withdraw();
                this.selection();
            case 3:
                System.out.println("Your current Balance is: $"+getBalance());
                this.selection();
            case 4:
                System.out.println("Thank You");
                return;

        }
    }
    public void deposit(){
        System.out.println("Current Balance is: $" +this.getBalance());
        System.out.println("Please enter the amount you wish to deposit");
        double value = input.nextDouble();
        this.balance = this.balance + value;
        System.out.println("Current Balance is now: $"+this.getBalance());
    }

    public void withdraw(){
        try {
            System.out.println("Please enter the amount you wish to withdraw: ");
            double value = input.nextDouble();
            if (value > this.balance){
                throw new InsufficientFundsException(value);
            }
            this.balance = this.balance - value;
            System.out.println("The balance after withdraw is: $"+this.getBalance());
        }catch(InsufficientFundsException e){
            System.out.println(e + "Sorry but your account is short by $"+ (e.getAmount()-this.getBalance()));
        }

    }

    public double getBalance() {
        return balance;
    }

    public double getNumber() {
        return number;
    }
}
