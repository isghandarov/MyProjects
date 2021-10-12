import account.Account;
import account.Transaction;
import account.TransactionType;
import exception.NegativeAmountException;

import java.nio.channels.AcceptPendingException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
//
//      Transaction trn=new Transaction(10,25,"AZN",
//                "1234@", LocalDateTime.now(), TransactionType.DEPOSIT);
//        System.out.println(trn);
//
//        Account account=new Account("turan23","Mammad",
//                "Hasanov","AZN","1234ad","6ALBYM7",50);
//
//
//        System.out.println(account.getBalance());
//        System.out.println(account.getAccountNumber());
//        System.out.println(account.checkPassword("1234ad"));
//        account.deposit(10);
//
//        account.withdraw(23);
//        account.deposit(55);
//        account.withdraw(36);
//      System.out.println(account.getBalance());
//
//
//
//
//        Account account2=new Account("garah23","Elnur",
//                "Mammadli","AZN","1234ad","RVC4EQ6",220);
//
//        Account account4=new Account("yellow81","Vuqar",
//                "Hasanli","EURO","1234ad","T6YREQ6",700);
//
//        Account account5=new Account("green63","Qara",
//                "Seyidov","AZN","1234ad","QAD5EQ6",560);
//
//        List<Account>accounts=getData();
//        account.transfer(5,account2);
//
//        System.out.println(account2.getBalance());
//        account2.transfer(133,account5);
//        account4.transfer(17,account);
//        account.showHistory();
//        account2.showHistory();
//        account4.showHistory();
//        account5.showHistory();
//
//        account.deposit(10);
//        System.out.println(account.getBalance());
//
//        account.withdraw(24);
//        System.out.println(account.getBalance());
//        System.out.println();
//       System.out.println(LocalDateTime.now());
//        System.out.println(LocalDate.now());
//        System.out.println("Hello Baku");
//       System.out.println(LocalDateTime.now());

        List<Account> accounts=getData();
        Scanner scan=new Scanner(System.in);
        while (true) {
            System.out.println("Hesablar sisteminə xos gelmisiniz!");
            System.out.println("**********************************");
            System.out.println("Zehmet olmasa hesab nomresini daxil edin:");
            String accountNumber = scan.next();

            Account account = null;
            for (Account value : accounts) {
                if (value.getAccountNumber().equals(accountNumber)) {
                    account = value;
                }
            }
            if (account == null) {
                System.out.println("Daxil etdiyiniz hesab tapilmadi");
             //    return;
        //System.exit(0);
                continue;
            }

            System.out.println();


            for (int i = 0; i <= 3; i++) {
                System.out.println("Zehmet olmasa FIN-i daxil edin");
                String FIN = scan.next();
                if (account.checkFIN(FIN)) {
                    break;
                } else {
                    System.out.println("Daxil edilen fin yalnisdir!");
                    if (i == 3) {
                        System.out.println("Uc defe yanlis daxil edildiyinden hesab bloklandi!");
                        return;
                    }
                    System.out.println("Zehmet olmasa yeniden yoxlayin.Yoxlama imkani:" + (3 - i));
                    // throw new NegativeAmountException("fin yanlisdir");
                }
            }
            System.out.println();

            for (int j = 0; j <= 3; j++) {
                System.out.println("Zehmet olmasa sifreni daxil edin");
                String password = scan.next();
                if (account.checkPassword(password)) {
                    break;
                } else {
                    System.out.println("Daxil edilen sifre yalnisdir!");

                    if (j == 3) {
                        System.out.println("Uc defe yanlis daxil edildiyinden hesab bloklandi!");
                        return;
                    }
                    System.out.println("Zehmet olmasa yeniden yoxlayin.Yoxlama imkani:" + (3 - j));
                }
            }
            while (true) {

                System.out.println("1-Balansini goster");
                System.out.println("2-Hesabdan Mexaric");
                System.out.println("3-Hesabda medaxil");
                System.out.println("4-Emeliyyat tarixcersi");
                System.out.println("5-Diger hesaba pul kocurmek");
                System.out.println("6-Sistemden cix");

                int operation = scan.nextInt();

                if (operation == 6) {
                    System.out.println("Sistemden istifade etdiyinize gore tesekurler!");
                    System.out.println("----*-****----**-****--*-*--*");
                    break;
                }

                double amount;
                switch (operation) {

                    case 1:
                        account.showBalance();
                        break;
                    case 2:
                        System.out.println("Zehmet olmasa meblegi daxil edin:");
                        amount = scan.nextDouble();
                        account.withdraw(amount);
                        break;
                    case 3:
                        System.out.println("Zehmet olmasa meblegi daxil edin:");
                        amount = scan.nextDouble();
                        account.deposit(amount);
                        break;
                    case 4:
                        account.showHistory();
                        break;
                    case 5:
                        System.out.println("Qarsi terefin hesab nomresini daxil edin");
                        String depositAccountNumber = scan.next();
                        Account depositAccount = null;
                        for (Account value : accounts) {
                            if (value.getAccountNumber().equals(depositAccountNumber)) {
                                depositAccount = value;
                            }
                        }
                        if (depositAccount == null) {
                            System.out.println("Daxil etdiyiniz hesab tapilmadi");
                            continue;
                        }
                        System.out.println("Zehmet olmasa meblegi daxil edin:");
                        amount = scan.nextDouble();
                        account.transfer(amount, depositAccount);
                        break;
                    default:
                        System.out.println("Emeliyyat movcud deyil. Secilen emeliyyat " + operation);
                }
            }
        }





        //------------------------------------
      //  System.out.print(account.getBalance());
    }
   static List<Account> getData(){

        Account ac1=new Account("1111","Amil",
                "Isghandarov","AZN","1234ad","6ALBYM7",150);

        Account ac2=new Account("2222","Mammad",
                "Hasanov","AZN","1234lc","ER3TY4Q",1200);

        Account ac3=new Account("3333","Kanan",
                "Amirli","AZN","1234mj","KY3BYM7",550);

        Account ac4=new Account("4444","Emin",
                "Miriyev","AZN","1234TR","3ASUYM7",120);

        Account ac5=new Account("5555","Qafar",
                "Qafarli","AZN","1234zn","REW8YM7",450);

        List<Account> accounts=new ArrayList<>();
        accounts.add(ac1);
        accounts.add(ac2);
        accounts.add(ac3);
        accounts.add(ac4);
        accounts.add(ac5);

        return accounts;
   }
}
