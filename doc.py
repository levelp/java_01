# ~*~ 
import os
import sys

PREFIX = u'//'

sys.stdout = open("README.md", "w", encoding="utf-8")


def get_extension(file_name):
    return os.path.splitext(file_name)[1]

def lang(file_name):
    extension = get_extension(file_name)
    if extension in ['.cpp', '.c', '.h', '.hpp']:
        return 'cpp'
    if extension == '.java':
        return 'java'
    return "TODO: doc.py Сделать обработчик **" + extension + "**";



def parse(file_name):
    """
    :param file_name: имя файла
    :return:
    """
    code = False
    with open(file_name, "r", encoding="utf-8-sig") as f:
        for line in f:
            if '//-->' in line:
                print('``` ' + lang(file_name))
                code = True
                continue
            if '//<--' in line:
                print('```')
                print()
                code = False
                continue
            if code:
                print(line.rstrip())
                continue
            s = line.strip()
            if s.startswith(PREFIX):
                print(s[len(PREFIX):].strip())


from os import listdir
from os.path import isfile, join

mypath = "."
extensions = [".cpp", ".c", ".h", ".hpp", ".java", ".md"]
special_files = ["pom.xml"]

all_files = []
for root, dirs, files in os.walk("."):
    for name in files:
        if (get_extension(name) in extensions) or (name in special_files):
            # Пропускаем готовые README.md
            # if name.upper() == "README.md".upper():
            # continue
            file_name = os.path.join(root, name)
            #print(file_name)
            #if name == "README.md":
            #    continue
            if file_name == '.\\README.md':
                continue
            all_files.append(file_name)

for file_name in sorted(all_files):
    # Markdown файлы просто передаём на выход не меняя
    if get_extension(file_name).lower() == ".md":
        for line in open(file_name, 'r', encoding="utf-8"):
            print(line.rstrip())
        print()
        continue
    # print(file_name)
    parse(file_name)


# [f for f in listdir(mypath) if isfile(join(mypath, f))]

