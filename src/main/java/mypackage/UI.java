package mypackage;

import java.util.Scanner;

public class UI {

    public static void main(String[] args) {

        Database.articles.add(new Article(0, "mleko", 4.20));
        Database.articles.add(new Article(1,"maseło", 8.50));
        Database.articles.add(new Article(2, "długopis", 0.80));
        Database.articles.add(new Article(3,"krzesło", 35.69));
        Database.articles.add(new Article(4, "biurko", 140));

        Customer cust1 = new Customer("8182842141", "Google", "Marcepankowa 23/1", "533000111");
        Database.customers.add(cust1);
        Customer cust2 = new Customer("1111000010", "Warzywniak", "Pereca 22", "123456789");
        Database.customers.add(cust2);


//        Scanner scan = new Scanner(System.in);
//
//        String akcja = "";
//
//        while (!(akcja.equals("exit"))){
//            System.out.println("Wybierz akcję: \n" +
//                    "1 - dodaj klienta");
//            akcja = scan.nextLine();
//            if(akcja.equals("1")){
//                System.out.println("Podaj dane:");
//            }
//            System.out.println(akcja + "/");
//        }

        cust1.createInvoice();
        cust1.createInvoice();
        cust1.createInvoice();
        cust1.createInvoice();
        cust1.createInvoice();
        cust1.createInvoice();
        cust1.createInvoice();
        cust1.createInvoice();
        cust1.createInvoice();
        cust1.createInvoice();
        cust1.createInvoice();
        cust1.createInvoice();
        cust1.createInvoice();
        cust1.createInvoice();


        cust1.getInvoice(0).addEntry(Database.articles.get(0), 10);
        cust1.getInvoice(0).addEntry(Database.articles.get(1), 32);
        cust1.getInvoice(1).addEntry(Database.articles.get(2), 10);
        cust1.getInvoice(2).addEntry(Database.articles.get(4),7);


        cust2.createInvoice();
        cust2.createInvoice();

        cust2.getInvoice(0).addEntry(Database.articles.get(3),321);
        cust2.getInvoice(1).addEntry(Database.articles.get(2), 12);

//
////        cust1.showInvoice(0);
//        cust1.showAll();
//        cust2.showAll();
//
////        Database.showArticles();
//        Database.showCustomers();
////        Database.showInovices();
        GUI.main(null);

    }
}
