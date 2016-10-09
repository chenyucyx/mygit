import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

/**
 * Created by chenyu on 2016/8/18.
 */
public class Groovy {

         public static void main(String[] args) {
                 ScriptEngineManager manager = new ScriptEngineManager();
                 ScriptEngine engine = manager.getEngineByName("groovy");
                 try {
                         System.out.println("calling groovy from java start");
                         engine.put("name", "VerRan");
                     try {
                         engine.eval("println \"${name}\"+\"你好\";name=name+'！'");
                     } catch (ScriptException e) {
                         e.printStackTrace();
                     }
                        System.out.println(engine.get("name"));
                        System.out.println("calling groovy from java end");

                         engine.eval("");
                     } catch (ScriptException e) {
                         e.printStackTrace();
                     }
            }
}
