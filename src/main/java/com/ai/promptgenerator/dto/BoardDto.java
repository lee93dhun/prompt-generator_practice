package com.ai.promptgenerator.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class BoardDto {

    private Long id;

    private String boardTitle;

    private String boardContent;

    private String boardWriter;


}
