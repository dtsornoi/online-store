package com.online.store.service.implementation;

import com.online.store.entity.Product;
import com.online.store.repository.ProductRepository;
import com.online.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for Product.class
 *
 * @author Dmitri Tsornoi
 */
@Service
public class ProductServiceImplementation implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImplementation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findOne(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public void save(Product product) {
        productRepository.saveAndFlush(product);
    }

    @Override
    public void update(Product product) {
        Product oldProduct = findOne(product.getId());
        oldProduct.setAuthor(product.getAuthor());
        oldProduct.setCategory(product.getCategory());
        oldProduct.setDescription(product.getDescription());
        oldProduct.setThumbnail(product.getThumbnail());
        oldProduct.setTitle(product.getTitle());
        oldProduct.setPrice(product.getPrice());

        save(oldProduct);
    }

    @Override
    public void delete(Long id) {
        Product product = findOne(id);
        product.setActive(false);
        save(product);
    }

    @Override
    public void restore(Long id) {
        Product product = findOne(id);
        product.setActive(true);
        save(product);
    }
}
