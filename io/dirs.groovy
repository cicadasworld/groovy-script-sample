/**
 * create by
 * @author hujin 2020/9/9
 */
def dir = 'D:\\03-projects\\02-idea_ws\\groovy-scripts\\src\\main\\groovy'
def hidden = []
new File(dir).eachFile {
    if (it.isDirectory()) {
        println it.name
    }
    if (it.isHidden()) {
        hidden << it.name
    }
}
println hidden

new File(dir).eachDir {
    println it
}

// create dir(s)
new File('dummy').mkdir()
new File('one/two/three').mkdirs()

// delete dir
new File('dummy').deleteDir()