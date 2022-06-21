package com.luv2code.springmvc;

import com.luv2code.springmvc.models.CollegeStudent;
import com.luv2code.springmvc.repository.StudentDao;
import com.luv2code.springmvc.service.StudentAndGradeService;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.test.context.TestPropertySource;

import static org.junit.jupiter.api.Assertions.*;

@TestPropertySource("/application.properties")
@SpringBootTest
public class StudentAndGradesServiceTest {

    @Autowired
    private JdbcTemplate jdbc;

    @Autowired
    private StudentAndGradeService studentService;

     @Autowired
     private StudentDao studentDao;

     @BeforeEach
     public void setupDatabase(){
         jdbc.execute("insert into student(id, firstname, lastname, email_address)" +
                 "values (1, 'Christian', 'Pasten', 'christian_pasten@outlook.com')");
     }

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

    @Test
    public void isStudentNullCheck(){
        assertTrue(studentService.checkIfStudentIsNull(1));

        assertFalse(studentService.checkIfStudentIsNull(0 ));
    }

    @AfterEach
    public void setupAfterTransaction() {
         jdbc.execute("DELETE from student");
    }
}
