package com.meowu.svc.lilith.app.core.account.entity;

import com.meowu.starter.entity.domain.Creatable;
import com.meowu.starter.entity.domain.Deletable;
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
    name = "user",
    indexes = {
        @Index(name = "idx_user_account_id", columnList = "account_id", unique = true)
    }
)
public class User extends Identity<Long> implements Creatable, Updatable{

    @Id
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "int")
    private Long id;

    @Column(name = "account_id", unique = true, nullable = false, columnDefinition = "int")
    private Long accountId;

    @Column(name = "nickname", nullable = false, columnDefinition = "varchar(50)")
    private String nickname;

    @Column(name = "header_url", columnDefinition = "text")
    private String headerUrl;

    @Column(name = "gender", columnDefinition = "varchar(3)")
    private String gender;

    @Column(name = "birthday", columnDefinition = "timestamp")
    private Date birthday;

    @Column(name = "create_time", nullable = false, columnDefinition = "timestamp")
    private Date createTime;

    @Column(name = "update_time", columnDefinition = "timestamp")
    private Date updateTime;

    @OneToOne(fetch = FetchType.LAZY, mappedBy = Account.Fields.user)
    private Account account;
}
