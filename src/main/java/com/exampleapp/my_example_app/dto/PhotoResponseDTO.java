package com.exampleapp.my_example_app.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Builder
public class PhotoResponseDTO {

    private int albumId;
    private int id;
    private String title;
    private String url;
    private String thumbnailUrl;
    private String downloadDateTime;
    private String localPath;
    private int fileSize;
}