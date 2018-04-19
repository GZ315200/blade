
#! /bin/bash

SCRIPT_PATH=`dirname $0`
echo $SCRIPT_PATH

echo "[INFO] calling common-env.sh"

myexecute() {
    dt=`date +%Y-%m-%d\ %H:%M:%S`
    theCommand=${1}
    echo "${dt}: [COMMAND] ${theCommand}"
    if [ "${LOG}" != "" ]; then
        echo "${dt}: [COMMAND] ${theCommand}" >> ${LOG}
    fi
    ${theCommand}
    return $?
}

mylog () {
  dt=`date +%Y-%m-%d\ %H:%M:%S`
  theLog=${1}
  echo "[INFO] ${dt}: ${theLog}"
}

echo "[INFO] export all variables in env.properties"
if [ -f ${SCRIPT_PATH}/env.properties ]; then
myexecute "source ${SCRIPT_PATH}/env.properties"
else
  echo "[ERROR] cannot find env.properties"
  exit 0
fi