package com.exampleapp.my_example_app.repository;

import com.exampleapp.my_example_app.dto.FileData;
import com.exampleapp.my_example_app.dto.PhotoResponseDTO;
import com.exampleapp.my_example_app.entity.PhotoEntity;
import com.exampleapp.my_example_app.repository.interfaces.PhotoRepository;
import com.exampleapp.my_example_app.service.interfaces.Mapper;
import com.exampleapp.my_example_app.service.interfaces.PhotoService;
import org.junit.After;
import org.junit.Before;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentMatchers;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

@RunWith(SpringRunner.class)
@SpringBootTest
class PhotoRepositoryImplTest {

    @MockBean
    PhotoRepository repository;

    @Autowired
    PhotoService service;

    @Autowired
    Mapper mapper;

    private FileData fileData;
    private FileData fileData2;
    private List<FileData> checkListDto;
    private List<PhotoEntity> listFromRepository;

    @Test
    void init() {
        initialization();

        Mockito.doReturn(listFromRepository).when(repository).init(ArgumentMatchers.any());
        List<PhotoResponseDTO> responseDTOS = service.init(checkListDto);
        assertNotNull(responseDTOS);
        assertNotNull(responseDTOS.get(0));

    }

    @Test
    void initWithNull(){
        initialization();

        Mockito.doThrow(NullPointerException.class).when(repository).init(null);
        assertThrows(NullPointerException.class,()->service.init(null));

    }

    @Test
    void getAllPhotos() {
        initialization();

        Mockito.doReturn(listFromRepository).when(repository).findAll();
        List<PhotoResponseDTO> responseDTOS = service.getAllPhotos();
        assertNotNull(responseDTOS);
        assertNotNull(responseDTOS.get(0));

    }

    @Test
    void getAllPhotosFromAlbum() {
        initialization();

        Mockito.doReturn(listFromRepository).when(repository).findPhotoEntitiesByAlbumId(1);
        List<PhotoResponseDTO> responseDTOS = service.getAllPhotos();
        assertNotNull(responseDTOS);

    }

    @Test
    void getAllPhotosFromAlbumWithNotExistsAlbum() {
        initialization();

        Mockito.doThrow(NullPointerException.class).when(repository).findPhotoEntitiesByAlbumId(5);
        assertThrows(NullPointerException.class,()->service.init(null));

    }

    @Before
    void initialization(){
        fileData = new FileData(1,
                1,
                "SomeTitle",
                "https://s3.amazonaws.com/shielddevtest/photo1.jfif",
                "https://s3.amazonaws.com/shielddevtest/photo1.jfif");
        fileData2 = new FileData(2,
                2,
                "SomeTitle",
                "https://s3.amazonaws.com/shielddevtest/photo2.jpg",
                "https://s3.amazonaws.com/shielddevtest/photo2.jpg");
        checkListDto = new ArrayList<>();
        checkListDto.add(fileData);
        checkListDto.add(fileData2);
        listFromRepository = new ArrayList<>();
        listFromRepository.add(mapper.map(fileData));
        listFromRepository.add(mapper.map(fileData2));
    }

    @After
    void afterTest(){
        fileData = null;
        fileData2 = null;
        checkListDto = null;
    }
}