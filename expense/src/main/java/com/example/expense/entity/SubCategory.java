package com.example.expense.entity;

import jakarta.persistence.*;

@Entity
@Table(name  = "sub_category")
public class SubCategory {

    @Column(name = "sub_category_id")
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "sub_category_name")
    private String name;

    @Column(name = "sub_category_type")
    private String type;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private Category category;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
