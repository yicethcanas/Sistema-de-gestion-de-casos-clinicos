package com.universidad.hexagonal.adapters.in.rest;

public class ClinicalExamRequest {

    private String patientId;
    private String patientName;
    private String examType;
    private Double examValue;
    private Double minNormalValue;
    private Double maxNormalValue;

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

    public Double getExamValue() {
        return examValue;
    }

    public void setExamValue(Double examValue) {
        this.examValue = examValue;
    }

    public Double getMinNormalValue() {
        return minNormalValue;
    }

    public void setMinNormalValue(Double minNormalValue) {
        this.minNormalValue = minNormalValue;
    }

    public Double getMaxNormalValue() {
        return maxNormalValue;
    }

    public void setMaxNormalValue(Double maxNormalValue) {
        this.maxNormalValue = maxNormalValue;
    }
}
