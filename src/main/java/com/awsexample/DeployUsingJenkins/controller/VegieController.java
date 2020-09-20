package com.awsexample.DeployUsingJenkins.controller;

import com.awsexample.DeployUsingJenkins.model.VegieModel;
import com.awsexample.DeployUsingJenkins.repository.VegieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.validation.Valid;

@RestController
public class VegieController {

    @Autowired
    private VegieRepository vegieRepository;

    @GetMapping("/allVegies")
    public Iterable<VegieModel> getAllVegies() {
        return vegieRepository.findAll();
    }

    @GetMapping("/vegie/{id}")
    public VegieModel getVegieInfo(@PathVariable long id) {
        return vegieRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, String.format("Invalid id " + id)));
    }

    @PostMapping("/saveVegie")
    public VegieModel saveVegie(@Valid @RequestBody VegieModel vegieModel) {
        return vegieRepository.save(vegieModel);
    }
}
