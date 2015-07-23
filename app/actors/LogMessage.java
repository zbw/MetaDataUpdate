package actors;

import java.io.Serializable;

/**
 * Created by Ott Konstantin on 03.06.2015.
 */
public class LogMessage implements Serializable {

    private String key;
    private String replacekey;
    private String value;
    private String pid;
    private String status;

    public LogMessage(String key, String replacekey, String value, String pid, String status) {
        this.key = key;
        this.value = value;
        this.pid = pid;
        this.status = status;
        this.replacekey = replacekey;
    }

    @Override
    public String toString() {
        return key+";"+replacekey+";"+value+";"+pid+";"+status;
    }
}
