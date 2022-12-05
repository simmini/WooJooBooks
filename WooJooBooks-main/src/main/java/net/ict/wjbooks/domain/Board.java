package net.ict.wjbooks.domain;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "sell_post")
public class Board {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "s_num")
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "u_num")
    private Member member;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "f_num")
    private File file;

    @Column(nullable = false, length = 50 ,name="s_title")
    private String sellTitle;

    @Column(name="s_content", nullable = false,length=10000)
    private String sellContent;

    @Column(nullable = false ,name="s_price")
    private Long sellPrice;


    @Column(nullable = false , name="s_state")
    private boolean sellState;

    @Column(nullable = false , name="s_condition")
    private Long sellCondition;

    @Column(nullable = false , name="s_viwe")
    private Long sellView;

    /*=============================================*/
    @Column(name="b_num")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long bookNum;

    @Column(nullable = false, name = "b_title" ,length = 50)
    @NotBlank
    private String bookTitle;

    @Column(nullable = false, name = "b_publisher")
    @NotBlank
    private String bookPublisher;

    @Column(nullable = false, name = "b_writer")
    @NotBlank
    private String bookWriter;

    @Column(nullable = false, name = "b_date")
    @NotBlank
    private Date bookDate;

    @Column(nullable = false, name = "b_price")
    @NotBlank
    @Length(min = 1, max = 6)
    private String bookPrice;

       /* @Column(nullable = false, name = "b_isbn")
        @NotBlank
        private Long bookIsbn;*/

    /* ================*/


}
