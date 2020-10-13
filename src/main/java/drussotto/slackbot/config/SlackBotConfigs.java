package drussotto.slackbot.config;


import com.slack.api.bolt.App;
import com.slack.api.bolt.AppConfig;
import com.slack.api.model.event.AppMentionEvent;
import com.slack.api.model.event.MessageBotEvent;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SlackBotConfigs {
    
    @Bean
    public App initSlackApp() {
        
    	AppConfig config = new AppConfig();
    	config.setSingleTeamBotToken("<Token>");
    	config.setSigningSecret("<signingSecret>");
    	
        App app = new App(config);
        app.event(AppMentionEvent.class, (payload, ctx) -> {
            return ctx.ack();
        });
        app.event(MessageBotEvent.class, (payload, ctx) -> {
            return ctx.ack();
        });
        app.command("/do-the-thing", (req, ctx) -> {
            return ctx.ack("OK, let's do it!");
        });
        return app;
      }
}
