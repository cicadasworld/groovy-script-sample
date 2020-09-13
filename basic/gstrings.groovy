/**
 * create by
 * @author hujin 2020/9/6
 */
def c = 'c'
println c.class

def str = 'this is a string'
println str.class

// string interpolation (GString)
String name = "John"
String msg = "Hello " + name
println msg

def msg2 = "Hello $name"
println msg2

// multiline strings
def largeMsg = """
Lorem ipsum dolor sit amet, 
consectetur adipisicing elit. 
Sequi ab soluta aliquid omnis, ${1+1}
odit minima. Ipsa ullam unde maiores, 
dolore error consequuntur vel ratione 
perferendis eos sit minus recusandae in!
"""
println largeMsg

// dollar slashy (for regex)
def folder = $/C:\groovy\dan\foo\bar/$
println folder