Spring Cloud Stream using RabbitMQ

This is a simple example of an application  implemented by using  Spring Cloud Stream and RabbitMQ. 
It contains 3 different microservices - Order(Producer),Payement(Processor) and Shipping(Consumer) communicate with each other asynchronously by using events.

First the Order Service trigger an event that will be processed by the Payement service and after succesful payement there will be another event that will eventually be handled by the shipping service


to test the application first run the docker command to create rabbitMq container :
                  docker run -it --rm --name rabbitmq -p 5672:5672 -p 15672:15672 rabbitmq:3.10-management

 then launch the 3 microservices apps

finnaly test the order endpoint (http://localhost:8080/api/orders , post request) with postman and watch the logs in all 3 microservices



                  
