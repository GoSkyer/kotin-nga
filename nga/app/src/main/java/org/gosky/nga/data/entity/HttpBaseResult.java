package org.gosky.nga.data.entity;

/**
 * Created by hunji on 2016/9/1.
 * desc:
 */
public class HttpBaseResult<T> {

    /**
     * server_time : 1477284985
     * success : true
     * message :
     * data :
     */

    private int server_time;
    private boolean success;
    private String message;
    private T data;

    public int getServer_time() {
        return server_time;
    }

    public void setServer_time(int server_time) {
        this.server_time = server_time;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
