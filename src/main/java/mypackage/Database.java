package mypackage;

import java.util.ArrayList;

public class Database {
    static ArrayList<Invoice> invoices = new ArrayList<>();
    static ArrayList<Customer> customers = new ArrayList<>();
    static ArrayList<Article> articles = new ArrayList<>();

    public static void showInovices(){
        for(Invoice inv : invoices){
            inv.show();
        }
    }

    public static void showCustomers(){
        for(Customer cust : customers) {
            cust.showCustomerData();
        }
    }

    public static void showArticles(){
        for(Article art : articles){
            art.showArticle();
        }
    }
}
