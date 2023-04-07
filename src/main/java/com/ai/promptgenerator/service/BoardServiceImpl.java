package com.ai.promptgenerator.service;

import com.ai.promptgenerator.entity.Board;
import com.ai.promptgenerator.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardRepository boardRepository;

    @Override
    public Board saveBoard(Board board){
        return boardRepository.save(board);
    }

    @Override
    public Board getBoardById(Long id){
        Optional<Board> board = boardRepository.findById(id);

        if(board.isPresent()){
            return board.get();
        }
        return null;
    }

    @Override
    public Board updateBoardById(Long id, Board board){
        Optional<Board> optionalBoard = boardRepository.findById(id);

        if (optionalBoard.isPresent()) {
            Board originalBoard = optionalBoard.get();

            if (Objects.nonNull(board.getBoardTitle()) && !"".equalsIgnoreCase(board.getBoardTitle())){
                originalBoard.setBoardTitle(board.getBoardTitle());
            }
            if (Objects.nonNull(board.getBoardContent()) && board.getBoardContent() !=""){
                originalBoard.setBoardContent(board.getBoardContent());
            }
            return boardRepository.save(originalBoard);
        }
        return null;
    }

    @Override
    public String deleteBoardById (Long id){
        if(boardRepository.findById(id).isPresent()){
            boardRepository.deleteById(id);
            return "Board deleted successfully";
        }
        return "No such Board in the database";
    }

    @Override
    public List<Board> fetchAllBoard(){
        List<Board> allBoard = boardRepository.findAll();
        return allBoard;
    }

}
