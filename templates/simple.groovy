import groovy.text.SimpleTemplateEngine

/**
 * create by
 * @author hujin 2020/9/10
 */
def engine = new SimpleTemplateEngine()
def template = engine.createTemplate(new File('dynamic-email.txt'))

// data bindings
Map bindings = [
        firstName: "John",
        lastName: "Doe",
        commits: 27,
        repositories: [
                [name: 'Apache Groovy Course', url: 'https://github.com/apache-groovy-course'],
                [name: 'Spring Boot REST', url: 'https://github.com/spring-boot-rest'],
                [name: 'Learn Spring Boot', url: 'https://github.com/learnspringboot']
        ]
]

println template.make(bindings)