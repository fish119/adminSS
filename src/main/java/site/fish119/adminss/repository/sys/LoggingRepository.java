package site.fish119.adminss.repository.sys;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import site.fish119.adminss.domain.log.Logging_event;

@Repository
public interface LoggingRepository extends JpaRepository<Logging_event, Long> {
    @Query(value = "select a from Logging_event a where a.levelString = :levelString and (a.arg1 like %:queryStr% or a.loggerName like %:queryStr% or a.formattedMessage like %:queryStr%)")
    Page<Logging_event> searchLogs(@Param("levelString")String levelString, @Param("queryStr")String queryStr,Pageable pageable);

    Page<Logging_event> findByArg1ContainsOrFormattedMessageContainsOrLoggerNameContains(String arg1, String formattedMessage,String loggerName,Pageable pageable);
}
