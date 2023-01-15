package net.ict.wjbooks_kakao.domain;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
@Entity
@Getter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@ToString(exclude = "sellBoard")
public class SellBoardImage implements Comparable<SellBoardImage> {
    @Id
    private String uuid;

    private String fileName;

    private int ord;

    @ManyToOne
    private SellBoard sellBoard;


    @Override
    public int compareTo(SellBoardImage other) {
        return this.ord - other.ord;
    }

    public void changeBoard(SellBoard sellBoard) {
        this.sellBoard = sellBoard;
    }
}

