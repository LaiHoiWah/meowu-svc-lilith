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
    name = "phone",
    indexes = {
        @Index(name = "idx_phone_account_id", columnList = "account_id", unique = true),
        @Index(name = "idx_phone_country_cde_number", columnList = "country_cde, number", unique = true)
    }
)
public class Phone extends Identity<Long> implements Creatable, Updatable{

    @Id
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "int")
    private Long id;

    @Column(name = "account_id", unique = true, nullable = false, columnDefinition = "int")
    private Long accountId;

    @Column(name = "country_cde", nullable = false, columnDefinition = "varchar(5)")
    private String countryCode;

    @Column(name = "number", nullable = false, columnDefinition = "20")
    private String number;

    @Column(name = "create_time", nullable = false, columnDefinition = "timestamp")
    private Date createTime;

    @Column(name = "update_time", columnDefinition = "timestamp")
    private Date updateTime;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = Account.Fields.phone)
    private Account account;
}
