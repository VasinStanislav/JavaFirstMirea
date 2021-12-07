package ru.mirea.task23;

import ru.mirea.task12.opt1.Student;

public class HBEStudent extends Student {
    public HBEStudent(String iDNumber, String name, Double gPA) {
        super(iDNumber, name, gPA);
    }

    @Override
    public int hashCode()   {
        int result = getName() == null ? 0 : getName().hashCode();
        result = getIDNumber() == null ? 0 : 31*result + getIDNumber().hashCode();
        result = (getGPA() < 2 || getGPA() > 5) ? 0 : (int) (31 * result + getGPA());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        HBEStudent that = (HBEStudent) obj;
        String str = getName() + getIDNumber() + getGPA();
        String thatStr = that.getName() + that.getIDNumber() + that.getGPA();
        return str.equals(thatStr);
    }
}
