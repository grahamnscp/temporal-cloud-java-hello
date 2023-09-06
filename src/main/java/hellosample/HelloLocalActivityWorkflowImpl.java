package hellosample;

import io.temporal.activity.LocalActivityOptions;
import io.temporal.workflow.Workflow;
import java.time.Duration;

public class HelloLocalActivityWorkflowImpl implements HelloLocalActivityWorkflow {

  private final HelloLocalActivityActivities activities = Workflow.newLocalActivityStub(
      HelloLocalActivityActivities.class,
      LocalActivityOptions.newBuilder()
          .setStartToCloseTimeout(Duration.ofSeconds(2))
          .build());

  @Override
  public String getGreeting(String name) {
    // This is a blocking call that returns only after the activity has completed.
    return activities.localActivityGreeting("Hello", name);
  }
}
