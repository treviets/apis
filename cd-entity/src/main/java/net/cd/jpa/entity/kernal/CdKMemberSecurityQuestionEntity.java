package net.cd.jpa.entity.kernal;

import javax.persistence.*;
import java.sql.Timestamp;

/**
 * Created by Vincent on 05/12/2017.
 */
@Entity
@Table(name = "cd_kMemberSecurityQuestion")
public class CdKMemberSecurityQuestionEntity {

    private Integer id;
    private String reference;
    private Integer member;
    private Integer index;
    private String question;
    private String answer;
    private Timestamp made;
    private Timestamp revised;
    private Timestamp purged;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    @Basic
    @Column(name = "reference")
    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    @Basic
    @Column(name = "member")
    public Integer getMember() {
        return member;
    }

    public void setMember(Integer member) {
        this.member = member;
    }

    @Basic
    @Column(name = "index")
    public Integer getIndex() {
        return index;
    }

    public void setIndex(Integer index) {
        this.index = index;
    }

    
    @Column(name = "question")
    public String getQuestion() {
        return question;
    }

    public void setQuestion(String question) {
        this.question = question;
    }

    
    @Column(name = "answer")
    public String getAnswer() {
        return answer;
    }

    public void setAnswer(String answer) {
        this.answer = answer;
    }

    @Basic
    @Column(name = "made")
    public Timestamp getMade() {
        return made;
    }

    public void setMade(Timestamp made) {
        this.made = made;
    }

    @Basic
    @Column(name = "revised")
    public Timestamp getRevised() {
        return revised;
    }

    public void setRevised(Timestamp revised) {
        this.revised = revised;
    }

    @Basic
    @Column(name = "purged")
    public Timestamp getPurged() {
        return purged;
    }

    public void setPurged(Timestamp purged) {
        this.purged = purged;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }

        CdKMemberSecurityQuestionEntity that = (CdKMemberSecurityQuestionEntity) o;

        if (id != null ? !id.equals(that.id) : that.id != null) {
            return false;
        }
        if (reference != null ? !reference.equals(that.reference) : that.reference != null) {
            return false;
        }
        if (member != null ? !member.equals(that.member) : that.member != null) {
            return false;
        }
        if (index != null ? !index.equals(that.index) : that.index != null) {
            return false;
        }
        if (question != null ? !question.equals(that.question) : that.question != null) {
            return false;
        }
        if (answer != null ? !answer.equals(that.answer) : that.answer != null) {
            return false;
        }
        if (made != null ? !made.equals(that.made) : that.made != null) {
            return false;
        }
        if (revised != null ? !revised.equals(that.revised) : that.revised != null) {
            return false;
        }
        if (purged != null ? !purged.equals(that.purged) : that.purged != null) {
            return false;
        }

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (reference != null ? reference.hashCode() : 0);
        result = 31 * result + (member != null ? member.hashCode() : 0);
        result = 31 * result + (index != null ? index.hashCode() : 0);
        result = 31 * result + (question != null ? question.hashCode() : 0);
        result = 31 * result + (answer != null ? answer.hashCode() : 0);
        result = 31 * result + (made != null ? made.hashCode() : 0);
        result = 31 * result + (revised != null ? revised.hashCode() : 0);
        result = 31 * result + (purged != null ? purged.hashCode() : 0);
        return result;
    }
}
