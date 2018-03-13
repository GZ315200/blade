
#! /bin/bash

#find out the absolute path of the script when being executed
if cd "`dirname $0`"; then
    SCRIPT_PATH=${PWD}
    echo "[INFO] SCRIPT_PATH=${SCRIPT_PATH}"
    cd "${OLDPWD}" || exit 1
else
    echo "[ERROR] cannot find script folder path"
    exit 1
fi

. ${SCRIPT_PATH}/common-env.sh
LOG=${prop_log}
LOOP_COUNT=${prop_coun:-1000}
CONTENT=${prop_content}
LOG_FILE=${prop_log_file}
INTERVAL_COUNT=${prop_interval_count:-0}

if [ ! -d "${LOG}" ]
then 
    echo "${LOG} not found,create it"
    mkdir ${LOG}
    for ((i=1;i<=${LOOP_COUNT};i++));
    do
    mylog "${CONTENT} ${i}" >> ${LOG}/${LOG_FILE}
    mylog "${CONTENT} ${i}"
    sleep ${INTERVAL_COUNT}
    done 
    echo "finished"
    exit 0
else 
    echo "${LOG} found"
    for ((i=1;i<=${LOOP_COUNT};i++));
    do
    mylog "${CONTENT} ${i}" >> ${LOG}/${LOG_FILE}
    mylog "${CONTENT} ${i}"
    sleep ${INTERVAL_COUNT}
    done 
    echo "finished"
    exit 0
fi
