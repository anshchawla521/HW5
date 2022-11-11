public class question2 {

    public static void main(String args[]) {

        SBI obj1 = new SBI();
        System.out.println(obj1.check_balance());
        obj1.deposit(10000);// deposit 2000
        System.out.println(obj1.check_balance());
        obj1.withdrawl(1000); //withdraw 1000
        System.out.println(obj1.check_balance());
        obj1.withdrawl(6000); //try to withdraw more than 5k// would fail
        
        System.out.println(obj1.check_balance());

    }
}

class RBI {
    static double minimum_interest_rate = 0.4;
    static double minimum_balance_allowed = 3000;
    static double maximum_withdrawl_limit = 5000;

    customer c;

    RBI()
    {
        c = new customer();
    }


    boolean withdrawl(int amount)
    {
        if(amount > maximum_withdrawl_limit || this.c.my_account.balance < amount + minimum_balance_allowed )
        {
            return false;
            // withdrawl not allowed 
        }else{
            this.c.my_account.balance -= amount;
            return true;
        }

    }


    void deposit(int amount)
    {
        this.c.my_account.balance += amount;
    }

    int check_balance()
    {
        return this.c.my_account.balance;
    }

}

class customer {
    Account my_account ;


    customer()
    {
        my_account = new Account(3000);
        // create customers account by default;

    }

}

class Account {
    int balance = 0;

    Account(int balance)
    {
        if (balance< RBI.minimum_balance_allowed)
        {
            return;
            // error as account cannot be opened with less balance
        }else{
            this.balance = balance;
        }

    }

}

class SBI extends RBI
{

    static double minimum_interest_rate = 0.4;
    static double minimum_balance_allowed = 3000;

    SBI()
    {
        c = new customer();
    }

}


class ICICI extends RBI
{

    static double minimum_interest_rate = 0.4;
    static double maximum_withdrawl_limit = 6000;

    ICICI()
    {
        c = new customer();
    }

}