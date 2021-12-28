#!/bin/bash

ARG1=$1
CMDS=("--help" "--setup" "--log")

CATEGORIES=$'1: CSTT-1  - Cluster Projects\n2: CSTT-1  - Department Wide\n3: CSTT-2  - Presales\n4: CSTT-3  - Company Wide\n5: CSTT-4  - Recruiting\n6: CSTT-6  - PTO\n7: CSTT-7  - Support\n8: CSTT-8  - Support Extra\n9: CSTT-11 - Training'
ISSUES=""
FROM=""
TO=""
DATE=$(date +"%Y-%m-%d")

# JIRA RELATED FUNCTIONS
function log_time() {
  jira log_time $@
}

function log_department() {
  log_time $@ --category "CS-InternalTasks" CSTT-1
}

function log_presales() {
  log_time $@ --category "CS-InternalTasks" CSTT-2
}

function log_company() {
  log_time $@ --category "CS-InternalTasks" CSTT-3
}

function log_recruiting() {
  log_time $@ --category "CS-InternalTasks" CSTT-4
}

function log_pto() {
  log_time --from 9 --to 17 $@ --category "CS-InternalTasks" CSTT-6
}

function log_support() {
  log_time $@ --category "CS-InternalTasks" CSTT-7
}

function log_support_extra() {
  log_time $@ --category "CS-InternalTasks" CSTT-8
}

function log_training() {
  log_time $@ --category "CS-InternalTasks" CSTT-11
}

function log_project() {
  log_time $@ PROJECT-1
}

# example of split ceremonies in 3 different projects
function log_status() {
  date="${1}"

  jira log_cluster --from "${date} 10:00" --to "${date} 10:30" --category "CS-ProjectGovernance"
}

# BUSINESS LOGIC
function cmd_reader() {
  case $ARG1 in
  ${CMDS[0]})
    echo "TODO: help menu"
    ;;
  ${CMDS[1]})
    echo "TODO: setup menu"
    ;;
  ${CMDS[2]})
    prompt
    ;;
  *)
    echo 'Tempo script needs an argument, try one of these:'
    for i in ${CMDS[@]}; do
      echo $i
    done
    ;;
  esac
}

pick_category() {

  while [[ ! $CATEGORY =~ ^[1-9]$ ]]; do
    read -p "Category: " -n 1 -r CATEGORY
    echo # NEW LINE

    if [[ ! $CATEGORY =~ ^[1-9]$ ]]; then
      echo "Not a valid option."
      echo # NEW LINE
    fi
  done

}

pick_date() {

  while [[ ! $REPLY =~ ^[YyNn]$ ]]; do
    read -p "Logging today? (Yy/Nn)" -n 1 -r
    echo # NEW LINE

    if [[ ! $REPLY =~ ^[YyNn]$ ]]; then
      echo "Not a valid option."
      echo # NEW LINE
    fi
  done

  if [[ $REPLY == [Nn] ]]; then

    while [[ ! $REPLY =~ ^[1-9]{4}-[1-9]{2}-[1-9]{2}$ ]]; do
      read -p "Define a date (yyyy-mm-dd)" -n 10 -r
      echo # NEW LINE

      if [[ ! $REPLY =~ ^[1-9]{4}-[1-9]{2}-[1-9]{2}$ ]]; then
        echo 'Wrong date format'
        echo # NEW LINE
      fi
    done

    DATE=$REPLY

  fi

  echo # NEW LINE
  echo "Logging time at this date: $DATE"

}

function pick_time_interval() {

  while [[ ! $REPLY =~ ^[0-9]{2}:[0-9]{2}$ ]]; do
    read -p "Logging from? (hh:mm)" -n 5 -r
    echo # NEW LINE

    if [[ ! $REPLY =~ ^[0-9]{2}:[0-9]{2}$ ]]; then
      echo "Not a valid option."
      echo # NEW LINE
    fi
  done

  FROM=$REPLY
  REPLY=""

  while [[ ! $REPLY =~ ^[0-9]{2}:[0-9]{2}$ ]]; do
    read -p "Logging from? (hh:mm)" -n 5 -r
    echo # NEW LINE

    if [[ ! $REPLY =~ ^[0-9]{2}:[0-9]{2}$ ]]; then
      echo "Not a valid option."
      echo # NEW LINE
    fi
  done

  TO=$REPLY

  echo # NEW LINE
  echo "Logging from $FROM to $TO"

}

function prompt() {

  echo 'Choose a category: '
  echo "$CATEGORIES"
  echo # NEW LINE

  pick_category
  echo # NEW LINE
  pick_date
  echo # NEW LINE
  pick_time_interval

}

cmd_reader
