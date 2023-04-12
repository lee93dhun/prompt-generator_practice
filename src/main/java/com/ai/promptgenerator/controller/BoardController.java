package com.ai.promptgenerator.controller;

import com.ai.promptgenerator.dto.BoardDto;
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
    public boolean saveBoard(@RequestBody BoardDto boardDto){
        if (boardService.saveBoard(boardDto)!=null){
            return true;
        }
        else {
            return false;
        }

    }

    @GetMapping("/board/{id}")
    public BoardDto getBoardById(@PathVariable("id") Long id){
       return boardService.getBoardById(id);
    }

    @PutMapping("/board/{id}")
    public Boolean updateBoardById(@PathVariable("id") Long id, @RequestBody BoardDto boardDto){
        return boardService.updateBoardById(id, boardDto);
    }

    @DeleteMapping("/board/{id}")
    public String deleteBoardById(@PathVariable("id") Long id){
        return boardService.deleteBoardById(id);
    }

    @GetMapping("/board")
    public List<BoardDto> fetchAllBoard(){
        return boardService.fetchAllBoard();
    }
}
