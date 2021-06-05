package com.online.store.service.implementation;

import com.online.store.entity.Images;
import com.online.store.repository.ImagesRepository;
import com.online.store.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Service implementation for Images.class
 *
 * @author Mark Salumaa
 */

@Service
public class ImagesServiceImplementation implements ImagesService {

    private final ImagesRepository imagesRepository;

    @Autowired
    public ImagesServiceImplementation(ImagesRepository imagesRepository) {
        this.imagesRepository = imagesRepository;
    }


    @Override
    public List<Images> findAll() {
        return imagesRepository.findAll();
    }

    @Override
    public Images findOne(Long id) {
        return imagesRepository.findById(id).orElseThrow(() -> new RuntimeException("Image not found"));
    }

    @Override
    public Images save(Images images) {
        return imagesRepository.saveAndFlush(images);
    }

    @Override
    public void update(Images images) {
        Images oldImage = findOne(images.getImageId());
        oldImage.setImageUrl(images.getImageUrl());
        oldImage.setImageTitle(images.getImageTitle());
        oldImage.setIsActive(images.getIsActive());

        imagesRepository.saveAndFlush(oldImage);
    }

    @Override
    public void delete(Long id) {
        Images images = findOne(id);
        images.setIsActive(false);
        imagesRepository.saveAndFlush(images);

    }

    @Override
    public void restore(Long id) {
        Images images = findOne(id);
        images.setIsActive(true);
        imagesRepository.saveAndFlush(images);

    }
}
