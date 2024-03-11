package com.kolesnikov.repository;

import com.kolesnikov.entity.QuarkusEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.RequestScoped;

@RequestScoped
public class QRepository implements PanacheRepository<QuarkusEntity> {



    public void save(QuarkusEntity quarkus) {


    }
}
