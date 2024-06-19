package org.example.metabox.seat;

import jakarta.persistence.*;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.example.metabox.screening.Screening;

import java.util.List;

@Entity
@Data
@NoArgsConstructor
@Table(name = "seat_tb")
public class Seat {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    private Screening screening;

    // 좌석번호 ex : A9
    private String code;

    // 장애인석, 라이트석은 -1000원 할인
    // 장애인석, 라이트석, 일반석, 모션베드
    @Enumerated(EnumType.STRING)
    private SeatType type;

    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<SeatBook> seatBookList;

    @Builder
    public Seat(int id, Screening screening, String code, SeatType type, List<SeatBook> seatBookList) {
        this.id = id;
        this.screening = screening;
        this.code = code;
        this.type = type;
        this.seatBookList = seatBookList;
    }
        private enum SeatType {
        장애인석, 일반석, 라이트석, 모션베드
    }
}
