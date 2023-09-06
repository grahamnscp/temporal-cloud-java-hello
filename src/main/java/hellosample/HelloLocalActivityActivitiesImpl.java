package hellosample;

public class HelloLocalActivityActivitiesImpl implements HelloLocalActivityActivities {

  @Override
  public String localActivityGreeting(String greeting, String name) {
    return greeting + " " + name + "!";
  }
}
