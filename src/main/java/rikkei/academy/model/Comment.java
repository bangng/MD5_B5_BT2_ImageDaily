package rikkei.academy.model;

import org.hibernate.annotations.CreationTimestamp;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "comments")
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Integer rate;
    private String author;
    private String feedback;
    private Integer likeCount;
    @Temporal(TemporalType.DATE)
    @CreationTimestamp
    private Date date;

    public Comment() {
    }

    public Comment(Integer id, Integer rate, String author, String feedback, Integer likeCount, Date date) {
        this.id = id;
        this.rate = rate;
        this.author = author;
        this.feedback = feedback;
        this.likeCount = likeCount;
        this.date = date;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Integer getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }

    public Integer getLikeCount() {
        return likeCount;
    }

    public void setLikeCount(int likeCount) {
        this.likeCount = likeCount;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }




    @Override
    public String toString() {
        return "Comment{" +
                "id=" + id +
                ", rate=" + rate +
                ", author='" + author + '\'' +
                ", feedback='" + feedback + '\'' +
                ", likeCount=" + likeCount +
                ", date=" + date +
                '}';
    }
}