package org.example.product;


@FeignClient(
        name = "product-service",
        url = "${application.config.product-url}"
)
public interface Product {


}
