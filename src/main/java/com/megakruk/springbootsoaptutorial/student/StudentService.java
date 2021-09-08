package com.megakruk.springbootsoaptutorial.student;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

@Service
public class StudentService {

    private List<Student> students;
    private static final Supplier<Throwable> supplier = () -> new RuntimeException("Nothing found");

        public Student getStudentById(Long id) throws Throwable {
            return students.stream()
                    .filter(student -> student.getId() == id)
                    .findFirst().orElseThrow(supplier);
    }

    public StudentService() {

        students = new ArrayList<>();

        Student student1 = new Student();
        student1.setId(1);
        student1.setName("Adam");
        student1.setSurname("Smith");

        Student student2 = new Student();
        student2.setId(2);
        student2.setName("David");
        student2.setSurname("Baker");

        students.add(student1);
        students.add(student2);
    }
}
