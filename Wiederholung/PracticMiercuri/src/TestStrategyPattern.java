import java.util.ArrayList;

public class TestStrategyPattern {
    public void test(ArrayList<String> courses){
        CourseCoordinatorStrategy strategy1 = new Teacher();
        CourseCoordinatorStrategy strategy2 = new SubstituteTeacher();
        CoordinateCourse coordinateCourse = new CoordinateCourse(strategy2);

        courses.stream()
                .forEach(course -> {
                    assert ("Teacher is sick so substitute teacher is coordinating course " + course)
                            .equals(coordinateCourse.executeStrategy(course));
                });

        coordinateCourse.setCourseCoordinatorStrategy(strategy1);
        courses.stream()
                .forEach(course -> {
                    assert ("Teacher coordinating course " + course)
                            .equals(coordinateCourse.executeStrategy(course));
                });
    }
}
