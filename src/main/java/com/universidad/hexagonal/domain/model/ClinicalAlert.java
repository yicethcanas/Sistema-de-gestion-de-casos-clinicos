package com.universidad.hexagonal.domain.model;

public class ClinicalAlert {

    private boolean alertGenerated;
    private String message;

    public ClinicalAlert(boolean alertGenerated, String message) {
        this.alertGenerated = alertGenerated;
        this.message = message;
    }

    public boolean isAlertGenerated() {
        return alertGenerated;
    }

    public String getMessage() {
        return message;
    }
}