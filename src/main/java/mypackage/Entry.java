package mypackage;

public class Entry {
    private final Article article;
    private final double quantity;
    private final double value;

    public Entry(Article article, double quantity) {
        this.article = article;
        this.quantity = quantity;
        this.value = Math.floor(quantity*article.getPrice()*100)/100;
    }

    public Article getArticle() {
        return article;
    }

    public double getQuantity() {
        return quantity;
    }

    public double getValue() {
        return value;
    }
}
