package com.avengers.hackathon.architecture;

import com.tngtech.archunit.lang.ArchRule;
import com.tngtech.archunit.lang.syntax.ArchRuleDefinition;
import org.junit.Test;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.Entity;

public class ApplicationComponentsTest extends ArchitectureTest {

    @Test
    public void serviceClassesShouldBeAnnotatedWithServiceAnnotation() {
        ArchRule rule = ArchRuleDefinition.classes()
                .that().haveSimpleNameEndingWith("Service")
                .should().beAnnotatedWith(Service.class);
        rule.check(classes);
    }

    @Test
    public void noServiceClassesShouldResideOutsideTheServiceLayer() {
        ArchRule rule = ArchRuleDefinition.noClasses()
                .that().haveSimpleNameEndingWith("Service")
                .should().resideOutsideOfPackage(SERVICE_LAYER_PACKAGES);
        rule.check(classes);
    }

    @Test
    public void noClassesWithServiceAnnotationShouldResideOutsideTheServiceLayer() {
        ArchRule rule = ArchRuleDefinition.noClasses()
                .that().areAnnotatedWith(Service.class)
                .should().resideOutsideOfPackage(SERVICE_LAYER_PACKAGES);
        rule.check(classes);
    }

    @Test
    public void noClassesWithRepositoryAnnotationShouldResideOutsideTheRepositoryLayer() {
        ArchRule rule = ArchRuleDefinition.noClasses()
                .that().areAnnotatedWith(Repository.class)
                .should().resideOutsideOfPackage(REPOSITORY_LAYER_PACKAGES);
        rule.check(classes);
    }

    @Test
    public void noClassesWithEntityAnnotationShouldResideOutsideTheModelLayer() {
        ArchRule rule = ArchRuleDefinition.noClasses()
                .that().areAnnotatedWith(Entity.class)
                .should().resideOutsideOfPackage(DOMAIN_LAYER_PACKAGES);
        rule.check(classes);
    }

    @Test
    public void noEntityShouldDependOnRepository() {
        ArchRule rule = ArchRuleDefinition.noClasses()
                .that().areAnnotatedWith(Entity.class)
                .should().dependOnClassesThat().areAnnotatedWith(Repository.class);
        rule.check(classes);
    }

    @Test
    public void noServiceShouldDependOnRestController() {
        ArchRule rule = ArchRuleDefinition.noClasses()
                .that().areAnnotatedWith(Service.class)
                .should().dependOnClassesThat().areAnnotatedWith(RestController.class);
        rule.check(classes);
    }

    @Test
    public void noRepositoryShouldDependOnService() {
        ArchRule rule = ArchRuleDefinition.noClasses()
                .that().areAnnotatedWith(Repository.class)
                .should().dependOnClassesThat().areAnnotatedWith(Service.class);
        rule.check(classes);
    }

}
