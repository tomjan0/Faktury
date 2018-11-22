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

    public Invoice(Customer customer, int size, ArrayList<Entry> entryList) {
        this.customer = customer;
        this.entryList = entryList;
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

    public String toString(){
        String result = "----FAKTURA nr " + number + "----\n";
        result = result + "[nazwa || ilość || cena || wartość]\n";
        for (Entry ent : entryList) {
            result = result + ent.getArticle().getName() + " || " + ent.getQuantity() + " || " + ent.getArticle().getPrice() + " || " + ent.getValue() + "\n";
        }
        result = result + "\n";
        return  result;
    }

    public String getNumber() {
        return number;
    }
}
