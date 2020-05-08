package com.exampleapp.my_example_app.controller;

import com.exampleapp.my_example_app.controller.interfaces.PhotoController;
import com.exampleapp.my_example_app.dto.FileData;
import com.exampleapp.my_example_app.dto.PhotoResponseDTO;
import com.exampleapp.my_example_app.service.interfaces.PhotoService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.http.CacheControl;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("photo")
public class PhotoControllerImpl implements PhotoController {

    @Autowired
    PhotoService photoService;

    @Autowired
    ObjectMapper objectMapper;

    @Value("${data.url}")
    String url;

    @Override
    @PostMapping("init")
    public List<PhotoResponseDTO> init() {
        try {
            List<FileData> list = Arrays.asList(objectMapper.readValue(
                    new URL(url), FileData[].class));
            return photoService.init(list);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return new ArrayList<>();
    }

    @Override
    @GetMapping("all")
    public List<PhotoResponseDTO> getAllPhotos() {
        return photoService.getAllPhotos();
    }

    @Override
    @GetMapping("all/{albumId}")
    public List<PhotoResponseDTO> getAllPhotosFromAlbum(@PathVariable("albumId") int album) {
        return photoService.getAllPhotosFromAlbum(album);
    }

    //TODO check
    @Override
    @GetMapping("download")
    public ResponseEntity<ByteArrayResource> getPhoto(@RequestParam("path") String path) throws FileNotFoundException {
        ByteArrayResource imageByteArr = photoService.getPhoto(path);
        return ResponseEntity
                .ok()
                .header(CacheControl.noCache().getHeaderValue())
                .contentType(MediaType.IMAGE_JPEG)
                .contentLength(imageByteArr.contentLength())
                .body(imageByteArr);
    }
}
