package cn.linc.defaultMethod;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 描述:
 * 默认方法
 *
 * @author xiechenglin
 * @create 2019-02-22 11:11
 */
public class DefaultMethod {

    public static void main(String[] args) {
        Car car = new DefaultMethod.Car();
        car.print();
    }

    interface Vehicle{
        default void print(){
            Consumer<String> consumer = System.out::println;
            consumer.accept("这是一辆车");
        }
    }

    interface FourVehicle{
        default void print(){
            Consumer<String> consumer = System.out::println;
            consumer.accept("这是一辆四轮车");
        }
    }

    static class  Car implements Vehicle,FourVehicle{
        //第一种方式，调用父类print方法;第二种方式：重写该方法
        public void print(){
            Vehicle.super.print();
            FourVehicle.super.print();
            System.out.println("重写该方法，我是汽车2");
        }



    }





}
