package com.universidad.hexagonal.adapters.in.rest;

import com.universidad.hexagonal.application.ports.in.RegisterClinicalExamUseCase;
import com.universidad.hexagonal.domain.model.ClinicalAlert;
import com.universidad.hexagonal.domain.model.ClinicalExam;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/clinical-exams")
public class ClinicalExamController {

    private final RegisterClinicalExamUseCase registerClinicalExamUseCase;

    public ClinicalExamController(RegisterClinicalExamUseCase registerClinicalExamUseCase) {
        this.registerClinicalExamUseCase = registerClinicalExamUseCase;
    }

    @PostMapping
    public ResponseEntity<?> registerExam(@RequestBody ClinicalExamRequest request) {
        try {
            validateRequiredNumericFields(request);

            ClinicalExam clinicalExam = new ClinicalExam(
                    request.getPatientId(),
                    request.getPatientName(),
                    request.getExamType(),
                    request.getExamValue(),
                    request.getMinNormalValue(),
                    request.getMaxNormalValue()
            );

            ClinicalAlert alert = registerClinicalExamUseCase.registerExam(clinicalExam);

            ClinicalExamResponse response = new ClinicalExamResponse(
                    clinicalExam.getPatientId(),
                    clinicalExam.getPatientName(),
                    clinicalExam.getExamType(),
                    clinicalExam.getExamValue(),
                    alert.isAlertGenerated(),
                    alert.getMessage()
            );

            return ResponseEntity.status(HttpStatus.CREATED).body(response);

        } catch (IllegalArgumentException e) {
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    private void validateRequiredNumericFields(ClinicalExamRequest request) {
        if (request.getExamValue() == null) {
            throw new IllegalArgumentException("El examValue es obligatorio");
        }

        if (request.getMinNormalValue() == null) {
            throw new IllegalArgumentException("El minNormalValue es obligatorio");
        }

        if (request.getMaxNormalValue() == null) {
            throw new IllegalArgumentException("El maxNormalValue es obligatorio");
        }
    }
}
