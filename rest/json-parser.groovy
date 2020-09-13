import groovy.json.JsonSlurper

/**
 * create by
 * @author hujin 2020/9/11
 */
def slurper = new JsonSlurper()
//def json = slurper.parseText(s)
def json = slurper.parse(new File("books.json"))

println json.books.nextBook.title