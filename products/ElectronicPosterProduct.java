package net.xstream.shop.products;

public class ElectronicPosterProduct extends PosterProduct {

    private Integer sizeInBytes;

    public ElectronicPosterProduct(String title, Double price, String size, Integer sizeInBytes) {
        super(title, price, size);
        this.sizeInBytes = sizeInBytes;
    }

    @Override
    public String description() {
        return super.description() + "To download: <strong>" + (sizeInBytes / 1024 / 1024) + "GB</strong>";
    }
}
