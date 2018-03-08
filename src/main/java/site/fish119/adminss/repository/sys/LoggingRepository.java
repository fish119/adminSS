package site.fish119.adminss.repository.sys;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.querydsl.QueryDslPredicateExecutor;
import org.springframework.stereotype.Repository;
import site.fish119.adminss.domain.log.Logging_event;

@Repository
public interface LoggingRepository extends JpaRepository<Logging_event, Long>,QueryDslPredicateExecutor<Logging_event> {

}
