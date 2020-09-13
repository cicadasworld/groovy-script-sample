/**
 * create by
 * @author hujin 2020/9/13
 */
def srcRoot = System.getenv('GTCLOUD_SRC_ROOT')
def etcDir = System.getenv('GTCLOUD_ETC_DIR')

// 删除旧目录
def ant = new AntBuilder()
if (new File(etcDir).exists()) {
    ant.with {
        delete(includeEmptyDirs: true) {
            fileset(dir: etcDir)
        }
    }
}

// 合并各repo下的etc目录到${GTCLOUD_ETC_DIR}
def gitRepo = [
    'gtcloud-commons',
    'gtcloud-extras',
    'gtcloud-indexdb',
    'gtcloud-jobman',
    'gtcloud-security',
    'gtcloud-geoservice',
    'gtcloud-blobstore',
    'gtcloud-datamgmt',
    'gtcloud-35jdapps',
    'gtcloud-datamgmt'
]

def srcDirs = []
gitRepo.each { repo ->
    String srcDir = "${srcRoot}/gtcloud/${repo}/etc"
    srcDirs << srcDir
}

ant.with {
    mkdir(dir: etcDir)
    copy(todir: etcDir) {
        srcDirs.each { srcDir ->
            fileset(dir: srcDir)
        }
    }
}