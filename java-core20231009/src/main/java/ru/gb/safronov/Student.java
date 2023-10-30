package ru.gb.safronov;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Student {
    private String name;
    private List<Double> grades;
    private String specialty;

    public Student(String name, List<Double> grades, String specialty) {
        this.name = name;
        this.grades = grades;
        this.specialty = specialty;
    }

    public double getAverageGrade() {
        return grades.stream().mapToDouble(Double::doubleValue).average().orElse(0.0);
    }

    public String getSpecialty() {
        return specialty;
    }

    public static void main(String[] args) {
        List<Student> students = Arrays.asList(
                new Student("Alina", Arrays.asList(4.5, 4.0, 5.0), "Mathematics"),
                new Student("Roman", Arrays.asList(5.0, 4.7, 4.8), "Informatics"),
                new Student("Denis", Arrays.asList(4.5, 4.6, 4.7), "Informatics"),
                new Student("Dmitry", Arrays.asList(4.9, 5.0, 5.0), "Informatics"),
                new Student("Elizaveta", Arrays.asList(4.2, 4.3, 4.1), "Physics"),
                new Student("Olga", Arrays.asList(4.6, 4.7, 4.8), "Informatics"),
                new Student("Yana", Arrays.asList(4.8, 5.0, 4.9), "Informatics")
        );

        List<Student> result = students.stream()
                .filter(s -> "Informatics".equals(s.getSpecialty()))
                .filter(s -> s.getAverageGrade() > 4.5)
                .sorted((s1, s2) -> Double.compare(s2.getAverageGrade(), s1.getAverageGrade()))
                .limit(5)
                .collect(Collectors.toList());

        result.forEach(s -> System.out.println(s.name + " - " + s.getAverageGrade()));
    }
}