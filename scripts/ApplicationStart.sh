#!/bin/bash
echo 'Starting app'
cd '/home/ec2-user/server/target'
screen -d -m java -jar functional-testing-0.0.1-SNAPSHOT.jar 