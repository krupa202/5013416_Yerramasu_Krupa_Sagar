package decoratorPatternExample;

public class DecoratorPatternTest {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		 Notifier emailNotifier = new EmailNotifier();

	        // Decorate with SMS
	        Notifier smsNotifier = new SMSNotifierDecorator(emailNotifier);

	        // Decorate with Slack
	        Notifier slackNotifier = new SlackNotifierDecorator(smsNotifier);

	        // Send notification via Email, SMS, and Slack
	        slackNotifier.send("This is a test message.");


	}

}
