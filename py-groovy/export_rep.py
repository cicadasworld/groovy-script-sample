import sys
import os
import shutil

repo = r'C:\dev\MavenRepo\RepoData\maven2'


def main():
	if len(sys.argv) < 3:
		print('usage: %s <src_dir> <target_dir>' % sys.argv[0])
	else:
		src_dir = sys.argv[1]
		target_dir = sys.argv[2]
		diff(src_dir, target_dir)


def diff(src_dir, target_dir):
	jars = []
	for _, _, files in os.walk(src_dir):
		for file in files:
			jars.append(file)

	for jar in jars:
		find_dirs(jar, target_dir)


def find_dirs(jar, target_dir):
	dirs = []
	for root, _, files in os.walk(repo):
		for file in files:
			if file == jar:
				f = os.path.join(root, file)
				d = os.path.dirname(f)
				dirs.append(d)
	export(dirs, target_dir)


def export(dirs, target_dir):
	for d in dirs:
		t = d.replace(repo, '')
		new_dir = target_dir + t
		os.makedirs(new_dir, exist_ok=True)
		for root, _, files in os.walk(d):
			for file in files:
				f = os.path.join(root, file)
				shutil.copy(f, new_dir)


if __name__ == '__main__':
	main()
