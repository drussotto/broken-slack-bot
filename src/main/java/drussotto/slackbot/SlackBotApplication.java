package drussotto.slackbot;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.ConfigurableApplicationContext;
import java.time.Instant;

@SpringBootApplication
@EnableConfigurationProperties
@ServletComponentScan
public class SlackBotApplication {

    private static final Logger LOGGER = LoggerFactory.getLogger(SlackBotApplication.class);

    public static void main(String[] args) {
        try {
            LOGGER.info("Starting up service! {}", Instant.now());
            ConfigurableApplicationContext applicationContext = new SpringApplicationBuilder()
                    .sources(SlackBotApplication.class)
                    .run(args);
            Thread.currentThread().join();
            LOGGER.info("Service is ready on {}, Its Ready to use, have fun.", Instant.now());
        } catch (Exception e) {
            System.out.println("Something went wrong " + e.getMessage());
            LOGGER.error("Unexpected error", e);
        }
    }
}
