#!/usr/bin/env python
# encoding: gb2312
# april4lee, 2019/6/1 8:51:14

""" ���Ի������޸�Cynosure����������ֹ��ͬ�����߳�ͻ��
"""

import sys
import os.path

def print_usage():
    """
    """
    _, f = os.path.split(__file__)
    print('usage: python %s <cynosuregroups.txt����Ŀ¼> <newGroupName>' % f)
    print('����:  python %s G:\\Temp\BZK-0.1\\bzkmaster BzkGroupLYM' % f)

def modify_file(file_to_modify, new_group_name):
    """
    """
    fin = open(file_to_modify, 'r')
    src_lines = fin.readlines()
    fin.close()

    with open(file_to_modify, 'w') as fout:
        for line in src_lines:
            if line.startswith('cynosure.groupName'):
                fout.write('cynosure.groupName = ' + new_group_name)
                fout.write('\n')
            else:
                fout.write(line)

if __name__ == '__main__':
    if len(sys.argv) != 3:
        print_usage()
        sys.exit(2)
    pivot_dir = sys.argv[1]
    new_group_name = sys.argv[2]

    cynosuregroups_file = os.path.join(pivot_dir, 'cynosuregroups.txt')
    if not os.path.isfile(cynosuregroups_file):
        sys.stderr.write('ERROR: �ļ�������: ' + cynosuregroups_file)
        sys.exit(3)

    with open(cynosuregroups_file, 'r') as fin:
        for line in fin:
            s = line.strip()
            if s.startswith('#'):
                continue
            file_to_modify = os.path.join(pivot_dir, s)
            file_to_modify = os.path.normpath(file_to_modify)
            print('modify ' + file_to_modify)
            modify_file(file_to_modify, new_group_name)

