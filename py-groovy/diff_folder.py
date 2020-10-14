#!/usr/bin/env python
# encoding: gb2312
# april4lee, 2018/12/12 17:36:00

""" 比较两个目录下的文件列表
"""

import sys
import os.path

def diff_dirs(dir1, dir2):
    """
    """
    files1 = dict()
    for child in os.listdir(dir1):
        full_name = os.path.join(dir1, child)
        if os.path.isfile(full_name):
            files1[child] = 1

    files2 = dict()
    for child in os.listdir(dir2):
        full_name = os.path.join(dir2, child)
        if os.path.isfile(full_name):
            files2[child] = 1

    print('两个目录下都有的文件:')
    n = 0
    for f in files1:
        if f in files2:
            print('    ' + f)
            n += 1
    print('共%d个文件' % n)

    print('')
    print('%s下独有的文件:' % dir1)
    n = 0
    for f in files1:
        if f not in files2:
            print('    ' + f)
            n += 1
    print('共%d个文件' % n)

    print('')
    print('%s下独有的文件:' % dir2)
    n = 0
    for f in files2:
        if f not in files1:
            print('    ' + f)
            n += 1
    print('共%d个文件' % n)


def print_usage():
    """
    """
    _, f = os.path.split(__file__)
    print('usage: python %s <dir1> <dir2>' % f)
    print('例子:  python %s g:\\gtserver d:\\gtserver' % f)

if __name__ == '__main__':
    if len(sys.argv) != 3:
        print_usage()
        sys.exit(2)
    dir1 = sys.argv[1]
    dir2 = sys.argv[2]
    diff_dirs(dir1, dir2)

