package silverstar.udemy.kotlin4jd.javainterop.challenge2;

public class Main {

    public static void main(String[] args) {

        KotlinCodeKt.sayHelloToJava("Student");

        Employee employee = new Employee("John", "Smith", 2010);
        employee.setStartYear(2009);

        Challenge.INSTANCE.doMath(5, 4);

        employee.takesDefault("arg1");
    }
}
