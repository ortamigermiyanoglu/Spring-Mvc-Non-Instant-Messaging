package com.sumutella.noninstantmessaging.entities;

import javax.persistence.*;
import java.sql.Date;

/**
 * @author sumutella
 * @time 5:09 PM
 * @since 11/21/2019, Thu
 */
@Entity
@Table(name = "messages")
public class Message {

    @Id
    @SequenceGenerator(name = "seqMessage", sequenceName = "MESSAGES_SEQ", allocationSize = 1)
    @GeneratedValue(generator = "seqMessage", strategy = GenerationType.SEQUENCE)
    private int id;
    @ManyToOne
    @JoinColumn(name = "sender")
    private User sender;
    @ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.MERGE,
            CascadeType.DETACH, CascadeType.REFRESH})
    @JoinColumn(name = "receiver")
    private User receiver;
    private String content;
    private Date sent;

    public Message() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public User getSender() {
        return sender;
    }

    public void setSender(User sender) {
        this.sender = sender;
    }

    public User getReceiver() {
        return receiver;
    }

    public void setReceiver(User receiver) {
        this.receiver = receiver;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getSent() {
        return sent;
    }

    public void setSent(Date sent) {
        this.sent = sent;
    }
}
