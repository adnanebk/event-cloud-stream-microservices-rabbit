Spring Cloud Stream using RabbitMQ

This is a simple example of an application  implemented by using  Spring Cloud Stream and RabbitMQ. 
It contains 3 different microservices - Order(Producer),Payement(Processor) and Shipping(Consumer) communicate with each other asynchronously 

First the Order Service trigger an event that will be processed by the Payement service and after succesful payement there will be another event that will eventually be handled by the shipping service
