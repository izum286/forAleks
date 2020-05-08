package com.exampleapp.my_example_app.service.interfaces;

import com.exampleapp.my_example_app.dto.FileData;
import com.exampleapp.my_example_app.dto.PhotoResponseDTO;
import com.exampleapp.my_example_app.entity.PhotoEntity;

public interface Mapper {

    PhotoEntity map(FileData from);
    PhotoResponseDTO map(PhotoEntity from);
}
