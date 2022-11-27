package net.ict.wjbooks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "user")
public class User {
    @Id
    @Column(length = 20, nullable=false)
    private String u_id;

    @Column(length = 20, nullable = false)
    private String u_pw;

    @Column(length = 10, nullable = false)
    private String u_name;

    @Column(length = 20, nullable = false)
    private String u_tel;

    @ColumnDefault(value = "0")
    @Column(length = 10, nullable = true)
    private int u_score;

    @Column(length = 20, nullable = false)
    private String u_addr1;

    @Column(length = 20, nullable = true)
    private String u_addr2;

    @Column(length = 20, nullable = true)
    private String u_addr3;
}//유저가 왜안올라갔을까..?
