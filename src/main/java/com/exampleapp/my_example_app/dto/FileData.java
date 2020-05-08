package com.exampleapp.my_example_app.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@Getter
@AllArgsConstructor
@NoArgsConstructor
public class FileData {

    private int albumId;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;


}
