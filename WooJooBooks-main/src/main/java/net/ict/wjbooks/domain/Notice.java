package net.ict.wjbooks.domain;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "notice")
public class Notice {
    @Id
    @Column(name="n_num")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long noticeNum;

    @Column(nullable = false, name="n_title",length = 100)
    @NotBlank
    private String noticeTitle;

    @Column(name = "n_content",length=10000)
    private String noticeContent;
}
