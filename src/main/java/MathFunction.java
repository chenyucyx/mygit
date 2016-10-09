import com.googlecode.aviator.runtime.function.AbstractFunction;
import com.googlecode.aviator.runtime.function.FunctionUtils;
import com.googlecode.aviator.runtime.type.AviatorDecimal;
import com.googlecode.aviator.runtime.type.AviatorObject;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created by chenyu on 2016/7/26.
 */
public class MathFunction extends AbstractFunction {


    @Override
    public AviatorObject call(Map<String, Object> env, AviatorObject arg1) {
        Number arg =(Number)FunctionUtils.getNumberValue(arg1,env);
        return new AviatorDecimal(new BigDecimal((Double)arg).setScale(0,BigDecimal.ROUND_HALF_UP));
    }

    @Override
    public String getName() {
        return "upDot";
    }
}
