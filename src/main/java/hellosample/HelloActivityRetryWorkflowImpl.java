package hellosample;

import io.temporal.activity.ActivityOptions;
import io.temporal.common.RetryOptions;
import io.temporal.workflow.Workflow;
import java.time.Duration;

// Define the workflow implementation which implements our getGreeting workflow method.
public class HelloActivityRetryWorkflowImpl implements HelloActivityRetryWorkflow {

  private final HelloActivityRetryActivities activities = Workflow.newActivityStub(
      HelloActivityRetryActivities.class,
      ActivityOptions.newBuilder()
          .setStartToCloseTimeout(Duration.ofSeconds(10))
          .setRetryOptions(
              RetryOptions.newBuilder()
                  .setInitialInterval(Duration.ofSeconds(1))
                  .setDoNotRetry(IllegalArgumentException.class.getName())
                  .build())
          .build());

  @Override
  public String getGreeting(String name) {
    // This is a blocking call that returns only after activity is completed.
    return activities.activityRetryGreeting("Hello", name);
  }
}
