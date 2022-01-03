package com.company;

public class Basket {
    private String name;
    private Node<Product> products;

    public Basket(String name) {
        this.name = name;
        this.products = null;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Node<Product> getProducts() {
        return products;
    }

    public void setProducts(Node<Product> products) {
        this.products = products;
    }

    @Override
    public String toString() {
        return "Basket{" +
                "name='" + name + '\'' +
                ", products=" + products +
                '}';
    }

    public double total() {
        Node<Product> products = this.products;
        double sum = 0;
        while (products != null) {
            sum += products.getValue().getPrice();
            products = products.getNext();
            System.out.println(sum);
        }
        return sum;
    }

    public void addProduct(Product p) {
        Node<Product> n = products;
        if (products == null) {
            products = new Node<>(p);
        }
        if (n != null) {
            while (n.getNext() != null) {
                n = n.getNext();
            }
            n.setNext(new Node<>(p));
        }
        System.out.println("successfully added " + p + " to " + this.name + "'s basket");
    }

    public void removeProduct(Product p) {
        Node<Product> n = products;
        if (products == null) {
            System.out.println("the basket is empty");
        }
        if (n != null) {
            while (n != null) {
                if (n.getNext().getValue() == p) {
                    n.setNext(n.getNext().getNext());
                }
                if (n.getNext() != null && n.getNext().getValue() != p) {
                    n = n.getNext();
                }
                n = n.getNext();
            }
        }
        if (n != null && n.getValue() == p) {
            n = n.getNext();
        }
        System.out.println("successfully removed " + p + " from " + this.name + "'s basket");
    }
}
