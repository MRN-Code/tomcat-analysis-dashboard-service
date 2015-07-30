# Create environment for axis build:
AXIS_HOME=/var/app/tomcat/webapps/webservices/WEB-INF
AXIS_LIB=$AXIS_HOME/lib
AXISCLASSPATH=$AXIS_LIB/axis.jar:$AXIS_LIB/commons-discovery.jar:$AXIS_LIB/commons-logging.jar:$AXIS_LIB/jaxrpc.jar:$AXIS_LIB/saaj.jar:$AXIS_LIB/log4j-1.2.8.jar:$AXIS_LIB/xml-apis.jar:$AXIS_LIB/xercesImpl.jar:$AXIS_LIB/wsdl4j.jar:$AXIS_LIB/ojdbc14.jar
CASTORCP=$AXIS_LIB/castor-0.9.5.4.jar:$AXIS_LIB/castor-0.9.5.4-xml.jar
export AXIS_HOME; export AXIS_LIB; export AXISCLASSPATH; export CASTORCP;

## Compile source for service
javac -classpath $AXISCLASSPATH:$CASTORCP:fibonacci:. fibonacci/*.java

## Build webservice skeleton
java -cp $AXISCLASSPATH:. org.apache.axis.wsdl.Java2WSDL -o fib.wsdl -l "http://jl/webservices/services/fibonacci" -n urn:fibonacci -p"fibonacci" urn:fibonacci fibonacci.Fibonacci

java -cp $AXISCLASSPATH:. org.apache.axis.wsdl.WSDL2Java -o . -d Session -s -S true -Nurn:fibonacci fibonacci.ws fib.wsdl

## At this point, edit *SoapBindingImpl.java file to link in proper implementation
javac -classpath $AXISCLASSPATH:$CASTORCP:. fibonacci/ws/*.java
cp -R fibonacci/* .

java -cp $AXISCLASSPATH:. org.apache.axis.client.AdminClient -lhttp://jl.mind.unm.edu/webservices/services fibonacci/ws/undeploy.wsdd
java -cp $AXISCLASSPATH:. org.apache.axis.client.AdminClient -lhttp://jl.mind.unm.edu/webservices/services fibonacci/ws/deploy.wsdd

/etc/init.d/tomcat stop
/etc/init.d/tomcat start
