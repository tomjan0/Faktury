package mypackage;

import java.util.Scanner;

public class UI {

    public static void main(String[] args) {

        Database.articles.add(new Article(0, "mleko", 4.20));
        Database.articles.add(new Article(1,"maseło", 8.50));
        Database.articles.add(new Article(2, "długopis", 0.80));
        Database.articles.add(new Article(3,"krzesło", 35.69));
        Database.articles.add(new Article(4, "biurko", 140));

        Customer c1 = new Customer("8182842141", "Google", "Marcepankowa 23/1", "533000111");
        Database.customers.add(c1);
        Customer c2 = new Customer("1111000010", "Warzywniak", "Pereca 22", "123456789");
        Database.customers.add(c2);

        Scanner scan = new Scanner(System.in);

        String akcja = "";

        while (!(akcja.equals("exit"))){
            System.out.println("Wybierz akcję: \n" +
                    "1 - dodaj klienta");
            akcja = scan.nextLine();
            if(akcja.equals("1")){
                System.out.println("Podaj dane:");
            }
            System.out.println(akcja + "/");
        }

//        c1.createInvoice();
//        c1.createInvoice();
//        c1.createInvoice();
//
//        c1.getInvoice(0).addEntry(Database.articles.get(0), 10);
//        c1.getInvoice(0).addEntry(Database.articles.get(1), 32);
//        c1.getInvoice(1).addEntry(Database.articles.get(2), 10);
//        c1.getInvoice(2).addEntry(Database.articles.get(4),7);
//
//        c2.createInvoice();
//        c2.createInvoice();
//
//        c2.getInvoice(0).addEntry(Database.articles.get(3),321);
//        c2.getInvoice(1).addEntry(Database.articles.get(2), 12);
//
////        c1.showInvoice(0);
//        c1.showAll();
//        c2.showAll();
//
////        Database.showArticles();
//        Database.showCustomers();
////        Database.showInovices();

    }
}
