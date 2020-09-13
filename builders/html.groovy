import groovy.xml.MarkupBuilder

/**
 * create by
 * @author hujin 2020/9/10
 */
def writer = new FileWriter('about.html')
def builder = new MarkupBuilder(writer)

def courses = [
        [id: 1, name: 'Apache Groovy'],
        [id: 2, name: 'Spring Boot']
]

builder.html {
    head {
        title 'About John Doe'
        description 'This is an about me page'
        keywords 'John Doe, Groovy, Java, Spring'
    }
    body {
        h1 'About Me'
        p 'This is a bunch of text about me...'
        section {
            h2 'Courses'
            table {
                tr {
                    th 'id'
                    th 'name'
                }
                tr {
                    td '1'
                    td 'Groovy'
                }
                courses.each { course ->
                    tr {
                        td course.id
                        td course.name
                    }
                }
            }
        }
    }
}
