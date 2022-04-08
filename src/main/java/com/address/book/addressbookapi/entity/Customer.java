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

    @Email(message = "email is not valid", regexp ="^[a-zA-Z0-9+_.-]+@[a-zA-Z0-9.-]+$")
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
