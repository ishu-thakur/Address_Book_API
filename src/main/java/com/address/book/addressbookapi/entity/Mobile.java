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

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Mobile {

//    @Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
//    @Column(name = "MOBILE_ID")
//    private int mobileId;
//    @Column(name = "MOBILE_NUMBER")
//    private String mobileNumber;
//    @Column(name = "COUNTRY_CD")
//    private String countryCd;
//    @Column(name = "TYPE")
//    @Enumerated(EnumType.STRING)
//    private Type type;
//    @Column(name = "CREATED_BY")
//    private String createdBy;
//    @CreationTimestamp
//    @Column(name = "CREATED_DATE", nullable = false)
//    private Date createdDate;
//    @Column(name = "UPDATED_BY")
//    private String updatedBy;
//    @UpdateTimestamp
//    @Column(name = "UPDATED_DATE", nullable = false)
//    private Date updatedDate;
//
//    public enum Type {
//        Home,
//        Work
//    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "mobile_id", nullable = false)
    private Long mobileId;

    @Column(name = "mobile_number")
    private String mobileNumber;

    @Column(name = "country_code")
    private String countryCode;

    @Column(name = "type")
    private String type;

    @Column(name = "created_by")
    private String createdBy;

    @Column(name = "created_Date")
    @CreationTimestamp
    private Date createdDate;

    @Column(name = "updated_By")
    private String updatedBy;

    @Column(name = "updated_Date")
    @UpdateTimestamp
    private Date updatedDate;
}
