package com.universidad.hexagonal.application.usecase;

import com.universidad.hexagonal.adapters.out.persistence.InMemoryClinicalExamRepository;
import com.universidad.hexagonal.domain.model.ClinicalAlert;
import com.universidad.hexagonal.domain.model.ClinicalExam;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class RegisterClinicalExamUseCaseImplTest {

    private RegisterClinicalExamUseCaseImpl useCase;

    @BeforeEach
    void setUp() {
        useCase = new RegisterClinicalExamUseCaseImpl(new InMemoryClinicalExamRepository());
    }

    @Test
    void shouldGenerateAlertWhenExamValueIsOutOfRange() {
        ClinicalExam exam = new ClinicalExam(
                "P001",
                "Juan Perez",
                "Glucosa",
                150,
                70,
                110
        );

        ClinicalAlert result = useCase.registerExam(exam);

        Assertions.assertTrue(result.isAlertGenerated());
        Assertions.assertEquals("Resultado fuera del rango permitido", result.getMessage());
    }

    @Test
    void shouldNotGenerateAlertWhenExamValueIsWithinRange() {
        ClinicalExam exam = new ClinicalExam(
                "P002",
                "Maria Gomez",
                "Glucosa",
                95,
                70,
                110
        );

        ClinicalAlert result = useCase.registerExam(exam);

        Assertions.assertFalse(result.isAlertGenerated());
        Assertions.assertEquals("Resultado dentro del rango permitido", result.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenPatientIdIsEmpty() {
        ClinicalExam exam = new ClinicalExam(
                "",
                "Carlos Ruiz",
                "Glucosa",
                95,
                70,
                110
        );

        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> useCase.registerExam(exam)
        );

        Assertions.assertEquals("El patientId es obligatorio", exception.getMessage());
    }

    @Test
    void shouldThrowExceptionWhenNormalRangeIsInvalid() {
        ClinicalExam exam = new ClinicalExam(
                "P003",
                "Ana Lopez",
                "Colesterol",
                180,
                200,
                120
        );

        IllegalArgumentException exception = Assertions.assertThrows(
                IllegalArgumentException.class,
                () -> useCase.registerExam(exam)
        );

        Assertions.assertEquals("El rango normal es inválido", exception.getMessage());
    }
}
