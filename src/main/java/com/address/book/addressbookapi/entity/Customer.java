package com.address.book.addressbookapi.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id", nullable = false)
    private Integer contactId;

    @NotBlank(message = "First Name cannot be empty")
    @Column(name = "first_name")
    private String firstName;

    @NotBlank(message = "Last Name cannot be empty")
    @Column(name = "last_name")
    private String lastName;

    @Email(message = "email is not valid", regexp = "(?:[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*|\"(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21\\x23-\\x5b\\x5d-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])*\")@(?:(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?|\\[(?:(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?)\\.){3}(?:25[0-5]|2[0-4][0-9]|[01]?[0-9][0-9]?|[a-z0-9-]*[a-z0-9]:(?:[\\x01-\\x08\\x0b\\x0c\\x0e-\\x1f\\x21-\\x5a\\x53-\\x7f]|\\\\[\\x01-\\x09\\x0b\\x0c\\x0e-\\x7f])+)\\])")
    @NotEmpty(message = "email cannot be empty")
    @Column(name = "email_address")
    private String emailAddress;

    @NotBlank(message = "created by cannot be empty")
    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_Date")
    @CreationTimestamp
    private Date createdDate;

    @NotBlank(message = "updated by cannot be empty")
    @Column(name = "updated_By")
    private String updatedBy;

    @Column(name = "updated_Date")
    @UpdateTimestamp
    private Date updatedDate;

    @NotBlank(message = "is Active cannot be empty")
    @Column(name = "is_active")
    private String isActive;

    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "contact_id", referencedColumnName = "contact_id")
    private List<Mobile> mobileEntities;

}
