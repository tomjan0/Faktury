package mypackage;

public class Article {
    private final int id;
    private final String name;
    private final double price;

    public Article(int id, String name, double price) {
        for (Article art : Database.articles){
            if(art.id == id){
                throw new IllegalArgumentException("Artykuł o podanym ID już istnieje");
            }
        }
        if(price <= 0){
            throw new IllegalArgumentException("Cena musi być dodatnia!");
        }
        this.id = id;
        this.name = name;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public void showArticle(){
        System.out.println("ID: " + id + "  Nazwa: " + name + "  Cena: " + price);
    }
}
