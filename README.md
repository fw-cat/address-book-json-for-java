# 連絡帳管理 for JSON

## 概要
* 専門学校の授業で作成したプログラムになります
* 仕様に関しては授業で定義した範囲になります
* 事前にgsonのjarファイルをダウンロードしてください

## 開発環境
[こちら](https://search.maven.org/artifact/com.google.code.gson/gson/2.10.1/jar)GsonのJarファイルをダウンロードしてください  
![Java](https://img.shields.io/badge/Java-17-blue)

## コンパイル - Javac
~~~sh
$ javac -cp gson-2.10.1.jar jp/ac/ohara/*.java Main.jav
~~~

## 実行 - Java
~~~sh
$ java -classpath ".:gson-2.10.1.jar" Main
~~~
