package hellosample;

import io.temporal.client.WorkflowClient;
import io.temporal.client.WorkflowOptions;

public class HelloLocalActivityStarter {

  // Define our workflow unique id
  static final String WORKFLOW_ID = "HelloLocalActivityWorkflow";

  public static void main(String[] args) {

    /* Temporal client connection */
    CloudClient cloudClient = new CloudClient();
    WorkflowClient client = cloudClient.getClient();

    // Start a workflow execution
    HelloLocalActivityWorkflow workflow = client.newWorkflowStub(
        HelloLocalActivityWorkflow.class, 
        WorkflowOptions.newBuilder()
          .setWorkflowId(WORKFLOW_ID)
          .setTaskQueue(AppConfig.TASK_QUEUE)
          .build());

    // Execute the workflow waiting for it to complete
    System.out.println("Starting Workflow: HelloLocalActivityWorkflow..");
    String greeting = workflow.getGreeting("Local World");

    // Display workflow execution results
    System.out.println("Greeting: "+greeting);

    System.exit(0);
  }
}
