/**
 * create by
 * @author hujin 2020/9/13
 */

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