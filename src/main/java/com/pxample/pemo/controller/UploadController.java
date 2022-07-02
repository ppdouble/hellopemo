package com.pxample.pemo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@Controller
public class UploadController {

    Map<String, Object> result = new HashMap<>();

    @RequestMapping("/uploadFile")
    @ResponseBody
    public Map<String, Object> upload(@RequestParam("attach")MultipartFile file) {
        // print file info to console
        System.out.println("file name " + file.getOriginalFilename());
        System.out.println("file type " + file.getContentType());

        String filePath = "/home/ideajavaprj/tmp/";
        try {
            file.transferTo(new File(filePath + file.getOriginalFilename()));
        } catch (IOException e) {
            System.out.println("I got IOException....");
            e.printStackTrace();
        }
        result.put("Success", true);
        return result;
    }
}
