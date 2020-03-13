package com.exampleapp.my_example_app.repository.interfaces;

import com.exampleapp.my_example_app.entity.PhotoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.Repository;

import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.List;

public interface PhotoRepositoryJPA  {
    /**
     * Method added new PhotoEntities to our data base and save new pictures from object link to pic in local folder /src/pictures
     * in folder with name of album number.
     *
     * Response is List of All PhotoEntities
     * Url photos/init
     *
     * @param list List of PhoneEntities
     * @author AleksGor
     */
    List<PhotoEntity> init(List<PhotoEntity> list);

    /**
     * Method get PhotoEntities by album number
     *
     * Response is byteArray of current picture
     * Url photos/init
     *
     * @param path local Path of pictures. We can look him from request getAllPhotos
     * @author AleksGor
     */
    byte[] getPhoto(Path path) throws FileNotFoundException;

}
