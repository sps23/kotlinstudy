package silverstar.learningkotlin.javainterop.java;

public class Car {

    public static int x = 5;

    private String color;
    private String model;
    private int year;
    private Object anObject;

    public Car(String color, String model, int year) {
        this.color = color;
        this.model = model;
        this.year = year;
    }

    public static String xString() {
        return "This is x: " + x++;
    }

    public void demoMethod(Runnable r) {

        new Thread(r).start();

        //new Thread( () -> System.out.println("I'm in a thread!") ).start();

//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                System.out.println("I'm in a thread!");
//            }
//        }).start();
    }

    public Object getAnObject() {
        return anObject;
    }

    public void setAnObject(Object anObject) {
        this.anObject = anObject;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void variableMethod(int num, String... strings) {
        for (String string : strings) {
            System.out.println(string);
        }
    }

    public void wantsIntArray(int[] theArray) {
        for (int i : theArray) {
            System.out.println("Here's the int: " + i);
        }
    }

    @Override
    public String toString() {
        return "Car{" +
                "color='" + color + '\'' +
                ", model='" + model + '\'' +
                ", year=" + year +
                '}';
    }
}
