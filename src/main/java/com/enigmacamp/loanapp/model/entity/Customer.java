package com.enigmacamp.loanapp.model.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.SQLDelete;

import java.util.Date;

@Entity
@Table(name = "mst_customer")
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Data

// custom delete
@SQLDelete(sql = "UPDATE mst_customer SET status = true WHERE customer_id = ?")
public class Customer {
    @Id
    @Column(name = "customer_id")
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;
    @Column(name="first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "date_of_birth")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+7")
    private Date dateOfBirth;
    private String phone;
    private boolean status = Boolean.FALSE;

    @OneToOne
    @JoinColumn(name = "user_id")
    private User user;
}
