package com.ai.promptgenerator.dto;

import com.ai.promptgenerator.entity.Board;
import lombok.*;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {

    private Long id;

    private String boardTitle;

    private String boardContent;

    private String boardWriter;

    public static BoardDto from(Board board) {
        return BoardDto.builder()
                .id(board.getId())
                .boardTitle(board.getBoardTitle())
                .boardContent(board.getBoardContent())
                .boardWriter(board.getBoardWriter())
                .build();
    }

}
