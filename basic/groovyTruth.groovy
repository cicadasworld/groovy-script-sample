/**
 * create by
 * @author hujin 2020/9/7
 */
// Boolean | Matcher | Collection | Map | String | Number | Non of the above
assert true
assert !false

assert ('a' =~ /a/)
assert !('b' =~ /a/)

assert [1]
assert ![]

assert [1: 'one']
assert ![:]

assert 'a'
assert !''

assert 1
assert !0

assert new Object()
assert !null
