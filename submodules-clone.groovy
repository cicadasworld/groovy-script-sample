import groovy.cli.picocli.CliBuilder

/**
 * create by
 * @author hujin 2020/9/13
 */
def cli = new CliBuilder(usage: """
    ${this.class.name}.groovy [options]
""")
cli.with {
    b(longOpt: 'branch', args: 1, argName: 'WORK_BRANCH',
      '克隆后切换到哪个分支作为活动分支，默认为develop分支')
}

def options = cli.parse(args)
if (options.h) {
    cli.usage()
    System.exit 0
}
if (options.b) {
    String workBranch = options.b
    repoNames = [
            'gtcloud-commons',
            'gtcloud-extras',
            'gtcloud-blobstore',
            'gtcloud-indexdb',
            'gtcloud-jobman',
            'gtcloud-security',
            'gtcloud-geoservice',
            'gtcloud-datamgmt',
            'gtcloud-35jdapps',
            'gtcloud-hjjmbapps',
            'gtcloud-gtmap4web',
            'gtcloud-devman',
            'gtcloud-build2',
            'gtcloud-otherapplications',
    ]
    repoNames.each {repoName ->
        if(repoName == 'gtcloud-devman') {
            return
        }
        def envName = repoName.toUpperCase().replace('-', '_') + '_DEV'
        if (!System.getenv(envName)) {
            return // 没有设置环境变量: 不需要该模块
        }
        def command = "git clone http://gitlab.gttech.com/gtcloud/${repoName}.git --branch ${workBranch}"
        execute(command)
    }
}

void execute(GString command) {
    def process = command.execute()
    def out = new StringBuffer()
    def err = new StringBuffer()
    process.consumeProcessOutput(out, err)
    process.waitFor()
    if (out.size() > 0) println out
    if (err.size() > 0) println err
}