package com.universidad.hexagonal.application.ports.in;

import com.universidad.hexagonal.domain.model.ClinicalAlert;
import com.universidad.hexagonal.domain.model.ClinicalExam;

public interface RegisterClinicalExamUseCase {
    ClinicalAlert registerExam(ClinicalExam clinicalExam);
}