def srcDir = new File('builders')
def destDir = new File(srcDir, 'antexample')
def zippedFile = new File(srcDir, 'antzipped.zip')

def ant = new AntBuilder()
ant.with {
    echo 'begin zipping and unzipping'
    zip(destfile: zippedFile, basedir: srcDir, includes: '*.groovy')
    mkdir(dir: destDir)
    unzip(src: zippedFile, dest: destDir)
    echo 'done zipping and unzipping'
}
ant.with {
    echo 'deleting created files'
    delete(includeEmptyDirs: true) {
        fileset(dir: destDir)
        fileset(file: zippedFile)
    }
    echo 'deleted created files'
}

/**
 * create by
 * @author hujin 2020/9/19
 */
// simple Copy
def ant = new AntBuilder()
ant.copy(file: "src.txt", tofile: "dest.txt")

// copy a file to a directory
def ant = new AntBuilder()
ant.copy(file: "src.txt", todir: "backup")

// Overwriting th destination file
def ant = new AntBuilder()
ant.copy(file: "src.txt", tofile: "dest.txt", overwrite: true)

// copy a directory
def ant = new AntBuilder()
ant.copy(todir: "backup") {
    fileset(dir: "images")
}

// selectively including/excluding files
// this will not copy files in subdirectories
// due to the pattern in include and exclude
def ant = new AntBuilder()
ant.copy(todir: "backup", overwrite: true) {
    fileset(dir: "images") {
        include(name: "*.jpg")
        exclude(name: "*.txt")
    }
}

// this will copy files in subdirectories
// due to the pattern in include and exclude
def ant = new AntBuilder()
ant.copy(todir: "backup", overwrite: true) {
    fileset(dir: "images") {
        include(name: "**/*.jpg")
        exclude(name: "**/*.txt")
    }
}

// flatten the directory structure on copy
def ant = new AntBuilder()
ant.copy(todir: "backup", overwrite: true, flatten: true) {
    fileset(dir: "images") {
        include(name: "**/*.jpg")
        exclude(name: "**/*.txt")
    }
}

// move/rename file
// using the File method
File src = new File("src.txt")
src.renameTo(new File("dest.txt"))

// using the operating system(linux)
"mv src.txt dest.txt".execute()

// using AntBuilder
def ant = new AntBuilder()
ant.move(file: "src.txt", tofile: "dest.txt")

// delete file
// using the File method
new File("src.txt").delete()

// using the operating system(linux)
"rm src.txt".execute()

// using AntBuilder
def ant = new AntBuilder()
ant.delete(file: "src.txt")

// delete directory
// using the File method
new File("tmp").deleteDir()

// using operating system(linux)
"rmdir tmp".execute()

// using AntBuilder
def ant = new AntBuilder()
ant.delete(dir: "tmp", includeEmptyDirs: true)

// delete selected files from a dirctory
def ant = new AntBuilder()
ant.delete(includeEmptyDirs: true) {
    fileset(dir: "tmp", includes: "**/*.bak")
}

// delete directory and file
def ant = new AntBuilder()
ant.delete(includeEmptyDirs: true) {
    fileset(dir: "destDir")
    fileset(file: "zippedFile")
}

// zip/unzip
def ant = new AntBuilder()

// zip files
ant.zip(basedir: "images", destfile: "backup.zip")

// tar files
ant.tar(basedir: "iamges", destfile: "backup.tar")
ant.gzip(zipfile: "backup.tar.gz", src: "backup.tar")
ant.bzip2(zipfile: "backup.tar.bz2", src: "backup.tar")

// zipping up selected files
def ant = new AntBuilder()
ant.zip(destfile: "backup.zip") {
    fileset(dir: "images") {
        include(name: "**/*.jpg")
        exclude(name: "**/*.txt")
    }
}

// unzip files
def ant = new AntBuilder()
ant.unzip(src: "backup.zip", dest: "dest")

// untar files
ant.gunzip(src: "backup.tar.gz")
ant.bunzip2(src: "backup.tar.bz2")
ant.untar(src: "backup.tar", dest: "dest")

// unziping selected files
def ant = new AntBuilder()
ant.unzip(src: "backup.zip", dest: "dest") {
    patternset {
        include(name: "**/*.jpg")
        exclude(name: "**/*.txt")
    }
}