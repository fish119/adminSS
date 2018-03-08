package site.fish119.adminss.service.log;

import com.querydsl.core.types.Predicate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import site.fish119.adminss.domain.log.Logging_event;
import site.fish119.adminss.domain.log.QLogging_event;
import site.fish119.adminss.repository.sys.LoggingRepository;
import site.fish119.adminss.utils.MainUtil;

/**
 * @Project adminss
 * @Package site.fish119.adminss.service.log
 * @Author fish1
 * @Date 2018/3/8 21:31
 * @Version V1.0
 */
@Service
public class LogginService {
    @Autowired
    private LoggingRepository loggingRepository;

    public Iterable<Logging_event> searchLogs(String level, String searchStr, Integer page, Integer size, String sortColumn, String direction) {
        Pageable pageable = MainUtil.getPageRequest(page, size, sortColumn, direction);

        /**Note: generated sources first
         * run maven/maven generated sources
         * run maven clean
         * run maven compile
         */
        QLogging_event ql = QLogging_event.logging_event;
        Predicate predicate;
        if (level != null) {
            predicate = ql.levelString.eq(level)
                    .and(ql.arg0.containsIgnoreCase(searchStr)
                            .or(ql.loggerName.containsIgnoreCase(searchStr))
                            .or(ql.formattedMessage.containsIgnoreCase(searchStr)));
        } else {
            predicate = ql.arg0.containsIgnoreCase(searchStr)
                    .or(ql.loggerName.containsIgnoreCase(searchStr))
                    .or(ql.formattedMessage.containsIgnoreCase(searchStr));
        }
        return loggingRepository.findAll(predicate, pageable);
    }

    public void deleteAll() {
        loggingRepository.deleteAll();
    }
}
