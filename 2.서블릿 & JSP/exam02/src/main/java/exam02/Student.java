package exam02;

import java.util.Objects;

public class Student {
    private int id;
    private String name;
    private String subject;

    public Student(){
        //객체 생성 이후에 실행
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", subject='" + subject + '\'' +
                '}';
    }

    public Student(int id, String name, String subject) {
        this.id = id;
        this.name = name;
        this.subject = subject;
    }

    public int hashCode() {
        return Objects.hash(id, name, subject);
    }

    @Override
    public boolean equals(Object obj) {
        Student s2 = (Student)obj;
        if( id== s2.id && name.equals(s2.name)&& subject.equals(s2.subject)) {
            return true;
        }
    return false ;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }
}
