@echo Compile Java Source: 
javac -encoding utf8 HelloWorld.java
@echo Run HelloWorld.class:
pushd
cd ..
java p00_helloworld.HelloWorld
popd