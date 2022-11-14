package com.example.getmesocialservice.resource;


import com.example.getmesocialservice.exception.RestrictedInfo;
import com.example.getmesocialservice.model.Album;
import com.example.getmesocialservice.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api/albums")
public class UserResource {



    @Autowired
    private UserService u2;
    @PostMapping
    public Album saveAlbum(@RequestBody @Valid Album al)
    {

        return u2.saveAlbum(al);

    }
    @GetMapping
    public List<Album> getAllAlbum() {
        return u2.getAllAlbum();

    }
    @PutMapping
    public Album updateAlbum(@RequestBody Album al)
    {

        return u2.updateAlbum(al);
    }
    @DeleteMapping
    public void deleteAlbum(@RequestParam(name="albumId") String albumId)
    {
        u2.deleteAlbum(albumId);

    }
    @GetMapping("/find")
    public List<Album> getalbumByName(@RequestParam (name="name") String name) throws RestrictedInfo {
        if (name.equalsIgnoreCase("ram")) {
            throw new RestrictedInfo();



        }
        return u2.getalbumByName(name);
    }

    @GetMapping("/find1")
    public Album getalbumById(@RequestParam (name="albumId") String albumId)
    {

        return u2.getalbumById(albumId);



    }













    }