package com.example.agri_drones.controller;

import com.example.agri_drones.model.SprayTask;
import com.example.agri_drones.service.SprayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/spray")
public class SprayController {

    @Autowired
    private SprayService sprayService;

    @PostMapping("/start")
    public String startSpraying(@RequestBody SprayTask sprayTask,
                                @RequestParam double startLat,
                                @RequestParam double startLng,
                                @RequestParam double endLat,
                                @RequestParam double endLng) {
        sprayService.startSpraying(sprayTask, startLat, startLng, endLat, endLng);
        return "Pulvérisation démarrée pour la tâche ID : " + sprayTask.getId();
    }

    @GetMapping("/status/{taskId}")
    public boolean checkSprayingStatus(@PathVariable Long taskId) {
        return sprayService.isSprayingCompleted(taskId);
    }
}
