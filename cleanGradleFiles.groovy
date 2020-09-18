/**
 * create by
 * @author hujin 2020/9/13
 */
def filesToClean = ['.gradle', '.settings', '.classpath', '.project', 'bin', 'build', 'var', 'out', '.idea', 'derby.log']

if (args.length != 1) {
    println "Usage: ${this.class.name}.groovy <gradleProjDir>"
    System.exit 1
}

String gradleProjDir = args[0]
def files = []
def dirs = []
new File(gradleProjDir).eachFileRecurse { file ->
    if (file.name in filesToClean) {
        if (file.isFile()) {
            files << file
        } else {
            dirs << file
        }
    }
}

def ant = new AntBuilder()
ant.with {
    delete(includeEmptyDirs: true) {
        files.each { file ->
            fileset(file: file)
        }
        dirs.each { dir ->
            fileset(dir: dir)
        }
    }
}