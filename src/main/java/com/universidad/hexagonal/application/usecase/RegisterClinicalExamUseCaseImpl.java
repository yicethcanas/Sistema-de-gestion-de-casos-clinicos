package com.universidad.hexagonal.application.usecase;

import com.universidad.hexagonal.application.ports.in.RegisterClinicalExamUseCase;
import com.universidad.hexagonal.application.ports.out.ClinicalExamRepository;
import com.universidad.hexagonal.domain.model.ClinicalAlert;
import com.universidad.hexagonal.domain.model.ClinicalExam;

public class RegisterClinicalExamUseCaseImpl implements RegisterClinicalExamUseCase {

    private final ClinicalExamRepository clinicalExamRepository;

    public RegisterClinicalExamUseCaseImpl(ClinicalExamRepository clinicalExamRepository) {
        this.clinicalExamRepository = clinicalExamRepository;
    }

    @Override
    public ClinicalAlert registerExam(ClinicalExam clinicalExam) {
        validateBusinessRules(clinicalExam);

        clinicalExamRepository.save(clinicalExam);

        if (clinicalExam.isOutOfRange()) {
            return new ClinicalAlert(true, "Resultado fuera del rango permitido");
        }

        return new ClinicalAlert(false, "Resultado dentro del rango permitido");
    }

    private void validateBusinessRules(ClinicalExam clinicalExam) {
        if (clinicalExam.getPatientId() == null || clinicalExam.getPatientId().isBlank()) {
            throw new IllegalArgumentException("El patientId es obligatorio");
        }

        if (clinicalExam.getPatientName() == null || clinicalExam.getPatientName().isBlank()) {
            throw new IllegalArgumentException("El patientName es obligatorio");
        }

        if (clinicalExam.getExamType() == null || clinicalExam.getExamType().isBlank()) {
            throw new IllegalArgumentException("El examType es obligatorio");
        }

        if (clinicalExam.getMinNormalValue() > clinicalExam.getMaxNormalValue()) {
            throw new IllegalArgumentException("El rango normal es inválido");
        }
    }
}