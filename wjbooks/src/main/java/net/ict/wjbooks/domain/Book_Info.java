package net.ict.wjbooks.domain;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Book_Info")
public class Book_Info {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long b_num;

    @Column(nullable = false)
    private String b_title;

    @Column(nullable = false)
    private String b_publisher;

    @Column(nullable = false)
    private String b_writer;

    @Column(nullable = false)
    private int b_price;

    @Column(nullable = false)
    private int b_isbn;
}
