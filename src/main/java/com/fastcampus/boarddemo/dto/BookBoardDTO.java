package com.fastcampus.boarddemo.dto;

import lombok.*;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class BookBoardDTO {
    private Long id;
    private String title;
    private String author;
    private String published_date;
    private String isbn;
    private LocalDate created_at;
    private LocalDate updated_at;
}
