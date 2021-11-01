#!/bin/bash

FILE_PATH='/etc/shadow'

if [ -f "$FILE_PATH" ]; then
	echo "$FILE_PATH exists"
	if [ -w "$FILE_PATH" ]; then
		echo "and you have permissions to write on the file."
	elif [ ! -w "$FILE_PATH" ]; then
		echo "and you do not have permissions to write on the file."
	fi
elif [ ! -f "$FILE_PATH" ]; then
	echo "$FILE_PATH does not exist."
fi
