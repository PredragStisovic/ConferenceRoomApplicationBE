/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.converter;

/**
 *
 * @author predrag
 */
public interface Converter<T, E> {
    T toDto(E e);
    E toEntity(T t);
}

