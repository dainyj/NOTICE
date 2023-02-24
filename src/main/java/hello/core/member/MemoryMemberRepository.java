package hello.core.member;

import java.util.HashMap;
import java.util.Map;

public class MemoryMemberRepository implements MemberRepository { //메모리 회원 저장소 구현체
    //DB가 확정은 안되었지만 개발 진행을 위해 가장 단순한 메모리 회원 저장소 구현
    private static Map<Long, Member> store = new HashMap<>();
    //참고로 HashMap은 동시성 이슈가 발생할 수 있다. 이런 경우 ConcurrentHashMap을 사용

    @Override
    public void save(Member member) {
        store.put(member.getId(), member);
    }

    @Override
    public Member findById(Long memberId) {
        return store.get(memberId);
    }

}
