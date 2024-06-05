package com.kw.Proj2_spr_2020202060.Service;

import com.kw.Proj2_spr_2020202060.Model.Image;
import com.kw.Proj2_spr_2020202060.Repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public Image saveImage(MultipartFile file, String title, String description) throws IOException {
        Image image = new Image();
        image.setTitle(title);
        image.setDescription(description);
        image.setData(file.getBytes());
        return imageRepository.save(image);
    }

    public List<Image> getAllImages() {
        return imageRepository.findAll();
    }

    public void deleteImage(Long id) {
        imageRepository.deleteById(id);
    }

    public Image updateImage(Long id, String title, String description) {
        Image image = imageRepository.findById(id).orElseThrow(() -> new RuntimeException("Image not found"));
        image.setTitle(title);
        image.setDescription(description);
        return imageRepository.save(image);
    }
}