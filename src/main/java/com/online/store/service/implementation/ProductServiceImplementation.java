package com.online.store.service.implementation;

import com.online.store.entity.Product;
import com.online.store.repository.ProductRepository;
import com.online.store.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Service implementation for Product.class
 *
 * @author Dmitri Tsornoi
 */
@Service
public class ProductServiceImplementation implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImplementation(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<Product> findAllActive() {
        return productRepository.findByIsActiveTrue();
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public List<Product> findByCategoryId(Long id) {
        return productRepository.findByCategoryId(id);
    }

    @Override
    public Product findOne(Long id) {
        return productRepository.findById(id).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    @Override
    public Product save(Product product) {
        return productRepository.saveAndFlush(product);
    }

    @Override
    public void update(Product product) {
        Product oldProduct = findOne(product.getId());
        oldProduct.setUserAccount(product.getUserAccount());
        oldProduct.setIsActive(product.getIsActive());
        oldProduct.setQuantity(product.getQuantity());
        oldProduct.setAvailableQuantity(product.getAvailableQuantity());
        oldProduct.setCategory(product.getCategory());
        oldProduct.setDescription(product.getDescription());
        oldProduct.setTitle(product.getTitle());
        oldProduct.setPrice(product.getPrice());
        oldProduct.setImage(product.getImage());

        productRepository.saveAndFlush(oldProduct);
    }

    @Override
    public void delete(Long id) {
        Product product = findOne(id);
        product.setIsActive(false);
        productRepository.saveAndFlush(product);
    }

    @Override
    public void restore(Long id) {
        Product product = findOne(id);
        product.setIsActive(true);
        productRepository.saveAndFlush(product);
    }
}
