/**
 * create by
 * @author hujin 2020/9/9
 */
// create a new file
def file = new File('dummy.txt')
file.write("This is some text\n")

println new File('dummy.txt').text

file.append("I am some more text...\n")

def lines = file.readLines()
lines.each { println it }

// list all files in a directory
def dir = 'D:\\03-projects\\02-idea_ws\\groovy-scripts\\src\\main\\groovy\\io'
new File(dir).eachFile { f ->
    // show all first
    if (f.isFile()) {
        println f.name
    }
}

new File('.').eachFile {
    if (it.name.endsWith(".groovy")) {
        println it.name
    }
}