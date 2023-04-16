package com.ai.promptgenerator.service;

import com.ai.promptgenerator.dto.BoardDto;
import com.ai.promptgenerator.entity.Board;
import com.ai.promptgenerator.repository.BoardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
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
       if(boardDto != null) {
           board.setBoardTitle(boardDto.getBoardTitle());
           board.setBoardContent(boardDto.getBoardContent());
           board.setBoardWriter(boardDto.getBoardWriter());

           return boardRepository.save(board);
       }else {
           return null;
       }
    }

    @Override
    public BoardDto getBoardById(Long id){
        Optional<Board> board = boardRepository.findById(id);
        BoardDto boardDto = new BoardDto();
        if (board.isPresent()){
            boardDto.setId(board.get().getId());
            boardDto.setBoardTitle(board.get().getBoardTitle());
            boardDto.setBoardContent(board.get().getBoardContent());
            boardDto.setBoardWriter(board.get().getBoardWriter());
            return boardDto;
        }else {
            return null;
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
    public Boolean deleteBoardById(Long id) {
        Optional<Board> optionalBoard = boardRepository.findById(id);
        if(optionalBoard.isPresent()){
            boardRepository.deleteById(id);
            return true;
        }else {
            return false;
        }

    }

//    @Override
//    public List<BoardDto> fetchAllBoard() {
//        List<BoardDto> boardDtoList = new ArrayList<>();
//        List<Board> boardList = boardRepository.findAll();
//        if (!(boardList.isEmpty())) {
//            for (int i = 0; i < boardList.size(); i++) {
//                BoardDto boardDto = new BoardDto();
//                boardDto.setId(boardList.get(i).getId());
//                boardDto.setBoardTitle(boardList.get(i).getBoardTitle());
//                boardDto.setBoardContent(boardList.get(i).getBoardContent());
//                boardDto.setBoardWriter(boardList.get(i).getBoardWriter());
//                boardDtoList.add(boardDto);
//            }
//            return boardDtoList;
//        } else {
//            return null;
//        }
//    }
    @Override
    public Page<BoardDto> fetchAllBoard(Pageable pageable) {
        Page<Board> boardList = boardRepository.findAllByOrderByIdDesc(pageable);
        Page<BoardDto> boardDtoList = boardList.map(m->BoardDto.builder()
                .id(m.getId())
                .boardTitle(m.getBoardTitle())
                .boardContent(m.getBoardContent())
                .boardWriter(m.getBoardWriter())
                .build());
        return boardDtoList;
    }

}
