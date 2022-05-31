package com.tnc.apigatewayas.controller;

import com.tnc.apigatewayas.entity.Adoption;
import com.tnc.apigatewayas.service.interfaces.ImageAnimal;
import com.tnc.apigatewayas.service.interfaces.ImageShelter;
import com.tnc.apigatewayas.service.interfaces.ImageUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class ApiGateway {

    @Resource
    private ImageShelter imageShelter;
    @Resource
    private ImageAnimal imageAnimal;
    @Resource
    private ImageUser imageUser;

    @GetMapping("/shelters")
    public Adoption getShelters() {
        var adoption = new Adoption();
        adoption.setShelter(imageShelter.getShelter());
        return adoption;
    }

    @GetMapping("/animals")
    public Adoption getAnimals() {
        var adoption = new Adoption();
        adoption.setAnimal(imageAnimal.getAnimals());
        return adoption;
    }

    @GetMapping("/users")
    public Adoption getUsers(){
        var adoption = new Adoption();
        adoption.setUser(imageUser.getUsers());
        return adoption;
    }
}
