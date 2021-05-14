package com.example.demo;


import com.example.demo.model.Acounting;
import com.example.demo.repository.AcountingRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertFalse;

//@DataJpaTest
@SpringBootTest
public class JPAUnitTest {



    @Autowired
    AcountingRepository repository;

    @Test
    void contextLoads() {
    }

    @Test
    public void should_find_no_accounting() {
        List<Acounting> accounts = (List<Acounting>) repository.findAll();
        assertThat(accounts).isNotEmpty();
    }


    @Test
    public void getAccountingsByTelnumTest() {
        Acounting foundacounting = repository.findAcountingByTelnum(98632001);

        assertThat(foundacounting.getId()).isEqualTo(9);


    }

    @Test
    @Rollback(true)
    public void creatAccountingTest(){
        Acounting account = new Acounting();
        account.setId(6);
        account.setTelnum(98632001);
        account.setDescription("No Sound");

        Acounting savedAccounting = repository.save(account);

        assertThat(savedAccounting).isNotNull();
    }

    @Test
    public void getAllAccountingTest(){
        List<Acounting> acountings = (List<Acounting>) repository.findAll();

        assertThat(acountings).isNotEmpty();

    }

    @Test
    public void updateAccountingTest(){
        Acounting readAcounting = repository.findAcountingByTelnum(98632001);
        readAcounting.setDescription("NO power");
        repository.save(readAcounting);
        Acounting updateDbAcounting = repository.findAcountingByTelnum(98632001);

        assertThat(updateDbAcounting.getDescription()).isEqualTo("NO power");

    }

    @Test
    public void deleteAccountingTest(){
        repository.deleteById(9);
        Acounting NotExistAfterDelete = repository.findAcountingByTelnum(98632001);

        assertThat(NotExistAfterDelete).isNull();


    }
}