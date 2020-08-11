package com.avengers.hackathon.architecture;

import com.tngtech.archunit.core.domain.JavaClasses;
import com.tngtech.archunit.core.importer.ClassFileImporter;
import com.tngtech.archunit.core.importer.ImportOption;
import org.junit.BeforeClass;

public abstract class ArchitectureTest {
    static final String DOMAIN_LAYER_PACKAGES = "com.avengers.hackathon.model..";
    static final String SERVICE_LAYER_PACKAGES = "com.avengers.hackathon.service..";
    static final String REPOSITORY_LAYER_PACKAGES = "com.avengers.hackathon.repository..";

    static JavaClasses classes;

    @BeforeClass
    public static void setUp() {
        classes = new ClassFileImporter()
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_TESTS)
                .withImportOption(ImportOption.Predefined.DO_NOT_INCLUDE_ARCHIVES)
                .importPackages("com.avengers.hackathon");
    }
}
