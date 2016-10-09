import com.googlecode.aviator.AviatorEvaluator;

import javax.script.ScriptEngineManager;
import java.text.SimpleDateFormat;
import java.util.*;

/**
 * Created by chenyu on 2016/7/26.
 */
public class AvitaorTest {

    public static void main(String[] args) {

        //自定义方法
        AviatorEvaluator.addFunction(new MathFunction());
        System.out.println(AviatorEvaluator.exec("upDot(3.2)"));

        //支持正则表达式
        String email ="chenyu123@gmail.com";
        Map<String, Object> env = new HashMap<String, Object>();
        env.put("email", email);
        Object a = AviatorEvaluator.execute("email=~/([\\w0-9]+)@\\w+[\\.\\w+]+/ ? $1:'unknow'",env);
        System.out.println(a);

        //对象
        Student s= new Student();
        s.setName("cy");
        s.setAge("20");
        env.put("student",s);
        String result = (String)AviatorEvaluator.execute("'name='+student.name+' age='+student.age",env);
        System.out.println(result);

        //数组和集合
         int[] array = new int[2];
         array[0]=123;
         array[1]=789;
         env.put("array",array);
         result = (String)AviatorEvaluator.execute("'array[0]='+array[0]+' array[1]='+array[1]",env);
         System.out.println(result);

        //三元表达式
        env.put("test",123);
        result = (String)AviatorEvaluator.execute("test>0 ? 'OK':'NOT OK'",env);
        System.out.println(result);

        //nil比较
        System.out.println(AviatorEvaluator.execute("nil==nil"));
        System.out.println(AviatorEvaluator.execute("3>=nil"));
        System.out.println(AviatorEvaluator.execute("true!=nil"));
        System.out.println(AviatorEvaluator.execute("a==nil"));

        //日期比较
        Date date = new Date();
        String datestr = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss:SS").format(date);
        env.put("date",date);
        env.put("datestr",datestr);
        System.out.println(AviatorEvaluator.execute("date==datestr",env));
        System.out.println(AviatorEvaluator.execute("date<'1900-09-01 00:00:00:00'",env));

        //大数字的计算
        System.out.println(AviatorEvaluator.execute("9999999999999999999999999999999999999999+9999999999999999999999999999999999999999"));

        //seq、内置函数的支持
        List list = new ArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        env.put("list",list);
        System.out.println(AviatorEvaluator.execute("count(list)",env));
        System.out.println(AviatorEvaluator.execute("count(filter(list,seq.eq('2')))",env));


        System.out.println(AviatorEvaluator.execute("string.length('hello')"));    // 求字符串长度
        System.out.println(AviatorEvaluator.execute("string.contains('hello','h')"));  //判断字符串是否包含字符串
        System.out.println(AviatorEvaluator.execute("string.startsWith('hello','h')"));  //是否以子串开头
        System.out.println(AviatorEvaluator.execute("string.endsWith('hello','llo')"));  //是否以子串结尾

        System.out.println(AviatorEvaluator.execute("math.pow(-3,2)"));   // 求n次方
        System.out.println(AviatorEvaluator.execute("math.sqrt(14.0)"));   //开平方根
        System.out.println(AviatorEvaluator.execute("math.sin(20)"));    //正弦函数

    }

}
