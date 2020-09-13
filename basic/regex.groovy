/**
 * create by
 * @author hujin 2020/9/6
 */
// Java Sample Pattern
import java.util.regex.*;
Pattern pat = Pattern.compile("a\\b")
println pat
println pat.class

// What patterns will look like in Groovy
def slashy = /a\b/   // slashy string
def url = $/https://www.baidu.com/$ // dollar slashy string
println slashy.class

def p = ~ /a\b/
println p.class

// Find | Match
def text = "Although never is often better than right now."
def pattern = ~/right now/

def finder = text =~ pattern
def matcher = text ==~ pattern //exact match
println finder // java.util.regex.Matcher
println finder.size()
println matcher // false

text = text.replaceFirst(pattern, "at this time")
println text