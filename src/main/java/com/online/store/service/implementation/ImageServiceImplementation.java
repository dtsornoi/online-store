package com.online.store.service.implementation;

import com.online.store.entity.Image;
import com.online.store.entity.Product;
import com.online.store.repository.ImageRepository;
import com.online.store.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Images Service Implementation
 *
 * @author Dmitri Tsornoi
 */
@Service
public class ImageServiceImplementation implements ImageService {

    private final ImageRepository imageRepository;

    @Autowired
    public ImageServiceImplementation(ImageRepository imageRepository) {
        this.imageRepository = imageRepository;
    }

    @Override
    public List<Image> getAll() {
        return imageRepository.findAll();
    }

    @Override
    public List<Image> getAllForCurrentProduct(Product product) {
        return imageRepository.findAll()
                .stream()
                .filter(image -> image.getProduct()
                        .getId()
                        .equals(product.getId()))
                .collect(Collectors.toList());
    }

    @Override
    public Image getOne(Long id) {
        return imageRepository.findById(id).orElseThrow(() -> new RuntimeException("Image not found"));
    }

    @Override
    public void save(Image image) {
        imageRepository.save(image);
    }

    @Override
    public void update(Image image) {
        Image oldImage = getOne(image.getId());
        oldImage.setImg(image.getImg());
        oldImage.setMain(image.isMain());
        oldImage.setActive(image.isActive());
        oldImage.setProduct(image.getProduct());
    }

    @Override
    public void delete(Image image) {
        image.setActive(false);
        update(image);
    }

    @Override
    public void restore(Image image) {
        image.setActive(true);
        update(image);
    }
}
