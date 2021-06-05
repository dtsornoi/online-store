package com.online.store.repository;

import com.online.store.entity.Images;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Repository for Images.class
 *
 * @author Mark Salumaa
 */

@Repository
public interface ImagesRepository extends JpaRepository<Images, Long> {

}
