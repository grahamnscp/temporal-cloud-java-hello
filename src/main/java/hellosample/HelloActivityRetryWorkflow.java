package hellosample;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface HelloActivityRetryWorkflow {

  @WorkflowMethod
  String getGreeting(String name);
}
