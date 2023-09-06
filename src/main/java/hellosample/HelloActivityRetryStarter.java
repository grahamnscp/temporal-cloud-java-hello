package hellosample;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;

/** Sample Temporal workflow that demonstrates workflow activity retries. */
public class HelloActivityRetryStarter {

  // Define our workflow unique id
  static final String WORKFLOW_ID = "HelloActivityWithRetriesWorkflow";

  public static void main(String[] args) {

    /* Temporal client connection */
    CloudClient cloudClient = new CloudClient();
    WorkflowClient client = cloudClient.getClient();

    // Set our workflow options
    WorkflowOptions workflowOptions = WorkflowOptions.newBuilder()
        .setWorkflowId(WORKFLOW_ID)
        .setTaskQueue(AppConfig.TASK_QUEUE)
        .build();

    // Create the workflow client stub used to start our workflow execution.
    HelloActivityRetryWorkflow workflow = client.newWorkflowStub(
      HelloActivityRetryWorkflow.class,
      workflowOptions);

    // Execute the workflow waiting for it to complete
    System.out.println("Starting Workflow: HelloActivityRetryWorkflow..");
    String greeting = workflow.getGreeting("Retry World");

    // Display workflow execution results
    System.out.println("Greeting: "+greeting);

    System.exit(0);
  }
}
