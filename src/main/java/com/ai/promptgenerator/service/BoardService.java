package com.ai.promptgenerator.service;

import com.ai.promptgenerator.dto.BoardDto;
import com.ai.promptgenerator.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BoardService {

    Board saveBoard(BoardDto boardDto);

    BoardDto getBoardById(Long id);

    Boolean updateBoardById(Long id, BoardDto boardDto);

    Boolean deleteBoardById(Long id);

    Page<BoardDto> fetchAllBoard(Pageable pageable);



}
