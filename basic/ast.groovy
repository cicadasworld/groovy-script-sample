import groovy.transform.Immutable

/**
 * create by
 * @author hujin 2020/9/5
 */
@Immutable
class Customer {
    String first, last
    int age
    Date since
    Collection favItems
}

def d = new Date()
def c1 = new Customer(first: 'Tom', last: 'Jones', age: 21, since: d, favItems: ['Books', 'Games'])
def c2 = new Customer('Tom', 'Jones', 21, d, ['Books', 'Games'])
assert c1 == c2