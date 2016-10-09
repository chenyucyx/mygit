/**
 * Created by chenyu on 2016/8/18.
 */

/*    public static void repeat(val){
            for(int i = 0; i < 5; i++){
                println val
            }
        }
    public static void main(def args){
        def var="hello "+
                "world"+
                ",groovy!"
         this.repeat(var)
    }*/


def var = "hello " +
        "world" +
        ",groovy!"

def repeat(val) {
    for (i = 0; i < 5; i++) {
        println "This is ${i}:${val}"
    }
}

repeat(var)

def map = ['name': 'john', 'age': 14, 'sex': 'boy']

map.each { println(it) }

def msg = "Hello!"
println msg.metaClass
String.metaClass.up = { delegate.toUpperCase() }
println msg.up()


(yd.get { n = "geneServiceMapper" } | { mapper ->
    (yd.get { n = "buffaloClient" } | { bc ->
        def total = mapper.countQueryGeneService(new HashMap<>());
        def pages = (total % 200 == 0) ? total / 200 : total / 200 + 1; println "BEGIN"; for (i in 1..pages) {
            def p = ["start": (i - 1) * 200, "size": 200]; mapper.pageQueryGeneService(p).each { gen ->
                try {
                    def mealId = bc.getMealId(gen.tcServiceOrderId); gen.mealId = mealId; mapper.updateGeneService(gen);
                    println "mealId updated:" + mealId + ",rightId:" + gen.tcServiceOrderId;
                } catch (e) {
                    println "error:" + gen.tcServiceOrderId
                }
            }
        }; println "END";
    })()
})()



