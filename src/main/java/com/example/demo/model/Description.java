package com.example.demo.model;

import jakarta.persistence.*;
import lombok.*;

import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Data
public class Description {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    @Column(name = "id", updatable = false, nullable = false)
    private String id;

    @Column(name = "userId")
    private String userId;

    @Column(name = "number") // номер тз сверху слева
    private String number;

    @Column(name = "manager") // менеджер
    private String manager;

    @Column(name = "rerun") // повтор тиража
    private String rerun;

    @Column(name = "invoiceagreement") // договор счет
    private String invoiceagreement;

    @Column(name = "customer") // заказчик
    private String customer;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "description_id")
    private List<Product> products;

    @Column(name = "protection") // печатные способы защиты
    private String protection;

    @Column(name = "embossing") // тиснение
    private String embossing;

    @Column(name = "bookOp") // переплетные операции
    private String bookOp;

    @Column(name = "box") // упаковка
    private String box;

    @Column(name = "needHelp") // Необходимо заготовить и закупить
    private String needHelp;

    @Column(name = "addCond") // доп условия
    private String addCond;

    @Column(name = "dateReception") // дата приема заказа
    private Date dateReception;

    @Column(name = "dateOfLayout") // дата сдачи макета
    private Date dateOfLayout;

    @Column(name = "dateRun") // дата сдачи тиража
    private Date dateRun;

    @Column(name = "counter")
    private Integer counter = 0;

}
