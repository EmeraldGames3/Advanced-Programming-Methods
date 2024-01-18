public class CoordinateCourse {
    CourseCoordinatorStrategy courseCoordinatorStrategy;

    public CoordinateCourse(CourseCoordinatorStrategy courseCoordinatorStrategy) {
        this.courseCoordinatorStrategy = courseCoordinatorStrategy;
    }

    public CourseCoordinatorStrategy getCourseCoordinatorStrategy() {
        return courseCoordinatorStrategy;
    }

    public void setCourseCoordinatorStrategy(CourseCoordinatorStrategy courseCoordinatorStrategy) {
        this.courseCoordinatorStrategy = courseCoordinatorStrategy;
    }

    public String executeStrategy(String course){
        return courseCoordinatorStrategy.coordinateCourse(course);
    }
}
