package in.sritaj.jpaandhibernate.repository.entitymanager;

import in.sritaj.jpaandhibernate.entity.entitymanager.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.HashMap;
import java.util.List;
import java.util.Objects;

/**
 * CourseRepository class for implementing SQL queries/transactions for Course Entity using Hibernate and JPA
 */
@Repository
@Transactional
public class CourseRepository {

    //Connection to database
    @Autowired
    private EntityManager entityManager;

    private final String selectAllJPQLQuery = "Select c from Course c";
    private final String selectAllNativeSQLQuery = "Select * from Course";
    private final String selectRecordNativeQuery = "Select * from Course where id =?";
    private final String updateRecordNativeQuery = "Update Course set course_name = ? where id = ?";
    private final String selectCoursesWithoutStudents = "Select c from Course c where c.students is empty";
    private final String selectCourseWithMinStudentsAndOrderByDesc = "Select c from Course c order by size(c.students) desc";
    private final String selectCourseAndStudentUsingJoin = "Select c, s from Course c JOIN c.students s";

    /**
     * Method to fetch Course based on id
     *
     * @param id - specific id
     * @return Course - specified Course
     */
    public Course findById(Long id) {
        return entityManager.find(Course.class, id);
    }

    /**
     * Method to delete Course if present
     *
     * @param id - specific id
     * @return String - message based on deletion of existing record or not finding the record
     */
    public String deleteCourse(Long id) {
        Course course = findById(id);
        if (Objects.isNull(course)) {
            return "Can't find Course for ID " + id;
        }
        entityManager.remove(course);
        return "Course removed";
    }

    /**
     * Method to create/update course
     *
     * @param course - course entity
     * @return Course - created/updated Course entity
     */
    public Course save(Course course) {
        if (Objects.isNull(course.getId())) {
            entityManager.persist(course);
        } else {
            entityManager.merge(course);
        }
        return course;
    }

    /**
     * Method to select and retrieve all the records using JPQL query
     *
     * @return List - Courses
     */
    public List fetchAllRecords_basic() {
        Query query = entityManager.createQuery(selectAllJPQLQuery);
        return query.getResultList();
    }

    /**
     * Method to select and retrieve all the records using JPQL typed query
     *
     * @return List<Courses> - Courses
     */
    public List<Course> fetchAllRecords_typedQuery() {
        TypedQuery<Course> typedQuery = entityManager.createQuery(selectAllJPQLQuery, Course.class);
        return typedQuery.getResultList();
    }

    /**
     * Method to select and retrieve all the records using Native SQL query
     *
     * @return List - Courses
     */
    public List fetchAllRecords_nativeQuery() {
        Query query = entityManager.createNativeQuery(selectAllNativeSQLQuery, Course.class);
        return query.getResultList();
    }

    /**
     * Method to select and retrieve record based on ID
     *
     * @param id - specific id
     * @return List - Courses
     */
    public Object fetchRecordBasedOnID_nativeQuery(Long id) {
        Query query = entityManager.createNativeQuery(selectRecordNativeQuery, Course.class);
        query.setParameter(1, id);
        return query.getSingleResult();
    }

    /**
     * Method to update Course name based on ID
     *
     * @param id         - specific id
     * @param courseName - updated Course Name
     * @return int - Rows affected
     */
    public int updateRecordBasedOnID_nativeQuery(String courseName, Long id) {
        Query query = entityManager.createNativeQuery(updateRecordNativeQuery, Course.class);
        query.setParameter(1, courseName);
        query.setParameter(2, id);
        return query.executeUpdate();
    }

    /**
     * Method to retrieve courses without Students using JPQL typed query
     *
     * @return List<Courses> - Courses
     */
    public List<Course> fetchCoursesWhereStudentsAreNotMapped() {
        TypedQuery<Course> typedQuery = entityManager.createQuery(selectCoursesWithoutStudents, Course.class);
        return typedQuery.getResultList();
    }

    /**
     * Method to retrieve courses in Descending Order using JPQL typed query
     *
     * @return List<Courses> - Courses
     */
    public List<Course> fetchCoursesInDescendingOrder() {
        TypedQuery<Course> typedQuery = entityManager.createQuery(selectCourseWithMinStudentsAndOrderByDesc, Course.class);
        return typedQuery.getResultList();
    }

    /**
     * Method to retrieve courses having students via JOIN using JPQL typed query
     *
     * @return Hashmap - Course as Key, Student as Value
     */
    public HashMap<Object, Object> fetchCoursesAndStudentsUsingJoin() {
        Query query = entityManager.createQuery(selectCourseAndStudentUsingJoin);
        List<Object[]> result = query.getResultList();
        HashMap<Object, Object> resultSet = new HashMap<>();
        for (Object[] res : result) {
            resultSet.put(res[0], res[1]);
        }
        return resultSet;
    }
}
