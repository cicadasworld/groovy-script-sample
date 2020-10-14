import groovy.io.FileType

import java.nio.file.Files
import java.nio.file.Path
import java.nio.file.StandardCopyOption

/**
 * create by
 * @author hujin 2020/9/12
 */
if (args.length < 2) {
    println "Usage: groovy ${this.class.name}.groovy <srcDir> <dstDir>"
    System.exit 1
}

def srcDir = args[0]
def dstDir = args[1]

def jars = []
new File(srcDir).eachFileRecurse(FileType.FILES) { file ->
    jars << file.name
}

jars.each { jar ->
    List<String> dirs = []
    def repo = /E:\maven-repo\RepoData\maven/
    new File(repo).eachFileRecurse(FileType.FILES) { file ->
        if (file.name == jar) {
            dirs << file.parentFile.absolutePath
        }
    }
    dirs.each { dir ->
        String t = dir.replace(repo, '')
        def newDir = new File(dstDir, t)
        newDir.mkdirs()
        new File(dir).eachFileRecurse { file ->
            Path src = file.toPath()
            Path dest = new File(newDir.path, file.name).toPath()
            Files.copy(src, dest, StandardCopyOption.REPLACE_EXISTING)
        }
    }
}
