package hello.core.member;

public class MemberServiceImpl implements MemberService {
    //클라이언트인 MemberServiceImpl 입장에서는 의존관계를 마치 외부에서 주입해주는 것 같다고 해서
    //DI(Dependency Injection) 우리말로 *의존관계 주입* 또는 의존성 주입이라 한다.

//    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;
    // 인터페이스만 존재, 추상화에만 의존 DIP?
    public MemberServiceImpl(MemberRepository memberRepository) {

        this.memberRepository = memberRepository;
    }

    public void join(Member member) {

        memberRepository.save(member);
    }

    public Member findMember(Long memberId) {

        return memberRepository.findById(memberId);
    }

    //테스트 용도, 테스트용이므로 인터페이스에는 굳이 추가 안함.
    public MemberRepository getMemberRepository(){
        return memberRepository;
    }

}

//DIP완성
//설계 변경으로 MemberServiceImpl 은 MemoryMemberRepository 를 의존하지 않는다!
//단지 MemberRepository 인터페이스만 의존한다.
//MemberServiceImpl 입장에서 생성자를 통해 어떤 구현 객체가 들어올지(주입될지)는 알 수 없다.
//MemberServiceImpl 의 생성자를 통해서 어떤 구현 객체를 주입할지는 오직 외부( AppConfig )에서
//결정된다.
//MemberServiceImpl 은 이제부터 의존관계에 대한 고민은 외부에 맡기고 실행에만 집중하면 된다.
