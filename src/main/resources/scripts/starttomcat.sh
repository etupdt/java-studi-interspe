#!/bin/bash

log=/var/log/deploy/starttomcat

pwd > $log.loc
chmod 755 /tmp/starttomcat-aws.sh >> $log.loc

/tmp/starttomcat-aws.sh |& tee $log.log
