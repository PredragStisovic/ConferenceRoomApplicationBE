/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.dto;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author predrag
 */
public class FilterSalaDto {
    @NotNull
    private int page;
    
    @NotNull
    private int size;
    
    @Nullable
    private int minimalCapacity;
    
    @Nullable
    private String name;

    public FilterSalaDto() {
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getMinimalCapacity() {
        return minimalCapacity;
    }

    public void setMinimalCapacity(int minimalCapacity) {
        this.minimalCapacity = minimalCapacity;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    
}
