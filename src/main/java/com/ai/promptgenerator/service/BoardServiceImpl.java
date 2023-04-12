package com.ai.promptgenerator.service;

import com.ai.promptgenerator.dto.BoardDto;
import com.ai.promptgenerator.entity.Board;
import com.ai.promptgenerator.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardRepository boardRepository;


    @Override
    public Board saveBoard(BoardDto boardDto){
       Board board = new Board();
       board.setBoardTitle(boardDto.getBoardTitle());
       board.setBoardContent(boardDto.getBoardContent());
       board.setBoardWriter(boardDto.getBoardWriter());

        return boardRepository.save(board);
    }

    @Override
    public BoardDto getBoardById(Long id){
        Optional<Board> board = boardRepository.findById(id);
        BoardDto boardDto = new BoardDto();
        if (board.isPresent()){
            boardDto.setBoardTitle(board.get().getBoardTitle());
            boardDto.setBoardContent(board.get().getBoardContent());
            boardDto.setBoardWriter(board.get().getBoardWriter());
            return boardDto;
        }else {
            return boardDto;
        }
    }

    @Override
    public Boolean updateBoardById(Long id, BoardDto boardDto) {
        Optional<Board> optionalBoard = boardRepository.findById(id);
        if(optionalBoard.isPresent()){
            Board board = optionalBoard.get();
            board.setBoardTitle(boardDto.getBoardTitle());
            board.setBoardContent(boardDto.getBoardContent());
            board.setBoardWriter(boardDto.getBoardWriter());
            boardRepository.save(board);
            return true;
        }else {
            return false;
        }
    }

    @Override
    public String deleteBoardById(Long id) {
        boardRepository.deleteById(id);
        return "Board with id " + id + " has been deleted";
    }

    @Override
    public List<BoardDto> fetchAllBoard() {
        List<Board> boardList = boardRepository.findAll();
        List<BoardDto> boardDtoList = new ArrayList<>();
        for(int i=0; i<boardList.size(); i++){
            BoardDto boardDto = new BoardDto();
            boardDto.setBoardTitle(boardList.get(i).getBoardTitle());
            boardDto.setBoardContent(boardList.get(i).getBoardContent());
            boardDto.setBoardWriter(boardList.get(i).getBoardWriter());
            boardDtoList.add(boardDto);
        }
        return boardDtoList;
    }

}
