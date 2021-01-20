package ru.job4j.oop;

public class Shop {
    private  LiquidationProduct lProduct;

    /* Нужно ли здесь так объявлят.
    public LiquidationProduct getlProduct() {
        return lProduct;
    }*/

    public static Product of(String name, int price) {
        lProduct = new LiquidationProduct(name, price);
        if ("Oil".equals(name)) {
            return lProduct;
        }
        return new Product(name, price);
    }

    public static void main(String[] args) {
        Product product = of("Oil", 100);
        System.out.println(product.label());
    }
}
