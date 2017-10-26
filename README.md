# spring-cloud-intro
An intro into the Spring Cloud ecosystem

The project contains six projects:
* `centralized-config` - a repository which keeps the configurations for the other projects and services 
* `config-server` - a [Spring Cloud Config Server](https://cloud.spring.io/spring-cloud-config/spring-cloud-config.html) application
* `discovery-server` - a [Spring Cloud Eureka Server](https://cloud.spring.io/spring-cloud-netflix/) application
* `gateway-server` - a [Spring Cloud Zuul Server](https://cloud.spring.io/spring-cloud-netflix/) application
* `product-service` - a products REST application
* `order-service` - an orders REST application

# Running the applications
In order to easily run all the projects from a single run config:
1. Install the `Multirun` IntelliJ IDEA plugin (Plugins -> Install JetBrains plugin -> Search for `Multirun`)
2. Create a run configuration and add the projects in the following order:
   * ConfigServerApplication
   * DiscoveryServerApplication
   * GatewayApplication
   * ProductServiceApplication
   * OrderServiceApplication
3. Set a delay of 5 seconds between their launch, to make sure that the depending services have been started

# Accessing the Eureka dashboard and the services endpoints
* [eureka-dashboard](http://localhost:8082)
* [order-service](http://localhost:8080/order-service/order)
* [product-service](http://localhost:8080/product-service/product)