package com.example.nicecoding.account.model;

import com.example.nicecoding.parameter.model.Client;
import com.example.nicecoding.parameter.model.Contact;
import com.example.nicecoding.parameter.model.Supplier;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.format.annotation.DateTimeFormat;
import java.util.Date;

@Entity
@Data
@EqualsAndHashCode(callSuper=false)
@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
@Table(name = "Transaction")
public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String amount;
    private String purpose;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date transactionDate;

    @ManyToOne
    @JoinColumn(name="contactid", insertable=false, updatable=false)
    private Contact contact;
    private Integer contactid;

    @ManyToOne
    @JoinColumn(name="supplierid", insertable=false, updatable=false)
    private Supplier supplier;
    private Integer supplierid;

    @ManyToOne
    @JoinColumn(name="clientid", insertable=false, updatable=false)
    private Client client;
    private Integer clientid;

    private String remarks;

}
