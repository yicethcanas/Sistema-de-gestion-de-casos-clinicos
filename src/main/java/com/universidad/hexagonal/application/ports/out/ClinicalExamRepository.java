package com.universidad.hexagonal.application.ports.out;

import com.universidad.hexagonal.domain.model.ClinicalExam;

public interface ClinicalExamRepository {
    void save(ClinicalExam clinicalExam);
}