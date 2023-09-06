package hellosample;

// Implementation of our workflow activity interface
public class HelloActivityRetryActivitiesImpl implements HelloActivityRetryActivities {
  private int callCount;
  private long lastInvocationTime;

  /**
   * Our activity implementation simulates a failure 3 times. Given our previously
   * set
   * RetryOptions, our workflow is going to retry our activity execution.
   */
  @Override
  public synchronized String activityRetryGreeting(String greeting, String name) {
    if (lastInvocationTime != 0) {
      long timeSinceLastInvocation = System.currentTimeMillis() - lastInvocationTime;
      System.out.print(timeSinceLastInvocation + " milliseconds since last invocation. ");
    }
    lastInvocationTime = System.currentTimeMillis();
    if (++callCount < 4) {
      System.out.println("activityRetryGreeting activity is going to fail");

      /*
       * We throw IllegalStateException here. It is not in the list of "do not retry"
       * exceptions
       * set in our RetryOptions, so a workflow retry is going to be issued
       */
      throw new IllegalStateException("not yet");
    }

    // after 3 unsuccessful retries we finally can complete our activity execution
    System.out.println("activityRetryGreeting activity is going to complete");
    return greeting + " " + name + "!";
  }
}
