/**
 * create by
 * @author hujin 2020/9/6
 */
def nums = [1, 2, 3, 4, 5, 6, 7, 9, 4, 5, 8, 6]
println nums
println nums.class.name

// add | remove | get | clear
nums.push(99)
nums[0] = 77
println nums
def newList = nums + [3, 4, 6]
newList << 66
println newList

nums.pop()
nums.removeAt(0)
println nums
println nums - 6
println nums[0..3]

for (x in nums) {
    println x
}

// flatten
nums << [3, 4, 5]
nums << [1, 2]
println nums.flatten()
println nums.unique()

def numbers = [10, 2, 7, 3, 8, 8, 9, 2] as SortedSet
println numbers
println numbers.class.name

def days = ["Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"]
println days
println days.size()
days.pop()
println days
days << "Saturday"
println days
println days[3]

// sort
def languages = ["java", "groovy", "jruby"]
println languages.sort()

// reverse
println languages.reverse()

//join
println languages.join()     // javagroovyjruby
println languages.join(',')  // java,groovy,jruby
println languages.join(', ') // java, groovy, jruby

// sum
println languages.sum() // javagroovyjruby

// statistic
def scores = [80, 90, 70]
println scores.max()
println scores.min()
println scores.sum()

// spread operator(*)
println languages*.toUpperCase() // [JAVA, GROOVY, JRUBY]