package com.igeek.bean;

import com.google.common.base.MoreObjects;

/**
 * @author Gyges Zean
 * @date 2018/1/31
 */
public class Message {

    private String sink;

    private String source;

    public Message() {
    }

    public Message(String sink, String source) {
        this.sink = sink;
        this.source = source;
    }

    public String getSink() {
        return sink;
    }

    public void setSink(String sink) {
        this.sink = sink;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    @Override
    public String toString() {
        return MoreObjects.toStringHelper(this)
                .add("sink", sink)
                .add("source", source)
                .toString();
    }
}
