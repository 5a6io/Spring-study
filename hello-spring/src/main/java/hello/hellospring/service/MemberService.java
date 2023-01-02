package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;

import java.util.List;
import java.util.Optional;

// sevice는 business에 대해서
// 아래 메소드는 business 메소드
public class MemberService {
    //    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    public MemberService(MemberRepository memberRepository) { // 외부에서 넣어주도록 변경
        this.memberRepository = memberRepository;
    }

    //회원가입
    public Long join(Member member) {
        //같은 이름을 가진 중복 회원x
        //Optional<Member> result = memberRepository.findByName(member.getName());

//        result.ifPresent(member1 -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });

        duplicatedValidMember(member); //중복회원 검증
        memberRepository.save(member);
        return member.getId();
    }

    private void duplicatedValidMember(Member member) {
        memberRepository.findByName(member.getName())
                .ifPresent(member1 -> {
                    throw new IllegalStateException("이미 존재하는 회원입니다.");
                });
    }

    // 전체회원 조회
    public List<Member> findMembers() {
        return memberRepository.findAll();
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
