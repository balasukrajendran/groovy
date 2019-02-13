import groovy.lang.GroovyObject;
import groovy.lang.MetaClass;
import org.codehaus.groovy.runtime.callsite.CallSite;
import org.codehaus.groovy.runtime.typehandling.ShortTypeHandling;
import org.testing.*
class Testsuite {

    @org.testng.annotations.Test
    void 'testing'(){
        println("this is an example")
    }

}

TestRunner.run(Testsuite.suite())