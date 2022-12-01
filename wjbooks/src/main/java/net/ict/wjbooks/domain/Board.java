package net.ict.wjbooks.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import javax.persistence.*;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sell_post")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long s_num;

    @Column(length = 50, nullable = false)
    private String s_title;

    @Column(length = 4*1024, nullable = false)
    private String o_file;

    @Column(length = 3000, nullable = false)
    private String s_content;

    @Column(length = 20, nullable = false)
    private int s_price;

    @ColumnDefault(value = "0")
    @Column(length = 1, nullable = true)
    private boolean s_state;

    @Column(length = 5, nullable = false)
    private int s_condition;

    @ColumnDefault(value = "0")
    @Column(length = 100, nullable = true)
    private int s_view;
}
