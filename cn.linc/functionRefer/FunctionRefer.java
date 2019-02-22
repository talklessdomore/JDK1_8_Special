package cn.linc.functionRefer;

import org.junit.Test;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * 描述:
 * 方法的引用
 *
 * @author xiechenglin
 * @create 2019-02-22 10:13
 */
public class FunctionRefer {

    interface FunctionOperator{
        int sum(int a ,int b);
    }

    /**
     * 静态方法的引用或任意对象方法引用：Class::method
     */
    @Test
    public void add(){
        //lumbda表达式执行的过程
        FunctionOperator functionOperator = (a,b)->a+b;
        Consumer<String> consumer = System.out::println;
        consumer.accept("lumbda执行结果："+functionOperator.sum(1,2));
        //函数引用过程，因为在Math中有个静态方法
        FunctionOperator functionOperator1 = Math::addExact;
        consumer.accept("lumbda执行结果："+functionOperator1.sum(1,2));
    }

    class FunctionReferImpl implements FunctionOperator{
        @Override
        public int sum(int a, int b) {
            return a+b;
        }
    }

    /**
     * 特定对象的引用
     */
    @Test
    public void objectRefer(){
        Supplier<FunctionOperator> fun = FunctionReferImpl::new;
        FunctionOperator functionOperator = fun.get();
        FunctionOperator functionOperator1 = functionOperator::sum;
        Consumer<String> consumer = System.out::println;
        consumer.accept("方法引用方式："+functionOperator1.sum(1,2));
    }







}
