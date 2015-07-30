# Create environment for axis build:
echo " Create environment for axis build:"
AXIS_HOME=/opt/tomcat6/webapps/webservices/WEB-INF
AXIS_LIB=$AXIS_HOME/lib
#NEW_LIB=/var/app/tomcat5/shared/lib

AXISCLASSPATH=$AXIS_LIB:$AXIS_LIB/axis.jar:$AXIS_LIB/commons-discovery.jar:$AXIS_LIB/commons-logging.jar:$AXIS_LIB/jaxrpc.jar:$AXIS_LIB/saaj.jar:$AXIS_LIB/log4j-1.2.8.jar:$AXIS_LIB/xml-apis.jar:$AXIS_LIB/xercesImpl.jar:$AXIS_LIB/wsdl4j.jar:$AXIS_LIB/postgresql-jdbc.jar:$AXIS_LIB/activation.jar
#AXISCLASSPATH=$AXIS_LIB/axis.jar:$AXIS_LIB/commons-discovery.jar:$AXIS_LIB/commons-logging.jar:$AXIS_LIB/jaxrpc.jar:$AXIS_LIB/saaj.jar:$AXIS_LIB/log4j-1.2.8.jar:$AXIS_LIB/xml-apis.jar:$AXIS_LIB/xercesImpl.jar:$AXIS_LIB/wsdl4j.jar:$AXIS_LIB/ojdbc14.jar
CASTORCP=$AXIS_LIB/castor-0.9.5.4.jar:$AXIS_LIB/castor-0.9.5.4-xml.jar
export AXIS_HOME; export AXIS_LIB; export AXISCLASSPATH; export CASTORCP;

## Compile source for service
echo "Compiling source"
rm dbutils/*.class
javac -classpath $AXISCLASSPATH:$CASTORCP:dbutils:. dbutils/*.java


## Build webservice skeleton
echo "Building webservice skeleton"
java -cp $AXISCLASSPATH:. org.apache.axis.wsdl.Java2WSDL -o dbutils.wsdl -l "http://localhost/webservices/services/dbutils" -n urn:dbutils -p"dbutils" urn:dbutils dbutils.DBService
java -cp $AXISCLASSPATH:. org.apache.axis.wsdl.WSDL2Java -o . -d Session -s -S true -Nurn:dbutils dbutils.ws dbutils.wsdl

## At this point, edit *SoapBindingImpl.java file to link in proper implementation
echo "Compiling generated SOAP classes."
javac -source 1.4 -classpath $AXISCLASSPATH:$CASTORCP:. dbutils/ws/*.java
#
echo "Copying classes"
cp -R dbutils/* .

# Compile AdminClient
echo "Compiling AdminClient"
javac -classpath $AXISCLASSPATH:. AdminClient.java 

# Undeploy old webservice details
echo "Undeploying old webservice details"
java -cp $AXISCLASSPATH:. AdminClient -lhttps://admin:admin@localhost:8443/webservices/services /opt/tomcat6/webapps/webservices/WEB-INF/classes/dbutils/ws/undeploy.wsdd

# Deploy new webservice details
echo "Deploying New webservice details"
java -cp $AXISCLASSPATH:. AdminClient -lhttps://admin:admin@localhost:8443/webservices/services /opt/tomcat6/webapps/webservices/WEB-INF/classes/dbutils/ws/deploy.wsdd

#echo "Restarting tomcat"
sudo /etc/init.d/tomcat6 stop
sudo /etc/init.d/tomcat6 start

