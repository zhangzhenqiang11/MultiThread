# MultiThread
深入浅出多线程
想深入研究多线程领域的各种技术要点难点的小伙伴，欢迎批评指正与学习交流，本人qq：1228681299。


记录下tomcat优化点：

优化1，禁用server.xml文件中的ajp
  <!-- Define an AJP 1.3 Connector on port 8009 -->
    <!--<Connector port="8009" protocol="AJP/1.3" redirectPort="8443" />-->
优化2， 将http通讯的bio改为nio
直接修改server.xml里的Connector节点,修改protocol为
<Connector port="8080" protocol="org.apache.coyote.http11.Http11NioProtocol"
               connectionTimeout="20000"
               redirectPort="8443" />
			   
3.启用线程池
<Executor name="tomcatThreadPool" namePrefix="catalina-exec-"
        maxThreads="300" minSpareThreads="4"/>
<Connector port="8080" protocol="org.apache.coyote.http11.Http11NioProtocol"
               connectionTimeout="20000"
			   executor="tomcatThreadPool"
               redirectPort="8443" />
4.修改最小初始现程数：minSpareThreads
http://www.cnblogs.com/sunxucool/archive/2013/07/31/3227366.html
maxThreads :Tomcat使用线程来处理接收的每个请求。这个值表示Tomcat可创建的最大的线程数。
acceptCount:指定当所有可以使用的处理请求的线程数都被使用时，可以放到处理队列中的请求数，超过这个数的请求将不予处理。
minSpareThreads:Tomcat初始化时创建的线程数。
maxSpareThreads:一旦创建的线程超过这个值，Tomcat就会关闭不再需要的socket线程。

http://blog.csdn.net/spider_zhcl/article/details/6167095


4.改变tomcat端口（3个）
http  port
ajp   port
redirectPort
https://wenku.baidu.com/view/23157ac16037ee06eff9aef8941ea76e58fa4a70.html?from=search
http://localhost:8080/docs/config/http.html
https://www.oschina.net/question/54100_16195
http://blog.csdn.net/albertfly/article/details/51494265

http://www.cnblogs.com/happy-rabbit/p/6232860.html


AVA_OPTS="-server -XX:PermSize=128M -XX:MaxPermSize=256M -Xms1024M -Xmx1024M -Xmn384M -XX:SurvivorRatio=8 -XX:+DisableExplicitGC -XX:+UseConcMarkSweepGC -XX:+UseParNewGC -XX:+UseCMSCompactAtFullCollection -XX:CMSFullGCsBeforeCompaction=10 -XX:+CMSClassUnloadingEnabled -XX:+CMSParallelRemarkEnabled -XX:+UseCMSInitiatingOccupancyOnly -XX:CMSInitiatingOccupancyFraction=70 -XX:TargetSurvivorRatio=90 -XX:MaxTenuringThreshold=15 -Dcom.sun.management.jmxremote -Dcom.sun.management.jmxremote.ssl=false -Dcom.sun.management.jmxremote.authenticate=true -Dcom.sun.management.jmxremote.password.file=../shared/conf/jmxremote.password -Dcom.sun.management.jmxremote.access.file=../shared/conf/jmxremote.access  -Djava.rmi.server.hostname=${tomcat_jmx_ip} -Dtomcat.working.group=${tomcat_group} -XX:-ReduceInitialCardMarks -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=${heap_bin} -XX:+PrintGCDetails -XX:+PrintGCDateStamps -Xloggc:${gc_log} -DThunderPort=${tomcat_thunder_port} -XX:MaxDirectMemorySize=128M"
