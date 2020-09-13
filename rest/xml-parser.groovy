import groovy.xml.XmlSlurper

/**
 * create by
 * @author hujin 2020/9/11
 */
def sports = new XmlSlurper().parse("sports.xml")
println sports
println sports.sport[2].name