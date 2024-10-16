package hello.hellspring.repository;

import hello.hellspring.domain.Member;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SpringDataJpaMemberRepository extends JpaRepository<Member, Long>, MemberRepository {

    @Override
    List<Member> findAllById(Iterable<Long> longs);
}
