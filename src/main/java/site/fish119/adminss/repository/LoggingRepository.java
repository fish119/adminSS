package site.fish119.adminss.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import site.fish119.adminss.domain.log.Logging_event;

public interface LoggingRepository extends JpaRepository<Logging_event,Long>{
}
