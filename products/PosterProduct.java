package net.xstream.shop.products;

public abstract class PosterProduct implements Product {

    private String title;
    private String size;
    private Double price;

    public PosterProduct(String title, Double price, String size) {
        this.title = title;
        this.size = size;
        this.price = price;
    }

    @Override
    public String description() {
        return "<h1>Poster for movie: " + title + "</h1>" +
                "<p>Size: " + size + "</p>";
    }

    @Override
    public Double getPrice() {
        return price;
    }

    @Override
    public Integer lengthInMinutes() {
        return 0;
    }
}
