FROM ubuntu:latest
##su GIT Mancano i file binari(apache-tomcat-9.0.27.tar.gz e jdk-8u231-linux-x64.tar.gz) che devono essere scaricati e copiati a mano in questa directory
ENV TOMCAT_USER=tomcat \
    TOMCAT_PASSWORD=tomcat \
    TOMCAT_TAR_FILE=apache-tomcat-9.0.27.tar.gz \
    TOMCAT_DIR=/opt/tomcat \
	CATALINA_HOME=/opt/tomcat/apache-tomcat-9.0.27 \
	JAVA_DIR=/opt/java \
	JDK_TAR_FILE=jdk-8u231-linux-x64.tar.gz \
	JDK_HOME=jdk1.8.0_231

	
RUN apt-get update; \ 
    apt-get install apt-utils --assume-yes; \
    apt-get install openssl --assume-yes; \
    useradd -m -p $(openssl passwd -1 $TOMCAT_USER) $TOMCAT_PASSWORD; \
	mkdir $TOMCAT_DIR; \
	chown $TOMCAT_USER:$TOMCAT_USER $TOMCAT_DIR; \
	mkdir $JAVA_DIR; \
	chown $TOMCAT_USER:$TOMCAT_USER $JAVA_DIR
	
USER $TOMCAT_USER
WORKDIR $JAVA_DIR

COPY --chown=tomcat:tomcat $JDK_TAR_FILE $JAVA_DIR/
RUN tar -xzf $JDK_TAR_FILE

ENV JAVA_HOME $JAVA_DIR/$JDK_HOME
ENV PATH $JAVA_HOME/bin:$PATH

WORKDIR $TOMCAT_DIR

COPY --chown=tomcat:tomcat $TOMCAT_TAR_FILE $TOMCAT_DIR/
RUN tar -xzf $TOMCAT_TAR_FILE

	
WORKDIR $CATALINA_HOME

RUN rm bin/*.bat

EXPOSE 8080

CMD ["./bin/catalina.sh", "run"]