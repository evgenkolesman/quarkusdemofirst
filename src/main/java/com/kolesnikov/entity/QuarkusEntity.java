package com.kolesnikov.entity;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;

import java.util.UUID;

@Entity(name = "quark_table")
public class QuarkusEntity extends PanacheEntity {
    @Id
    @GeneratedValue
    private UUID id;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public QuarkusEntity name(String name) {
        this.name = name;
        return this;
    }

    @Column(name = "name")
    String name;

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getId() {
        return id;
    }
}
