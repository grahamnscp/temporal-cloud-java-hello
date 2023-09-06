package hellosample;

import io.temporal.activity.ActivityInterface;
import io.temporal.activity.ActivityMethod;

// Activity Definition Interface
@ActivityInterface
public interface HelloLocalActivityActivities {

  @ActivityMethod
  String localActivityGreeting(String greeting, String name);
}
