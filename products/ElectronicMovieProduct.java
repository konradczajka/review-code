package net.xstream.shop.products;

public class ElectronicMovieProduct extends MovieProduct {

    private Integer sizeInBytes;

    public ElectronicMovieProduct(String title, String summary, Integer length, Double price, boolean isPriceExternal, Integer sizeInBytes) {
        super(title, summary, length, price, isPriceExternal);
        this.sizeInBytes = sizeInBytes;
    }

    @Override
    public String description() {
        return super.description() + "To download: <strong>" + (sizeInBytes / 1024 / 1024) + "GB</strong>";
    }
}
