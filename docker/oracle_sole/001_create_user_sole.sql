alter session set container=gio;
create tablespace sole_tbs datafile '/opt/oracle/oradata/ORCL/sole01.dbf' size 200M;
create user sole identified by prova_1 default tablespace sole_tbs;
grant connect,resource to sole;
alter user sole quota unlimited on sole_tbs;