package ejb;

import javax.ejb.Remote;
import jpa.Feedback;

@Remote
public interface FeedbackBeanRemote {

	void saveFeedback(Feedback feedback);
	Feedback retrieveFeedback(int Id);
	void updateFeedback(Feedback feedback);
	void deleteFeedback(int Id);

}
