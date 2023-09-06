package hellosample;

import io.temporal.client.WorkflowClient;
import io.temporal.worker.Worker;
import io.temporal.worker.WorkerFactory;

public class HelloSampleWorker {

  public static void main(String[] args) {

    // Temporal client connection
    CloudClient cloudClient = new CloudClient();
    WorkflowClient client = cloudClient.getClient();
    WorkerFactory factory = WorkerFactory.newInstance(client);

    // Temporal Task Queue to poll
    System.out.println("polling task queue: "+AppConfig.TASK_QUEUE);
    Worker worker = factory.newWorker(AppConfig.TASK_QUEUE);

    // Register our workflow implementations with the worker
    System.out.println("registering for workflow: HelloActivityRetryWorkflowImpl");
    worker.registerWorkflowImplementationTypes(HelloActivityRetryWorkflowImpl.class);
    System.out.println("registering for workflow: HelloLocalActivityWorkflowImpl");
    worker.registerWorkflowImplementationTypes(HelloLocalActivityWorkflowImpl.class);

    // Register Activity Types with the Worker 
    System.out.println("registering for activities: HelloActivityRetryActivitiesImpl");
    worker.registerActivitiesImplementations(new HelloActivityRetryActivitiesImpl());
    System.out.println("registering for activities: HelloLocalActivityActivitiesImpl");
    worker.registerActivitiesImplementations(new HelloLocalActivityActivitiesImpl());

    // Start all the workers registered for the specific task queue
    System.out.println("worker started");
    factory.start();
  }
}
