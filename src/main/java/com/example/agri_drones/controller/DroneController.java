package com.example.agri_drones.controller;

import com.example.agri_drones.model.Drone;
import com.example.agri_drones.service.DroneService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/drones")
public class DroneController {

    @Autowired
    private DroneService droneService;

    private static final Logger log = LoggerFactory.getLogger(DroneService.class);

    @GetMapping
    public List<Drone> getAllDrones() {
        return droneService.getAllDrones();
    }

    @GetMapping("/{id}")
    public Drone getDroneById(@PathVariable Long id) {
        return droneService.getDroneById(id);
    }


    @PostMapping
    public List<Drone> createDrones(@RequestBody @Valid List<Drone> drones) {
        log.debug("Données reçues: " + drones.toString());
        return droneService.saveall(drones);
    }


    @PutMapping("/{id}")
    public Drone updateDrone(@PathVariable Long id, @RequestBody Drone droneDetails) {
        return droneService.updateDrone(id, droneDetails);
    }

    @DeleteMapping("/{id}")
    public void deleteDrone(@PathVariable Long id) {
        droneService.deleteDrone(id);
    }


}

