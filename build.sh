#!/bin/sh
echo "===使用mvn构建school工程"
mvn clean install
#定义当前目录
DIR='./'
#k8s部署文件夹
K8S_DIR="./k8s"
if [ ! -d $K8S_DIR ]
then
  mkdir $K8S_DIR
fi

#遍历所有的项目
for file in `ls $DIR`
do
  if [ $file != ".."   -a  $file != "." -a  $file = "auth" -a $file != "k8s" -a $file != "istio"  -a  -d "$DIR/$file" ]
  then
    jarDir="$DIR$file"
    imageName="tangbao203/$file"
    echo "=====开始构建镜像 $imageName  从目录:$jarDir"
    echo "========="
    #docker rmi $imageName
    version=`redis-cli -a 2011 -n 9 incr "image_${imageName}_version"`
    echo "=====当前镜像:$imageName 的tag:${version}"
    docker  build -t $imageName:$version $jarDir
    echo "========="
    echo "=====开始上传镜像 $imageName "
    echo "========="
    docker push $imageName
    echo "cp $DIR$file/deployment.yml" "$K8S_DIR/$file"_deployment.yml
    sed -in "s/\(image:[ ]*tangbao203\/[a-z]*:\)[0-9a-z]*/\1${version}/g" "$DIR$file/deployment.yml"
    cp "$DIR$file/deployment.yml" "$K8S_DIR/$file"_deployment.yml
    cp "$DIR$file/service.yml" "$K8S_DIR/$file"_service.yml
  fi
done