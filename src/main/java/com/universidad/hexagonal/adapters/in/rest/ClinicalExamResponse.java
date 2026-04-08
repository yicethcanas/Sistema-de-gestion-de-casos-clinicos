package com.universidad.hexagonal.adapters.in.rest;

public class ClinicalExamResponse {

    private String patientId;
    private String patientName;
    private String examType;
    private double examValue;
    private boolean alertGenerated;
    private String alertMessage;

    public ClinicalExamResponse(String patientId, String patientName, String examType,
                                double examValue, boolean alertGenerated, String alertMessage) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.examType = examType;
        this.examValue = examValue;
        this.alertGenerated = alertGenerated;
        this.alertMessage = alertMessage;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public String getExamType() {
        return examType;
    }

    public double getExamValue() {
        return examValue;
    }

    public boolean isAlertGenerated() {
        return alertGenerated;
    }

    public String getAlertMessage() {
        return alertMessage;
    }
}