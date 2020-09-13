/**
 * create by
 * @author hujin 2020/9/6
 */
def map = [:]
println map
println map.getClass().getName() // map.class.name NPE
println map.foo

def person = [first: "John", last: "Doe", email: "john.doe@gmail.com"]
println person
println person.first

def emailKey = "Email Address"
def twitter = [username: '@john-doe', (emailKey): 'john.deo@gmail.com']
print twitter

println person.size()
println person.sort() // key is sorted

// looping through person
for (entry in person) {
    println entry
}

// each | eachWithIndex
person.each {
    println it
}

person.eachWithIndex{  entry, i ->
    println "$i: $entry"
}

def week = [1: "Sunday", 2: "Monday", 3: "Tuesday", 4: "Wednesday", 5: "Thursday", 6: "Friday", 7: "Saturday"]
println week
println week.getClass().getName()
println week.size()
println week.values()
