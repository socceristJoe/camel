This is a project for Apache Camel demo by Joe Qiao from Global EAI Team.

#Structure of the Demo:
##Starter
###First ever router
Create a router sends hardcoded message to with two components (print current time & message).

###File router
Create a file router, transfers file from input folder to output folder

##Play with ActiveMQ
###Run ActiveMQ in Docker
```shell
Pull images from dockerhub
$ docker pull rmohr/activemq:5.15.9-alpine
Run active mq
$ docker run -p 61616:61616 -p 8161:8161 -d rmohr/activemq:5.15.9-alpine
```
###Open ActiveMQ in Browser
open http://0.0.0.0:8161/admin/index.jsp for local ActiveMQ

###Send Message to ActiveMQ
Create a router sending hardcoded message to ActiveMQ

###Send JSON to ActiveMQ
Create a router sending predefined JSON file to ActiveMQ

###Send XML to ActiveMQ
Create a router sending Predefined XML File to ActiveMQ

