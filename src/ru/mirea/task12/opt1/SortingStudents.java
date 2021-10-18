package ru.mirea.task12.opt1;

public class SortingStudents {
    public static void main(String[] args)  {
        Student[] students = {new Student(), new Student("\t20И0389"), new Student("\t20И1742"),
                new Student("\t20И0396"), new Student("\t20И0397"), new Student("\t20И0399"),
                new Student("\t20И0409"), new Student("\t20И0412"), new Student("\t20И0414"),
                new Student("\t20И1870"), new Student("\t20И0422"), new Student("\t20И1755"),
                new Student("\t20И0430"), new Student("\t20И2126"), new Student("\t20И0435"),
                new Student("\t20Л0200"), new Student("\t20И2132"), new Student("\t20И0444"),
                new Student("\t20И0448"), new Student("\t20И0853"), new Student("\t20И0457"),
                new Student("\t20И0460"), new Student("\t20И0464"), new Student("\t20И0467"),
                new Student("\t20И0470"), new Student("\t20И1250"), new Student("\t20И0485"),
                new Student("\t20И0486"), new Student("\t20И0491"), new Student("\t20Л0058"),
                new Student("\t20И1994")};

        String[] iDNumber = new String[31];
        for (int i = 0; i < iDNumber.length; i++)   {
            iDNumber[i] = students[i].getIDNumber();
        }

        for (int left = 0; left < iDNumber.length; left++) {
            String value = iDNumber[left];
            int i = left - 1;
            for (; i >= 0; i--) {
                if (value.compareTo(iDNumber[i]) < 0) {
                    iDNumber[i + 1] = iDNumber[i];
                } else {
                    break;
                }
            }
            iDNumber[i + 1] = value;
        }

        for (String iD: iDNumber) {
            System.out.println(iD);
        }
    }
}
