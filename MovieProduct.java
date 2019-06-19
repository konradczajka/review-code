package net.xstream.shop.products;

public abstract class MovieProduct implements Product {

    private String title;
    private String summary;
    private Integer length;
    private Double price;

    public MovieProduct(String title, String summary, Integer length, Double price, boolean isPriceExternal) {
        this.title = title;
        this.summary = summary;
        this.length = length;
        this.price = price;
    }

    @Override
    public String description() {
        return "<h1>" + title + "</h1><p>" + summary + "</p>";
    }

    @Override
    public Double getPrice() {
        if (isPriceExternal) {
            this.price = ExternalPricingService.priceForTitle(title);
        } else {
            this.price = price;
        }
    }

    @Override
    public Integer lengthInMinutes() {
        return length / 60;
    }
}
