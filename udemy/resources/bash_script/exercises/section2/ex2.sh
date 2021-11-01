#!/bin/bash

cat /etc/shadow
EX_ST=$?

if [ $EX_ST -eq 0 ]; then
echo 'Command succeded'
exit 0
else
echo 'Command failed'
exit 1
fi
