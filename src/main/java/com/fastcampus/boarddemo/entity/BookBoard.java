package com.fastcampus.boarddemo.entity;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Entity
@Table(name = "book_board")
@NoArgsConstructor(access = AccessLevel.PROTECTED) // JPA 프록시용 기본 생성자 보호
@AllArgsConstructor //@Builder는 모든 필드를 한 번에 세팅할 수 있는 생성자가 필요하기 떄문에 추가
@Getter
@Builder
public class BookBoard {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) //Primary Key
    @Column(name="id")
    Long id;

    @Column(name ="title" , nullable=false)
    String title;

    @Column(name ="author" , nullable=false)
    String author;

    @Column(name ="published_date" , nullable=true)
    LocalDate published_date; //연,월,일

    @Column(name ="isbn" , nullable=true)
    String isbn;

    @Column(name ="created_at" , nullable=true)
    LocalDate created_at;

    public static BookBoard ofDefault() {
        BookBoard bookBoard = new BookBoard();
        return bookBoard;
    }

    @PrePersist
    protected void onCreate() {
        this.created_at = LocalDate.now();
    }

    @Column(name ="updated_at" , nullable=true)
    LocalDate updated_at;
}
