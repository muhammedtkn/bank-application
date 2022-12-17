package com.muhammed.bankapplication.general.entity;

import jakarta.persistence.Embedded;
import jakarta.persistence.MappedSuperclass;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

@MappedSuperclass
@Getter
@Setter
public abstract class BaseEntity implements BaseModel, Serializable,Cloneable {

    @Embedded
    private  BaseAdditionalFields baseAdditionalFields;

}
