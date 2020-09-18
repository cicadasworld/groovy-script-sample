import groovy.io.FileType

/**
 * create by
 * @author hujin 2020/9/12
 */

// search file or folder under a folder recursively
new File('../../../../').eachFileRecurse {
    println it.name
}

// search only file under a folder recursively
new File('../../../../').eachFileRecurse(FileType.FILES) {
    println it.name
}

// search only folder under a folder recursively
new File('../../../../').eachDirRecurse {
    println it.name
}