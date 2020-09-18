import groovy.io.FileType

/**
 * create by
 * @author hujin 2020/9/13
 */
if (args.length != 1) {
    println "Usage: ${this.class.name}.groovy <jsdir>|<jsfile>"
    System.exit 1
}

String path = args[0]
def checkTool = System.getenv('GTCLOUD_SRC_ROOT') + '/gtcloud/gtcloud-devman/build2/bcommon/b_yuicompressor-2.4.8.jar'
new File(path).eachFileRecurse(FileType.FILES) { file ->
    if (file.name.endsWith('.js')) {
        println "processing ${file.absolutePath}"
        def tempFile = File.createTempFile('temp', '.js')
        def command = "java -jar $checkTool --type js --charset gbk ${file.absolutePath} > ${tempFile.path}"
        def process = command.execute()
        def out = new StringBuffer()
        def err = new StringBuffer()
        process.consumeProcessOutput(out, err)
        process.waitFor()
        if (out.size() > 0) println out
        if (err.size() > 0) println err
    }
}