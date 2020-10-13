package drussotto.slackbot.service;


import javax.servlet.annotation.WebServlet;


import com.slack.api.bolt.servlet.SlackAppServlet;
import com.slack.api.bolt.App;

@WebServlet("/slack/events")
public class SlackAppController extends SlackAppServlet {
    public SlackAppController(App app) {
        super(app);
    }
}
