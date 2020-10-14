#!/usr/bin/env python
# encoding: gb2312
# april4lee, 2020/5/21 15:01:46

"""
将各个repo中的etc目录拷贝到${GTCLOUD_ETC_DIR}，聚合在一起。
    C:/Temp/GTCloud3.0/webetc
        common/
        ...
"""

import os
import sys
import time
import os.path
import platform
import subprocess

def get_envvar(var, force=True):
    """
    """
    d = os.environ.get(var, '')
    if len(d) > 0:
        return d
    if not force:
        return None
    emsg = r"ERROR: env-var '%s' not set correctly." % var
    raise EnvironmentError(emsg)

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

def remove_dir(dirname):
    """
    """
    if not os.path.isdir(dirname):
        return
    if 'win' in sys.platform:
        cmd = 'rmdir /s /q "%s"' % dirname
    else:
        cmd = 'rm -rf "%s"' % dirname
    execute_shell(cmd, is_shell=True, ignore_error=True)

def make_dirs(dirname):
    """
    """
    if os.path.isdir(dirname):
        return
    if 'win' in sys.platform:
        cmd = 'mkdir "%s"' % dirname
    else:
        cmd = 'mkdir -p "%s"' % dirname
    execute_shell(cmd, is_shell=True, ignore_error=False)

def merge_folder(src_dir, dest_dir):
    """
    """
    if 'win' in sys.platform:
        cmd = 'xcopy /I /E /Y "%s" "%s"' % (src_dir, dest_dir)
        execute_shell(cmd, is_shell=True, ignore_error=True)
    else:
        make_dirs(dest_dir)
        for fod in os.listdir(src_dir):
            fullpath = os.path.join(src_dir, fod)
            if os.path.isdir(fullpath):
                cmd = 'cp -rf "%s" "%s"' % (fullpath, dest_dir)
            else:
                cmd = 'cp -f "%s" "%s"' % (fullpath, dest_dir)
            execute_shell(cmd, is_shell=True, ignore_error=False)

################################################################################

def main():
    """
    """
    src_root = get_envvar('GTCLOUD_SRC_ROOT') #某个盘符
    etc_dir  = get_envvar('GTCLOUD_ETC_DIR')

    # 删除旧目录
    remove_dir(os.path.normpath(etc_dir))
    make_dirs(os.path.normpath(etc_dir))

    # 合并各repo下的etc目录到${GTCLOUD_ETC_DIR}
    git_repos = [
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
    for repo in git_repos:
        src_dir = os.path.normpath('%s/gtcloud/%s/etc' % (src_root, repo))
        if not os.path.isdir(src_dir):
            continue
        dest_dir = os.path.normpath(etc_dir)
        merge_folder(src_dir, dest_dir)

if __name__ == '__main__':
    main()
