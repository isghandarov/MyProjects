package account;

import accounts.ShoppingType;

import java.time.LocalDateTime;

public class shopping {
    private String  username;
    private  String password;
    private String name;
    private int number;
    private int count;
    private String brand;
    private String email;
    private LocalDateTime dateTime;
    private ShoppingType type;

    public shopping(
            String accountNumber,
            String name,
            int number,
            String brand, LocalDateTime now, boolean add){
      this.username= username;
        this.name=name;
        this.count=count;
        this.brand=brand;
        this.number=number;
        this.email=email;
        this.dateTime=dateTime;
        this.type=type;
    }



}
