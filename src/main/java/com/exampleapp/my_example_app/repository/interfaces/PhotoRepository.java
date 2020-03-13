package com.exampleapp.my_example_app.repository.interfaces;

import com.exampleapp.my_example_app.entity.PhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.List;

public interface PhotoRepository extends JpaRepository<PhotoEntity, Integer>, PhotoRepositoryJPA {
    List<PhotoEntity> findPhotoEntitiesByAlbumId(int albumId);
}
