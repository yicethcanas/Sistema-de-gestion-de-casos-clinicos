package com.universidad.hexagonal.domain.model;

public class ClinicalExam {

    private String patientId;
    private String patientName;
    private String examType;
    private double examValue;
    private double minNormalValue;
    private double maxNormalValue;

    public ClinicalExam(String patientId, String patientName, String examType, double examValue, double minNormalValue, double maxNormalValue) {
        this.patientId = patientId;
        this.patientName = patientName;
        this.examType = examType;
        this.examValue = examValue;
        this.minNormalValue = minNormalValue;
        this.maxNormalValue = maxNormalValue;
    }

    public boolean isOutOfRange() {
        return examValue < minNormalValue || examValue > maxNormalValue;
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

    public double getMinNormalValue() {
        return minNormalValue;
    }

    public double getMaxNormalValue() {
        return maxNormalValue;
    }
}