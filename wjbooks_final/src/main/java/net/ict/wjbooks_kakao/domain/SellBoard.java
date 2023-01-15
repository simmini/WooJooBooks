package net.ict.wjbooks_kakao.domain;

import lombok.*;
import net.ict.wjbooks_kakao.constant.SellCondition;
import net.ict.wjbooks_kakao.constant.SellStatus;
import org.hibernate.annotations.BatchSize;
import net.ict.wjbooks_kakao.constant.*;
import org.hibernate.annotations.ColumnDefault;
import org.hibernate.annotations.DynamicInsert;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "imageSet")
public class SellBoard extends BaseTimeEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "s_num")
    private Long id;

//    @ManyToOne(fetch = FetchType.LAZY)
//    @JoinColumn(name = "u_num") //유저번호
//    private Member member;

    @Column(name="s_title")
    private String sellTitle; //게시글제목

    @Lob
    @Column(name="s_content")
    private String sellContent; //게시글내용

    @Column(name="s_price")
    private Integer sellPrice; //판매가격


    @Enumerated(EnumType.STRING)
    private SellStatus sellStatus; //판매상태(판매중/판매완료)

    @Enumerated(EnumType.STRING)
    private SellCondition sellCondition; //상품상태(새것/거의새것/사용감있음)

    /*=============================================*/

    @Column(name = "b_title" ,length = 50)
    private String bookTitle; //책제목

    @Column(name = "b_publisher")
    private String bookPublisher; //출판사

    @Column(name = "b_writer")
    private String bookWriter; //글쓴이

    @Column(name = "b_date")
    private String bookDate; //출판일

    @Column(name = "b_price")
    private Integer bookPrice; //원가


    public void change(
            String title,
            String bookTitle,
            Integer bookPrice,
            Integer sellPrice,
            String bookDate,
            String sellCondition,
            String sellContent,
            String bookWriter,
            String bookPublisher
            ){
        this.sellTitle = title;
        this.bookTitle = bookTitle;
        this.bookPrice = bookPrice;
        this.sellPrice = sellPrice;
        this.bookDate = bookDate;
        this.bookWriter = bookWriter;
        this.bookPublisher = bookPublisher;
        switch (sellCondition) {
            case "NEW": {
                this.sellCondition = SellCondition.NEW;
                break;
            }
            case "AlmostNew": {
                this.sellCondition = SellCondition.AlmostNew;
                break;
            }
            case "OLD": {
                this.sellCondition = SellCondition.OLD;
                break;
            }
        }

        this.sellContent = sellContent;
    }


    @OneToMany(mappedBy = "sellBoard",
            cascade = {CascadeType.ALL},
            fetch = FetchType.LAZY,
            orphanRemoval = true)
    @Builder.Default
    @BatchSize(size = 20)
  private Set<SellBoardImage> imageSet = new HashSet<>();

    public void addImage(String uuid, String fileName){

        SellBoardImage boardImage = SellBoardImage.builder()
                .uuid(uuid)
                .fileName(fileName)
                .sellBoard(this)
                .ord(imageSet.size())
                .build();
        imageSet.add(boardImage);
    }

    public void clearImages() {

        imageSet.forEach(sellBoardImg  -> sellBoardImg.changeBoard(null));

        this.imageSet.clear();
    }

}
