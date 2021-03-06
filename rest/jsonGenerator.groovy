import groovy.json.JsonBuilder

/**
 * create by
 * @author hujin 2020/9/11
 */

def builder = new JsonBuilder()
builder.books {
    currentBook {
        title 'The 4 Hour Work Week'
        isbn '9348-353-645-345'
        author(first: 'John', last: 'Doe', twitter: '@jdoe')
        related 'The 4 Hour Body', 'The 4 hour chef'
    }
    nextBook {
        title '#AskGaryVee'
        isbn '343-67-8343-6'
        author(first: 'Tom', last: 'chuck', twitter: '@guck')
        related 'Right Hook', 'Crush It!'
    }
}

new File("books.json").write(builder.toPrettyString())