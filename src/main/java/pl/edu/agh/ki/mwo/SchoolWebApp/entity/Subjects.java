package pl.edu.agh.ki.mwo.SchoolWebApp.entity;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

@SuppressWarnings("serial")
@Entity
@Table(name = "subjects")
public class Subjects implements java.io.Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column
    private String name;

    @ManyToOne(fetch = FetchType.LAZY)
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "teacher_id",nullable=true)
    private Teacher teacher;

    public SchoolClass getSchoolClass() {
        return schoolClass;
    }

    public void setSchoolClass(SchoolClass schoolClass) {
        this.schoolClass = schoolClass;
    }

    @ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.MERGE, CascadeType.PERSIST,
            CascadeType.REFRESH })
    @NotFound(action = NotFoundAction.IGNORE)
    @JoinColumn(name = "class_id",nullable=true)
    private SchoolClass schoolClass;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Subjects() {
    }






    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }



}