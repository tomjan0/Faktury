package mypackage;

import java.util.ArrayList;

public class Invoice {
    private ArrayList<Entry> entryList;
    private Customer customer;
    private String number;

    public Invoice(Customer customer, int size) {
        this.customer = customer;
        this.entryList = new ArrayList<>();
        this.number = customer.getNip() + "/" + size;
    }

    public ArrayList<Entry> getEntryList() {
        return entryList;
    }

    public void addEntry(Article article, double quantity) {
        if(quantity <= 0){
            throw new IllegalArgumentException("Ilość musi być dodatnia!");
        }
        this.entryList.add(new Entry(article, quantity));
    }

    public void show(){
        System.out.println("----FAKTURA nr " + number + "----");
        System.out.println("[nazwa || ilość || cena || wartość]");
        for (Entry ent : entryList) {
            System.out.println(ent.getArticle().getName() + " || " + ent.getQuantity() + " || " + ent.getArticle().getPrice() + " || " + ent.getValue());
        }
        System.out.println();
    }
}
