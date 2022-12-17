package com.muhammed.bankapplication.general.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.CreatedBy;
import org.springframework.data.annotation.CreatedDate;
import org.springframework.data.annotation.LastModifiedBy;
import org.springframework.data.annotation.LastModifiedDate;

import java.time.LocalDateTime;

@Embeddable
@Getter
@Setter
public class BaseAdditionalFields {

    @CreatedDate
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name="CREATE_DATE",updatable = false)
    private LocalDateTime createdDate;

    @CreatedBy
    @Column(name="CREATE_BY",updatable = false)
    private Long createdBy;
    @LastModifiedDate
    @Column(name="UPDATE_DATE",updatable = false)
    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime uptatedDate;

    @LastModifiedBy
    @Column(name="CREATE_BY",updatable = false)
    private Long uptatedBy;

}
