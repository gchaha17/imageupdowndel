package com.example.getmesocialservice.service;

import com.amazonaws.AmazonServiceException;
import com.amazonaws.auth.AWSStaticCredentialsProvider;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.regions.Regions;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3ClientBuilder;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class FileService {


    public boolean upload(MultipartFile file) {
        BasicAWSCredentials crd=new BasicAWSCredentials("AKIATE6MLPUMM7D6E7NL","AXPalxUCQ01bvdsXT4QlRixd0tFtKBHRmDgIF5Qm");
        final AmazonS3 s3= AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(crd)).withRegion(Regions.US_WEST_2).build();
        try {
            ObjectMetadata o1=new ObjectMetadata();
            o1.setContentLength(file.getSize());
o1.setContentType(file.getContentType());




            s3.putObject("backend-spring222",file.getOriginalFilename(),file.getInputStream(),o1);

            return true;
        }

catch(AmazonServiceException | IOException e)
{

    return false;
}



    }

    public S3Object getFile(String key)
    {
        BasicAWSCredentials crd=new BasicAWSCredentials("AKIATE6MLPUMM7D6E7NL","AXPalxUCQ01bvdsXT4QlRixd0tFtKBHRmDgIF5Qm");
        final AmazonS3 s3= AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(crd)).withRegion(Regions.US_WEST_2).build();
      return s3.getObject("backend-spring222",key);
    }

    public void deleteFile(String key)
    {
        BasicAWSCredentials crd=new BasicAWSCredentials("AKIATE6MLPUMM7D6E7NL","AXPalxUCQ01bvdsXT4QlRixd0tFtKBHRmDgIF5Qm");
        final AmazonS3 s3= AmazonS3ClientBuilder.standard().withCredentials(new AWSStaticCredentialsProvider(crd)).withRegion(Regions.US_WEST_2).build();
        s3.deleteObject("backend-spring222",key);
    }
}
