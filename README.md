git config --global user.name "guohongliang"
git config --global user.email "guohongliang@163.com"
git config --global --list
ssh-keygen -t rsa -C "guohongliang@163.com"


#添加远程仓库 git@github.com:guuohongliang1818/suanfa.git
git remote add origin 仓库地址
git remote set-url origin 新的仓库地址
git remote -v 查看远程仓库地址

