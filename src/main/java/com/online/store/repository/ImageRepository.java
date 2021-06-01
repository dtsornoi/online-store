package com.online.store.repository;

import com.online.store.entity.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Images Repository
 *
 * @author Dmitri Tsornoi
 */
@Repository
public interface ImageRepository extends JpaRepository<Image, Long> {
}
