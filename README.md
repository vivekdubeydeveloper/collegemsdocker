# collegems
Prerequisite for project
1)JDK 1.8
2)Maven 3.6.0
3)Mysql 5.7.28
4)Zookeeper(Should be running)
5)Kafka(Should be running)
6)Docker 18.09.7
7)GIT
8)Postman/Curl(One mandatory)
9)Internet Connection

Install Open JDK8 on Ubuntu
sudo add-apt-repository ppa:openjdk-r/ppa
sudo apt-get update
sudo apt-get install openjdk-8-jdk
if multiple jdk then run the below command 
sudo update-alternatives --config java
select no:<No>

Install Maven on ubuntu
sudo apt install maven
mvn -version


Install mysql server

sudo apt-get update
sudo apt-get install mysql-server
sudo ufw enable
sudo ufw allow mysql
sudo systemctl start mysql
sudo mysql

ALTER USER 'root'@'localhost' IDENTIFIED WITH mysql_native_password BY 'very_strong_password';
FLUSH PRIVILEGES;

Install Kafka and zookeeper
wget http://www-us.apache.org/dist/kafka/2.2.1/kafka_2.12-2.2.1.tgz
tar xzf kafka_2.12-2.2.1.tgz
mv kafka_2.12-2.2.1 /usr/local/kafka
cd /usr/local/kafka
bin/zookeeper-server-start.sh config/zookeeper.properties
bin/kafka-server-start.sh config/server.properties
bin/kafka-topics.sh --create --zookeeper localhost:2181 --replication-factor 1 --partitions 1 --topic testTopic
bin/kafka-topics.sh --list --zookeeper localhost:2181
bin/kafka-console-producer.sh --broker-list localhost:9092 --topic testTopic
bin/kafka-console-consumer.sh --bootstrap-server localhost:9092 --topic testTopic --from-beginning

install Docker
sudo apt install docker.io
sudo usermod -aG docker ${USER}

install Docker compose
sudo curl -L "https://github.com/docker/compose/releases/download/1.24.0/docker-compose-$(uname -s)-$(uname -m)" -o /usr/local/bin/docker-compose
sudo chmod +x /usr/local/bin/docker-compose
sudo ln -s /usr/local/bin/docker-compose /usr/bin/docker-compose
docker-compose --version

Install GIT
sudo apt-get install git


I have tested this code on Ubuntu.

Steps:
1)Clone the project
git clone https://github.com/vivekdubeydeveloper/collegems.git
2)Run the database script college.sql
3)Run zookeeper and kafka
4)Go to collegems/collegems directory
5)run mvn clean install
6)Give permisson to start.sh,dockerimagebuilder.sh,dockerimagerunner.sh
chmod -R 755.
7)Run start.sh it will start all the microservices.
8)Use postman collection to test the microservices.
9)Kill all the java process of microservices
killall -9 java
10)Now run the dockerimagebuilder.sh,it will create docker image of all the microservices.
11)Run dockerimagerunner.sh,it will run all the docker images
12)Again test all the api using postman collection.

Important
Swagger URl
http://localhost:8081/subject/swagger-ui.html
http://localhost:8081/subject/v2/api-docs

http://localhost:8082/teacher/swagger-ui.html
http://localhost:8082/teacher/v2/api-docs

http://localhost:8083/student/swagger-ui.html
http://localhost:8082/student/v2/api-docs

http://localhost:8765/

GRANT ALL PRIVILEGES ON database_name.* TO 'root'@'%' identified by 'root';
FLUSH PRIVILEGES;


