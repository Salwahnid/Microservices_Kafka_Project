package org.example.product.product.resolver;

import graphql.kickstart.tools.GraphQLQueryResolver;
import org.example.product.product.entity.Product;
import org.example.product.product.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class ProductQueryResolver implements GraphQLQueryResolver {
    @Autowired
    private ProductService productService;

    public List<Product> allProducts() {
        return productService.getAllProducts();
    }

    public Product getProductById(Long id) {
        return productService.getProductById(id);
    }
}
