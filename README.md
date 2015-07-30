# tomcat-analysis-dashboard-service
File-serving webservice consumed by portal analysis dashboard

# About
The analysis dashboard requires metadata about files which are located on
internal network storage. This storage cannot be accessed by the server
which serves the analysis dashboard (Portal), because it is in the DMZ, and
is not allowed direct access to internal network storage.

This tomcat service runs on an internal network server (chronus ATM), and
allows the dashboard service on portal to request data contained on internal
network storage safely.

# Usage

1. Install tomcat7 (see ansible role)
1. `cp -r src /var/lib/tomcat7/webapps/webservices`
1. `chown -r tomcat7 /var/lib/tomcat7/webapps/webservices`
1. (re)start tomcat

# For further questions, ask Runtang :-)
