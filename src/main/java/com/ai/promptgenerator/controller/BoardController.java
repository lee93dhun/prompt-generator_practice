package com.ai.promptgenerator.controller;

import com.ai.promptgenerator.entity.Board;
import com.ai.promptgenerator.service.BoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/board")
    public Board saveBoard(@RequestBody Board board){
        return boardService.saveBoard(board);
    }

    @GetMapping("/board/{id}")
    public Board getBoardById(@PathVariable("id") Long id){
        return boardService.getBoardById(id);
    }

    @PutMapping("/board/{id}")
    public Board updateBoardById(@PathVariable("id") Long id, @RequestBody Board board){
        return boardService.updateBoardById(id, board);
    }

    @DeleteMapping("/board/{id}")
    public String deleteBoardById(@PathVariable("id") Long id){
        return boardService.deleteBoardById(id);
    }

    @GetMapping("/board")
    public List<Board> fetchAllBoard(){
        return boardService.fetchAllBoard();
    }
}
