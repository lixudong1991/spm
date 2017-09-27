package cn.lxd.entity;

/**
 * Created by Tomcat on 2017/9/25.
 */
public class Logstatus {
    boolean logsuccess;
    String logmessage;

    public boolean isLogsuccess() {
        return logsuccess;
    }

    public void setLogsuccess(boolean logsuccess) {
        this.logsuccess = logsuccess;
    }

    public String getLogmessage() {
        return logmessage;
    }

    public void setLogmessage(String logmessage) {
        this.logmessage = logmessage;
    }
}
