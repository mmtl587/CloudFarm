package com.example.CloudFarm.enity;

import jakarta.persistence.*;

import java.util.Objects;

@Entity
@Table(name = "store_comment", schema = "cloud_farm", catalog = "")
public class StoreComment {
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Id
    @Column(name = "id")
    private int id;
    @Basic
    @Column(name = "customer_id")
    private int customerId;
    @Basic
    @Column(name = "store_id")
    private int storeId;
    @Basic
    @Column(name = "content")
    private String content;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public int getStoreId() {
        return storeId;
    }

    public void setStoreId(int storeId) {
        this.storeId = storeId;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        StoreComment that = (StoreComment) o;
        return id == that.id && customerId == that.customerId && storeId == that.storeId && Objects.equals(content, that.content);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, storeId, content);
    }
}
