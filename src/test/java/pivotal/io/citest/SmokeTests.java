package pivotal.io.citest;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.IfProfileValue;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

import static org.assertj.core.api.Assertions.assertThat;

@IfProfileValue(name="testprofile", value="smoketests")
@RunWith(SpringRunner.class)
@SpringBootTest
public class SmokeTests {

    @Test
    public void shouldReturn20OkWhenDeployed() throws IOException {

        RestTemplate restTemplate = new RestTemplate();

        String colour = Files.lines(Paths.get("../current-app-info/next-app.txt")).findFirst().get();
        String suffix = System.getenv("PWS_APP_SUFFIX");
        String domain = System.getenv("PWS_APP_DOMAIN");

        String url = String.format("http://%s-%s.%s", colour, suffix, domain);

        System.out.println("TEST URL: " + url);

        ResponseEntity<Void> response = restTemplate.getForEntity(url, Void.class);

        System.out.println("TEST RESPONSE: " + response);

        assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }
}
