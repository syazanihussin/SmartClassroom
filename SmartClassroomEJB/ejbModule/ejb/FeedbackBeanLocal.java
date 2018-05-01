package ejb;

import javax.ejb.Local;
import jpa.Feedback;

@Local
public interface FeedbackBeanLocal {

	void saveFeedback(Feedback feedback);
	Feedback retrieveFeedback(int Id);
	void updateFeedback(Feedback feedback);
	void deleteFeedback(int Id);

}
