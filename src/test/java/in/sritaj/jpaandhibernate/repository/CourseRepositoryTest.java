package in.sritaj.jpaandhibernate.repository;

import com.github.javafaker.Faker;
import in.sritaj.jpaandhibernate.entity.Course;
import org.junit.jupiter.api.Assertions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.testng.AbstractTestNGSpringContextTests;
import org.testng.annotations.Test;

@SpringBootTest
public class CourseRepositoryTest extends AbstractTestNGSpringContextTests {

    @Autowired
    CourseRepository courseRepository;

    Faker fs = new Faker();

    @Test(testName = "Validate findBy returns the specified course when the ID exists")
    public void validateFindByIDFetchesTheSpecifiedCourse() {
        Course course = courseRepository.findById(18999L);

        Assertions.assertNotNull(course);
        Assertions.assertEquals("Geography", course.getCourseName());
    }

    @Test(testName = "Validate findBy returns the specified course when the ID doesn't exist")
    public void validateFindByIDWhenTheIDDoesntExist() {
        Course course = courseRepository.findById(64738474L);

        Assertions.assertNull(course);
    }

    @Test(testName = "Validate Delete removes the specified course when the ID exists")
    public void validateDeletionOfTheSpecifiedCourse() {
        String actualMessage = courseRepository.deleteCourse(18999L);

        Assertions.assertEquals("Course removed", actualMessage);
    }

    @DirtiesContext
    @Test(testName = "Validate Delete returns the proper error msg when the ID doesn't exist")
    public void validateDeletionWhenTheIDDoesntExist() {
        Long id = 64738474L;
        String actualMessage = courseRepository.deleteCourse(id);

        Assertions.assertEquals("Can't find Course for ID " + id, actualMessage);
    }

    @Test(testName = "Validate Saving new courses")
    public void validateSaveForCreatingNewCourse() {
        String courseName = fs.book().title();
        Course course = courseRepository.save(new Course(courseName));

        Assertions.assertNotNull(course);
        Assertions.assertEquals(courseName, course.getCourseName());
    }

    @Test(testName = "Validate Updation of existing courses")
    public void validateSaveForUpdatingExistingCourse() {
        String courseName = fs.book().title();
        String updatedCourseName = fs.book().title();
        Course course = courseRepository.save(new Course(courseName));

        Assertions.assertNotNull(course);
        Assertions.assertEquals(courseName, course.getCourseName());

        course.setCourseName(updatedCourseName);
        Course updatedCourse = courseRepository.save(course);

        Assertions.assertNotNull(updatedCourse);
        Assertions.assertEquals(updatedCourseName, updatedCourse.getCourseName());

    }

    @Test(testName = "Validate Saving new courses with nullable value", expectedExceptions = DataIntegrityViolationException.class)
    public void validateSaveForCreatingNewCourseWithNullValue() {
        courseRepository.save(new Course(null));

    }

    @Test(testName = "Validate fetching of Record based on ID")
    public void validateFetchingOnfRecordBasedOnID() {
        String courseName = fs.book().title();
        Course course = courseRepository.save(new Course(courseName));

        Course actualCourseAdded = (Course)courseRepository.fetchRecordBasedOnID_nativeQuery(course.getId());
        Assertions.assertEquals(courseName, actualCourseAdded.getCourseName());
    }
}