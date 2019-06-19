package net.xstream.shop.products;

public class PhysicalMovieProduct extends MovieProduct {

    // CD, DVD, BlueRay
    private String mediumDetails;

    public PhysicalMovieProduct(String title, String summary, Integer length, Double price, boolean isPriceExternal, String mediumDetails) {
        super(title, summary, length, price, isPriceExternal);
        this.mediumDetails = mediumDetails;
    }

    @Override
    public String description() {
        return super.description() + mediumDescription();
    }

    private String mediumDescription() {
        return "<strong>" + mediumDetails + "</strong>";
    }
}
