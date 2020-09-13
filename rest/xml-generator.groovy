import groovy.xml.MarkupBuilder

/**
 * create by
 * @author hujin 2020/9/11
 */
def writer = new FileWriter("sports.xml")
def builder = new MarkupBuilder(writer)
builder.doubleQuotes = true
builder.sports {
    sport {
        name 'Football'
    }
    sport {
        name 'Baseball'
    }
    sport {
        name 'Basketball'
    }
    sport {
        name 'Tennis'
    }
}