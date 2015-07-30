# Create environment for axis build:
AXIS_HOME=/var/app/tomcat/webapps/webservices/WEB-INF
AXIS_LIB=$AXIS_HOME/lib
AXISCLASSPATH=$AXIS_LIB/axis.jar:$AXIS_LIB/commons-discovery.jar:$AXIS_LIB/commons-logging.jar:$AXIS_LIB/jaxrpc.jar:$AXIS_LIB/saaj.jar:$AXIS_LIB/log4j-1.2.8.jar:$AXIS_LIB/xml-apis.jar:$AXIS_LIB/xercesImpl.jar:$AXIS_LIB/wsdl4j.jar:$AXIS_LIB/ojdbc14.jar
CASTORCP=$AXIS_LIB/castor-0.9.5.4.jar:$AXIS_LIB/castor-0.9.5.4-xml.jar
export AXIS_HOME; export AXIS_LIB; export AXISCLASSPATH; export CASTORCP;

## Compile source for service
javac -classpath $AXISCLASSPATH:calculator:. calculator/*.java

# Use Java2WSDL to generate wsdl file
java -cp $AXISCLASSPATH:. org.apache.axis.wsdl.Java2WSDL -o calc.wsdl -l
"http://jl/webservices/services/calculator" -n urn:calculator -p"calculator" urn:calculator calculator.Calculator

# Use WSDL2Java to generate server side wrapper classes and client side stubs
java -cp $AXISCLASSPATH:. org.apache.axis.wsdl.WSDL2Java -o . -d Session -s -p calculator.ws calc.wsdl

# At this point, edit *SoapBindingImpl.java file to link in proper implementation
#javac -classpath $AXISCLASSPATH:$CASTORCP:. calculator/ws/*.java

#cp -R calculator/* .

#java -cp $AXISCLASSPATH:. org.apache.axis.client.AdminClient -lhttp://jl.mind.unm.edu/webservices/services calculator/ws/deploy.wsdd
