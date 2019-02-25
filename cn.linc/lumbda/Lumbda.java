package lumbda;

import org.junit.Test;

/**
 * 描述:
 * lumbda表达式
 *
 * @author xiechenglin
 * @create 2019-02-21 22:35
 */
public class Lumbda {
    /**
     * 1.Lambda 表达式 − Lambda允许把函数作为一个方法的参数（函数作为参数传递进方法中)。
     * 2.方法引用 − 方法引用提供了非常有用的语法，可以直接引用已有Java类或对象（实例）的方法或构造器。与lambda联合使用，方法引用可以使语言的构造更紧凑简洁，减少冗余代码。
     * 3.默认方法 − 默认方法就是一个在接口里面有了一个实现的方法。
     * 4.新工具 − 新的编译工具，如：Nashorn引擎 jjs、 类依赖分析器jdeps。
     * 5.Stream API −新添加的Stream API（java.util.stream） 把真正的函数式编程风格引入到Java中。
     * 6.Date Time API − 加强对日期与时间的处理。
     * 7.Optional 类 − Optional 类已经成为 Java 8 类库的一部分，用来解决空指针异常。
     * 8.Nashorn, JavaScript 引擎 − Java 8提供了一个新的Nashorn javascript引擎，它允许我们在JVM上运行特定的javascript应用。
     */
    /**
     * Lambda 表达式 开始 参考url-http://www.runoob.com/java/java8-lambda-expressions.html
     */
    /**
     * 基础总结：lambda表达式是使用接口进行函数的定义，在方法中进行函数的申明实现，然后通过定义的参数进行执行
     */

    @Test
    public void testLambda(){
        //函数定义
        MathOperation addMathOperation = (a, b) -> a+b;
        MathOperation subMathOperation = (a, b) -> a-b;
        MathOperation divMathOperation = (a, b) -> a/b;
        MathOperation mulMathOperation = (a, b) -> a*b;
        GreetService greetService = (message) -> System.out.println("hello"+message);
       GreetService greetService1 = message -> System.out.println("hello"+message);
        System.out.println("10 + 5 = " + this.mathOperationOperate(10, 5, addMathOperation));
        System.out.println("10 - 5 = " + this.mathOperationOperate(10, 5, subMathOperation));
        System.out.println("10 / 5 = " + this.mathOperationOperate(10, 5, divMathOperation));
        System.out.println("10 * 5 = " + this.mathOperationOperate(10, 5, mulMathOperation));
        greetService.sayMessage("有括号装饰");
        greetService1.sayMessage("无括号装饰");
    }

    //函数接口定义
    interface MathOperation{
        int operate(int a, int b);
    }

    interface GreetService{
        void sayMessage(String message);
    }

    private int mathOperationOperate(int a , int b, MathOperation mathOperation){
        return mathOperation.operate(a,b);
    }

    final static int a = 12;
    //1.注意点1：lambda 表达式只能引用标记了 final 的外层局部变量，这就是说不能在 lambda 内部修改定义在域外的局部变量，否则会编译错误。
    @Test
    public void testScope(){
        MathOperation scopeMathOperation = (c, b)->a+c+b;
        int scope = scopeMathOperation.operate(1,2);
        System.out.println("变量作用域测试"+scope);
    }

    //2.我们可以再lambda表达式中访问外部局部变量
    @Test
    public void testScope1(){
        int a = 12;
        MathOperation scopeMathOperatin = (c, b) -> a+c+b;
        int scope = scopeMathOperatin.operate(1,2);
        System.out.println("变量作用域测试"+scope);
    }

    //3lambda 表达式的局部变量可以不用声明为 final，但是必须不可被后面的代码修改（即隐性的具有 final 的语义）,引用的变量后期不可以更改
    @Test
    public void testScope2(){
        int a = 12;
        MathOperation scopeMathOperatin = (c, b) -> c+b;
        int scope = scopeMathOperatin.operate(1,2);
        System.out.println("变量作用域测试"+scope);
        a = 1;//会报错
    }

    //4在 Lambda 表达式当中不允许声明一个与局部变量同名的参数或者局部变量
    @Test
    public void testScope3(){
        int a = 1;//编译异常
        MathOperation scopeMathOperatin = (a, b) -> a+b;
        int scope = scopeMathOperatin.operate(1,2);
        System.out.println("变量作用域测试"+scope);
    }
    /**
     * Lambda 表达式 结束
     */

}
