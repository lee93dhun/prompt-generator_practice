package com.ai.promptgenerator.entity;

import jakarta.persistence.*;

@Entity
public class Board {

    @Id
    @Column(name = "board_id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, length = 50)
    private String boardTitle;

    @Column(nullable = false, length = 500)
    private String boardContent;

    @Column(nullable = false, length = 20)
    private String boardWriter;

    public Board(){

    }

    public Board(Long id, String boardTitle, String boardContent, String boardWriter){
        this.id = id;
        this.boardTitle = boardTitle;
        this.boardContent = boardContent;
        this.boardWriter = boardWriter;
    }


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBoardTitle() {
        return boardTitle;
    }

    public void setBoardTitle(String boardTitle) {
        this.boardTitle = boardTitle;
    }

    public String getBoardContent() {
        return boardContent;
    }

    public void setBoardContent(String boardContent) {
        this.boardContent = boardContent;
    }

    public String getBoardWriter() {
        return boardWriter;
    }

    public void setBoardWriter(String boardWriter) {
        this.boardWriter = boardWriter;
    }
}
