package com.fastcampus.boarddemo.repository;

import com.fastcampus.boarddemo.dto.BookBoardDTO;
import com.fastcampus.boarddemo.entity.BookBoard;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface BookRepository extends JpaRepository<BookBoard, Long> {
    BookBoard findByBookBoardId(Long id);
    List<BookBoard> findAll();

}
