package ru.mirea.task12.opt3;

import ru.mirea.task12.opt1.Student;

public class MultipleDataSorting {
    public static void main(String[] args)  {
        Student[] students = {new Student("\t20И0389","Нечипоренко Олег", 4.6), new Student("\t20И1742","Анна Лис", 4.6),
                new Student("\t20И0396","Петр Преображенский", 4.2), new Student("\t20И0397","Лиза Сомова", 4.2),
                new Student("\t20И0399","Адиль Майер", 4.8), new Student("\t20И0409","Станислав Шишкин", 4.8),
                new Student("\t20И0412","Эмир Альд", 4.3), new Student("\t20И0414","Михаил Круговой", 4.8),
                new Student("\t20И1870","Игорь Конам", 5.0),  new Student("\t20И0422","Яна Месте", 5.0),
                new Student("\t20И1755","Никита Светов", 4.9), new Student("\t20И0430","Павел Итл", 4.9)};
        students = mergeSort(students);
        for (Student student: students) {
            System.out.println(student.getIDNumber() + ": " + student.getGPA());
        }
    }

    public static Student[] mergeSort(Student[] students)   { // сортировка Массива который передается в функцию
        if (students.length < 2)    {
            return students;
        }

        int mid = students.length / 2;
        Student[] l = new Student[mid];
        Student[] r = new Student[students.length - mid];

        for (int i = 0; i < mid; i++) {
            l[i] = students[i];
        }
        for (int i = mid; i < students.length; i++) {
            r[i - mid] = students[i];
        }
        l = mergeSort(l);
        r = mergeSort(r);

        students = merge(students, l, r, mid, students.length - mid);
        return students;
    }

    public static Student[] merge(Student[] students, Student[] l, Student[] r, int left, int right) {
        int i = 0, j = 0, k = 0;
        while (i < left && j < right) {
            if (compareTo(l[i], r[j]) <= 0) {
                students[k++] = l[i++];
            }
            else {
                students[k++] = r[j++];
            }
        }
        while (i < left) {
            students[k++] = l[i++];
        }
        while (j < right) {
            students[k++] = r[j++];
        }
        return students;
    }

    public static int compareTo(Student o1, Student o2) {
        if (o1.getGPA().toString().compareTo(o2.getGPA().toString()) == 0) {
            return (o1.getIDNumber().compareTo(o2.getIDNumber()));
        } else  {
            return (-o1.getGPA().toString().compareTo(o2.getGPA().toString()));
        }
    }
}
