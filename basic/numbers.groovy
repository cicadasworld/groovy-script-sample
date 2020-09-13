/**
 * create by
 * @author hujin 2020/9/5
 */
def x = 5.5
println x.class
int y = 2
println y.class

// if either operand is a float or a double the result is a double
// in java if only floats are involved the result is a float
Float f = 5.25
Double d = 10.50

def result = d / f
println result
println result.class

// If either operand is a big decimal
def m = 34.5 // BigDecimal
def n = 15
def bugResult = x / y
println bugResult
println binding.class

// GDK methods
assert 2 == 2.5.toInteger() // conversion
assert 2 == 2.5 as Integer // enforce coercion
assert 2 == (int) 2.5 // cast

assert '5.50'.isNumber()
assert 5 == '5'.toInteger()

// times | upto | downto | step
20.times {
    print '-'
}

1.upto(10) {
    println it
}

10.downto(1) {
    println it
}

0.step(1, 0.1) {
    println it
}
