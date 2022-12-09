package com.cathayunitedbank.interview.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

import lombok.Data;
import lombok.EqualsAndHashCode;

@Entity
@Table(name = "NAMECONVERT")
@EqualsAndHashCode(callSuper=false)
@Data
public class ConvertEntity extends BaseEntity {
    @Column(name = "code")
    private String code;
    @Column(name = "cname")
    private String cname;
}
