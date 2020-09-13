/**
 * create by
 * @author hujin 2020/9/5
 */

class Developer {
    String first
    String last
    def languages = []

    void work() {
        println "$first $last is working..."
    }
}

// create a new instance of a developer
def d = new Developer()
d.first = "John"
d.setLast("Doe")

// assign some languages
d.languages << "Groovy"
d.languages << "Java"

// call some methods
d.work()