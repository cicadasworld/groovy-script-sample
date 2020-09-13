/**
 * create by
 * @author hujin 2020/9/6
 */
def c = {}

println c.class.name
println c instanceof Closure

def sayHello = { name ->
    println "Hello, $name"
}

sayHello('John')

def nums = [1, 4, 7, 4, 30, 2]
nums.each { num ->
    println num
}

// closures are objects and last param
def timesTen(num, closure) {
    closure(num * 10)
}

timesTen(10) {println it}
timesTen(2) {println it}

10.times {
    println it
}