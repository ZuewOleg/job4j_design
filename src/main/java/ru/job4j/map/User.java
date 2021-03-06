package ru.job4j.map;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Objects;

public class User {
    private String name;
    private int children;
    private Calendar birthday = new GregorianCalendar(Calendar.YEAR, Calendar.MONTH,
            Calendar.DAY_OF_MONTH, Calendar.HOUR_OF_DAY, Calendar.MINUTE, Calendar.SECOND);

    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getChildren() {
        return children;
    }

    public void setChildren(int children) {
        this.children = children;
    }

    public Calendar getBirthday() {
        return birthday;
    }

    public void setBirthday(Calendar birthday) {
        this.birthday = birthday;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || o.getClass() != this.getClass()) {
            return false;
        }
        User user = (User) o;
        return children == user.children
                && (name == user.name
                || (name != null && name.equals(user.getName())))
                && (birthday == user.birthday
                || (birthday != null && birthday.equals(user.getBirthday())));
    }

    @Override
    public int hashCode() {
        int rsl = 1;
        rsl = 31 * rsl + name.hashCode();
        rsl = 31 * rsl + children;
        rsl = 31 * rsl + birthday.hashCode();
        return rsl;
    }

    @Override
    public String toString() {
        return "User{"
                + "name='" + name + '\''
                + ", children=" + children
                + ", birthday=" + birthday
                + '}';
    }
}
