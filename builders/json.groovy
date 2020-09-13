import groovy.json.JsonBuilder

/**
 * create by
 * @author hujin 2020/9/11
 */

def builder = new JsonBuilder()

builder.books {
    book {
        title 'The 4 Hour Work Week'
        isbn '9348-353-645-345'
        author(first: 'John', last: 'Doe', twitter: '@jdoe')
        related 'The 4 Hour Body', 'The 4 hour chef'
    }
}

println builder.toPrettyString()