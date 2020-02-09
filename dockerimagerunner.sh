docker run --network college-ms --name configserver -p 8888:8888 -d config-server
echo "waiting for 20 second"
sleep 20
docker run --network college-ms --name servicediscovery -p 8761:8761 -d servicediscovery
echo "waiting for 20 second"
sleep 20
docker run --network college-ms --name apigateway -p 8080:8080 -d apigateway
docker run --network college-ms --name studentconsumer -p 8084:8084 -d student-consumer
docker run --network college-ms --name studentproducer -p 8083:8083 -d student-producer
docker run --network college-ms --name subject -p 8081:8081 -d subject
docker run --network college-ms --name teacher -p 8082:8082 -d teacher
