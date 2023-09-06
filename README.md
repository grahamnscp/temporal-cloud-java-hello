# Temporal java hello sample - separate java files

## Environment
Sample direnv .envrc file provided with classpath using target in maven pom.xml  
```
export CLASSPATH="./target/dependency/*:./target/hellosample-1.0.jar"
```

## Build
Might need to tweek for java versions etc or use ide :)
```
mvn compile
mvn verify
mvn dependency:copy-dependencies
```

## Start the common sample worker
```
java hellosample.HelloSampleWorker
```

## Run samples
```
java hellosample.HelloActivityRetryStarter
java hellosample.HelloLocalActivityStarter
```

## Example Run:
### Worker:
```
$ java hellosample.HelloSampleWorker
Connecting to my-ns.abcd0
polling task queue: HelloCloud
registering for workflow: HelloActivityRetryWorkflowImpl
registering for workflow: HelloLocalActivityWorkflowImpl
registering for activities: HelloActivityRetryActivitiesImpl
registering for activities: HelloLocalActivityActivitiesImpl
worker started
activityRetryGreeting activity is going to fail
1109 milliseconds since last invocation. activityRetryGreeting activity is going to fail
2103 milliseconds since last invocation. activityRetryGreeting activity is going to fail
4106 milliseconds since last invocation. activityRetryGreeting activity is going to complete
```
### Starters
```
$ java hellosample.HelloActivityRetryStarter
Connecting to my-ns.abcd0
Starting Workflow: HelloActivityRetryWorkflow..
Greeting: Hello Retry World!

java hellosample.HelloLocalActivityStarter
Connecting to my-ns.abcd0
Starting Workflow: HelloLocalActivityWorkflow..
Greeting: Hello Local World!
```
