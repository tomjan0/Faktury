package mypackage;

import java.util.ArrayList;

public class Customer {
    private final String nip;
    private final String name;
    private final String address;
    private final String phone;
    private final ArrayList<Invoice> invoiceList = new ArrayList<>();

    public Customer(String nip, String name, String address, String phone) {
        for (Customer cust : Database.customers){
            if(cust.nip == nip){
                throw new IllegalArgumentException("Klient o podanym nipie już istnieje");
            }
        }
        if(nip.isEmpty() || name.isEmpty() || address.isEmpty() || phone.isEmpty()){
            throw new IllegalArgumentException("Argument nie może być pusty!");
        }
        if(!(nip.length() == 10 && nip.matches("[0-9]+"))){
            throw  new IllegalArgumentException("NIP musi zawierać 10 CYFR");
        }
        if (!(phone.length() == 9 && phone.matches("[0-9]+"))){
            throw new IllegalArgumentException("Numer telefonu musi składać się z 9 CYFR");
        }
        this.nip = nip;
        this.name = name;
        this.address = address;
        this.phone = phone;
    }

    public String getNip() {
        return nip;
    }

    public String getName() {
        return name;
    }

    public ArrayList<Invoice> getInvoiceList() {
        return invoiceList;
    }

    public Invoice getLatestInvoice(){
        return invoiceList.get(invoiceList.size()-1);
    }

    public String getAddress() {
        return address;
    }

    public String getPhone() {
        return phone;
    }

    public void createInvoice(){
        invoiceList.add(new Invoice(this, invoiceList.size()));
        Database.invoices.add(invoiceList.get(invoiceList.size()-1));
    }
    public void createInvoice(ArrayList<Entry> entryList){
        invoiceList.add(new Invoice(this, invoiceList.size(), entryList));
        Database.invoices.add(invoiceList.get(invoiceList.size()-1));
    }

    public Invoice getInvoice(int invIndex){
        if(invIndex < 0 || invIndex >= invoiceList.size()) {
            throw new IllegalArgumentException("Fakturta o podanym invIndex nie istnieje");
        }
        return invoiceList.get(invIndex);
    }

    public void showCustomerData(){
        System.out.println("-----DANE KLIENTA-----");
        System.out.println("NIP: " + this.nip);
        System.out.println("Nazwa: " + this.name);
        System.out.println("Adres: " + this.address);
        System.out.println("Nr Telefonu: " + this.phone);
        System.out.println();
    }

    public void showInvoice(int invIndex){
        showCustomerData();
        getInvoice(invIndex).show();
        System.out.println("==========================================\n\n");
    }

    public void showAll(){
        showCustomerData();
        for (Invoice inv : invoiceList) {
            inv.show();
        }
        System.out.println("==========================================\n\n");
    }

}
