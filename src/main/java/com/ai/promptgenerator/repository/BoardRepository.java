package com.ai.promptgenerator.repository;

import com.ai.promptgenerator.entity.Board;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BoardRepository extends JpaRepository<Board,Long> {
    Page<Board> findAllByOrderByIdDesc(Pageable pageable);
}
