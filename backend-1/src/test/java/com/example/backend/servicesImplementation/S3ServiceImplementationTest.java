package com.example.backend.servicesImplementation;



import java.io.File;
import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

import com.amazonaws.services.s3.AmazonS3;

@SpringBootTest
public class S3ServiceImplementationTest {
	
	
	@Mock
	AmazonS3 s3;
	
	
	@InjectMocks
	S3ServiceImplementation s3Implementation;
	
	@Test
	public void test_saveFile() throws IOException {
		
		
//		//mocking multipart file
////		MockMultipartFile file 
////	      = new (
////	        "file", 
////	        "hello.txt", 
////	        MediaType.TEXT_PLAIN_VALUE, 
////	        "Hello, World!".getBytes()
////	      );
//		
//		
//		MultipartFile file = new MockMultipartFile("file", 
//	        "hello.txt", 
//	        MediaType.TEXT_PLAIN_VALUE, 
//        "Hello, World!".getBytes());
//		
//		File file1 = File.createTempFile("test", ".txt");
//		
//		
//		
		
		
	}

}
