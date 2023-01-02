package hello.hellospring.repository;

import hello.hellospring.domain.Member;

import java.util.List;
import java.util.Optional;

public interface MemberRepository {
    Member save(Member member);
    Optional<Member> findById(Long id); // 아이디로 회원 찾기, optional java8에 들어가 있는 기능
    Optional<Member> findByName(String name);
    List<Member> findAll(); // 지금까지 저장된 모은 회원 리스트를 반환
}
