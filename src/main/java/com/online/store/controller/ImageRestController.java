package com.online.store.controller;

import com.online.store.entity.Image;
import com.online.store.entity.Product;
import com.online.store.service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Images Rest Controller
 *
 * @author Dmitri Tsornoi
 */

@RestController
@RequestMapping("/api/images")
@CrossOrigin(origins = "*")
public class ImageRestController {

    private final ImageService imageService;

    @Autowired
    public ImageRestController(ImageService imageService) {
        this.imageService = imageService;
    }

    /**
     * GET:<code>/</code>
     * @return List of all images and http status 200
     */
    @GetMapping("/")
    public ResponseEntity<List<Image>> getAll(){
        List<Image> images = imageService.getAll();

        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    /**
     * GET:<code>/product-filter</code>
     * @param product the current selected product
     * @return List of Images for current product
     */
    @GetMapping("/product-filter")
    public ResponseEntity<List<Image>> getAllForCurrentProduct(@RequestBody Product product){
        List<Image> images = imageService.getAllForCurrentProduct(product);

        return new ResponseEntity<>(images, HttpStatus.OK);
    }

    /**
     * GET:<code>/id</code>
     * @param id of image to be found
     * @return image with specified ID and http status 200
     */
    @GetMapping("/{id}")
    public ResponseEntity<Image> getOneImage(@PathVariable("id") Long id){
        return new ResponseEntity<>(imageService.getOne(id),HttpStatus.OK);
    }

    /**
     * POST:<code>/</code>
     * @param image to be persisted into DB
     * @return http status of 201
     */
    @PostMapping("/")
    public ResponseEntity<HttpStatus> saveImage(@RequestBody Image image){
        imageService.save(image);

        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    /**
     * PUT:<code>/</code>
     * @param image to be updated
     * @return Http status of 200
     */
    @PutMapping("/")
    public ResponseEntity<HttpStatus> update(@RequestBody Image image){
        imageService.update(image);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * POST:<code>/delete</code>
     * @param image to be set inActive
     * @return http status of ok
     */
    @PostMapping("/delete")
    public ResponseEntity<HttpStatus> delete(@RequestBody Image image){
        imageService.delete(image);

        return new ResponseEntity<>(HttpStatus.OK);
    }

    /**
     * POST:<code>/restore</code>
     * @param image to be set Active
     * @return http status of 200
     */
    @PostMapping("/restore")
    public ResponseEntity<HttpStatus> restore(@RequestBody Image image){
        imageService.restore(image);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
