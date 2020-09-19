/**
 * create by
 * @author hujin 2020/9/9
 */
// create a new file
def file = new File('dummy.txt')
file.write("This is some text\n")

println new File('dummy.txt').text

file.append("I am some more text...\n")

def lines = file.readLines()
lines.each { println it }

// list all files in a directory
def dir = 'D:\\03-projects\\02-idea_ws\\groovy-scripts\\src\\main\\groovy\\io'
new File(dir).eachFile { f ->
    // show all first
    if (f.isFile()) {
        println f.name
    }
}

new File(dir).eachFile(FileType.FILES) { file ->
	println file
}


// list specified files(no dir) in a directory
new File(dir).eachFile() { file ->
	if (file.isFile() && file.name.endsWith(".groovy")) {
		println file

	}
}

new File(dir).eachFile(FileType.FILES) { file ->
	if (file.name.endsWith(".groovy")) {
		println file
	}
}

new File(dir).eachFile() { file ->
	if (file.isFile() && file.name ==~/.*\.groovy/) {
		println file
	}
}

new File(dir).eachFile(FileType.FILES, ~/.*\.groovy/) { file ->
	println file
}


