package com.test.springboot.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

// MultipartAutoConfiguration-MultipartProperties
// spring it auto configure StandardServletMultipartResolver [this is file upload resolver]
//  1. request inside use StandardServletMultipartResolver determine (isMultipart)
//     and encapsulated (resolveMultipart, return MultipartHttpServletRequest) file upload request
//  2. argumentResolver to resolve request file content to MultipartFile
//  3. request file content is encapsulated as a map; MultiValueMap<String, MultipartFile>
public class FileTestController {

    // MultipartFile will auto encapsulated uploaded files
    @PostMapping("/upload")
    public void upload(@RequestParam("email") String email, @RequestParam("password") String password,
                       @RequestPart("headerImg")MultipartFile headerImg,@RequestPart("photos") MultipartFile[] photos) throws IOException {

        // save to file server or cloud OSS server or to local disk
        if(!headerImg.isEmpty())
        {
            String originalFilename = headerImg.getOriginalFilename();
            headerImg.transferTo(new File("C:\\Git" + originalFilename));
        }
        if(photos.length > 0)
        {
            for(MultipartFile photo: photos)
            {
                if(!photo.isEmpty())
                {
                    photo.transferTo(new File("C:\\Git" + photo.getOriginalFilename()));
                }
            }
        }
    }
}
