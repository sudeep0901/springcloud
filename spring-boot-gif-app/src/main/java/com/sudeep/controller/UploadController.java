package com.sudeep.controller;

import java.io.File;
import java.io.IOException;
import java.lang.invoke.MethodHandles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class UploadController {

	private final static Logger log = LoggerFactory.getLogger((MethodHandles.lookup().lookupClass()));

	@Value("${multipart.location}")
	private String location;

	@RequestMapping(value = "/upload", method = RequestMethod.POST, produces = MediaType.IMAGE_GIF_VALUE)
	public String upload(@RequestPart("file") MultipartFile file, @RequestPart("start") int start,
			@RequestPart("end") int end, @RequestPart("speed") int speed, @RequestPart("repeat") boolean repeat) {

		File videoFile = new File(location + "/" + System.currentTimeMillis() + ".mp4");

		log.info("Uploading file in progress ....." + videoFile);

		try {
			file.transferTo(videoFile);
		} catch (IllegalStateException | IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		log.info("File saved to {}", videoFile.getAbsolutePath());
		
		return "";

	}
}
