export PROJECT_PATH=.
sudo chmod -R 755 .
cd $PROJECT_PATH/config-server/
docker build -t config-server .
cd ..
cd $PROJECT_PATH/apigateway/
docker build -t apigateway .
cd ..
cd $PROJECT_PATH/servicediscovery/
docker build -t servicediscovery .
cd ..
cd $PROJECT_PATH/student-consumer/
docker build -t student-consumer .
cd ..
cd $PROJECT_PATH/student-producer/
docker build -t student-producer .
cd ..
cd $PROJECT_PATH/subject/
docker build -t subject .

cd ..
cd $PROJECT_PATH/teacher/
docker build -t teacher .
