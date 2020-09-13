import java.time.LocalDate

/**
 * create by
 * @author hujin 2020/9/6
 */
def r = 1..10 // def r = 1..<10 (less than 10)
println r
println r.class.name
println r.from
println r.to

assert (0..10).contains(0)
assert (0..10).contains(10)
assert (0..10).contains(-1) == false

assert (0..<10).contains(0)
assert (0..<10).contains(10) == false

def today = LocalDate.now()
def oneWeekAway = today + 7 // GDK for simple statement

println today
println oneWeekAway

def letters = 'a'..'z'
println letters

enum Days {
    Sunday, Monday, Tuesday, Wednesday, Thursday, Friday, Saturday
}

def dayRange = Days.Sunday..Days.Saturday

for (day in dayRange) {
    println day
}

dayRange.each {
    println it
}

println dayRange.size()
println dayRange.contains(Days.Wednesday)
println dayRange.from
println dayRange.to
