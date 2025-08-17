package com.fastcampus.boarddemo.mapper;

import com.fastcampus.boarddemo.dto.BookBoardDTO;
import com.fastcampus.boarddemo.entity.BookBoard;
import org.mapstruct.Mapper;
import org.mapstruct.ObjectFactory;
import org.springframework.stereotype.Component;

import java.awt.print.Book;

@Component
@Mapper(componentModel = "spring")
public interface BookDtoToEntityMapper {
    @ObjectFactory
    default BookBoard create() {
        return BookBoard.ofDefault(); // 기본 생성자 정적 팩토리 메서드 (public static ofDefault)
    }

    BookBoard toEntity(BookBoardDTO bookboardDto);
}
