package com.universidad.hexagonal.config;

import com.universidad.hexagonal.adapters.out.persistence.InMemoryClinicalExamRepository;
import com.universidad.hexagonal.application.ports.in.RegisterClinicalExamUseCase;
import com.universidad.hexagonal.application.ports.out.ClinicalExamRepository;
import com.universidad.hexagonal.application.usecase.RegisterClinicalExamUseCaseImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ClinicalExamConfig {

    @Bean
    public ClinicalExamRepository clinicalExamRepository() {
        return new InMemoryClinicalExamRepository();
    }

    @Bean
    public RegisterClinicalExamUseCase registerClinicalExamUseCase(ClinicalExamRepository repository) {
        return new RegisterClinicalExamUseCaseImpl(repository);
    }
}