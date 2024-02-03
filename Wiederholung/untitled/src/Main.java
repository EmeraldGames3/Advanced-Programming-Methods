import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class Main {
    public static void main(String[] args) throws NoSuchFieldException, IllegalAccessException {
        Person person = new Person("Bob");
        Field[] fields = person.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            if (field.getName().equals("department")) {
                try {
                    String value = "ceva2";
                    field.set(person, value);
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                }
            }
        }

        System.out.println(person.getDepartment());

        Field nameField = person.getClass().getDeclaredField("name");
        nameField.setAccessible(true);
        nameField.set(person, "mirciu");
        String nameValue = (String) nameField.get(person);
        System.out.println("Name: " + nameValue);

        Method[] methods = person.getClass().getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName());
        }
    }
}