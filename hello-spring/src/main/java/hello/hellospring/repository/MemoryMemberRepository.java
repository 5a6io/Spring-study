package hello.hellospring.repository;

import hello.hellospring.domain.Member;
import jdk.jfr.MemoryAddress;
import org.springframework.stereotype.Repository;

import java.util.*;

//@Repository 스프링 빈 자동 등록 방법
public class MemoryMemberRepository implements MemberRepository {
    private static Map<Long, Member> store = new HashMap<>(); //실무에서는 동시성 문제로 concurrent hashmap 사용
    private static long sequence = 0L; // 0, 1, 2,... 등 key 값 생성, 실무에서는 동시성 문제로 automic long 사용.
    @Override
    public Member save(Member member) {
        member.setId(++sequence);
        store.put(member.getId(), member);
        return member;
    }

    @Override
    public Optional<Member> findById(Long id) {
        return Optional.ofNullable(store.get(id)); // null이 반환될 가능성이 있으면 optional을 이용해서 반환 가능.
    }

    @Override
    public Optional<Member> findByName(String name) {
        return store.values().stream()
                .filter(member -> member.getName().equals(name))
                .findAny();
    }

    @Override
    public List<Member> findAll() {
        return new ArrayList<>(store.values());
    }

    public void clearStore() {
        store.clear();
    }
}
