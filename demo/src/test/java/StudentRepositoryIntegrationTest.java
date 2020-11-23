import com.example.demo.entity.Address;
import com.example.demo.entity.Internship;
import com.example.demo.entity.Student;
import com.example.demo.repository.StudentRepository;
import com.example.demo.service.StudentService;
import org.hamcrest.collection.IsEmptyCollection;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.sql.Timestamp;
import java.util.List;

import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.MatcherAssert.assertThat;

@RunWith(SpringRunner.class)
@DataJpaTest
@ActiveProfiles("test")
public class StudentRepositoryIntegrationTest {

    @MockBean
    private StudentRepository studentRepository;

    @MockBean
    private StudentService studentService;

    @Test
    public void getAllStudentsTest() {
        List<Student> students = studentRepository.findAll();
        assertThat(students, IsEmptyCollection.empty());
    }

    @Test
    public void testAddNewStudent() {
        Student student = new Student();
        Timestamp date = new Timestamp(3281);
        student.setName("Beatrice");
        student.setSurname("Ciuta");
        student.setFaculty("FEAA");
        student.setBirthDate(date);
        student.setEmail("beatrice@gmail.com");
        student.setPassword("test1234");
        student.setPhoneNumber("39812721");
        studentService.insertWithEntityManager(student);
        List<Student> students = studentRepository.findAll();
        assertThat(students, not(IsEmptyCollection.empty()));
    }
}
