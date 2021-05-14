package com.example.demo.repository;

import com.example.demo.model.Acounting;
import org.springframework.data.repository.CrudRepository;



    public interface AcountingRepository extends CrudRepository <Acounting, Integer> {
         Acounting findAcountingByTelnum(int telnum);
    }

