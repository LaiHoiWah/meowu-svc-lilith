package com.meowu.svc.lilith.app.core.account.entity;

import com.meowu.starter.entity.domain.Creatable;
import com.meowu.starter.entity.domain.Deletable;
import com.meowu.starter.entity.domain.Identity;
import com.meowu.starter.entity.domain.Updatable;
import com.meowu.starter.entity.enums.AccountStatus;
import com.meowu.svc.lilith.app.commons.struct.constant.graph.AccountGraph;
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
    name = "account",
    indexes = {
        @Index(name = "idx_account_login_name", columnList = "login_name", unique = true)
    }
)
@NamedEntityGraphs({
    @NamedEntityGraph(
        name = AccountGraph.WITH_ALL,
        attributeNodes = {
            @NamedAttributeNode(Account.Fields.user),
            @NamedAttributeNode(Account.Fields.email),
            @NamedAttributeNode(Account.Fields.phone)
        }
    ),
    @NamedEntityGraph(
        name = AccountGraph.WITH_USER,
        attributeNodes = {
            @NamedAttributeNode(Account.Fields.user)
        }
    ),
    @NamedEntityGraph(
        name = AccountGraph.WITH_EMAIL,
        attributeNodes = {
            @NamedAttributeNode(Account.Fields.email)
        }
    ),
    @NamedEntityGraph(
        name = AccountGraph.WITH_PHONE,
        attributeNodes = {
            @NamedAttributeNode(Account.Fields.phone)
        }
    ),
})
public class Account extends Identity<Long> implements Creatable, Updatable, Deletable{

    @Id
    @Column(name = "id", unique = true, nullable = false, columnDefinition = "int")
    private Long id;

    @Column(name = "login_name", unique = true, nullable = false, columnDefinition = "varchar(20)")
    private String loginName;

    @Column(name = "password", nullable = false, columnDefinition = "text")
    private String password;

    @Column(name = "status", nullable = false, columnDefinition = "varchar(3)")
    private AccountStatus status;

    @Column(name = "create_time", nullable = false, columnDefinition = "timestamp")
    private Date createTime;

    @Column(name = "create_time", columnDefinition = "timestamp")
    private Date updateTime;

    @Column(name = "create_time", columnDefinition = "timestamp")
    private Date deleteTime;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "account_id", insertable = false, updatable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private User user;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "account_id", insertable = false, updatable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Email email;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id", referencedColumnName = "account_id", insertable = false, updatable = false, foreignKey = @ForeignKey(ConstraintMode.NO_CONSTRAINT))
    private Phone phone;
}
