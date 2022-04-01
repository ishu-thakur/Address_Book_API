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
//************************************OLD***************************************
//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "CONTACT_ID")
//    private int contactId;
//    @Column(name = "FIRST_NAME")
//    private String firstName;
//    @Column(name = "LAST_NAME")
//    private String lastName;
//    @Column(name = "EMAIL_ADDRESS")
//    private String emailAddress;
//    @Column(name = "CREATED_BY")
//    private String createdBy;
//    @CreationTimestamp
//    @Column(name = "CREATED_DATE" , nullable = false)
//    private Date createdDate;
//    @Column(name = "UPDATED_BY")
//    private String updatedBy;
//    @UpdateTimestamp
//    @Column(name = "UPDATED_DATE",nullable = false)
//    private Date updatedDate;
//    @Column(name = "IS_ACTIVE")
//    private String isActive;
//
//    @OneToMany(targetEntity = Mobile.class, cascade = CascadeType.ALL)
//    @JoinColumn(name = "CONTACT_ID", referencedColumnName = "CONTACT_ID")
//    private List<Mobile> mobile_details;

//************************************for running the external apis***************************************
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "contact_id", nullable = false)
    private Long contactId;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "email_address")
    private String emailAddress;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_Date")
    @CreatedDate
    private Date createdDate;

    @Column(name = "updated_By")
    private String updatedBy;

    @Column(name = "updated_Date")
    @UpdateTimestamp
    private Date updatedDate;

    @Column(name = "is_active")
    private String isActive;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id", referencedColumnName = "contact_id")
    private List<Mobile> mobileEntities;

}
