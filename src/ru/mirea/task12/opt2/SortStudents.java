package ru.mirea.task12.opt2;

import ru.mirea.task12.opt1.Student;

public class SortStudents {
    public static void main(String[] args) {
        SortingStudentsByGPA sortingStudentsByGPA = new SortingStudentsByGPA();
        Student[] students = {new Student("Нечипоренко Олег", 3.9), new Student("Анна Лис", 4.6),
                new Student("Петр Преображенский", 4.2), new Student("Лиза Сомова", 4.4),
                new Student("Адиль Майер", 4.8), new Student("Станислав Шишкин", 4.7),
                new Student("Эмир Альд", 4.3), new Student("Михаил Круговой", 4.7),
                new Student("Игорь Конам", 5.0),  new Student("Яна Месте", 5.0),
                new Student("Никита Светов", 4.0), new Student("Павел Итл", 4.9)};

        students = sortingStudentsByGPA.quickSort(students, 0, students.length-1);
        for (Student student: students) {
            System.out.println(student.getName() + ": " + student.getGPA());
        }
    }
}
