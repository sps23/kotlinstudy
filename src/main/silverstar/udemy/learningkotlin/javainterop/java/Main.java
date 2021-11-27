package silverstar.udemy.learningkotlin.javainterop.java;

import silverstar.udemy.learningkotlin.javainterop.Car;
import silverstar.udemy.learningkotlin.javainterop.SingletonObj;
import silverstar.udemy.learningkotlin.javainterop.StaticCar;

import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        StaticCar.topLevel();
        StaticCar.myPrint("print this java string");

        Car car = new Car("blue", "BMW", 2011, true);
        System.out.println(car.getModel());
        car.setColor("purple"); // accessing custom set from Kotlin
        System.out.println(car.getColor());
        System.out.println(car.getAuto());
        System.out.println(car.year); // thanks to annotation @JvmField

        Car.Companion.carComp();
        Car.carComp(); // thanks to annotation @JvmStatic

        SingletonObj.INSTANCE.doSth(); // single instance of an object
        SingletonObj.doSth(); // thanks to annotation @JvmStatic

        System.out.println(Car.isAuto); // thanks to annotation @JvmField
        System.out.println(Car.constant); // because it is defined as 'const' in Kotlin

        // car.printMe(null); // NullPointerException
        try {
            StaticCar.doIO();
        } catch (IOException e) {
            System.out.println("IOException caught!!!");
        }

        StaticCar.defaultArgs("test", 123);
        StaticCar.defaultArgs("test"); // thanks to annotation @JvmOverloads
    }
}
