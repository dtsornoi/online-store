package com.online.store.service;

import com.online.store.entity.Images;

import java.util.List;

/**
 * Service interface for Images.class
 *
 * @author Mark Salumaa
 */

public interface ImagesService {

    List<Images> findAll();

    Images findOne(Long id);

    Images save(Images images);

    void update(Images images);

    void delete(Long id);

    void restore(Long id);
}
