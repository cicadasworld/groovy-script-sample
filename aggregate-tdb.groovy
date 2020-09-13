import groovy.io.FileType

/**
 * create by
 * @author hujin 2020/9/13
 */

// 源数据所在目录
def startDir = /D:\99-temp\testtile/
List<String> tdbFilenames = []
new File(startDir).eachFileRecurse(FileType.FILES) { file ->
    if (file.name.endsWith('.tdb')) {
        tdbFilenames << file.absolutePath
    }
}

def levelToTdbs = [:]
tdbFilenames.each { path ->
    def filename = new File(path).name
    filename = filename.replace('.tdb', '')
    def (name, level) = filename.tokenize('-')
    def tdbs = levelToTdbs[level]
    if (tdbs == null) {
        tdbs = levelToTdbs[level] = []
    }
    tdbs << path
}