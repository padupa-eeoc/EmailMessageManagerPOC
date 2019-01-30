# EmailMessageManagerPOC
Spring boot POC to send for Emails using a message broker(Rabbit/Active)MQ

Uses H2 Database, RabbitMQ, greenmail


To use with with RabbitMQ:

1.Install RabbitMQ
2. Enable mangement plugin from rabbitmq admin prompt
3. login to the management console and create a queue 'emaillist'
4. Run the spring boot project.
5. Send post request with json/xml input. sample below
{
   "charSequenceId": "1100",
   "emailIds": [
      "adupap@gmail.com",
      "adupap@eeoc.gov"
   ]
}
