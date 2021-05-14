package com.example.demo;

import com.example.demo.model.Acounting;
import com.example.demo.repository.AcountingRepository;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.springframework.test.util.AssertionErrors.assertEquals;

//@RunWith(SpringRunner.class)
@SpringBootTest
//@DataJpaTest
class DemoApplicationTests {

    @Autowired
    AcountingRepository repository;

    @Test
    void contextLoads() {
    }

    @Test
    public void should_find_no_acounting() {
        List<Acounting> acounts= (List<Acounting>) repository.findAll();
         assertThat(acounts).isEmpty();
    }
}
