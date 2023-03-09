package com.example.CloudFarm.enity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
public class Carousel {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "image")
    private String image;
    @Basic
    @Column(name = "target_type")
    private byte targetType;
    @Basic
    @Column(name = "target_id")
    private int targetId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public byte getTargetType() {
        return targetType;
    }

    public void setTargetType(byte targetType) {
        this.targetType = targetType;
    }

    public int getTargetId() {
        return targetId;
    }

    public void setTargetId(int targetId) {
        this.targetId = targetId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Carousel carousel = (Carousel) o;
        return id == carousel.id && targetType == carousel.targetType && targetId == carousel.targetId && Objects.equals(image, carousel.image);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, image, targetType, targetId);
    }
}
