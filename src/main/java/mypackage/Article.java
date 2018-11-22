package mypackage;

public class Article {
    private final int artIndex;
    private final String name;
    private final double price;

    public Article(int artIndex, String name, double price) {
        for (Article art : Database.articles){
            if(art.artIndex == artIndex){
                throw new IllegalArgumentException("Artykuł o podanym ID już istnieje");
            }
        }
        if(price <= 0){
            throw new IllegalArgumentException("Cena musi być dodatnia!");
        }
        this.artIndex = artIndex;
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
        System.out.println("ID: " + artIndex + "  Nazwa: " + name + "  Cena: " + price);
    }
}
