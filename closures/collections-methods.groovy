/**
 * create by
 * @author hujin 2020/9/6
 */
// each | eachWithIndex
def favNums = [2, 3,54,6, 8]

favNums.each { println it }

favNums.eachWithIndex { entry, i ->
    println "$i:$entry"
}

// find (find first) | findAll (filter in Java)
def days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"]
def findDays = days.findAll {it.startsWith("S") }
println(findDays)

// collect (map transform in java)
def nums = [1, 2, 3, 7, 2, 8, 2, 4, 6]

def numsTimesTen = [] // classic
nums.each {
    numsTimesTen << it * 10
}
def newTimesTen = nums.collect { it * 10 }
println nums
println numsTimesTen
println newTimesTen

// curry method
def log = { level, createdOn, message ->
    println "$createdOn [$level] - $message"
}
log("DEBUG", new Date(), "This is my first debug statement...")

def debugLog = log.curry("DEBUG")
debugLog(new Date(), "This is another debug message.")

// right curry - rcurry
def msgLog = log.rcurry("logging...")
msgLog("ERROR", new Date())

// index bsased curry - ncurry
def todayLog = log.ncurry(1, new Date())
todayLog("DEBUG", "This is index based curry...")

// any | every
def people = [
        [name: 'zhangsan', city: 'Beijing'],
        [name: 'lisi', city: 'Shanghai'],
        [name: 'wangwu', city: 'Guangzhou'],
        [name: 'zhaoliu', city: 'Beijing']
]

println people.any { it.city == 'Shanghai' }
println people.every {it.city == 'Shanghai' }
println people.every { it.name.size() >= 4 }

def peopleByCity = people.groupBy { it.city }
println peopleByCity
def peopleByBeijing = peopleByCity['Beijing']
peopleByBeijing.each { println it.name }