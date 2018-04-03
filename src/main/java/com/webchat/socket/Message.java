package com.webchat.socket;


import java.io.Serializable;

public class Message implements Serializable{
    private String isGroup;//1.group 2.personal
    private String groupId;
    private String toPersistId;
    private String toTmpId;
    private String content;
}