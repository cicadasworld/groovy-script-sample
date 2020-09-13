/**
 * create by
 * @author hujin 2020/9/9
 */
def numbers = []

// push
10.times {
    println "push: \t $it"
    numbers << it
}

println numbers

// pop
for (i in 9..0) {
    println "pop: \t $i"
    numbers.pop()
}

println numbers