package net.ict.wjbooks.domain;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "file")
public class File {
    @Id
    @Column(name = "f_num")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "s_num")
    private Board board;
    private String f_name; //파일명
    private String o_name; //원본파일명
    private String f_path; //파일저장경로

    @Column(name = "rep_img")
    private String repimgYn; //대표이미지여부

    @Builder
    public void uploadFileImg(String o_name, String f_name, String f_path){
        this.o_name=o_name;
        this.f_name=f_name;
        this.f_path=f_path;
    }
}
