#!/bin/bash


CURRENT_FOLDER=`dirname $0`
APPNAME=generatorData
echo $CURRENT_FOLDER
#APPVERSION=`date +%Y%m%d-%H%M%S`
echo "mvn clean package -Dmaven.test.skip=true"


mvn clean install -Dmaven.test.skip=true

cd target
mkdir generatorData
cp generator-tools.jar generatorData
cp -r ../config/ generatorData/config
cp -r ../db/ generatorData/db
cp -r ../README.MD generatorData

tar -zcvf generatorData.tar.gz generatorData
