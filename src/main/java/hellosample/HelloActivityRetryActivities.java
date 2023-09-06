package hellosample;

import io.temporal.activity.ActivityInterface;

// Activity Definition Interface
@ActivityInterface
public interface HelloActivityRetryActivities {

  // Define your activity method which can be called during workflow execution
  String activityRetryGreeting(String greeting, String name);
}
