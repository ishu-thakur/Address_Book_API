package com.address.book.addressbookapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;
import org.springframework.data.annotation.CreatedDate;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Data
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Customer {

    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "CONTACT_ID")
    private int contactId;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "EMAIL_ADDRESS")
    private String email;
    @Column(name = "CREATED_BY")
    private String createdBy;
    @CreationTimestamp
    @Column(name = "CREATED_DATE" , nullable = false)
    private Date createdDate;
    @Column(name = "UPDATED_BY")
    private String updatedBy;
    @UpdateTimestamp
    @Column(name = "UPDATED_DATE",nullable = false)
    private Date updatedDate;
    @Column(name = "IS_ACTIVE")
    private String isActive;

    @OneToMany(targetEntity = Mobile.class, cascade = CascadeType.ALL)
    @JoinColumn(name = "CONTACT_ID", referencedColumnName = "CONTACT_ID")
    private List<Mobile> mobile_details;


}
