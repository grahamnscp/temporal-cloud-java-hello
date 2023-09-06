package hellosample;

import io.temporal.api.common.v1.WorkflowExecution;
import io.temporal.api.history.v1.HistoryEvent;
import io.temporal.client.*;
import io.temporal.common.WorkflowExecutionHistory;
import io.temporal.serviceclient.SimpleSslContextBuilder;
import io.temporal.serviceclient.WorkflowServiceStubs;
import io.temporal.serviceclient.WorkflowServiceStubsOptions;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Optional;
import java.util.stream.Stream;

public class CloudClient {

  public WorkflowClient getClient() {
        return cloudClient;
  }

  public WorkflowServiceStubs getService() {
        return cloudService;
  }

  private WorkflowClient cloudClient;
  private WorkflowServiceStubs cloudService;

  public CloudClient() {

    cloudService = null;
    String cloudNamespace = AppConfig.TEMPORAL_NAMESPACE;
    if (cloudNamespace==null) {
            throw new IllegalArgumentException("missing TEMPORAL_NAMESPACE");
    }
    String cloudEndpoint = String.format("%s.tmprl.cloud:7233", cloudNamespace);

    try {
      System.out.println(String.format("Connecting to %s", AppConfig.TEMPORAL_NAMESPACE));
      InputStream clientCert = new FileInputStream(AppConfig.TLS_CERT_PATH);
      InputStream clientKey = new FileInputStream(AppConfig.TLS_KEY_PATH);

      cloudService = WorkflowServiceStubs.newServiceStubs(
        WorkflowServiceStubsOptions.newBuilder()
          .setSslContext(SimpleSslContextBuilder.forPKCS8(clientCert, clientKey).build())
          .setTarget(cloudEndpoint)
          .build());

    } catch (IOException e) {
            System.err.println("Error loading certificates: " + e.getMessage());
    }

    // Temporal Cloud workflow client
    cloudClient = WorkflowClient.newInstance(cloudService, 
      WorkflowClientOptions.newBuilder()
        .setNamespace(cloudNamespace)
        .build());
  }
}
