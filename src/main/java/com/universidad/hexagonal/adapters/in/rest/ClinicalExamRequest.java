package com.universidad.hexagonal.adapters.in.rest;

public class ClinicalExamRequest {

    private String patientId;
    private String patientName;
    private String examType;
    private double examValue;
    private double minNormalValue;
    private double maxNormalValue;

    public ClinicalExamRequest() {
    }

    public String getPatientId() {
        return patientId;
    }

    public void setPatientId(String patientId) {
        this.patientId = patientId;
    }

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getExamType() {
        return examType;
    }

    public void setExamType(String examType) {
        this.examType = examType;
    }

    public double getExamValue() {
        return examValue;
    }

    public void setExamValue(double examValue) {
        this.examValue = examValue;
    }

    public double getMinNormalValue() {
        return minNormalValue;
    }

    public void setMinNormalValue(double minNormalValue) {
        this.minNormalValue = minNormalValue;
    }

    public double getMaxNormalValue() {
        return maxNormalValue;
    }

    public void setMaxNormalValue(double maxNormalValue) {
        this.maxNormalValue = maxNormalValue;
    }
}