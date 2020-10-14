#!/usr/bin/env python
# encoding: gb2312
# april4lee, 2018/4/5 9:48:27

""" 用于生成"清除gradle及eclipse-gradle插件生成的临时文件"的命令
"""

import sys
import os.path
import subprocess

NAME_TO_CLEAN = ['.gradle', '.settings', '.classpath', '.project', 'bin', 'build', 'var', 'out', '.idea', 'derby.log']

def clean_dir(current_dir, level):
    """
    """
    for child in os.listdir(current_dir):
        full_name = os.path.join(current_dir, child)
        if not child in NAME_TO_CLEAN:
            if level <= 1 and os.path.isdir(full_name):
                clean_dir(full_name, level+1)
        else:
            if os.path.isfile(full_name):
                execute_shell('del %s' % full_name)
            else:
                execute_shell('rmdir /s /q %s' % full_name)

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

def print_usage():
    """
    """
    _, f = os.path.split(__file__)
    print('usage: python %s <gradleProjDir>' % f)
    print('例子:  python %s L:\\gtcloud' % f)

if __name__ == '__main__':
    if len(sys.argv) != 2:
        print_usage()
        sys.exit(2)

    # delete stuff in U:/gtcloud/
    gradleProjDir = sys.argv[1]
    clean_dir(gradleProjDir, 0)

    # delete stuff in U:/eclipse_ws/
    # U:/
    #   eclipse_ws/
    #   gtcloud/
    parentDir, _ = os.path.split(gradleProjDir)
    eclipseWsDir = os.path.normpath(parentDir + '/eclipse_ws')
    if os.path.isdir(eclipseWsDir):
        for child in os.listdir(eclipseWsDir):
            full_name = os.path.join(eclipseWsDir, child)
            if os.path.isfile(full_name):
                execute_shell('del %s' % full_name)
            else:
                execute_shell('rmdir /s /q %s' % full_name)
