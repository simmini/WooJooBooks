package net.ict.wjbooks.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "notice")
public class Notice {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long n_num;
    @Column(length = 50, nullable = false)
    private String n_title;
    @Column(length = 2000, nullable = false)
    private String n_content;
}
