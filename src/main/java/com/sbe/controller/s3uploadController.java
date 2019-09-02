package com.sbe.controller;

import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.PutObjectResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;

@RestController
public class s3uploadController {

    @RequestMapping("/")
    String upload(){
        return "upload successfully";
    }

    @RequestMapping("/s3upload")
    String s3upload(){


        String bucketName = "bucket name";

        AWSCredentials credentials = new BasicAWSCredentials(
                "access key id",
                "access secret key"
        );

        AmazonS3 s3client = AmazonS3ClientBuilder
                .standard()
                .withCredentials(new AWSStaticCredentialsProvider(credentials))
                .withRegion(Regions.US_EAST_1)
                .build();


        PutObjectResult putObjectResult =  s3client.putObject(
                bucketName,
                "s3 path where file to store",
                new File("source file location")
        );

        return "s3upload successfully"+putObjectResult.getVersionId();
    }

}
