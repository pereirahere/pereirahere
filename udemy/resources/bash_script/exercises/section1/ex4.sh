#!/bin/bash 

#read -p "File/Directory to look for: " VAR1

VAR1=$1

if [ -f $VAR1 ]; then
echo $VAR1 is a file
fi

if [ -d $VAR1 ]; then
echo $VAR1 is a directory
ls $VAR1
fi
