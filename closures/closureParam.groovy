/**
 * create by
 * @author hujin 2020/9/6
 */

// implicit parameter
def foo = {
    println it
}

foo("John")

def noparams = { -> //  -> only stands for no argument
    println "no params..."
}

noparams()

def sayHello = { first, last ->
    println "Hello, $first $last"
}

sayHello("John", "Doe")

// default values
def greeting = { name, greeting = "Howdy" ->
    println "$greeting, $name"
}
greeting("John", "Hello")
greeting("John")

// var-arg
def concat = { def...args ->
    args.join("")
}

println concat("abc", "def")
println concat("abc", "def", "123")

def someMethod(Closure c) {
    println "..."
    println c.maximumNumberOfParameters
    println c.parameterTypes
}
def someClosure = { int x, int y -> x + y}
someMethod(someClosure)