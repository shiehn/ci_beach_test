package pivotal.io.citest;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Date;

@RestController
public class CiController {

    Date deployDate = null;

    @RequestMapping(value = "/", produces = "application/json")
    public String get() {

        if (deployDate == null) {
            deployDate = new Date();
        }

        return deployDate.toString();
    }
}
