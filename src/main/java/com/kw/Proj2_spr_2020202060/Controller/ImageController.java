package com.kw.Proj2_spr_2020202060.Controller;


import com.kw.Proj2_spr_2020202060.Model.Image;
import com.kw.Proj2_spr_2020202060.Service.ImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/api/images")
public class ImageController {

    @Autowired
    private ImageService imageService;

    @PostMapping("/test")
    public ResponseEntity<Image> uploadImage(
            @RequestParam("id") String str) throws IOException {
        System.out.print(str);

        return ResponseEntity.ok(imageService.saveImage(str));
    }

   /* @PostMapping("/upload")
    public ResponseEntity<Image> uploadImage(
            @RequestParam("file") MultipartFile file,
            @RequestParam("title") String title,
            @RequestParam("description") String description) throws IOException {
        System.out.print("PostMapping");
        return ResponseEntity.ok(imageService.saveImage(file, title, description));
    }*/

   /* @GetMapping
    public ResponseEntity<List<Image>> getAllImages() {

        System.out.print("GetMapping");
        return ResponseEntity.ok(imageService.getAllImages());

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteImage(@PathVariable Long id) {
        System.out.print("DeleteMapping");
        imageService.deleteImage(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Image> updateImage(
            @PathVariable Long id,
            @RequestParam("title") String title,
            @RequestParam("description") String description) {
        System.out.print("PutMapping");
        return ResponseEntity.ok(imageService.updateImage(id, title, description));
    }*/
}