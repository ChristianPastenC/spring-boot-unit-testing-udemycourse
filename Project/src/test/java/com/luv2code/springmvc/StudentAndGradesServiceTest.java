package com.luv2code.springmvc;

import com.luv2code.springmvc.models.CollegeStudent;
import com.luv2code.springmvc.repository.StudentDao;
import com.luv2code.springmvc.service.StudentAndGradeService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.assertEquals;

@TestPropertySource("/application.properties")
@SpringBootTest
public class StudentAndGradesServiceTest {
    @Autowired
    private StudentAndGradeService studentService;

     @Autowired
     private StudentDao studentDao;

    @Test
    public void createStudentService(){
        studentService.createStudent(
                "Christian",
                "Pasten",
                "christian_pasten@outlook.com"
        );

         CollegeStudent student = studentDao.findByEmailAddress(
                 "christian_pasten@outlook.com"
         );

         assertEquals(
                 "christian_pasten@outlook.com",
                 student.getEmailAddress(),
                 "find by email"
         );
    }
}
