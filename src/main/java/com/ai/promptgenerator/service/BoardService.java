package com.ai.promptgenerator.service;

import com.ai.promptgenerator.dto.BoardDto;
import com.ai.promptgenerator.entity.Board;

import java.util.List;

public interface BoardService {

    Board saveBoard(BoardDto boardDto);

    BoardDto getBoardById(Long id);

    Boolean updateBoardById(Long id, BoardDto boardDto);

    String deleteBoardById(Long id);

    List<BoardDto> fetchAllBoard();

}
