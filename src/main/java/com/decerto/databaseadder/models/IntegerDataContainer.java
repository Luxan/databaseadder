package com.decerto.databaseadder.models;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table
public class IntegerDataContainer {

    @Id
    private Integer data;

    IntegerDataContainer() {}

    public IntegerDataContainer(Integer data) {
        this.data = data;
    }

    public Integer getData() {
        return data;
    }

    public void setData(Integer data) {
        this.data = data;
    }
}
