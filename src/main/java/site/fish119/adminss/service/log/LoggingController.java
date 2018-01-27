package site.fish119.adminss.service.log;

import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import site.fish119.adminss.domain.log.Logging_event;
import site.fish119.adminss.repository.LoggingRepository;
import site.fish119.adminss.secruity.UserDetailsImple;
import site.fish119.adminss.utils.MainUtil;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/**
 * @Project adminss
 * @Package site.fish119.adminss.service.log
 * @Author fish119
 * @Date 2018/1/27 20:20
 * @Version V1.0
 */
@RestController
public class LoggingController {
    @Autowired
    private LoggingRepository loggingRepository;

    @RequestMapping(value = "/logs", method = RequestMethod.GET)
    public ResponseEntity<?> getPageAndSortUsers(
            @RequestParam(name = "level", required = false) String level,
            @RequestParam(name = "searchStr", required = false) String searchStr,
            @RequestParam(name = "page", required = false) Integer page,
            @RequestParam(name = "size", required = false) Integer size,
            @RequestParam(name = "sortColumn", required = false) String sortColumn,
            @RequestParam(name = "direction", required = false) String direction) {
        Map<String, Object> result = new HashMap<>();
        Iterable<Logging_event> logging_events;
        Pageable pageable = MainUtil.getPageRequest(page, size, sortColumn, direction);
        if (level != null) {
            logging_events = loggingRepository.findByLevelStringEqualsAndCallerFilenameContainsOrLevelStringEqualsAndCallerMethodContains(level, searchStr, level,searchStr, pageable);
        } else {
            logging_events = loggingRepository.findByCallerFilenameIgnoreCaseContainingOrCallerMethodIgnoreCaseContaining(searchStr, searchStr, pageable);
        }
        result.put("data", logging_events);
        return ResponseEntity.ok(result);
    }

    @RequestMapping(value = "/logs", method = RequestMethod.DELETE)
    @Transactional
    public ResponseEntity<?> deleteAllLogs(){
        Map<String, Object> result = new HashMap<>();
        loggingRepository.deleteAll();
        LoggerFactory.getLogger(this.getClass()).info("删除所有日志",((UserDetailsImple) SecurityContextHolder.getContext().getAuthentication().getPrincipal()).getId(),new Date());
        result.put("data", "SUCCESS");
        return ResponseEntity.ok(result);
    }
}
