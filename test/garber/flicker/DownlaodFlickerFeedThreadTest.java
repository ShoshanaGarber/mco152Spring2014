package garber.flicker;

import java.io.IOException;

import org.junit.Test;
import org.mockito.Mockito;
import org.mockito.verification.VerificationMode;

public class DownlaodFlickerFeedThreadTest {

	@Test
	public void testCallsLoadImages() throws IOException {// testing if calling
															// the method
		FlickerFeedFrame frame = Mockito.mock(FlickerFeedFrame.class);
		DownloadFlickerFeedThread thread = new DownloadFlickerFeedThread(frame);

		// calling run because we want to execute run in the same thread that we
		// are running
		VerificationMode never = Mockito.never();
		Mockito.verify(frame, never).loadImages(Mockito.any(FlickerFeed.class));

		thread.run();

		VerificationMode once = Mockito.times(1);
		Mockito.verify(frame, once).loadImages(Mockito.any(FlickerFeed.class));

	}
}
