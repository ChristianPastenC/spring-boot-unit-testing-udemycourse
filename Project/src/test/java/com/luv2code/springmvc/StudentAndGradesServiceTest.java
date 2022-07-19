package com.luv2code.springmvc;

import com.luv2code.springmvc.models.CollegeStudent;
import com.luv2code.springmvc.models.HistoryGrade;
import com.luv2code.springmvc.models.MathGrade;
import com.luv2code.springmvc.models.ScienceGrade;
import com.luv2code.springmvc.repository.HistoryGradesDao;
import com.luv2code.springmvc.repository.MathGradesDao;
import com.luv2code.springmvc.repository.ScienceGradesDao;
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

     @Autowired
     private MathGradesDao mathGradeDao;

     @Autowired
     private ScienceGradesDao scienceGradeDao;

     @Autowired
     private HistoryGradesDao historyGradeDao;

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

    @Test
    public void createGradeService() {
         // Create the grade
        assertTrue(studentService.createGrade(80.50, 1, "math"));
        assertTrue(studentService.createGrade(80.50, 1, "science"));
        assertTrue(studentService.createGrade(80.50, 1, "history"));

        // Get all grades
        Iterable<MathGrade> mathGrades = mathGradeDao.findGradeByStudentId(1);
        Iterable<ScienceGrade> scienceGrades = scienceGradeDao.findGradeByStudentId(1);
        Iterable<HistoryGrade> historyGrades = historyGradeDao.findGradeByStudentId(1);

        // Verify there is grades
        assertTrue(mathGrades.iterator().hasNext(), "Student has math grades");
        assertTrue(scienceGrades.iterator().hasNext(), "Student has science grades");
        assertTrue(historyGrades.iterator().hasNext(), "Student has history grades");
    }

    @Test
    public void createGradeServiceReturnFalse() {
         assertFalse(studentService.createGrade(105, 1, "math"));
         assertFalse(studentService.createGrade(-5, 1, "math"));
         assertFalse(studentService.createGrade(80.50, 2, "math"));
         assertFalse(studentService.createGrade(80.50, 1, "Literature"));
    }

    @AfterEach
    public void setupAfterTransaction() {
         jdbc.execute("DELETE from student");
    }
}
