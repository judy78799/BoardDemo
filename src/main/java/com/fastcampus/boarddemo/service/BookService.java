package com.fastcampus.boarddemo.service;

import com.fastcampus.boarddemo.dto.BookBoardDTO;
import com.fastcampus.boarddemo.entity.BookBoard;
import com.fastcampus.boarddemo.mapper.BookDtoToEntityMapper;
import com.fastcampus.boarddemo.mapper.BooktoDTOMapper;
import com.fastcampus.boarddemo.repository.BookRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.awt.print.Book;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BookService {

    private final BookRepository bookRepository;
    private final BooktoDTOMapper booktoDTOMapper;
    private final BookDtoToEntityMapper bookDtoToEntityMapper;

//    public List<BookBoardDTO> findByBookBoardId(){
//        List<BookBoard> bookList = bookRepository.findByBookBoardId(1L);
//        List<BookBoardDTO> bookDTOList = bookList.stream()
//                .map(bookEntity -> booktoDTOMapper.toDto(bookEntity))
//                .collect(Collectors.toList());
//        bookDTOList.stream().forEach(bookDTO -> System.out.println("bookDTO = " + bookDTO));
//        return bookDTOList;
//    }

    public List<BookBoardDTO> findAll(){
        List<BookBoard> bookList = bookRepository.findAll();
        List<BookBoardDTO> bookDTOList = bookList.stream()
                .map(bookEntity -> booktoDTOMapper.toDto(bookEntity))
                .collect(Collectors.toList());
        return bookDTOList;
    }


    public void save(BookBoardDTO bookboardDTO) {
        BookBoard bookboardDTOtoEntity = bookDtoToEntityMapper.toEntity(bookboardDTO);
        bookRepository.save(bookboardDTOtoEntity);
    }
    /**
     * 1. 존재하는 지 여부 확인
     * 2. 존재하면, 리포지토리에서 하나 읽어서 가져옴
     * 3. 리포지토리에서 가져오는 것들을 DTO로 매핑함.
     * @param id
     * @return
     */
    public BookBoardDTO findOneBookBoard(Long id) {
        //엔티티의 @Id로 지정된 기본 키(primary key)로만 검색 가능, 디버깅용 코드.
        bookRepository.findById(id).ifPresent(book -> {
            System.out.println("책 제목: " + book.getTitle());
        });
        BookBoard bookBoardId = bookRepository.findByBookBoardId(id); //id값을 주고 해당 데이터를 불러옴.
        BookBoardDTO bookBoardDTO = booktoDTOMapper.toDto(bookBoardId); //DTO로 매핑
        return bookBoardDTO;
    }
}
