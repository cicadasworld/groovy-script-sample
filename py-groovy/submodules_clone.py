#!/usr/bin/env python
# encoding: gb2312
# april4lee, 2020/6/23 18:58:59

"""
根据当前开发者的任务情况，从GitLab仓库中克隆对应的子模块。
"""

import os
import sys
from optparse import OptionParser
import subprocess

##
## Git-global-settings:
## git config --global user.name "somebody"
## git config --global user.email "somebody@gttech.com"
## git config --global credential.helper store
##

def execute_shell(cmd, is_shell=True, ignore_error=False, reap_result=False, env=None, feedback=True):
    """execute a shell script and return its output strings
    """
    if feedback:
        print('Running: ' + cmd)
    if reap_result:
        process = subprocess.Popen(cmd, shell=is_shell, stdout=subprocess.PIPE, env=env)
    else:
        process = subprocess.Popen(cmd, shell=is_shell, env=env)
    process.wait()
    stdout = process.communicate()[0]
    if not ignore_error and process.returncode:
        raise Exception(r"execute cmd='%s' failed, return code is %d" % (cmd, process.returncode))
    else:
        return stdout


def clone_one_repo(repo_name, work_branch):
    """
    """
    # 看当前开发者是否需要负责该模块
    if repo_name == 'gtcloud-devman':
        pass
    else:
        # gtcloud-commons --> GTCLOUD_COMMONS_DEV
        env_name = repo_name.upper().replace('-', '_') + '_DEV'
        d = os.environ.get(env_name, '')
        if len(d) == 0:
            # 没有设置环境变量: 不需要该模块
            return
    cmd = 'git clone http://gitlab.gttech.com/gtcloud/%s.git --branch %s' % (repo_name, work_branch)
    # print(cmd)
    execute_shell(cmd)

def main():
    """
    """
    usage = r"""
  %prog [options]

说明：
  根据当前开发者的任务情况，从GitLab仓库中克隆gtcloud对应的子模块。
  [options]指定其它可选参数，若不指定则这些参数将使用默认值。
"""
    parser = OptionParser(usage=usage)

    parser.add_option("-b",
                      "--branch",
                      default='develop',
                      dest='work_branch',
                      help='克隆后切换到哪个分支作为活动分支，默认为develop分支')
    options, args = parser.parse_args()

    work_branch = options.work_branch

    repo_names = [
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
    for repo_name in repo_names:
        clone_one_repo(repo_name, work_branch)

if __name__ == '__main__':
    main()
