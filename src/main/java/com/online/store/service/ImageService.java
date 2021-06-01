package com.online.store.service;

import com.online.store.entity.Image;
import com.online.store.entity.Product;

import java.util.List;

/**
 * Images Service Interface
 *
 * @author Dmitri Tsornoi
 */
public interface ImageService {

    List<Image> getAll();

    List<Image> getAllForCurrentProduct(Product product);

    Image getOne(Long id);

    void save(Image image);

    void update(Image image);

    void delete(Image image);

    void restore(Image image);
}
