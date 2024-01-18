public class Teacher implements CourseCoordinatorStrategy{
    @Override
    public String coordinateCourse(String course) {
        return "Teacher coordinating course " + course;
    }
}
