package hellosample;

public final class AppConfig {

  public static final String TEMPORAL_NAMESPACE=System.getenv("TEMPORAL_NAMESPACE");
  public static final String TLS_CERT_PATH=System.getenv("TEMPORAL_TLS_CERT");
  public static final String TLS_KEY_PATH=System.getenv("TEMPORAL_TLS_KEY");
  public static final String TASK_QUEUE=System.getenv("TASK_QUEUE");

  private AppConfig() {
  }
}
