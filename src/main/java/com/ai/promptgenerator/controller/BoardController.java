package com.ai.promptgenerator.controller;

import com.ai.promptgenerator.dto.BoardDto;
import com.ai.promptgenerator.message.ResponseMessage;
import com.ai.promptgenerator.service.BoardService;
import com.ai.promptgenerator.status.StatusEnum;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.charset.Charset;
import java.util.List;

@RestController
public class BoardController {

    @Autowired
    private BoardService boardService;

    @PostMapping("/board")
    public ResponseEntity<ResponseMessage<?>> saveBoard(@RequestBody BoardDto boardDto){
        ResponseMessage<?> rm = new ResponseMessage<>();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        if (boardService.saveBoard(boardDto)!=null){
            rm.setStatus(StatusEnum.OK);
            rm.setMessage("success");
            return new ResponseEntity<>(rm, headers, HttpStatus.OK);
        }else {
            rm.setStatus(StatusEnum.BAD_REQUEST);
            rm.setMessage("fail");
            return new ResponseEntity<>(rm, headers,HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/board/{id}")
    public ResponseEntity<ResponseMessage<BoardDto>> getBoardById(@PathVariable("id") Long id){
        ResponseMessage<BoardDto> rm = new ResponseMessage();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        BoardDto boardDto = boardService.getBoardById(id);
        if(boardDto != null) {
            rm.setStatus(StatusEnum.OK);
            rm.setMessage("success");
            rm.setData(boardDto);
            return new ResponseEntity<>(rm, headers, HttpStatus.OK);
        }else {
            rm.setStatus(StatusEnum.BAD_REQUEST);
            rm.setMessage("fail");
            return new ResponseEntity<>(rm, headers, HttpStatus.BAD_REQUEST);
        }
    }

//    @PutMapping("/board/{id}")
//    public Boolean updateBoardById(@PathVariable("id") Long id, @RequestBody BoardDto boardDto){
//        return boardService.updateBoardById(id, boardDto);
//    }
    @PutMapping("/board/{id}")
    public ResponseEntity<ResponseMessage<?>> updateBoardById(@PathVariable("id") Long id, @RequestBody BoardDto boardDto){
        ResponseMessage<?> rm = new ResponseMessage<>();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        if (boardService.updateBoardById(id, boardDto) == true){
            rm.setStatus(StatusEnum.OK);
            rm.setMessage("success");
            return new ResponseEntity<>(rm, headers, HttpStatus.OK);
        }else {
            rm.setStatus(StatusEnum.BAD_REQUEST);
            rm.setMessage("fail");
            return new ResponseEntity<>(rm, headers,HttpStatus.BAD_REQUEST);
        }
    }

//    @DeleteMapping("/board/{id}")
//    public String deleteBoardById(@PathVariable("id") Long id){
//
//        return boardService.deleteBoardById(id);
//    }

    @DeleteMapping("/board/{id}")
    public ResponseEntity<ResponseMessage<?>> deleteBoardById(@PathVariable("id") Long id){
        ResponseMessage<?> rm = new ResponseMessage<>();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        if (boardService.deleteBoardById(id) == true){
            rm.setStatus(StatusEnum.OK);
            rm.setMessage("success");
            return new ResponseEntity<>(rm, headers, HttpStatus.OK);
        }else {
            rm.setStatus(StatusEnum.BAD_REQUEST);
            rm.setMessage("fail");
            return new ResponseEntity<>(rm, headers,HttpStatus.BAD_REQUEST);
        }

    }
//    @GetMapping("/board")
//    public List<BoardDto> fetchAllBoard(){
//
//        return boardService.fetchAllBoard();
//    }
//    @GetMapping("/board")
//    public  ResponseEntity<ResponseMessage<List<BoardDto>>> fetchAllBoard(){
//        ResponseMessage<List<BoardDto>> rm = new ResponseMessage();
//        HttpHeaders headers = new HttpHeaders();
//        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
//        List<BoardDto> boardDtoList = boardService.fetchAllBoard();
//        if(boardDtoList != null) {
//            rm.setStatus(StatusEnum.OK);
//            rm.setMessage("success");
//            rm.setData(boardDtoList);
//            return new ResponseEntity<>(rm, headers, HttpStatus.OK);
//        }else {
//            rm.setStatus(StatusEnum.BAD_REQUEST);
//            rm.setMessage("fail");
//            return new ResponseEntity<>(rm, headers, HttpStatus.BAD_REQUEST);
//        }
//    }

    @GetMapping("/board")
    public ResponseEntity<ResponseMessage<Page<BoardDto>>> fetchAllBoard( @PageableDefault(size = 5,sort = "id",direction = Sort.Direction.DESC) Pageable pageable){
        ResponseMessage<Page<BoardDto>> rm = new ResponseMessage();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(new MediaType("application", "json", Charset.forName("UTF-8")));
        Page<BoardDto> boardDtos = boardService.fetchAllBoard(pageable);
        if(boardDtos != null) {
            rm.setStatus(StatusEnum.OK);
            rm.setMessage("success");
            rm.setData(boardDtos);
            return new ResponseEntity<>(rm, headers, HttpStatus.OK);
        }else {
            rm.setStatus(StatusEnum.BAD_REQUEST);
            rm.setMessage("fail");
            return new ResponseEntity<>(rm, headers, HttpStatus.BAD_REQUEST);
        }
    }


}
