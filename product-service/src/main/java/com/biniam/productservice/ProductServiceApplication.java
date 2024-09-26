package com.biniam.productservice;

import com.biniam.productservice.model.Category;
import com.biniam.productservice.model.Product;
import com.biniam.productservice.model.Variant;
import com.biniam.productservice.repository.ProductRepository;
import com.biniam.productservice.repository.VariantRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.Currency;
import java.util.List;

@SpringBootApplication
public class ProductServiceApplication implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    @Autowired
    VariantRepository variantRepository;
    public static void main(String[] args) {
        SpringApplication.run(ProductServiceApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {

        Variant variant1 = new Variant();
        variant1.setVariantId("5410");
        variant1.setColor("Red");

        variant1.setSize("M");

        List<Variant> variants = Arrays.asList(variant1);

        Product product1 = new Product();
        product1.setId("1234");
        product1.setName("Smartphone");
        product1.setDescription("Latest model smartphone with high-end features");
        product1.setCategory(Category.ELECTRONICS);
        product1.setPrice(699.99);
        product1.setCurrency(Currency.getInstance("USD"));
        product1.setAvailability(true);
        product1.setVariants(variants);

        // Product 2: Laptop
        Variant variant2 = new Variant();
        variant2.setVariantId("5420");

        variant2.setColor("Red");

        variant2.setSize("M");


        List<Variant> variants2 = Arrays.asList(variant2);

        Product product2 = new Product();
        product2.setId("3456");
        product2.setName("Laptop");
        product2.setDescription("High-performance laptop for professionals");
        product2.setCategory(Category.ELECTRONICS);
        product2.setPrice(1299.99);
        product2.setCurrency(Currency.getInstance("USD"));
        product2.setAvailability(true);
        product2.setVariants(variants2);

        // Product 3: T-shirt

        Variant variant3 = new Variant();
        variant3.setVariantId("5430");

        variant3.setColor("Red");

        variant3.setSize("M");



        List<Variant> variants3 = Arrays.asList(variant3);

        Product product3 = new Product();
        product3.setId("2300");
        product3.setName("T-shirt");
        product3.setDescription("Comfortable cotton t-shirt");
        product3.setCategory(Category.ELECTRONICS);
        product3.setPrice(19.99);
        product3.setCurrency(Currency.getInstance("USD"));
        product3.setAvailability(true);
        product3.setVariants(variants3);

        // Product 4: Book
        Variant variant4 = new Variant();
        variant4.setVariantId("5430");

        variant4.setColor("Red");
        variant4.setSize("M");
        List<Variant> variants4 = Arrays.asList(variant3);

        Product product4 = new Product();
        product4.setId("5430");
        product4.setName("Novel");
        product4.setDescription("Best-selling novel");
        product4.setCategory(Category.BOOKS);
        product4.setPrice(14.99);
        product4.setCurrency(Currency.getInstance("USD"));
        product4.setAvailability(true);
        product4.setVariants(variants4); // No variants for books

        // Product 5: Toy
        Variant variant5 = new Variant();
        variant4.setVariantId("5530");
        variant4.setColor("Red");

        Product product5 = new Product();
        product5.setId("9040");
        product5.setName("Toy Car");
        List<Variant> variants5 = Arrays.asList(variant3);

        product5.setDescription("Remote-controlled toy car");
        product5.setCategory(Category.TOYS);
        product5.setPrice(49.99);
        product5.setCurrency(Currency.getInstance("USD"));
        product5.setAvailability(true);
        product5.setVariants(variants5); // No variants for this product


        // Save all products to the database
        productRepository.saveAll(Arrays.asList(product1, product2, product3, product4, product5));

        System.out.println("Sample data has been loaded into the database.");

    }
}
