import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args){
        ArrayList<Item> items = new ArrayList<>();
        Scanner sc = new Scanner (System.in);
        double subTotal=0;
        double salesTax =0;
        String myitem = "";
        ArrayList<Double> taxRate = new ArrayList<>();

        taxRate.add(6.00);
        taxRate.add(5.30);
        taxRate.add(5.75);
        taxRate.add(5.00);


        do {
            System.out.println("Enter the order");
            String userOrder = sc.next();
            System.out.println("enter the price for your order");
            double userPrice = sc.nextDouble();
            System.out.println("Enter the quantity");
            int userQuantity = sc.nextInt();
            System.out.println("Is it taxable- enter true or false");
            boolean userTax = sc.nextBoolean();



            items.add(new Item(userOrder, userPrice, userQuantity, userTax));
            System.out.println("do you want to inter more item");
             myitem = sc.next();
        }while (!myitem.equalsIgnoreCase("no"));

        Random rn = new Random();
        int taxrate = rn.nextInt(taxRate.size());
        double salestaxe = taxRate.get(taxrate);

        for(Item g:items){
            System.out.print(g.getName() + "\t");
            System.out.print(g.getPrice()+ "\t");
            System.out.print(g.getQuantity()+ "\t");
            System.out.print(g.getCost()+"\t");
            System.out.println(g.isTaxable());

            subTotal = subTotal + g.getCost();
            if(g.isTaxable() == true){
                 salesTax = (g.getCost()* (salestaxe /100)) + salesTax;
//                salesTax1 =  + salesTax1;
            }

        }
        System.out.println("\nSubTotal =" + subTotal);
        System.out.println("Sales Tax = " + salesTax);
        double  grandTotal;
        grandTotal=subTotal+salesTax;
        System.out.println("Total = " + grandTotal);

    }
}
