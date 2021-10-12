package account;

import exception.InsufficientBalanceException;
import exception.NegativeAmountException;

import java.lang.invoke.LambdaMetafactory;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Account {
// TODO: Add comission calculation
    private final String accountNumber;
    private  String name;
    private  String surname;
    private  final String password;
    private final String currency;
    private final String FIN;
    private  double balance;
private List<Transaction> transactions;


    //constructor yaradiriq
    public  Account(String accountNumber,
                    String name,
                    String surname,
                    String currency,
                    String password,
                    String FIN,
                    double balance){
        this.accountNumber=accountNumber;
        this.name=name;
        this.surname=surname;
        this.currency=currency;
        this.password=password;
        this.FIN=FIN;
        if (balance<0){
            throw new NegativeAmountException("DAXIL EDILEN MEBLEG SIFIRDAN KICIKDIR");
        }
        this.balance=balance;
        this.transactions=new ArrayList<>();

    }

    public String  getAccountNumber(){
        return accountNumber;
    }

   public  String getName(){
        return  name;
   }
   public  void setName( String name){
        this.name=name;
   }

   public String getSurname(){
        return surname;
    }
    public void setSurname(){
        this.surname=surname;
    }

    public  String getCurrency(){
        return currency;
    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance){

        this.balance=balance;
    }
    public  void showBalance(){
        System.out.println("Hesabinizin balansi"+this.balance+ " " + this.currency);
    }
    public  void deposit(double amount){
        if (amount<=0){
            System.out.println("Daxil edilen mebleg duzgun deyil");
            throw new NegativeAmountException("Invalid amount!");
        }
        this.balance+=amount;
        Transaction trn=new Transaction(this.balance,amount,this.currency,
                this.accountNumber, LocalDateTime.now(),TransactionType.DEPOSIT);
        transactions.add(trn);
    }
    public  void  withdraw(double amount){
        if (amount<=0){
            System.out.println("Daxil edilen mebleg duzgun deyil");
            throw new NegativeAmountException("Invalid amount!");
        }
        if (amount>this.balance){
//            System.out.println("Balansinizda kifayet qeder mebleg yoxdur." +
//                    " Balans: %s daxil edilen mebleg:%s \n",balance,amount );
           throw  new InsufficientBalanceException("Insufficient balance");
        }
        this.balance -=amount;
        Transaction trn=new Transaction(this.balance,amount,this.currency,
                this.accountNumber, LocalDateTime.now(),TransactionType.WITHDRAW);
        transactions.add(trn);
    }
// TODO: Check currency before transfer.AZN hesabdan diger valyutada olan hesaba kocurme etmek olmaz
    public void transfer(double amount,Account depositAccount){
      double commission=amount*0.01;
      if (commission<1){
          commission=1;
      }
      if ((amount+commission)>balance){
          throw new InsufficientBalanceException("Insufficient balance");
      }
        this.balance -=commission;

        Transaction trn=new Transaction(this.balance,commission,this.currency,
                this.accountNumber, LocalDateTime.now(),TransactionType.COMMISSION);
        transactions.add(trn);


      //  depositAccount.balance=depositAccount.balance+amount;
this.withdraw(amount);
depositAccount.deposit(amount);
    }


    public void showHistory() {
        System.out.println("Account history is:");



        System.out.println("amount  |  currency  | date | type |  current balance");
        transactions.forEach((m) -> System.out.println(m));
    }

    public boolean checkFIN(String FIN){
        return this.FIN.equals(FIN);
    }
    public boolean checkPassword(String password){
        return this.password.equals(password);
    }



}
