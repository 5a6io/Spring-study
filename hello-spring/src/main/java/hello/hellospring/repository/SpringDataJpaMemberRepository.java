package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    // 우리가 직접 등록하는 것이 아니라 이것이 구현체를 만들어서 등록을 해줌
    Optional<Member> findByName(String name);
}