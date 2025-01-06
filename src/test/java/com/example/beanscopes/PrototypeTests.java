package com.example.beanscopes;

import com.example.beanscopes.config.ScopesConfig;
import com.example.beanscopes.dto.Person;
import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.AbstractApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class PrototypeTests {

    private static final String NAME = "John Smith";
    private static final String NAME_OTHER = "Anna Jones";

    @Test
    public void givenPrototypeScope_whenSetNames_thenDifferentNames() {
        final ApplicationContext applicationContext = new AnnotationConfigApplicationContext(ScopesConfig.class);

        Person personPrototypeA = (Person) applicationContext.getBean("personPrototype");
        Person personPrototypeB = (Person) applicationContext.getBean("personPrototype");

        personPrototypeA.setName(NAME);
        personPrototypeB.setName(NAME_OTHER);

        assertEquals(NAME, personPrototypeA.getName());
        assertEquals(NAME_OTHER, personPrototypeB.getName());

        ((AbstractApplicationContext) applicationContext).close();
    }
}