package com.online.store.controller;

import com.online.store.entity.Images;
import com.online.store.service.ImagesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Images controller
 *
 * @author Mark Salumaa
 */

@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = "*")
public class ImagesRestController {

    private ImagesService imagesService;

    @Autowired
    public ImagesRestController(ImagesService imagesService) {
        this.imagesService = imagesService;
    }

    /**
     * GET:<code>/</code>
     *
     * @return List of all Images
     */
    @GetMapping("/")
    public ResponseEntity<List<Images>> getAllImages() {
        List<Images> image = imagesService.findAll();
        return new ResponseEntity<>(image, HttpStatus.OK);
    }


    /**
     * GET:<code>/id</code>
     *
     * @param id of type Long for searching Image by Id in DB
     * @return Image with with specified Id and HttpStatus.OK
     */
    @GetMapping("/{id}")
    public ResponseEntity<Images> getImageById(@PathVariable("id") Long id) {
        Images image = imagesService.findOne(id);
        return new ResponseEntity<>(image, HttpStatus.OK);
    }


    /**
     * POST:<code>/</code>
     *
     * @param image from UI to be persisted to DB
     * @return HttpStatus 201
     */
    @PostMapping("/")
    public ResponseEntity<Images> createImage(@RequestBody Images image) {
        Images upcomingImage = imagesService.save(image);
        return new ResponseEntity<>(upcomingImage, HttpStatus.CREATED);
    }

    /**
     * PUT:<code>/</code>
     *
     * @param image from UI to be updated to DB
     * @return HttpStatus 200
     */
    @PutMapping("/")
    public ResponseEntity<HttpStatus> updateImage(@RequestBody Images image) {
       imagesService.update(image);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * POST:<code>/delete/id</code>
     *
     * @param id of type Long for deleting Product by Id in DB
     * @return HttpStatus 200
     */
    @PostMapping("/delete/{id}")
    public ResponseEntity<HttpStatus> deleteImage(@PathVariable("id") Long id) {
        imagesService.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * POST:<code>/restore/id</code>
     *
     * @param id of type Long for restoring Product by Id in DB
     * @return HttpStatus 200
     */
    @PostMapping("/restore/{id}")
    public ResponseEntity<HttpStatus> restoreImage(@PathVariable("id") Long id) {
       imagesService.restore(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
