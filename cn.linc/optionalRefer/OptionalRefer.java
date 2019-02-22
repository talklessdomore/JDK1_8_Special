package cn.linc.optionalRefer;

import org.junit.Test;

import java.util.Optional;

/**
 * 描述:
 * optional测试使用
 *
 * @author xiechenglin
 * @create 2019-02-22 15:35
 */
public class OptionalRefer {

    @Test
    public void testOptionMethod(){
        optionMethodOperator(Optional.ofNullable(null),Optional.ofNullable(null));
    }

    private void optionMethodOperator(Optional<String> name,Optional<Integer> age){
        boolean isNameExist = name.isPresent();
        boolean isAgeExist = age.isPresent();
        System.out.println(isNameExist);
        System.out.println(isAgeExist);
    }




}
