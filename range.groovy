import com.santaba.agent.groovyapi.http.*;
static void main(String [] args){
    def range = 1..10
    for (n in range){
        println n
    }
    range.contains(2)?println("true"):println("false")
}