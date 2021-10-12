package account;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Product {
    private final String username;
    private String name;
    private final String password;
    private int number;
private int count;
private String brand;
private String email;
private List<shopping>shoppings;

    public Product(String username, String name,String password,int number,
                   int count,String brand,String email) throws NegativeProductException {
        this.username = username;
        this.name=name;
        this.password = password;
        this.number=number;
        this.count=count;
       this.brand=brand;
       this.email=email;
       if (count<=0){
           throw new NegativeProductException("Gosterdiyiniz sayda mehsul yoxdur");
       }
       this.shoppings=new ArrayList<>();
    }

    public String getUsername() {
        return username;
    }

    public String getName() {
        return name;
    }

    public String getPassword() {
        return password;
    }

    public int getNumber() {
        return number;
    }

    public int getCount() {
        return count;
    }


    public String getBrand() {
        return brand;
    }
        public String getEmail() {
            return email;
        }

    public void showCount() {
        System.out.println("Qalan mehsulun sayi"+this.count);
    }
    public void BUY(int amount) throws NegativeProductException {
        if (amount<=0){
            System.out.println("Secdiniz mehsulun sayi duzgun deyil");
            throw new NegativeProductException("Invalid count");
        }
        this.count +=amount;
        shopping shp=new shopping(this.brand,this.name,this.number,
                this.username,LocalDateTime.now(), shoppings.add((shopping) shoppings));
    }
    public  void SELL(int amount) throws NegativeProductException, InssufficientCountException {
        if (amount<=0){
            System.out.println("Secdiyiniz mehsulun sayi duzgun deyil");
            throw new NegativeProductException("Invalid count");
        }
        if (amount>this.count){
            System.out.println("Secdiyiniz mehsul bitmisdir");
            throw new InssufficientCountException("Inssufficient count");
        }
        this.count-=amount;
        shopping shp=new shopping(this.brand,this.name,this.number,
                this.username,LocalDateTime.now(),shoppings.add((shopping) shoppings));

    }
    public boolean checkPassword(String password){
        return this.password.equals(password);
    }

}










