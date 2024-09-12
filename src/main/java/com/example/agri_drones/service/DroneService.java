package com.example.agri_drones.service;


import com.example.agri_drones.controller.exception.ResourceNotFoundException;
import com.example.agri_drones.model.Drone;
import com.example.agri_drones.repository.DroneRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

@Service
public class DroneService {

    @Autowired
    private DroneRepository droneRepository;
    private static final Logger log = LoggerFactory.getLogger(DroneService.class);

    public List<Drone> getAllDrones() {
        return droneRepository.findAll();
    }

    public Drone getDroneById(Long id) {
        return droneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Drone not found with id: " + id));
    }

    public List<Drone> saveall(List<Drone> drones) {
        try {
            return droneRepository.saveAll(drones);
        } catch (Exception e) {
            log.error("Erreur lors de l'enregistrement des drones: ", e);
            throw e;
        }
    }

    public Drone updateDrone(Long id, Drone droneDetails) {
        Drone drone = droneRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Drone not found with id: " + id));

        drone.setModel(droneDetails.getModel());
        drone.setStatus(droneDetails.getStatus());
        drone.setLocation(droneDetails.getLocation());
        drone.setAutonomy(droneDetails.getAutonomy());
        drone.setCapacity(droneDetails.getCapacity());
        drone.setSensors(droneDetails.getSensors());

        return droneRepository.save(drone);
    }

    public void deleteDrone(Long id) {
        Drone drone = droneRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Drone with ID " + id + " not found."));
        droneRepository.deleteById(id);
    }



}

