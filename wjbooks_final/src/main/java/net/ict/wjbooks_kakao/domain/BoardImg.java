package net.ict.wjbooks_kakao.domain;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name = "board_img")
@Getter @Setter
public class BoardImg extends BaseTimeEntity{
    @Id
    @Column(name = "board_img_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String imgName;

    private String oriImgName;

    private String imgUrl;

    private String repimgYn;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "s_num")
    private Board board;

    public void updateBoardImg(String oriImgName, String imgName, String imgUrl){
        this.oriImgName=oriImgName;
        this.imgName=imgName;
        this.imgUrl=imgUrl;
    }
}
