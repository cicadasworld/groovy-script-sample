import groovy.xml.MarkupBuilder

/**
 * create by
 * @author hujin 2020/9/10
 */
def builder = new MarkupBuilder()
builder.omitEmptyAttributes = true
builder.omitNullAttributes = true
builder.doubleQuotes = true
builder.sports {
    sport(id: 1) {
        name 'Baseball'
    }
    sport(id: 2) {
        name 'Basketball'
    }
    sport(id: 3) {
        name 'Football'
    }
    sport(id: 4) {
        name 'Tennis'
    }
    sport(id: null, foo: '') {
        name ''
    }
}