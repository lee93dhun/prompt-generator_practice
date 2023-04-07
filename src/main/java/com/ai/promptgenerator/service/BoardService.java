package com.ai.promptgenerator.service;

import com.ai.promptgenerator.entity.Board;

import java.util.List;

public interface BoardService {

    Board saveBoard(Board board);

    Board getBoardById(Long id);

    Board updateBoardById(Long id, Board board);

    String deleteBoardById(Long id);

    List<Board> fetchAllBoard();

}
