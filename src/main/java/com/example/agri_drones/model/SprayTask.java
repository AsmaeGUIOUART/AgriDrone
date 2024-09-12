package com.example.agri_drones.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class SprayTask {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    private Long id;
    private String cropType; // Type de culture (ex : légumes verts)
    private double areaToSpray; // Surface à pulvériser en m²
    private double sprayRadius; // Rayon de pulvérisation en mètres (1,5m)
    private double spacing;// Espacement entre les pulvérisations (1,45m)

    private String areaName;

    // getter and setter
    public String getAreaName() {
        return areaName;
    }

    public void setAreaName(String areaName) {
        this.areaName = areaName;
    }

    // Getters et setters
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCropType() {
        return cropType;
    }

    public void setCropType(String cropType) {
        this.cropType = cropType;
    }

    public double getAreaToSpray() {
        return areaToSpray;
    }

    public void setAreaToSpray(double areaToSpray) {
        this.areaToSpray = areaToSpray;
    }

    public double getSprayRadius() {
        return sprayRadius;
    }

    public void setSprayRadius(double sprayRadius) {
        this.sprayRadius = sprayRadius;
    }

    public double getSpacing() {
        return spacing;
    }

    public void setSpacing(double spacing) {
        this.spacing = spacing;
    }

    public int calculateSprayingPoints(double area, double radius, double spacing) {
        // Calculer le nombre de points de pulvérisation nécessaires pour couvrir la zone
        double diameter = radius * 2;
        int numPoints = (int) Math.ceil(area / (Math.pow(diameter - spacing, 2)));
        return numPoints;
    }

}

