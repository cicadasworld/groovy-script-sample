#!/usr/bin/env python
# encoding: gb2312
# april4lee, 2018/10/29 15:48:27

""" 用于"检查js文件是否能 通过yuicompressor"的处理
"""

import sys
import os.path
import subprocess
import tempfile

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

def check_js_file(full_name, check_tool):
    """
    """
    print('processing ' + full_name)
    temp_file = tempfile.mktemp(suffix='.js')
    cmd = 'java -jar "%s" --type js --charset gbk "%s" > "%s"' % (check_tool, full_name, temp_file)
    try:
        execute_shell(cmd)
    except:
        sys.exit(1)    
    finally:    
        os.unlink(temp_file)

def process_dir(current_dir, check_tool):
    """
    """
    for child in os.listdir(current_dir):
        full_name = os.path.join(current_dir, child)
        if os.path.isdir(full_name):
            process_dir(full_name, check_tool)
            continue
        if os.path.isfile(full_name) and full_name.endswith('.js'):
            check_js_file(full_name, check_tool)

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
    if process.returncode != 0:
        raise Error('returncode != 0')

def print_usage():
    """
    """
    _, f = os.path.split(__file__)
    print('usage: python %s <jsdir>|<jsfile>' % f)

if __name__ == '__main__':
    if len(sys.argv) != 2:
        print_usage()
        sys.exit(2)
    path = sys.argv[1]

    check_tool = get_envvar('GTCLOUD_SRC_ROOT') + '/gtcloud/gtcloud-devman/build2/bcommon/b_yuicompressor-2.4.8.jar'
    check_tool = os.path.normpath(check_tool)
    if os.path.isfile(path):
        check_js_file(path, check_tool)
    else:    
        process_dir(path, check_tool)
