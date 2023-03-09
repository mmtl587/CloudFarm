package com.example.CloudFarm.enity;

import jakarta.persistence.*;

import java.sql.Timestamp;
import java.util.Objects;

@Entity
public class Store {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "farmer_id")
    private Integer farmerId;
    @Basic
    @Column(name = "name")
    private String name;
    @Basic
    @Column(name = "logo")
    private String logo;
    @Basic
    @Column(name = "description")
    private String description;
    @Basic
    @Column(name = "create_time")
    private Timestamp createTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getFarmerId() {
        return farmerId;
    }

    public void setFarmerId(Integer farmerId) {
        this.farmerId = farmerId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Timestamp getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Timestamp createTime) {
        this.createTime = createTime;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Store store = (Store) o;
        return id == store.id && Objects.equals(farmerId, store.farmerId) && Objects.equals(name, store.name) && Objects.equals(logo, store.logo) && Objects.equals(description, store.description) && Objects.equals(createTime, store.createTime);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, farmerId, name, logo, description, createTime);
    }
}
