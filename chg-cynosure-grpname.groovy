/**
 * create by
 * @author hujin 2020/9/13
 */
if (args.length != 2) {
    println "Usage: groovy ${this.class.name}.groovy <cynosuregroups.txt所在目录> <newGroupName>"
    System.exit 1
}

String pivotDir = args[0]
def newGroupName = args[1]

def cynosuregroupsFile = new File(pivotDir, 'cynosuregroups.txt')
if (cynosuregroupsFile.exists()) {
    System.err.println "ERROR: 文件不存在:$cynosuregroupsFile"
}

cynosuregroupsFile.eachLine { line ->
    def s = line.trim()
    if (s.startsWith('#')) return
    def fileToModify = new File(pivotDir, s)
    println "modify $fileToModify"
    def lines = []
    fileToModify.eachLine {
        if (it.startsWith('cynosure.groupName')) {
            lines << "cynosure.groupName = $newGroupName\n"
        }
    }
    fileToModify.withWriter {writer ->
        lines.each {
            writer.writeLine it
        }
    }
}
