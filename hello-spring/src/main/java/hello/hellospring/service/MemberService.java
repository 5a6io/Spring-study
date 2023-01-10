package hello.hellospring.service;

import hello.hellospring.domain.Member;
import hello.hellospring.repository.MemberRepository;
import hello.hellospring.repository.MemoryMemberRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

// sevice는 business에 대해서
// 아래 메소드는 business 메소드

//@Service
@Transactional
public class MemberService {
    //    private final MemberRepository memberRepository = new MemoryMemberRepository();
    private final MemberRepository memberRepository;

    //@Autowired
    public MemberService(MemberRepository memberRepository) { // 외부에서 넣어주도록 변경
        this.memberRepository = memberRepository;
    }


    // 생성자를 제외하고 필드(변수) 앞에 @Autowired 하는 방법이 있음.
    // setter 앞에 Autowired를 붙일 수 있으나, 누군가 멤버 컨트롤러를 호출했을 때 publicd으로 노출이 되어있어야 함. 그러므로 중간에 잘못 바꾸면 문제가 생기게 됨.
    // 생성자를 통해 주입하는 것을 권장.

    //회원가입
    public Long join(Member member) {
        //같은 이름을 가진 중복 회원x
        //Optional<Member> result = memberRepository.findByName(member.getName());

//        result.ifPresent(member1 -> {
//            throw new IllegalStateException("이미 존재하는 회원입니다.");
//        });
        long start = System.currentTimeMillis();

        try {
            duplicatedValidMember(member); //중복회원 검증
            memberRepository.save(member);

        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("join" + timeMs + "ms");
        }


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
        long start = System.currentTimeMillis();

        try {
            return memberRepository.findAll();
        } finally {
            long finish = System.currentTimeMillis();
            long timeMs = finish - start;
            System.out.println("findMembers " + timeMs + "ms");
        }
    }

    public Optional<Member> findOne(Long memberId) {
        return memberRepository.findById(memberId);
    }
}
