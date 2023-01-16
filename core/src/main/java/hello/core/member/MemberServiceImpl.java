package hello.core.member;

public class MemberServiceImpl implements MemberService { // 멤버 서비스에 대한 구현

    private final MemberRepository memberRepository; // 추상화에도 의존하고 구체화에도 의존. 변경사항 발생 시, 문제 발생. DIP 위반. -> 생성자를 만들어 변경 후 DIP문제 해결

    public MemberServiceImpl(MemberRepository memberRepository) {
        this.memberRepository = memberRepository;
    }

    @Override
    public void join(Member member) {
        memberRepository.save(member);
    }

    @Override
    public Member findMember(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
