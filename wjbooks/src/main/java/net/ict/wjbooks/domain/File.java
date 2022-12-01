package net.ict.wjbooks.domain;

import lombok.*;

import javax.persistence.*;


@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "f_upload")
public class File {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long f_num;

    @ManyToOne
    @JoinColumn(name="s_num") //사진이 등록 될 게시글의 번호
    private Board board;

    @Column(nullable = false)
    private String f_name; //파일 원본 명

    @Column(nullable = false)
    private String f_path; //파일저장경로

    private long f_size;

    @Builder
    public File(String f_name, String f_path, long f_size){
        this.f_name=f_name;
        this.f_path=f_path;
        this.f_size=f_size;
    }

    public void setBoard(Board board) {
        this.board = board;

    }
}
