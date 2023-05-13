#!/bin/bash

log=/var/log/deploy/restarttomcat

pwd > $log.loc
chmod 755 /tmp/restarttomcat-aws.sh >> $log.loc

/tmp/restarttomcat-aws.sh |& tee -a $log.log
