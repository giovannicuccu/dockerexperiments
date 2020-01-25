FROM oracle/database:19.3.0-ee as base

ENV ORACLE_SID=ORCL \
    ORACLE_PDB=GIO \
	ORACLE_PWD=Giovanni72
	
USER oracle
WORKDIR /home/oracle

COPY --chown=oracle:dba createInstance.sh $ORACLE_BASE/
COPY --chown=oracle:dba startDBCustom.sh $ORACLE_BASE/
COPY --chown=oracle:dba *.sql $ORACLE_BASE/scripts/startup/

RUN $ORACLE_BASE/createInstance.sh

#RUN cp $ORACLE_HOME/dbs/init.ora $ORACLE_HOME/dbs/initORCL.ora
#FROM base
#USER oracle
CMD exec $ORACLE_BASE/startDBCustom.sh

