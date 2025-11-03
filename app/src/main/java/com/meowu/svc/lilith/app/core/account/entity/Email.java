package com.meowu.svc.lilith.app.core.account.entity;

import com.meowu.starter.entity.domain.Creatable;
import com.meowu.starter.entity.domain.Identity;
import com.meowu.starter.entity.domain.Updatable;
import jakarta.persistence.*;
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
@Table(
    name = "email",
    indexes = {
        @Index(name = "idx_email_account_id", columnList = "account_id", unique = true),
        @Index(name = "idx_email_address", columnList = "address", unique = true)
    }
)
public class Email extends Identity<Long> implements Creatable, Updatable{

    @Id
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "int")
    private Long id;

    @Column(name = "account_id", unique = true, nullable = false, columnDefinition = "int")
    private Long accountId;

    @Column(name = "address", unique = true, nullable = false, columnDefinition = "varchar(100)")
    private String address;

    @Column(name = "create_time", nullable = false, columnDefinition = "timestamp")
    private Date createTime;

    @Column(name = "update_time", columnDefinition = "timestamp")
    private Date updateTime;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = Account.Fields.email)
    private Account account;
}
