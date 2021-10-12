package account;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

public class Transaction {
    // TODO: Add commission details

    private  double balance;
    private  double amount;
    private  String currency;
    private  String accountNumber;
    private LocalDateTime dateTime;
    private TransactionType type;

    public  Transaction(double balance,
                        double amount,
                        String currency,
                        String accountNumber,
                        LocalDateTime dateTime,
                        TransactionType type){
        this.balance=balance;
        this.amount=amount;
        this.currency=currency;
        this.accountNumber=accountNumber;
        this.dateTime=dateTime;
        this.type=type;

    }
    public  String toString(){
        return  amount+ " | " +currency+" | "+dateTime+" | "+type+" | "+balance;
//        return "amount="+ amount+",currency="+currency+
//                ",date=" + dateTime+",type="+type+",currency balance="+balance;

    }

}
