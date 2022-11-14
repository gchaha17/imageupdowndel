package com.example.getmesocialservice.service;


import com.example.getmesocialservice.model.Album;
import com.example.getmesocialservice.userrepo.repoistery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {
    @Autowired
    private repoistery u3;

    public Album saveAlbum(Album al) {
        return u3.save(al);
    }
    public List<Album> getAllAlbum() {
        return  u3.findAll();
    }
    public Album updateAlbum(Album al) {
        return u3.save(al);
    }
    public void deleteAlbum(String albumId) {
       u3.deleteById(albumId);
    }


    public List<Album> getalbumByName(String name) {
        return u3.findAllByName(name);
    }

    public Album getalbumById(String albumId) {
       return u3.findById(albumId).get();
    }

/*
    public Album getAlbum() {
        return u3.getAlbum();
    }


 public Album getalbumbyId(int albumId) {
        return u3.getalbumbyId(albumId);
    }




    */

}