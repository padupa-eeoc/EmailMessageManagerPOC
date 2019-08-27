# EmailMessageManagerPOC
Spring boot POC to send for Emails using a message broker(Rabbit/Active)MQ

Uses H2 Database, RabbitMQ, greenmail


To use with with RabbitMQ:

1. Install RabbitMQ
2. Enable mangement plugin from rabbitmq admin prompt
3. login to the management console and create a queue 'emaillist'
4. Run greenmail service. java -Dgreenmail.setup.test.smtp -Dgreenmail.setup.test.imap -Dgreenmail.users=test1:pwd1 -jar greenmail-standalone-1.5.9.jar
5. Run the spring boot project.
6. Send post request with json/xml input. sample below

{
   "charSequenceId": "1100",
   "emailIds": [
      "test1@gmail.com",
      "test2@eeoc.gov"
   ]
}
[PP-111]
