import account.NegativeProductException;
import account.Product;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NegativeProductException {
        List<Product>accounts=getData();
        Scanner sc =new Scanner(System.in);
        while (true) {
            System.out.println("Elektron mehsullar sistemi");
            System.out.println("****************************");
            System.out.println("Zehmet olmasa hesab nomrenizi daxil edin");
            String userName = sc.next();


            Product product = null;

            Iterable<? extends Product> products = null;
            for (Product value : products) {

                if (value.getUsername().equals(userName)) {
                    product = value;
                }
            }
        }

   for (int i=0;i<=2;i++){
       System.out.println("Zehmet olmasa parolu daxil edin ");
       String password=sc.next();
       Product product;
       if (product.checkPassword(password)){
           break;
       }else {
           System.out.println("Daxil etdiyiniz parol sehvdir");
           if(i==2){
               System.out.println("Parolu daxil etme sansiniz bitdi");
               continue;
           }
           System.out.println("Yeniden cehd edin");
       }
   }
}




    public static List<Product> getData() throws NegativeProductException {
        Product pr1 = new Product("0001", "USB","12345",12,
                25,"Samsung","electronicequipment@gmail.com" );
        Product pr2 = new Product("0002", "Phone","81245",13,
                30,"Samsung","electronicequipment@gmail.com" );
        Product pr3 = new Product("0003", "Laptop","54145",34,
                30,"Samsung","electronicequipment@gmail.com" );
        Product pr4 = new Product("0004", "Adapter","80045",22,
                50,"Samsung","electronicequipment@gmail.com" );
        Product pr5 = new Product("0005", "TV","81874",19,
                100,"Samsung","electronicequipment@gmail.com" );
        Product pr6 = new Product("0006", "Fridge","784120",55,
                30,"Samsung","electronicequipment@gmail.com" );
        Product pr7 = new Product("0007", "Conditioner","8128744",123,
                45,"Samsung","electronicequipment@gmail.com" );
        Product pr8 = new Product("0009", "Iron","232201",76,
                56,"Samsung","electronicequipment@gmail.com" );
        List<Product>products=new ArrayList<>();
        products.add(pr1);
        products.add(pr2);
        products.add(pr3);
        products.add(pr4);
        products.add(pr5);
        products.add(pr6);
        products.add(pr7);
        products.add(pr8);

        return products;
    }


}