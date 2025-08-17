package com.fastcampus.boarddemo.mapper;

import com.fastcampus.boarddemo.dto.BookBoardDTO;
import com.fastcampus.boarddemo.entity.BookBoard;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Component
@Mapper(componentModel = "spring")
public interface BooktoDTOMapper {
    BookBoardDTO toDto(BookBoard bookboard);
}
