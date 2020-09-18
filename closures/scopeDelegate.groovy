/**
 * create by
 * @author hujin 2020/9/7
 */
// this | owner | delegate
def writer = {
    append "John"
    append " loves hiking"
}

def append(String s) {
    println "append() called with argument of $s"
}

def sb = new StringBuffer()
writer.resolveStrategy = Closure.DELEGATE_FIRST
writer.delegate = sb
println writer()