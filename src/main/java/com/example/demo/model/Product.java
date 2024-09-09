package com.example.demo.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id")
    private String id;

    @Column(name = "productName") // наименование
    private String productName;

    @Column(name = "protectioNumber") // уровень защиты
    private String protectioNumber;

    @Column(name = "colorfulness") // красочность
    private String colorfulness;

    @Column(name = "format") // формат
    private String format;

    @Column(name = "material") // материал
    private String material;

    @Column(name = "run") // тираж
    private Integer run;

    @Column(name = "characters") // кол-во знаков
    private Integer characters;

    @Column(name = "numeric") // нумерация
    private String numeric;

    @Column(name = "serial") // серия
    private String serial;

    @Column(name = "colorOfNumber") // цвет номера
    private String colorOfNumber;
}
