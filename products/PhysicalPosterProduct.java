package net.xstream.shop.products;

public class PhysicalPosterProduct extends MovieProduct {

    // paper type: gloss, matte
    private String mediumDetails;

    public PhysicalPosterProduct(String title, String summary, Integer length, Double price, boolean isPriceExternal, String mediumDetails) {
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
