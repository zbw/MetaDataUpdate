package actors;

import java.io.Serializable;
import java.util.Date;

/**
 * Created by Ott Konstantin on 02.06.2015.
 */
public class StatusMessage implements Serializable {

    private String type;
    private boolean exists;
    private int count;
    private int total;
    private String status;
    private boolean active;
    private String error;
    private Date started;
    private Date finished;

    public StatusMessage() {
        this.exists = true;
    }
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public boolean isExists() {
        return exists;
    }

    public void setExists(boolean exists) {
        this.exists = exists;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isActive() {
        return active;
    }

    public void setActive(boolean active) {
        this.active = active;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public Date getStarted() {
        return started;
    }

    public void setStarted(Date started) {
        this.started = started;
    }

    public Date getFinished() {
        return finished;
    }

    public void setFinished(Date finished) {
        this.finished = finished;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    @Override
    public String toString() {
        return "StatusMessage{" +
                "count=" + count +
                ", total=" + total +
                '}';
    }
}
