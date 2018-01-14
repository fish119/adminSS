package site.fish119.adminss.controller.main;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import site.fish119.adminss.service.main.MainService;


@RestController
public class MainController {
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    MainService mainService;

    @RequestMapping(value = "/index", method = RequestMethod.POST)
    public ResponseEntity<?> index() {
        return ResponseEntity.ok(mainService.getIndexData());
    }
}
