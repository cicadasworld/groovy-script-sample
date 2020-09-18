/**
 * create by
 * @author hujin 2020/9/12
 */
def text = new File('dummy.txt').text
println text

// specify encoding
def s = new File('dummy.txt').getText('UTF-8')
println s

// read file line by line
new File('dummy.txt').eachLine { println it }

// read file line by line with specified encoding
new File('dummy.txt').eachLine('UTF-8') { println it }