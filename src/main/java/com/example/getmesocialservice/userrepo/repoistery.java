package com.example.getmesocialservice.userrepo;

import com.example.getmesocialservice.model.Album;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface repoistery extends MongoRepository<Album, String> {

    List<Album> findAllByName(String name);
}
