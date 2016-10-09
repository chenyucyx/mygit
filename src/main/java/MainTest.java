import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * Created by chenyu on 2016/7/27.
 */
public class MainTest {

    public static void main(String[] args) {

/*        Stream.generate(()->"test");
        //Stream.iterate(1,p->p*2).limit(4).forEach(System.out::println);
        //System.out.println(s);
        ArrayList a = new ArrayList<String>();

        Optional.of("a");

        BigInteger m= new BigInteger("9999999999999999999999999999999999999999");
        BigInteger n= new BigInteger("9999999999999999999999999999999999999999");
        System.out.println(m.add(n));*/

        int a=123;
        Integer b =a;
        int d=12345;
        Integer c=new Integer(d);
        System.out.println(b);
        System.out.println(c);



    }

}
