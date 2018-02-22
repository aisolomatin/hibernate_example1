package ru.solomatin.hibernate.example1.entity;

import javax.persistence.*;

/**
 * Created by lesha on 14.02.2018.
 */
@Entity
@Table(name = "people")
public class PeopleEntity {
    private long peopleId;
    private String name;
    private String surname;
    private String patronymic;

    @Id
    @Column(name = "people_id", nullable = false)
    public long getPeopleId() {
        return peopleId;
    }

    public void setPeopleId(long peopleId) {
        this.peopleId = peopleId;
    }

    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "surname", nullable = true, length = 255)
    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    @Column(name = "patronymic", nullable = true, length = 255)
    public String getPatronymic() {
        return patronymic;
    }

    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    @Override
    // сгенерировано IDE, пока оставляем без изменений
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        PeopleEntity that = (PeopleEntity) o;

        if (peopleId != that.peopleId) return false;
        if (name != null ? !name.equals(that.name) : that.name != null) return false;
        if (surname != null ? !surname.equals(that.surname) : that.surname != null) return false;
        if (patronymic != null ? !patronymic.equals(that.patronymic) : that.patronymic != null) return false;

        return true;
    }

    @Override
    // сгенерировано IDE, пока оставляем без изменений
    public int hashCode() {
        int result = (int) (peopleId ^ (peopleId >>> 32));
        result = 31 * result + (name != null ? name.hashCode() : 0);
        result = 31 * result + (surname != null ? surname.hashCode() : 0);
        result = 31 * result + (patronymic != null ? patronymic.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "People(peopleId=" + peopleId + ",name=" + (name != null ? name : "") + ",surname=" + (surname != null ? surname : "") + ",patronymic=" + (patronymic != null ? patronymic : "") + ")";
    }

}
