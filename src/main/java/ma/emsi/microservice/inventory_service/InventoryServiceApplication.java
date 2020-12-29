package ma.emsi.microservice.inventory_service;

import ma.emsi.microservice.inventory_service.model.Product;
import ma.emsi.microservice.inventory_service.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }


    @Bean
    CommandLineRunner start(ProductRepository productRepository, RepositoryRestConfiguration restConfiguration){
        return args -> {
            restConfiguration.exposeIdsFor(Product.class);
            List<Product> products = new ArrayList<>();
            for (int i = 0; i < 25; i++) {
                products.add(new Product(null,"product"+i,"https://m.media-amazon.com/images/I/51JvqroQdWL._SY346_.jpg",Math.random()*500));
            }
            productRepository.saveAll(products);

        };
    }
}

