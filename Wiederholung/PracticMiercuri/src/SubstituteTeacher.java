public class SubstituteTeacher implements CourseCoordinatorStrategy{
    @Override
    public String coordinateCourse(String course) {
        return "Teacher is sick so substitute teacher is coordinating course " + course;
    }
}
