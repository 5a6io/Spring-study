package hello.hellospring.repository;

import com.fasterxml.jackson.annotation.JsonTypeInfo;
import hello.hellospring.domain.Member;
//import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.*;

class MemoryMemberRepositoryTest {
    MemoryMemberRepository repository = new MemoryMemberRepository();
    @AfterEach // 아래 메소드의 실행이 끝날 때마다 수행
    public void afterEach() {
        repository.clearStore();
    }

    @Test
    public void save(){
        Member member = new Member();
        member.setName("spring");

        repository.save(member);

        Member result = repository.findById(member.getId()).get();

//        System.out.println("result = "+(result == member));
        assertThat(member).isEqualTo(result); //Assertions 위에서 옵션+엔터를 하면 static import 가능
//        Assertions.assertEquals(result, member); //member는 기대값, result는 실제값. 제대로 실행되는지 확인할 때 출력문 사용보다 좋음.
    }

    @Test
    public void findByName(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        Member result = repository.findByName("spring2").get();

        assertThat(result).isEqualTo(member2); //result가 실제값, member1이 기대값.
    }

    @Test
    public void findAll(){
        Member member1 = new Member();
        member1.setName("spring1");
        repository.save(member1);

        Member member2 = new Member();
        member2.setName("spring2");
        repository.save(member2);

        List<Member> result = repository.findAll();

        assertThat(result.size()).isEqualTo(1);
    }
}
