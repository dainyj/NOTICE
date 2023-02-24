package hello.core.member;

public interface MemberRepository { // 회원 저장소 인터페이스
    void save(Member member);

    Member findById(Long memberId);
}
