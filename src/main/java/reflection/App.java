package reflection;

import reflection.model.Car;

import java.lang.reflect.Field;
import java.lang.reflect.Method;

public class App {
    public static void main(String[] args) {
//        get Class
        Car car = new Car();
        Class<? extends Car> carClass = car.getClass();
        System.out.println(carClass);
//        get private field
        try {
            Field horsepowerField = carClass.getDeclaredField("horsepower");
            System.out.println(horsepowerField);
            Field blaBlaField = carClass.getDeclaredField("bla_bla");
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        }
//        get protected method
        try {
            Method printSerialNumberMethod = carClass.getDeclaredMethod("printSerialNumber");
            System.out.println(printSerialNumberMethod);

            Method setHorsepowerMethod = carClass.getDeclaredMethod("setHorsepower", int.class);
            System.out.println(setHorsepowerMethod);

            carClass.getDeclaredMethod("dodooooo");
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }
}
