package org.example.product;

import graphql.kickstart.tools.GraphQLMutationResolver;
import graphql.kickstart.tools.GraphQLQueryResolver;
import lombok.RequiredArgsConstructor;
import org.example.product.product.entity.Product;
import org.example.product.product.service.ProductService;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProductGraphQL implements GraphQLQueryResolver, GraphQLMutationResolver {
    private final ProductService productService;

    // Query: Get product by ID
    public Product getProductById(Long id) {
        return productService.getProductById(id);
    }

    // Query: Get all products
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    // Mutation: Create a new product
    public Product createProduct(String name, String description, double price, int quantity) {
        return productService.createProduct(Product.builder()
                .name(name)
                .description(description)
                .price(price)
                .quantity(quantity)
                .build());
    }

    // Mutation: Update an existing product
    public Product updateProduct(Long id, String name, String description, Double price, Integer quantity) {
        return productService.updateProduct(id, Product.builder()
                .name(name)
                .description(description)
                .price(price)
                .quantity(quantity)
                .build());
    }

    // Mutation: Delete a product
    public String deleteProduct(Long id) {
        productService.deleteProduct(id);
        return "Product deleted successfully!";
    }
}
