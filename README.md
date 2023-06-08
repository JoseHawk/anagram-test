# Anagram Test

## Running the Project:

There are several options to run the project.

**Option 1: Kubernetes**

You can deploy it in Kubernetes in your local machine, for example, using Minikube. The idea is to work in a local environment the closest to a production environment, so among other advantages:

- We will avoid unnecessary installations.
- We will avoid local machine statuses that could affect the code execution.
- More OS independent.

*Minikube installation:*

- In the first place, it is necessary to install DockerDesktop in our local machine: https://docs.docker.com/desktop/windows/install/
- Make sure that Hyper-V is activated in your OS.
- Install Minikube in the local machine: https://minikube.sigs.k8s.io/docs/start/

*Minikube basic commands:*

In order to run Minikube, it is necessary to run DockerDesktop first. These are the basics commands that we will use:

- `minikube start`: It runs the Kubernetes instante
- `minikube tunnel`: It generates tunnels to the ports defined in the services

To run the project, you just need to execute:
- `kubectl kustomize kubernetes`: It generates the final deployment file
- `kubectl apply -k kubernetes`: It will deploy it in our Kubernetes instance.

An advantage of running the project following this option, is that an instance of Sonar will be also deployed.

**Option 2: Docker**

Code is prepared to run by Docker (as this is also a requirement for Kubernetes). First of all, it is important to add the next environment variable (or add it as a parameter):

|  DICTIONARY_URL| https://api.dictionaryapi.dev/api/v2/entries/en |
|--|--|

Then we need to run the next commands after a `mvn clean install`:

- `docker build -t josehawktests/anagram-test .` : It will build the solution
- `docker run -p 8090:8090-t josehawktests/anagram-test`: I will run the application in the port 8090

**Option 3: Standard execution**

The service is a Spring Boot application, so it can be run standalone. You can execute it by the JAR file or using your favourite IDE. Only consideration is to add the same environment variable as before:

|  DICTIONARY_URL| https://api.dictionaryapi.dev/api/v2/entries/en |
|--|--|

## REST API documentation

This documentation is auto generated, when running the application, at the "swagger-ui.html" route

## Sonar

If you followed the first option, a Sonar instance will also be deployed in your local Kubernetes instance. To link the project, you need to follow the next steps:

- Access localhost:9000
- Login with admin/admin for the first time, then change your password
- Add a new project and choose manual configuration.
- Add the Project Key and Display name.
- Generate a token giving a name.
- In the next screen, it will show you how to link and scan your project according to your language. In our case, we choose Maven.
- After executing the command, you should be able to see the results of your code analysis in the dashboard.

## Built with

* Spring framework
* Java 17
* Maven
* JUnit 5
* Mockito
* Cucumber
* Wiremock
* RestAssured
* SpringDoc

## Related tools

* Sonar
* Jacoco

## Authors

* **Jose Lara** - *Software Architect* - [Email](laragomezjc@gmail.com)