package com.universidad.hexagonal.adapters.out.persistence;

import com.universidad.hexagonal.application.ports.out.ClinicalExamRepository;
import com.universidad.hexagonal.domain.model.ClinicalExam;

import java.util.ArrayList;
import java.util.List;

public class InMemoryClinicalExamRepository implements ClinicalExamRepository {

    private final List<ClinicalExam> storage = new ArrayList<>();

    @Override
    public void save(ClinicalExam clinicalExam) {
        storage.add(clinicalExam);
    }

    public List<ClinicalExam> findAll() {
        return storage;
    }
}