import groovy.transform.Sortable
import groovy.transform.ToString

/**
 * create by
 * @author hujin 2020/9/6
 */
@ToString
@Sortable
class Person {
    String first
    String last
}

def p1 = new Person(first: 'John', last: 'Doe')
def p2 = new Person(first: 'Anny', last: 'Gon')

def people = [p1, p2]
println people

def sorted = people.sort(false)// do not mutate original collection
println sorted
