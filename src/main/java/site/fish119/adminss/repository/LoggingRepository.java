package site.fish119.adminss.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import site.fish119.adminss.domain.log.Logging_event;

@Repository
public interface LoggingRepository extends JpaRepository<Logging_event, Long> {
    Page<Logging_event> findByLevelStringEqualsAndCallerFilenameContainsOrLevelStringEqualsAndCallerMethodContains(String level_string, String caller_filename, String level_string2, String caller_method,Pageable pageable);
    Page<Logging_event> findByCallerFilenameIgnoreCaseContainingOrCallerMethodIgnoreCaseContaining(String caller_filename, String caller_method,Pageable pageable);
}
