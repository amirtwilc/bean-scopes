package com.example.beanscopes;

import com.example.beanscopes.config.ScopesConfig;
import com.example.beanscopes.dto.Person;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class SingletonTests {

    private static final String NAME = "John Smith";

    @Test
    public void givenSingletonScope_whenSetName_thenEqualNames() {
        final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScopesConfig.class);

        final Person personSingletonA = (Person) applicationContext.getBean("personSingleton");
        final Person personSingletonB = (Person) applicationContext.getBean("personSingleton");

        personSingletonA.setName(NAME);
        assertEquals(NAME, personSingletonB.getName());

        ((AbstractApplicationContext) applicationContext).close();
    }
}