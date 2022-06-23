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
import org.springframework.test.context.jdbc.Sql;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    @Test
    public void deleteStudentService(){
         Optional<CollegeStudent> deletedCollegeStudent = studentDao.findById(1);

         assertTrue(deletedCollegeStudent.isPresent(), "Return True");

         studentService.deleteStudent(1);

         deletedCollegeStudent = studentDao.findById(1);

         assertFalse(deletedCollegeStudent.isPresent(), "Return false");
    }

    @Sql("/insertData.sql")
    @Test
    public void getGradebookService() {
         Iterable<CollegeStudent> iterableCollegeStudent = studentService.getGradebook();

         List<CollegeStudent> collegeStudents = new ArrayList<>();

         for (CollegeStudent collegeStudent : iterableCollegeStudent) {
             collegeStudents.add(collegeStudent);
         }

         assertEquals(5, collegeStudents.size());
    }

    @AfterEach
    public void setupAfterTransaction() {
         jdbc.execute("DELETE from student");
    }
}