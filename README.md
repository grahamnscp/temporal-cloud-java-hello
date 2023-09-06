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
java hellosample.HelloSampleWorker

## Run samples
```
java hellosample.HelloActivityRetryStarter
java hellosample.HelloLocalActivityStarter
```
