package hellosample;

import io.temporal.workflow.WorkflowInterface;
import io.temporal.workflow.WorkflowMethod;

@WorkflowInterface
public interface HelloLocalActivityWorkflow {

  @WorkflowMethod
  String getGreeting(String name);
}
