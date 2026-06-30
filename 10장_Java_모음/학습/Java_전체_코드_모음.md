# Java 전체 코드 모음 (정보처리기사 실기)

---

## 목차
1. [기본 입출력](#1-기본-입출력)
2. [연산자 / 진법](#2-연산자--진법)
3. [제어문 (for / while / switch)](#3-제어문-for--while--switch)
4. [break / continue](#4-break--continue)
5. [배열 / 문자열](#5-배열--문자열)
6. [클래스 / 상속 / 다형성](#6-클래스--상속--다형성)
7. [인터페이스 / 추상클래스](#7-인터페이스--추상클래스)
8. [예외처리](#8-예외처리)
9. [기타 / 기출 따라잡기](#9-기타--기출-따라잡기)
10. [정답 모음](#10-정답-모음)
11. [풀이 & 포인트 모음](#11-풀이--포인트-모음)

---

## 1. 기본 입출력

### 문제 01 데이터 입출력 - Java 예상체크1

```java
import java.util.Scanner;

public class Test {
	public static void main(String args[ ]) {
		Scanner scan = new Scanner(System.in); 
		int a = scan.nextInt( ); 
		int b = scan.nextInt( ); 
		System.out.printf("%d", a + b); 
		scan.close( );
	}
}
```

### 문제 02 데이터 입출력 - Java

```java
import java.util.Scanner;
public class Test
{
	public static void main(String[] args)
	{
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		System.out.printf("a * 3 = %d\n", a * 3);
		System.out.println("a / 2 = " + (a / 2));
		System.out.print("a - 1 = " + (a - 1));
		scan.close();
	}
}
```

### 문제 03 기출 따라잡기 - 데이터 입출력

(동일 코드: 문제 01 데이터 입출력 - Java 예상체크1)

```java
import java.util.Scanner;
public class Test {
	public static void main(String args[]) {
		Scanner scan = new Scanner(System.in);
		int a = scan.nextInt();
		int b = scan.nextInt();
		System.out.printf("%d", a + b);
		scan.close( );
	}
}
```

---

## 2. 연산자 / 진법

### 문제 04 진법 변환

```java
public class Problem {
	public static void main(String[] args) {
		int a = 035, b = 0x35, c = 35;
		System.out.printf("%d\n", a);
		System.out.printf("%d\n", b);
		System.out.printf("%d\n", c);
	}
}
```

### 문제 05 삼항 연산자

```java
public class Problem {
	public static void main(String[] args) {
		int j, k, L, result;
		j = 10;
		k = 20;
		L = 30;
		result = j < k ? k++ : --L;
		System.out.printf("%d %d %d\n", result, k, L);
	}
}
```

### 문제 06 산술 연산자 우선순위

```java
public class Problem {
	public static void main(String[] args) {
		int a, b = 10;
		a = 20 % 11 / 3 * 5 - b;
		System.out.printf("%d\n", a);
	}
}
```

### 문제 07 비트 / 논리 복합 연산자

```java
public class Problem {
	public static void main(String[] args){
		int a, b, c, hap;
		a = b = c = 2;
		hap = ++a | b-- & c--;
		System.out.printf("%d %d %d %d", hap, a, b, c);
	}
}
```

### 문제 08 삼항 연산자 - 메서드

```java
public class Test {
	public static void main(String[] args) {
		System.out.print(Test.check(1));
	}
	static String check(int num){
		return (num >= 0) ? "positive" : "negative";
	}
}
```

### 문제 09 비트 논리 연산자

```java
public class Test {
	public static void main(String[] args) {
		int w = 3, x = 4, y = 3, z = 5;
		if((w == 2 | w == y) & !(y > z) & (1 == x ^ y != z)) {
			w = x + y;
			if(7 == x ^ y != w)
				System.out.println(w);
			else
				System.out.println(x);
		}
		else {
			w = y + z;
			if(7 == y ^ z != w)
				System.out.println(w);
			else
				System.out.println(z);
		}
	}
}
```

### 문제 10 break와 continue 기출체크2 (※ C 코드 포함 주의)

```java
#include <stdio.h>
main() {
	int input = 101110;
	int di = 1;
	int sum = 0;
	while (1) {
		if (input == 0) break;
		sum = sum + (input % 10) * di;
		di = di * 2;
		input = input / 10;
	}
	printf("%d", sum);
}
```

> **주의**: 이 파일은 C 언어 코드입니다 (Java 파일에 포함되어 있으나 C 문법).

---

## 3. 제어문 (for / while / switch)

### 문제 11 for 누적합

```java
public class Test {
	public static void main(String[] args) {
		int j, i;
		for (j = 0, i = 0; i <= 5; i++) {
			j += i;
			System.out.print(i);
			if (i == 5) {
				System.out.print("=");
				System.out.print(j);
			}
			else
				System.out.print("+");
		}
	}
}
```

### 문제 12 3의 배수이자 2의 배수

```java
public class Test {
	public static void main(String[] args) {
		int r = 0;
		for (int i = 1; i < 999; i++) {
			if (i % 3 == 0 && i % 2 == 0)
				r = i;
		}
		System.out.print(r);
	}
}
```

### 문제 13 while + 곱셈

```java
public class Test {
	public static void main(String[] args) {
		int i = 0, c = 0;
		while (i < 10) {
			i++;
			c *= i;
		}
		System.out.println(c);
	}
}
```

### 문제 14 Thread + while

```java
class Car implements Runnable {
	int a;
	public void run() {
		try {
			while(++a < 100) {
				System.out.println("miles traveled : " + a);
				Thread.sleep(100);
			}
		} catch(Exception E) { }
	}
}

public class Test {
	public static void main(String args[]) {
		Thread t1 = new Thread(new Car());
		t1.start();
	}
}
```

---

## 4. break / continue

### 문제 15 break와 continue 기출체크1

```java
public class Test{
	public static void main(String[] args){
		int a = 0, sum = 0;
		while (a < 10) {
			a++;
			if (a % 2 == 1)
				continue;
			sum += a;
		}
		System.out.println(sum);
	}
}
```

---

## 5. 배열 / 문자열

### 문제 16 배열 + 문자열 역방향 출력

```java
public class Test {
	public static void main(String[] args) {
		String str = "agile";
		int x[] = { 1, 2, 3, 4, 5 };
		char y[] = new char[5];
		int i = 0;
		while (i < str.length()) {
			y[i] = str.charAt(i);
			i++;
		}
		for (int p : x) {
			i--;
			System.out.print(y[i]);
			System.out.print(p + " ");
		}
	}
}
```

### 문제 17 2진수 변환 배열

```java
public class Test {
	public static void main(String[] args) {
		int a[] = new int[8];
		int i = 0;
		int n = 10;
		while(n > 0) {
			a[i++] = n % 2;
			n /= 2;
		}
		for(i = 7; i >= 0; i- -)
			System.out.print(a[i]);
	}
}
```

### 문제 18 비정형 2차원 배열

```java
public class Test {
	public static void main(String[] args) {
		int aa[][] = { {45, 50, 75},{89} };
		System.out.println(aa[0].length);
		System.out.println(aa[1].length);
		System.out.println(aa[0][0]);
		System.out.println(aa[0][1]);
		System.out.println(aa[1][0]);
	}
}
```

### 문제 19 2차원 배열 출력

(동일 코드: 기출 따라잡기_문제2 와 문제 27 동일)

```java
public class Test {
	public static void main(String[] args) {
		int ary[][] = new int[3][5];
		int n = 1;
		for(int i = 0; i < 3; i++) {
			for(int j = 0; j < 5; j++) {
				ary[i][j] = j * 3 + i + 1;
				System.out.print(ary[i][j] + " ");
			}
			System.out.println( );
		}
	}
}
```

### 문제 20 배열 반환

```java
public class Test {
	static int[] arr() {
		int a[] = new int[4];
		int b = a.length;
		for(int i = 0; i < b; i++)
			a[i] = i;
		return a;
	}
	public static void main(String[] args) {
		int a[] = arr();
		for(int i = 0; i < a.length; i++)
			System.out.print(a[i] + " ");
	}
}
```

### 문제 21 배열 순위 계산

```java
public class Test {
	public static void main(String[] args) {
		int result[] = new int[5];
		int arr[] = { 77, 32, 10, 99, 50 };
		for(int i = 0; i < 5; i++) {
			result[i] = 1;
			for(int j = 0; j < 5; j++)
				if(arr[i] < arr[j])
					result[i]++;
		}
		for(int k = 0; k < 5; k++)
			System.out.print(result[k]);
	}
}
```

### 문제 22 문자열 split

```java
public class Test {
	public static void main(String[] args) {
		String str = "ITISTESTSTRING";
		String[] result = str.split("T");
		System.out.print(result[3]);
	}
}
```

### 문제 23 문자열 == vs equals

```java
public class Test {
	public static void main(String[] args) {
		String str1 = "Programming";
		String str2 = "Programming";
		String str3 = new String("Programming");
		System.out.println(str1==str2);
		System.out.println(str1==str3);
		System.out.println(str1.equals(str3));
		System.out.println(str2.equals(str3));
	}
}
```

### 문제 24 객체 배열 참조 스왑

(동일 코드: 문제 24 과 문제 55 동일)

```java
public class Main {
	public static class BO {
		public int v;
		public BO(int v) {
			this.v = v;
		}
	}
	public static void main(String[] args) {
		BO a = new BO(1);
		BO b = new BO(2);
		BO c = new BO(3);
		BO[] arr = {a, b, c};
		BO t = arr[0];
		arr[0] = arr[2];
		arr[2] = t;
		arr[1].v = arr[0].v;
		System.out.println(a.v + "a" + b.v + "b" + c.v);
	}
}
```

### 문제 25 배열 참조 동일성 비교

```java
public class Test {
	public static void check(int[] x, int[] y)
	{
		if(x == y) System.out.print("O");
		else System.out.print("N");
	}
	public static void main(String[] args) {
		int a[] = new int[] {1, 2, 3, 4};
		int b[] = new int[] {1, 2, 3, 4};
		int c[] = new int[] {1, 2, 3};
		check(a, b);
		check(b, c);
		check(a, c);
	}
}
```

### 문제 26 재귀 + 문자열 중복 제거

```java
public class Test {
	public static String rf(String str, int index, boolean[] seen) {
		if(index < 0) return "";
		char c = str.charAt(index);
		String result = rf(str, index-1, seen);
		if(!seen[c]) {
			seen[c] = true;
			return c + result;
		}
		return result;
	}
	public static void main(String[] args) {
		String str = "abacabcd";
		int len = str.length( );
		boolean[] seen = new boolean[256];
		System.out.print(rf(str, len-1, seen));
	}
}
```

### 문제 27 String 배열 equals 비교

```java
public class Main{
	static String[] x = new String[3];
	static void func(String[] x, int y) {
		for(int i = 1; i < y; i++) {
			if(x[i-1].equals(x[i])) {
				System.out.print("O");
			}
			else {
				System.out.print("N");
			}
		}
		for (String z : x) {
			System.out.print(z);
		}
	}
	public static void main(String[] args) {
		x[0] = "A";
		x[1] = "A";
		x[2] = new String("A");
		func(x, 3);
	}
}
```

---

## 6. 클래스 / 상속 / 다형성

### 문제 28 기본 클래스 메서드

(동일 코드: 323 Java의 클래스1.java 와 동일)

```java
class ClassA {
	int a = 10;
	int funcAdd(int x, int y) {
		return x + y + a;
	}
}
public class Test {
	public static void main(String[] args) {
		int x = 3, y = 6, r;
		ClassA cal = new ClassA();
		r = cal.funcAdd(x, y);
		System.out.print(r);
	}
}
```

### 문제 29 생성자 오버라이딩 + super

```java
class ClassA {
	ClassA() {
		System.out.print('A');
		this.prn();
	}
	void prn() {
		System.out.print('B');
	}
}
class ClassB extends ClassA {
	ClassB() {
		super();
		System.out.print('D');
	}
	void prn() {
		System.out.print('E');
	}
	void prn(int x) {
		System.out.print(x);
	}
}
public class Test {
	public static void main(String[] args) {
		int x = 7;
		ClassB cal = new ClassB();
		cal.prn(x);
	}
}
```

### 문제 30 참조 전달

```java
class A {
	int a;
	int b;
}
public class Test {
	static void func1(A m) {
		m.a *= 10;
	}
	static void func2(A m) {
		m.a += m.b;
	}
	public static void main(String args[]) {
		A m = new A();
		m.a = 100;
		func1(m);
		m.b = m.a;
		func2(m);
		System.out.printf("%d", m.a);
	}
}
```

### 문제 31 기출 따라잡기 - 참조 전달

(동일 코드: 문제 30 참조 전달)

### 문제 32 static 변수

```java
class Static {
	public int a = 20;
	static int b = 0;
}

public class Test {
	public static void main(String[] args) {
		int a = 10;
		Static.b = a;
		Static st = new Static();
		System.out.println(Static.b++);
		System.out.println(st.b);
		System.out.println(a);
		System.out.print(st.a);
	}
}
```

### 문제 33 상속 + super 생성자

```java
class A {
	int a;
	public A(int a) { this.a = a; }
	void display() { System.out.println("a=" + a); }
}
class B extends A {
	public B(int a) {
		super(a);
		super.display();
	}
}
public class Test {
	public static void main(String[] args) {
		B obj = new B(10);
	}
}
```

### 문제 34 static 메서드 + 다형성

```java
public class Main {
	public static class Parent {
		public int x(int i) { return i + 2; }
		public static String id( ) { return "P"; }
	}
	public static class Child extends Parent {
		public int x(int i) { return i + 3; }
		public String x(String s) { return s + "R"; }
		public static String id( ) { return "C"; }
	}
	public static void main(String[] args) {
		Parent ref = new Child( );
		System.out.println(ref.x(2) + ref.id( ));
	}
}
```

### 문제 35 추상클래스 + 상속

```java
abstract class Animal {
	String a = " is animal";
	abstract void look();
	void show() {
		System.out.println("Zoo");
	}
}
class Chicken extends Animal {
	Chicken() {
		look();
	}
	void look() {
		System.out.println("Chicken" + a);
	}
	void display() {
		System.out.println("two wings");
	}
}
public class Test {
	public static void main(String[] args) {
		Animal a = new Chicken();
		a.show();
	}
}
```

### 문제 36 다형성 오버라이딩

(동일 코드: 문제 36 과 Section 124_기출 따라잡기_문제1 동일)

```java
class Parent { 
	void show( ) { System.out.println("parent"); }
}
class Child extends Parent { 
	void show( ) {  System.out.println("child"); }
}
public class Test {
	public static void main(String[ ] args) {
		Parent pa = new Child( );
		pa.show( );
	}
}
```

### 문제 37 오버라이딩 연쇄 + 재귀 StackOverflow 주의

```java
class SuperObject {
	public void draw() {
		System.out.println("A");
		draw();
	}
	public void paint() {
		System.out.print('B');
		draw();
	}
}
class SubObject extends SuperObject {
	public void paint() {
		super.paint();
		System.out.print('C');
		draw();
	}
	public void draw() {
		System.out.print('D');
	}
}
public class Test {
	public static void main(String[] args) {
		SuperObject a = new SubObject();
		a.paint();
		a.draw();
	}
}
```

### 문제 38 싱글톤 패턴

(동일 코드: 문제 39 와 동일 - conn1.count() 1번 추가 차이)

```java
class Connection {
	private static Connection _inst = null;
	private int count = 0;
	public static Connection get() {
		if(_inst == null) {
			_inst = new Connection();
			return _inst;
		}
		return _inst;
	}
	public void count() { count++; }
	public int getCount() { return count; }
}
public class Test {
	public static void main(String[] args) {
		Connection conn1 = Connection.get();
		conn1.count();
		Connection conn2 = Connection.get();
		conn2.count();
		Connection conn3 = Connection.get();
		conn3.count();
		conn1.count();
		System.out.print(conn1.getCount());
	}
}
```

### 문제 39 싱글톤 패턴 - count 3회

```java
class Connection {
	private static Connection _inst = null;
	private int count = 0;
	public static Connection get() {
		if(_inst == null) {
			_inst = new Connection();
			return _inst;
		}
		return _inst;
	}
	public void count() { count++; }
	public int getCount() { return count; }
}
public class Test {
	public static void main(String[] args) {
		Connection conn1 = Connection.get();
		conn1.count();
		Connection conn2 = Connection.get();
		conn2.count();
		Connection conn3 = Connection.get();
		conn3.count();
		System.out.print(conn1.getCount());
	}
}
```

### 문제 40 재귀 오버라이딩 - C 클래스

```java
class P {
	public int calc(int n) {
		if (n <= 1) return n;
		return calc(n - 1) + calc(n - 2);
	}
}
class C extends P {
	public int calc(int n) {
		if (n <= 1) return n;
		return calc(n - 1) + calc(n - 3);
	}
}
public class Test {
	public static void main(String[] args) {
		P obj = new C();
		System.out.print(obj.calc(7));
	}
}
```

### 문제 41 재귀 오버라이딩

```java
class Parent {
	int compute(int num) {
		if(num <= 1) return num;
		return compute(num - 1) + compute(num - 2);
	}
}
class Child extends Parent {
	int compute(int num) {
		if(num <= 1) return num;
		return compute(num - 1) + compute(num - 3);
	}
}
public class Test {
	public static void main(String[] args) {
		Parent obj = new Child();
		System.out.print(obj.compute(4));
	}
}
```

### 문제 42 상속 super.getX

```java
class Parent {
	int x, y;
	Parent(int x, int y) {
		this.x = x;
		this.y = y;
	}
	int getX() {
		return x*y;
	}
}
class Child extends Parent {
	int x;
	Child(int x) {
		super(x+1, x);
		this.x = x;
	}
	int getX(int n) {
		return super.getX() + n;
	}
}
public class Main {
	public static void main(String[] args) {
		Parent parent = new Child(10);
		System.out.println(parent.getX());
	}
}
```

### 문제 43 static + 상속 생성자 체인

```java
public class Main {
	public static void main(String[ ] args) {
		new Child( );
		System.out.println(Parent.total);
	}
}
class Parent {
	static int total = 0;
	int v = 1;
	public Parent( ) {
		total += ++v;
		show( );
	}
	public void show( ) {
		total += total;
	}
}
class Child extends Parent {
	int v = 10;
	public Child( ) {
		v += 2;
		total += v++;
		show( );
		}
	@Override
	public void show( ) {
		total += total * 2;
	}
}
```

### 문제 44 클래스 상속 면적 계산

```java
class Rectangle {
	int x, y;
	Rectangle(int x, int y) {
		this.x = x;
		this.y = y;
	}
	int getArea( ) {
		return x*y;
	}
}
class Square extends Rectangle {
	Square(int a) {
		super(a, a);
	}
	int getSquareArea( ) {
		return x*y;
	}
}
public class Main {
	public static void main(String[] args) {
		Square sq = new Square(10);
		System.out.println(sq.getSquareArea( ));
	}
}
```

### 문제 45 생성자 + this + 재귀

```java
class Test {
	public static void main(String args[]) {
		cond obj = new cond(3);
		obj.a = 5;
		int b = obj.func( );
		System.out.print(obj.a + b);
	}
}

class cond {
	int a;
	public cond(int a) {
		this.a = a;
	}
	public int func( ) {
		int b = 1;
		for (int i = 1; i < a; i++)
			b += a * i;
		return a + b;
	}
}
```

### 문제 46 추상클래스 + 오버로딩

```java
abstract class Vehicle {
	String name;
	abstract public String getName(String val);
	public String getName() {
		return "Vehicle name : " + name;
	}
}
class Car extends Vehicle {
	private String name;
	public Car(String val) {
		name = super.name = val;
	}
	public String getName(String val) {
		return "Car name : " + val;
	}
	public String getName(byte[] val) {
		return "Car name : " + val;
	}
}
public class Test {
	public static void main(String[] args) {
		Vehicle obj = new Car("Spark");
		System.out.print(obj.getName());
	}
}
```

### 문제 47 enum

(동일 코드: 문제 48 과 동일)

```java
enum Tri {
	A("A"), B("AB"), C("ABC");
	private String code;
		Tri(String code) {
	this.code = code;
	}
	public String code( ) {
		return code;
	}
}
public class Main {
	public static void main(String[] args) {
		Tri t = Tri.values( )[Tri.A.name( ).length( )];
		System.out.print(t.code( ));
	}
}
```

### 문제 48 enum - 동일

(동일 코드: 문제 47)

```java
enum Tri { 
    A("A"), B("AB"), C("ABC"); 
    private String code; 
    Tri(String code) { 
        this.code = code; 
        
    }
    public String code( ) { 
        return code;
        }
} 

public class Main { 
    public static void main(String[] args) { 
        Tri t = Tri.values( )[Tri.A.name( ).length( )]; 
        System.out.print(t.code( ));
        }

}
```

---

## 7. 인터페이스 / 추상클래스

### 문제 49 인터페이스 구현 - 홀수/짝수 합

```java
interface Number {
	int sum(int[] a, boolean odd);
}
public class Test {
	public static void main(String[] args) {
		int a[] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
		OENumber OE = new OENumber( );
		System.out.print(OE.sum(a, true) + ", " + OE.sum(a, false));
	}
}
class OENumber implements Number {
	public int sum(int[] a, boolean odd) {
		int result = 0;
		for (int i = 0; i < a.length; i++) {
			if ((odd && a[i] % 2 != 0) || (!odd && a[i] % 2 == 0)) {
				result += a[i];
			}
		}
		return result;
	}
}
```

### 문제 50 제네릭 + 메서드 오버로딩

(동일 코드: 문제 51 과 동일)

```java
class Printer {
	void print(Integer a) {
		System.out.print("A" + a);
	}
	void print(Object a) {
		System.out.print("B" + a);
	}
	void print(Number a) {
		System.out.print("C" + a);
	}
}
public class Main {
	public static void main(String[] args) {
		new Collection<>(0).print( );
	}
	public static class Collection<T> {
		T value;
		public Collection(T t) {
			value = t;
		}
		public void print( ) {
			new Printer( ).print(value);
		}
	}
}
```

### 문제 51 제네릭 + 메서드 오버로딩 - 동일

(동일 코드: 문제 50)

---

## 8. 예외처리

### 문제 52 예외처리 - ArithmeticException

```java
public class Main {
	public static void main(String[ ] args) {
		int a = 5, b = 0;
		try {
			System.out.print(a/b);
		}
		catch(ArithmeticException e){
			System.out.print("출력1");
		}
		catch(ArrayIndexOutOfBoundsException e) {
			System.out.print("출력2");
		}
		catch(NumberFormatException e) {
			System.out.print("출력3");
		}
		catch(Exception e) {
			System.out.print("출력4");
		}
		finally {
			System.out.print("출력5");
		}
	}
}
```

### 문제 53 예외처리 + finally

```java
public class Main {
	public static void main(String[] args) {
		int sum = 0;
		try {
			func( );
		}
		catch (NullPointerException e) {
			sum = sum + 1;
		}
		catch (Exception e) {
			sum = sum + 10;
		}
		finally {
			sum = sum + 100;
		}
		System.out.print(sum);
	}
	static void func( ) throws Exception {
		throw new NullPointerException( );
	}
}
```

### 문제 54 람다 + 예외처리

```java
public class Main {
	static interface F {
		int apply(int x) throws Exception;
	}
	public static int run(F f) {
		try {
			return f.apply(3);
		} catch (Exception e) {
			return 7;
		}
	}
	public static void main(String[] args) {
		F f = (x) -> {
			if (x > 2) {
				throw new Exception( );
			}
			return x * 2;
		};
		System.out.print(run(f) + run((int n) -> n + 9));
	}
}
```

---

## 9. 기타 / 기출 따라잡기

### 문제 55 동일 코드: 문제 24

(동일 코드: 문제 24 - 객체 배열 참조 스왑)

### 문제 56 → 6번 클래스/상속 섹션에 포함 (문제 43 참조)

---

## 10. 정답 모음

| 문제 번호 | 원본 파일명 | 출력값 |
|---|---|---|
| 문제 01 | 311 데이터 입출력 - Java 예상체크1 | 입력 의존 (a+b 출력) |
| 문제 02 | 311 데이터 입출력 - Java | 입력 의존 |
| 문제 03 | 기출 따라잡기_문제3 / 311 예상체크1 | 입력 의존 |
| 문제 04 | 문제10 (진법 변환) | `29`(줄)`53`(줄)`35` |
| 문제 05 | 문제11 (삼항 연산자) | `20 21 30` |
| 문제 06 | 문제14 (산술 연산자 우선순위) | `5` |
| 문제 07 | 문제16 (비트 / 논리 복합 연산자) | `3 3 1 1` |
| 문제 08 | 문제 07 (삼항 연산자 - 메서드) | `positive` |
| 문제 09 | Section 118_기출 따라잡기_문제8 | `7` |
| 문제 10 | 319 break와 continue 기출체크2 (C코드) | `46` |
| 문제 11 | 318 제어문 - Java 기출체크1 | `0+1+2+3+4+5=15` |
| 문제 12 | 318 제어문 - Java 기출체크2 | `996` |
| 문제 13 | 문제7 (while + 곱셈) | `0` |
| 문제 14 | 문제 31 (Thread + while) | 순서 불규칙 (`miles traveled : 1` ~ `99`) |
| 문제 15 | 319 break와 continue 기출체크1 | `30` |
| 문제 16 | 03 Java 문제 - 예제1 (배열 + 문자열 역방향) | `e1 l2 i3 g4 a5 ` |
| 문제 17 | 기출 따라잡기_문제1 (2진수 변환) | `00001010` |
| 문제 18 | 기출 따라잡기_문제12 (비정형 2차원 배열) | `3`(줄)`1`(줄)`45`(줄)`50`(줄)`89` |
| 문제 19 | 기출 따라잡기_문제2 / 문제 27 (2차원 배열) | (아래 상세 참조) |
| 문제 20 | Section 123_기출 따라잡기_문제2 (배열 반환) | `0 1 2 3 ` |
| 문제 21 | 기출 따라잡기_문제8 (배열 순위) | `24513` |
| 문제 22 | 문제17 (문자열 split) | `S` |
| 문제 23 | 문제 20 (문자열 == vs equals) | `true`(줄)`false`(줄)`true`(줄)`true` |
| 문제 24 | 문제 33 / 문제30 (객체 배열 참조 스왑) | `1a3b3` |
| 문제 25 | 문제43 (배열 참조 동일성) | `NNN` |
| 문제 26 | 문제45 (재귀 + 문자열 중복 제거) | `dcba` |
| 문제 27 | 문제48 (String 배열 equals) | `OOAAA` |
| 문제 28 | 02 Java 문제1 - 예제1 / 323 Java의 클래스1 | `19` |
| 문제 29 | 03 Java 문제2 - 예제1 (생성자 오버라이딩) | `AED7` |
| 문제 30 | 323 Java의 클래스1 기출체크1 (참조 전달) | `2200` |
| 문제 31 | 기출 따라잡기_문제5 / 323기출체크1 | `2200` |
| 문제 32 | 323 Java의 클래스1 기출체크2 (static 변수) | `10`(줄)`11`(줄)`10`(줄)`20` |
| 문제 33 | 324 Java의 클래스2 기출체크1 (상속 + super) | `a=10` |
| 문제 34 | 324 Java의 클래스2 (static 메서드 + 다형성) | `5P` |
| 문제 35 | 02 Java 문제 - 예제1 (추상클래스 + 상속) | `Chicken is animal`(줄)`Zoo` |
| 문제 36 | 문제 02 / Section 124_기출 따라잡기_문제1 | `child` |
| 문제 37 | 문제 21 (오버라이딩 연쇄) | `BDCDD` |
| 문제 38 | 문제 22 (싱글톤 패턴) | `4` |
| 문제 39 | 문제49 (싱글톤 패턴 - count 3회) | `3` |
| 문제 40 | 문제 23 (재귀 오버라이딩 - C 클래스) | `2` |
| 문제 41 | Section 124_기출 따라잡기_문제3 (재귀 오버라이딩) | `1` |
| 문제 42 | 기출 따라잡기_문제6 (상속 super.getX) | `110` |
| 문제 43 | 문제32 (static + 상속 생성자 체인) | `54` |
| 문제 44 | 문제33 (클래스 상속 면적 계산) | `100` |
| 문제 45 | Section 123_기출 따라잡기_문제4 (생성자 + this + 재귀) | `61` |
| 문제 46 | 326 Java의 활용 기출체크1 (추상클래스 + 오버로딩) | `Vehicle name : Spark` |
| 문제 47 | 문제37 (enum) | `AB` |
| 문제 48 | 문제 35 (enum - 동일) | `AB` |
| 문제 49 | 문제44 (인터페이스 구현 - 홀수/짝수 합) | `25, 20` |
| 문제 50 | 문제47 (제네릭 + 메서드 오버로딩) | `B0` |
| 문제 51 | 문제 39 (제네릭 + 메서드 오버로딩 - 동일) | `B0` |
| 문제 52 | 문제35 (예외처리 - ArithmeticException) | `출력1출력5` |
| 문제 53 | Section 127_기출 따라잡기_문제2 (예외처리 + finally) | `101` |
| 문제 54 | Section 127_기출 따라잡기_문제3 (람다 + 예외처리) | `19` |
| 문제 55 | 문제30 (동일 코드: 문제 24) | `1a3b3` |

### 문제 19 출력 상세

```
1 4 7 10 13 
2 5 8 11 14 
3 6 9 12 15 
```

---

## 11. 풀이 & 포인트 모음

---

### 문제 35 추상클래스 + 상속

**실행 추적:**
- `Animal a = new Chicken()` → Chicken 생성자 실행 → `look()` 호출
- `look()` : `System.out.println("Chicken" + a)` → `a`는 Animal의 필드 `" is animal"` → 출력: `Chicken is animal`
- `a.show()` → Animal의 `show()` : 출력 `Zoo`

**출력:**
```
Chicken is animal
Zoo
```

**핵심 포인트:** 추상클래스 필드는 부모에 정의되어 있어도 자식에서 `a` 참조 시 상속된 필드 사용. 생성자에서 `look()` 호출은 오버라이딩된 자식 메서드 실행.

---

### 문제 28 기본 클래스 메서드

**실행 추적:**
- `cal.funcAdd(3, 6)` → `3 + 6 + 10 = 19`

**출력:** `19`

**핵심 포인트:** 인스턴스 변수 a=10이 메서드 내 연산에 포함됨.

---

### 문제 16 배열 + 문자열 역방향 출력

**실행 추적:**
- str = "agile" → y = ['a','g','i','l','e'], i=5 (while 후)
- for(p : x) : p=1,2,3,4,5 순서로 enhanced for
  - p=1: i-- → i=4, y[4]='e', 출력 `e1 `
  - p=2: i-- → i=3, y[3]='l', 출력 `l2 `
  - p=3: i-- → i=2, y[2]='i', 출력 `i3 `
  - p=4: i-- → i=1, y[1]='g', 출력 `g4 `
  - p=5: i-- → i=0, y[0]='a', 출력 `a5 `

**출력:** `e1 l2 i3 g4 a5 `

**핵심 포인트:** enhanced for는 배열 x를 순방향(1→5)으로 순회하지만, i를 역방향으로 감소시켜 y를 역순으로 접근.

---

### 문제 29 생성자 오버라이딩 + super

**실행 추적:**
- `new ClassB()` → 내부적으로 `super()` (ClassA 생성자) 먼저 실행
  - ClassA 생성자: `System.out.print('A')` → A 출력
  - `this.prn()` → ClassB의 `prn()` 실행 (오버라이딩) → `System.out.print('E')` → E 출력
- ClassB 생성자 계속: `System.out.print('D')` → D 출력
- `cal.prn(7)` → `System.out.print(7)` → 7 출력

**출력:** `AED7`

**핵심 포인트:** 부모 생성자에서 `this.prn()` 호출 시, 이미 자식 객체가 생성 중이므로 자식의 오버라이딩된 메서드가 동적 바인딩으로 실행됨.

---

### 문제 11 for 누적합

**실행 추적:**
- i=0: j=0, 출력 `0+`
- i=1: j=1, 출력 `1+`
- i=2: j=3, 출력 `2+`
- i=3: j=6, 출력 `3+`
- i=4: j=10, 출력 `4+`
- i=5: j=15, 출력 `5=15`

**출력:** `0+1+2+3+4+5=15`

---

### 문제 12 3의 배수이자 2의 배수

**실행 추적:**
- 3의 배수 AND 2의 배수 = 6의 배수
- 1 ~ 998 중 6의 배수 중 가장 큰 값 = 996

**출력:** `996`

**핵심 포인트:** r = i 로 계속 덮어씀 → 마지막 값이 남음.

---

### 문제 15 break와 continue 기출체크1

**실행 추적:**
- a=1(홀수→continue), a=2(sum=2), a=3(continue), a=4(sum=6), a=5(continue), a=6(sum=12), a=7(continue), a=8(sum=20), a=9(continue), a=10(sum=30)
- 짝수만 더함: 2+4+6+8+10=30

**출력:** `30`

---

### 문제 10 break와 continue 기출체크2 (C 언어 코드)

**실행 추적 (C):**
- input=101110, 2진수 문자열을 10진수로 해석
- 101110₂ = 32+8+4+2 = 46

| 반복 | input | input%10 | di | sum |
|------|-------|----------|----|-----|
| 1 | 101110 | 0 | 1 | 0 |
| 2 | 10111 | 1 | 2 | 2 |
| 3 | 1011 | 1 | 4 | 6 |
| 4 | 101 | 1 | 8 | 14 |
| 5 | 10 | 0 | 16 | 14 |
| 6 | 1 | 1 | 32 | 46 |
| 7 | 0 | break | | |

**출력:** `46`

---

### 문제 30 참조 전달

**실행 추적:**
- m.a = 100
- func1(m): m.a = 100 * 10 = 1000
- m.b = 1000
- func2(m): m.a = 1000 + 1000 = 2000 (오답 주의: m.b는 func1 호출 후 설정된 1000)

**출력:** `2000`

**핵심 포인트:** 객체는 참조 전달 → 함수 내 필드 수정이 원본에 반영. m.b = m.a 는 func1 이후 실행됨.

---

### 문제 32 static 변수

**실행 추적:**
- `Static.b = 10` (a=10)
- `Static.b++` → 후위증가: 현재값 10 출력 후 b=11
- `st.b` → static 변수 공유 → 11 출력
- `a` → 지역변수 a=10 출력
- `st.a` → 인스턴스 변수 a=20 출력

**출력:**
```
10
11
10
20
```

**핵심 포인트:** static 변수는 클래스에 하나만 존재하며 인스턴스로도 접근 가능. 후위 증가(b++)는 출력 시점에 증가 전 값을 사용.

---

### 문제 33 상속 + super 생성자

**실행 추적:**
- `new B(10)` → B 생성자 → `super(10)` → A 생성자: this.a = 10
- `super.display()` → `System.out.println("a=" + 10)`

**출력:** `a=10`

---

### 문제 34 static 메서드 바인딩

**실행 추적:**
- `ref`는 컴파일 타입 Parent, 런타임 타입 Child
- `ref.x(2)` → 인스턴스 메서드, 동적 바인딩 → Child.x(2) = 2+3 = 5
- `ref.id()` → static 메서드, 정적 바인딩 → 컴파일 타입 Parent → "P"
- `5 + "P"` → `"5P"`

**출력:** `5P`

**핵심 포인트:** static 메서드는 오버라이딩되지 않음(hiding). 참조 변수의 컴파일 타입 기준으로 정적 바인딩.

---

### 문제 09 비트 논리 연산자

**실행 추적:**
- w=3, x=4, y=3, z=5
- 조건: `(w==2 | w==y) & !(y>z) & (1==x ^ y!=z)`
  - `w==2` → false, `w==y` → true → `false | true` = true
  - `y>z` → 3>5 → false → `!false` = true
  - `1==x` → false, `y!=z` → true → `false ^ true` = true
  - true & true & true = **true**
- `w = x + y = 7`
- 내부 조건: `7==x ^ y!=w`
  - `7==4` → false, `3!=7` → true → `false ^ true` = true
  - → `System.out.println(w)` → 출력 **7**... 

**재추적:** w는 이제 7이므로 `y != w`는 `3 != 7` = true
- `7 == x` = `7 == 4` = false
- `false ^ true` = true → println(w) = println(7)

**출력:** `7`

**핵심 포인트:** `|`는 비트 OR (단락평가 없음), `^`는 XOR, `&`는 비트 AND. 모든 피연산자를 평가함 (단락 평가 없음). w가 7이 되고 `7==x`(false)^`y!=w`(true) = true → println(w)=7.

---

### 문제 20 배열 반환

**실행 추적:**
- arr() : a[0]=0, a[1]=1, a[2]=2, a[3]=3 반환
- 출력: `0 1 2 3 ` (끝에 공백 포함)

**출력:** `0 1 2 3 `

---

### 문제 45 생성자 + this + 재귀

**실행 추적:**
- `new cond(3)` → this.a = 3
- `obj.a = 5` → a = 5
- `obj.func()`:
  - b=1, i=1~4(i<5)
  - i=1: b += 5*1 = 6
  - i=2: b += 5*2 = 16
  - i=3: b += 5*3 = 31
  - i=4: b += 5*4 = 51
  - return a + b = 5 + 51 = 56
- `obj.a + b = 5 + 56 = 61`

**출력:** `61`

**재추적 (주의):**
- b=1 (초기)
- i=1: b = 1 + 5*1 = 6
- i=2: b = 6 + 5*2 = 16
- i=3: b = 16 + 5*3 = 31
- i=4: b = 31 + 5*4 = 51
- return 5 + 51 = 56 (b 반환값)
- `obj.a + b` : obj.a=5, b(지역변수)=56 → 5 + 56 = **61**

**출력:** `61`

---

### 문제 36 다형성 오버라이딩

**실행 추적:**
- `Parent pa = new Child()` → 런타임 타입 Child
- `pa.show()` → 동적 바인딩 → Child.show() → `child`

**출력:** `child`

---

### 문제 41 재귀 오버라이딩

**실행 추적 (Child의 compute 오버라이딩):**
- compute(4) → compute(3) + compute(1) → ...
- compute(0)=0, compute(1)=1
- compute(2) = compute(1)+compute(-1) = 1+compute(-2)... 

**Child.compute 정의:** `compute(n) = compute(n-1) + compute(n-3)`
- compute(1) = 1
- compute(0) = 0
- compute(-1) = -1 <= 1 → return -1? 

**재추적 (조건: num<=1 return num):**
- compute(4) = compute(3) + compute(1)
  - compute(3) = compute(2) + compute(0) = compute(2) + 0
    - compute(2) = compute(1) + compute(-1) = 1 + (-1) = 0
  - compute(3) = 0 + 0 = 0
- compute(4) = 0 + 1 = **1**

**출력:** `1`

**핵심 포인트:** `compute(n-3)` 에서 n=2이면 compute(-1)이 호출됨. `num <= 1` 조건에 음수도 포함되므로 compute(-1) = -1 반환. 이를 주의해야 함.

---

### 문제 53 예외처리 + finally

**실행 추적:**
- `func()` → `throw new NullPointerException()`
- catch (NullPointerException e) 실행: sum = 0 + 1 = 1
- finally: sum = 1 + 100 = 101

**출력:** `101`

**핵심 포인트:** finally는 예외 발생 여부와 무관하게 항상 실행. NullPointerException은 Exception의 하위 클래스이므로 첫 번째 catch에서 잡힘.

---

### 문제 54 람다 + 예외처리

**실행 추적:**
- `run(f)`:
  - f.apply(3) → x=3, 3>2 → throw Exception
  - catch → return 7
- `run((int n) -> n + 9)`:
  - f.apply(3) → 3+9 = 12, 정상 반환
  - return 12
- `7 + 12 = 19`

**출력:** `19`

---

### 문제 17 2진수 변환 배열

**실행 추적:**
- n=10, 2진수 변환: 10 = 1010₂
- 나머지 순서(LSB first): a[0]=0, a[1]=1, a[2]=0, a[3]=1, n=0 → 종료
- a[4]~a[7] = 0 (초기화값)
- i=7→0 순서 출력: a[7]a[6]a[5]a[4]a[3]a[2]a[1]a[0] = 0 0 0 0 1 0 1 0

**출력:** `00001010`

---

### 문제 18 비정형 2차원 배열

**실행 추적:**
- aa[0] = {45,50,75} → 길이 3
- aa[1] = {89} → 길이 1
- aa[0][0]=45, aa[0][1]=50, aa[1][0]=89

**출력:**
```
3
1
45
50
89
```

---

### 문제 19 2차원 배열 출력

**실행 추적 (ary[i][j] = j*3 + i + 1):**

| i\j | 0 | 1 | 2 | 3 | 4 |
|-----|---|---|---|---|---|
| 0 | 1 | 4 | 7 | 10 | 13 |
| 1 | 2 | 5 | 8 | 11 | 14 |
| 2 | 3 | 6 | 9 | 12 | 15 |

**출력:**
```
1 4 7 10 13 
2 5 8 11 14 
3 6 9 12 15 
```

---

### 문제 42 상속 super.getX

**실행 추적:**
- `new Child(10)` → super(11, 10) → Parent(x=11, y=10)
- `parent.getX()` → 컴파일 타입 Parent, Parent.getX()는 오버라이딩 없음
- `return x*y = 11*10 = 110`

**출력:** `110`

**핵심 포인트:** Child에 `getX(int n)` 은 오버로딩이지, `getX()`의 오버라이딩이 아님. 따라서 Parent.getX()가 호출됨.

---

### 문제 21 배열 순위 계산

**실행 추적:**
- arr = {77, 32, 10, 99, 50}
- 각 요소보다 큰 값의 수+1 = 순위
  - 77: 99만 큼 → result=2
  - 32: 77,99,50 큼 → result=4
  - 10: 모두 큼 → result=6? 

**재추적 (result[i]++는 arr[i] < arr[j] 일 때):**
- i=0(77): j 순회 → 99 > 77 → result[0]++ → result[0]=2
- i=1(32): 77>32, 99>32, 50>32 → result[1]=1+3=4
- i=2(10): 77>10, 32>10, 99>10, 50>10 → result[2]=1+4=5
- i=3(99): 없음 → result[3]=1
- i=4(50): 77>50, 99>50 → result[4]=1+2=3

**출력:** `24513`

---

### 문제 36 다형성 오버라이딩 (Section 124)

**출력:** `child` (상세 위 참조)

---

### 문제 08 삼항 연산자 - 메서드

**실행 추적:**
- `check(1)` → 1 >= 0 → "positive"

**출력:** `positive`

---

### 문제 23 문자열 == vs equals

**실행 추적:**
- str1, str2 → 리터럴 풀 동일 객체 → `str1==str2` = true
- str3 → new String() → 다른 객체 → `str1==str3` = false
- `.equals()` → 값 비교 → true, true

**출력:**
```
true
false
true
true
```

**핵심 포인트:** `==`은 참조(주소) 비교, `.equals()`는 값 비교. String 리터럴은 String Pool에서 재사용.

---

### 문제 37 오버라이딩 연쇄

**실행 추적:**
- `a = new SubObject()` → 런타임 타입 SubObject
- `a.paint()` → SubObject.paint() 실행:
  - `super.paint()` → SuperObject.paint():
    - `System.out.print('B')` → B
    - `draw()` → 동적 바인딩 → SubObject.draw() → `System.out.print('D')` → D
  - `System.out.print('C')` → C
  - `draw()` → SubObject.draw() → D
- `a.draw()` → SubObject.draw() → D

**출력:** `BDCDD`

**핵심 포인트:** super.paint() 내에서도 draw()는 동적 바인딩으로 SubObject.draw() 호출됨.

---

### 문제 38 싱글톤 패턴

**실행 추적:**
- 싱글톤: conn1, conn2, conn3 모두 동일 인스턴스
- conn1.count() → count=1
- conn2.count() → count=2
- conn3.count() → count=3
- conn1.count() → count=4 (추가 1회)
- conn1.getCount() = 4

**출력:** `4`

---

### 문제 40 재귀 오버라이딩 - C 클래스

**실행 추적 (C.calc 오버라이딩):**
- `calc(n-1) + calc(n-3)`, num<=1이면 num 반환
- calc(7) = calc(6) + calc(4)
- calc(6) = calc(5) + calc(3)
- calc(5) = calc(4) + calc(2)
- calc(4) = calc(3) + calc(1)
- calc(3) = calc(2) + calc(0)
- calc(2) = calc(1) + calc(-1) = 1 + (-1) = 0
- calc(0) = 0, calc(1) = 1, calc(-1) = -1
- calc(3) = 0 + 0 = 0
- calc(4) = 0 + 1 = 1
- calc(5) = 1 + 0 = 1
- calc(6) = 1 + 0 = 1
- calc(7) = 1 + 1 = **2**

**출력:** `2`

**핵심 포인트:** num <= 1 이면 num 반환 (음수도 포함). calc(-1) = -1, calc(-2) = -2 등.

---

### 문제 24 객체 배열 참조 스왑

**실행 추적:**
- a→BO(1), b→BO(2), c→BO(3)
- arr = [ref_a, ref_b, ref_c]
- t = arr[0] = ref_a
- arr[0] = arr[2] = ref_c
- arr[2] = t = ref_a
- arr 상태: [ref_c, ref_b, ref_a]
- `arr[1].v = arr[0].v` → ref_b.v = ref_c.v = 3
- a.v=1 (변화없음), b.v=3, c.v=3

**출력:** `1a3b3`

**핵심 포인트:** arr 배열에서 참조를 스왑해도 원본 객체 a, c의 v 값은 변하지 않음. b의 v만 arr[0](ref_c)을 통해 3으로 변경됨.

---

### 문제 47 / 문제 48 enum

**실행 추적:**
- `Tri.A.name()` → "A", `.length()` → 1
- `Tri.values()[1]` → Tri.B
- `Tri.B.code()` → "AB"

**출력:** `AB`

**핵심 포인트:** enum의 name()은 열거형 상수 이름 문자열 반환. values()는 선언 순서대로 배열 반환 (index 0=A, 1=B, 2=C).

---

### 문제 50 / 문제 51 제네릭 + 오버로딩

**실행 추적:**
- `new Collection<>(0)` → T=Integer (autoboxing of 0), value=Integer(0)
- `print()` → `new Printer().print(value)` → value 타입은 T이나 컴파일 시 타입 소거(erasure) → Object
- Printer.print(Object a) 호출 → `"B" + 0` = `"B0"`

**출력:** `B0`

**핵심 포인트:** 제네릭 타입 소거(Type Erasure) → 런타임에 T는 Object로 처리됨. 오버로딩 해소는 컴파일 시 정적으로 결정되므로 print(Object)가 선택됨.

---

### 문제 04 진법 변환

**실행 추적:**
- `035` → 8진수 → 3*8+5 = 29
- `0x35` → 16진수 → 3*16+5 = 53
- `35` → 10진수 → 35

**출력:**
```
29
53
35
```

---

### 문제 05 삼항 연산자

**실행 추적:**
- `j < k` → `10 < 20` = true → `k++` 실행 (후위증가)
- result = k의 현재값(증가 전) = 20, 그 후 k = 21
- L은 변경 없음 = 30

**출력:** `20 21 30`

**핵심 포인트:** 삼항 연산자에서 `k++`는 후위 증가이므로 result에 현재 값(20)이 할당된 후 k가 21이 됨.

---

### 문제 06 산술 연산자 우선순위

**실행 추적:**
- `20 % 11 / 3 * 5 - b`
- 우선순위: %, /, * 는 동일 우선순위로 좌→우
- 20 % 11 = 9
- 9 / 3 = 3
- 3 * 5 = 15
- 15 - 10 = 5

**출력:** `5`

**검증:** `20 % 11` = 9, `9 / 3` = 3 (정수 나눗셈), `3 * 5` = 15, `15 - 10` = **5**

---

### 문제 07 비트 / 논리 복합 연산자

**실행 추적:**
- a=b=c=2
- `++a` → a=3 (전위, 먼저 증가)
- `b--` → 현재값 2 사용 후 b=1
- `c--` → 현재값 2 사용 후 c=1
- 연산자 우선순위: `&`가 `|`보다 높음
- `b-- & c--` = `2 & 2` = 2
- `++a | (b-- & c--)` = `3 | 2` = 3 (비트 OR: 11 | 10 = 11 = 3)
- hap = 3

**출력:** `3 3 1 1`

**핵심 포인트:** 비트 AND(&), 비트 OR(|). 후위 증감 연산자는 해당 표현식에서 현재 값을 사용하고 나서 변경. 연산자 우선순위: &가 | 보다 높음.

---

### 문제 22 문자열 split

**실행 추적:**
- "ITISTESTSTRING".split("T") → T 기준으로 분리
- 분리 결과: ["I", "IS", "ES", "S", "RING"] (인덱스 0~4)
- result[3] = "S"... 

**재추적:**
- 문자열: I T I S T E S T S T R I N G
- 위치:  0 1 2 3 4 5 6 7 8 9 10 11 12 13
- T 기준 split: ["I", "IS", "ES", "S", "RING"]
  - "I" (0번)
  - "IS" (1번)
  - "ES" (2번)
  - "S" (3번)
  - "RING" (4번)
- result[3] = "S"... 

**재재추적:**
- `ITISTESTSTRING`을 T로 분리:
  - 위치 1에 T → split → ["I", "ISTESTSTRING"]
  - 위치 4에 T → ["I", "IS", "ESTSTRING"]
  - 위치 7에 T → ["I", "IS", "ES", "STRING"]
  - 위치 9에 T → ["I", "IS", "ES", "S", "RING"]
- result[3] = "S"... 아, 다시 확인:
  - `ITISTESTSTRING`.split("T") → Java split은 정규식
  - I | T | ISTEST | S | TRING 아닌가?
  - 실제: split은 구분자 제거 후 남은 부분
  - "I" + "T" + "IS" + "T" + "ES" + "T" + "S" + "T" + "RING"
  - split("T") = ["I", "IS", "ES", "S", "RING"]
  - result[3] = **"S"**

**출력:** `S`

**핵심 포인트:** String.split()은 구분자를 제거하고 배열로 반환. "ITISTESTSTRING"에서 T가 4개 → 5개 조각 생성. [0]="I", [1]="IS", [2]="ES", [3]="S", [4]="RING".

---

### 문제 55 / 문제 24 객체 배열 참조 스왑

(풀이 동일 - 위 문제 24 참조)

---

### 문제 43 static + 상속 + 오버라이딩

**실행 추적:**
- `new Child()` 호출 → Parent 생성자 먼저 실행
- **Parent 생성자:**
  - `total += ++v` → v(Parent의 인스턴스 v)=1 → ++v=2 → total = 0+2 = 2
  - `show()` → 동적 바인딩 → Child의 show() 실행
    - `total += total * 2` → total = 2 + 2*2 = 6
- **Child 생성자 계속:**
  - Child의 v=10 (인스턴스 변수 초기화)
  - `v += 2` → v = 12
  - `total += v++` → total = 6 + 12 = 18, v = 13
  - `show()` → Child의 show()
    - `total += total * 2` → total = 18 + 18*2 = 54

**출력:** `54`

**재추적 주의:** Child.v 초기화는 `int v = 10`이지만, 생성자 실행 전에 인스턴스 변수 초기화가 이루어짐. 따라서 Child 생성자 진입 시 Child.v=10.

**상세 단계:**
1. `new Child()` → JVM이 먼저 Parent 생성자 호출
2. Parent 생성자: `int v = 1` (Parent의 v), `total(0) += ++v(2)` → total=2
3. `show()` → Child의 오버라이딩된 show(): `total(2) += total*2(4)` → total=6
4. Parent 생성자 완료, Child 인스턴스 필드 `int v = 10` 초기화
5. Child 생성자 몸체: `v(10) += 2` → Child.v=12
6. `total(6) += v++(12)` → total=18, Child.v=13
7. `show()` → Child.show(): `total(18) += total*2(36)` → total=54
8. `System.out.println(Parent.total)` → 54

**출력:** `54`

---

### 문제 44 클래스 상속 면적

**실행 추적:**
- `new Square(10)` → `super(10, 10)` → Rectangle(x=10, y=10)
- `getSquareArea()` = x*y = 10*10 = 100

**출력:** `100`

---

### 문제 52 예외처리

**실행 추적:**
- `a/b` = `5/0` → ArithmeticException 발생
- catch(ArithmeticException): `출력1`
- finally: `출력5`

**출력:** `출력1출력5`

---

### 문제 25 배열 참조 동일성

**실행 추적:**
- a, b, c는 모두 다른 배열 객체
- check(a,b): a==b → false → "N"
- check(b,c): b==c → false → "N"
- check(a,c): a==c → false → "N"

**출력:** `NNN`

**핵심 포인트:** `==`은 배열 참조(주소)를 비교. 내용이 같아도 new로 생성된 서로 다른 배열은 false.

---

### 문제 49 인터페이스 구현 - 홀수/짝수 합

**실행 추적:**
- `OE.sum(a, true)` → 홀수 합: 1+3+5+7+9 = 25
- `OE.sum(a, false)` → 짝수 합: 2+4+6+8 = 20

**출력:** `25, 20`

---

### 문제 26 재귀 + 문자열 중복 제거

**실행 추적 (재귀 역방향 중복 제거):**
- str = "abacabcd", len=8
- rf(str, 7, seen) 재귀 전개 (index 7→0):
  - index=7: c='d', 먼저 rf(str,6,seen) 실행
  - index=6: c='c', 먼저 rf(str,5,seen) 실행
  - ...index=0까지 내려감
  - index=0: c='a', rf(str,-1,seen)="" 반환
    - seen['a']=false → seen['a']=true, return 'a'+""="a"
  - index=1: c='b', result="a"
    - seen['b']=false → seen['b']=true, return 'b'+"a"="ba"
  - index=2: c='a', result="ba"
    - seen['a']=true → return "ba" (건너뜀)
  - index=3: c='c', result="ba"
    - seen['c']=false → seen['c']=true, return 'c'+"ba"="cba"
  - index=4: c='a', result="cba"
    - seen['a']=true → return "cba"
  - index=5: c='b', result="cba"
    - seen['b']=true → return "cba"
  - index=6: c='c', result="cba"
    - seen['c']=true → return "cba"
  - index=7: c='d', result="cba"
    - seen['d']=false → seen['d']=true, return 'd'+"cba"="dcba"

**출력:** `dcba`

**핵심 포인트:** 재귀로 index 0부터 처리. 처음 등장한 문자를 앞에 붙이므로 결과적으로 각 문자의 첫 등장 순서대로 정렬됨. "abacabcd"에서 첫 등장: a(0), b(1), c(3), d(7) → "abcd"... 

**재재추적 - return 방향 주의:**
- `return c + result` → c를 result **앞에** 붙임
- index=0: 'a' + "" = "a"
- index=1: 'b' + "a" = "ba"
- index=3: 'c' + "ba" = "cba"
- index=7: 'd' + "cba" = "dcba"

**최종 출력:** `dcba`

**핵심 포인트:** 재귀가 index 0부터 결과를 만들고 올라오면서 c를 앞에 붙이므로, 나중에 처리될수록 앞에 위치. 결과는 처음 등장 순서의 역순.

---

### 문제 50 / 문제 51 제네릭 + 오버로딩

(풀이 위 참조 - B0)

---

### 문제 27 String 배열 equals 비교

**실행 추적:**
- x[0]="A"(리터럴), x[1]="A"(리터럴), x[2]=new String("A")
- func(x, 3):
  - i=1: x[0].equals(x[1]) → "A".equals("A") = true → "O"
  - i=2: x[1].equals(x[2]) → "A".equals("A") = true → "O"
  - for(String z : x): x[0]="A", x[1]="A", x[2]="A" → "AAA"

**출력:** `OOAAA`

**핵심 포인트:** equals()는 값 비교이므로 new String("A")도 "A"와 같다고 판정.

---

### 문제 39 싱글톤 패턴 - count 3회

**실행 추적:**
- 싱글톤: conn1=conn2=conn3 동일 인스턴스
- count() 3회 → count=3
- getCount() = 3

**출력:** `3`

---

### 문제 13 while + 곱셈

**실행 추적:**
- i=0, c=0
- 반복마다 c *= i 인데, c는 항상 0
- i=1: c = 0*1 = 0
- i=2: c = 0*2 = 0
- ... c는 항상 0

**출력:** `0`

**핵심 포인트:** c의 초기값이 0이므로 c *= i는 항상 0 * i = 0.

---

### 문제 14 Thread + while

**출력:** 순서 불규칙 (Thread 비동기 실행)

- `miles traveled : 1` ~ `miles traveled : 99` 까지 출력되나 Thread 특성상 실행 순서는 JVM/OS에 따라 다를 수 있음.

---

*생성일: 2026-06-26*
