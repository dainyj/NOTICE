package com.project.springbootproject.domain.entity;
//DB 테이블과 매핑되는 객체를 정의하는 Entity, JPA와 관련이 깊다.


import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import net.bytebuddy.implementation.bind.annotation.Empty;

import javax.persistence.*;


@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
@Entity
@Table(name = "board")
public class BoardEntity extends TimeEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(length = 10, nullable = false)
    private String writer;

    @Column(length = 100, nullable = false)
    private String title;

    @Column(columnDefinition = "TEXT", nullable = false)
    private String content;

    @Builder
    public BoardEntity(Long id, String writer, String title, String content) {
        this.id = id;
        this.writer = writer;
        this.title = title;
        this.content = content;
    }
}

/*  **Explain**
* @NoArgsConstructor(access = AccessLevel.PROTECTED)
 - 파라미터가 없는 기본 생성자를 추가하는 어노테이션 (JPA 사용을 위해 기본 생성자 생성은 필수)
    - access는 생성자의 접근 권한을 설정하는 속성이며,  최종적으로 protected BoardEntity() {}와 동일
    - protected인 이유는 Entity생성을 외부에서 할 필요가 없기 때문이다

@Getter
 - 모든 필드에 getter를 자동생성해주는 어노테이션
 - @Setter 어노테이션은 setter를 자동생성해주지만, 무분별한 setter 사용은 안정성을 보장받기 어려우므로
    Builder 패턴을 사용한다
    - 참고로 @Getter와 @Setter를 모두 해결해주는 @Data 어노테이션도 있다

@Entity
 - 객체를 테이블과 매핑할 엔티티라고 JPA에게 알려주는 역할을 하는 어노테이션 (엔티티 매핑)
 - @Entity가 붙은 클래스는 JPA가 관리하며, 이를 엔티티 클래스라 한다

@Table(name="board")
 - 엔티티 클래스와 매핑되는 테이블 정보를 명시하는 어노테이션
 - name 속성으로 테이블명을 작성할 수 있으며, 생략 시 엔티티 이름이 테이블명으로 자동 매핑

@Id
 - 테이블의 기본 키임을 명시하는 어노테이션

@GeneratedValue(strategy=GenerationType.IDENTITY)
 - 기본키로 대체키를 사용할 때, 기본키 값 생성 전략을 명시

@Column
 - 컬럼을 매핑하는 어노테이션

@Builder
 - 빌더패턴 클래스를 생성해주는 어노테이션
 - @Setter 사용 대신 빌더패턴을 사용해야 안정성을 보장할 수 있다

Entity클래스는 테이블과 관련이 있는 것을 알 수 있다
비즈니스 로직은 Entity를 기준으로 돌아가기 때문에 Entity를 Request, Response 용도로 사용하는 것은 적절하지 못하다
그래서 데이터 전달 목적을 갖는 dto 클래스를 정의하여 사용한다*/