import groovy.io.FileType

/**
 * create by
 * @author hujin 2020/9/13
 */
if (args.length != 2) {
    println "Usage: groovy ${this.class.name}.groovy <dir1> <dir2>"
    System.exit 1
}

String dir1 = args[0]
String dir2 = args[1]

def files1 = [:]
new File(dir1).eachFile(FileType.FILES) { file ->
    files1[file.name] = 1
}
println files1
def files2 = [:]
new File(dir2).eachFile(FileType.FILES) { file ->
    files2[file.name] = 1
}
println files2
println '两个目录下都有的文件:'
n = 0
files1.keySet().each {
    if (it in files2.keySet()) {
        println it
        n += 1
    }
}
println "共${n}个文件"

println "${dir1}下独有的文件:"
n = 0
files1.keySet().each {
    if (!(it in files2.keySet())) {
        println it
        n += 1
    }
}
println "共${n}个文件"

println "${dir2}下独有的文件:"
n = 0
files2.keySet().each {
    if (!(it in files1.keySet())) {
        println it
        n += 1
    }
}
println "共${n}个文件"

