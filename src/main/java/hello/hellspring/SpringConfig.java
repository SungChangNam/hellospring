package hello.hellspring;

import hello.hellspring.repository.JdbcMemberRepository;
import hello.hellspring.repository.JdbcTemplateMemberRepository;
import hello.hellspring.repository.MemberRepository;
import hello.hellspring.repository.MemoryMemberRepository;
import hello.hellspring.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class SpringConfig {

    DataSource dataSource;


    @Autowired
    public SpringConfig(DataSource dataSource) {
        this.dataSource = dataSource;

    }

    @Bean
    public MemberService memberService() {
        return new
                MemberService(memberRepository());
    }

    @Bean
    public MemberRepository memberRepository() {

        //return new MemoryMemberRepository();
        //return new JdbcMemberRepository(dataSource);
        return new JdbcTemplateMemberRepository(dataSource);
    }
}
