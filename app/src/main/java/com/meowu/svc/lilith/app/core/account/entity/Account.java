package com.meowu.svc.lilith.app.core.account.entity;

import com.meowu.starter.entity.domain.Creatable;
import com.meowu.starter.entity.domain.Deletable;
import com.meowu.starter.entity.domain.Identity;
import com.meowu.starter.entity.domain.Updatable;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.FieldNameConstants;

import java.util.Date;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@FieldNameConstants
@Entity
@Table
public class Account extends Identity<Long> implements Creatable, Updatable, Deletable{

    private Long id;
    private String loginName;
    private Date createTime;
    private Date updateTime;
    private Date deleteTime;
}
