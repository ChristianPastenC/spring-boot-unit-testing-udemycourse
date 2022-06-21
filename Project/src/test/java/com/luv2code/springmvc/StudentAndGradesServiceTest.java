package com.luv2code.springmvc;

import com.luv2code.springmvc.models.CollegeStudent;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

@TestPropertySource("/application.properties")
@SpringBootTest
public class StudentAndGradesServiceTest {

    @Test
    public void createStudentService(){
        //studentService.createStudent("Christian", "Pasten", "christian_pasten@outlook.com");

        // CollegeStudent student = studentDao.findByEmailAddress("christian_pasten@outlook.com");

        // assertEquals("christian_pasten@outlook.com", student.getEmailAddress(), "find by email");
    }
}
