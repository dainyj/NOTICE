package com.project.springbootproject.service;

//비즈니스 로직을 수행하는 Service

import com.project.springbootproject.domain.repository.BoardRepository;
import com.project.springbootproject.dto.BoardDto;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@AllArgsConstructor
@Service
public class BoardService {
    private BoardRepository boardRepository;

    @Transactional
    public Long savePost(BoardDto boardDto) {
        return boardRepository.save(boardDto.toEntity()).getId();
    }
}

/* **EXPLAIN**
* @AllArgsConstructor
 - Controller에서 봤던 어노테이션
 - 마찬가지로 Repository를 주입하기 위해 사용

@Service
 - 서비스 계층임을 명시해주는 어노테이션

@Transactional
 - 선언적 트랜잭션이라 부르며, 트랜잭션을 적용하는 어노테이션

save()
 - JpaRepository에 정의된 메서드로, DB에 INSERT, UPDATE를 담당한다
 - 매개변수로는 Entity를 전달*/