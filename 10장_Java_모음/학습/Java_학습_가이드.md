# Java 학습 가이드 (정보처리기사 실기 10장)

> 이 폴더에 있는 58개 Java 파일을 분석하여 개념별로 정리한 학습 가이드입니다.

---

## 학습 순서 (추천)

```
1단계: 기본 입출력·변수·연산자   → 문제10, 문제11, 문제14, 문제 07
2단계: 제어문 (for/while/switch) → 318 기출체크1/2, 319 기출체크1, 문제7
3단계: 배열                      → 기출따라잡기_문제2, 문제27, 기출따라잡기_문제12
4단계: 문자열                    → 문제17, 문제 20, 03 Java 문제
5단계: 클래스·상속 기초          → 323 클래스1, 324 클래스2, 02 Java 문제1
6단계: 다형성·추상·인터페이스    → 02 Java 문제(Animal), Section 124 문제1/3, 문제44
7단계: 예외처리·고급              → Section 127 문제2/3, 문제35, 문제31
8단계: 종합 응용                  → 문제22, 문제23, 문제32, 문제33
```

---

## 개념별 파일 분류

### 기본 입출력 / 연산자

| 파일 | 핵심 개념 | 정답 |
|------|-----------|------|
| `문제10.java` | 8진수(035), 16진수(0x35) 출력 | `29 / 53 / 35` |
| `문제11.java` | 삼항 연산자 + 후위 증감 | `20 21 30` |
| `문제14.java` | 연산자 우선순위 계산 | `−5` |
| `문제16.java` | 전위 증감 + 비트OR | `3 3 1 1` |
| `문제 07.java` | 삼항 연산자 반환 | `positive` |

---

### 제어문

| 파일 | 핵심 개념 | 정답 |
|------|-----------|------|
| `318 제어문 - Java 기출체크1.java` | for + 누적합 출력 | `0+1+2+3+4+5=15` |
| `318 제어문 - Java 기출체크2.java` | 6의 배수 최댓값 | `996` |
| `319 break와 continue 기출체크1.java` | while + continue 짝수 합 | `30` |
| `문제7.java` | while + 곱셈 누적 (0 곱) | `0` |

---

### 배열

| 파일 | 핵심 개념 | 정답 |
|------|-----------|------|
| `기출 따라잡기_문제2.java` | 2D 배열 초기화 + 출력 | `1 4 7 / 2 5 8 / 3 6 9` |
| `문제27.java` | 동일 패턴 2D 배열 | 동일 |
| `기출 따라잡기_문제12.java` | 가변 2D 배열 길이 | `3/1/45/50/89` |
| `기출 따라잡기_문제8.java` | 배열 원소 크기 순위 계산 | `23451` |
| `기출 따라잡기_문제1.java` | 10진수 → 2진수 배열 저장 | `00001010` |
| `Section 123_기출 따라잡기_문제2.java` | 함수에서 배열 반환 | `0 1 2 3` |

---

### 문자열

| 파일 | 핵심 개념 | 정답 |
|------|-----------|------|
| `문제17.java` | `split()` 분리 | `RING` |
| `문제 20.java` | `==` vs `equals()` | `true/false/true/true` |
| `03 Java 문제 - 예제1.java` | charAt + 배열 역방향 순회 | `e1l2i3a4g5` |
| `문제43.java` | 배열 주소 비교 `==` | `NNN` |
| `문제48.java` | `equals()` vs `==` + String 리터럴 | `ONaAbAB` (주의: new String) |

---

### 클래스 기초

| 파일 | 핵심 개념 | 정답 |
|------|-----------|------|
| `323 Java의 클래스1.java` / `02 Java 문제1 - 예제1.java` | 인스턴스 메소드 호출 | `19` |
| `323 Java의 클래스1 기출체크1.java` / `기출 따라잡기_문제5.java` | 객체 참조 전달 (call by reference) | `2000` |
| `323 Java의 클래스1 기출체크2.java` | static 변수 공유 | `10/11/10/20` |
| `Section 123_기출 따라잡기_문제4.java` | this + for 반복 계산 | `16` |

---

### 상속 / 다형성

| 파일 | 핵심 개념 | 정답 |
|------|-----------|------|
| `Section 124_기출 따라잡기_문제1.java` / `문제 02.java` | 업캐스팅 + 오버라이딩 | `child` |
| `324 Java의 클래스2 기출체크1.java` | super() + super.메소드() | `a=10` |
| `324 Java의 클래스2.java` | 오버라이딩 + 정적 메소드 | `5P` |
| `기출 따라잡기_문제6.java` | super()로 부모 생성자 호출 | `110` |
| `03 Java 문제2 - 예제1.java` | 생성자 호출 순서 + 오버라이딩 | `AED7` |
| `문제 21.java` | 다형성 체인 + 재귀 호출 | `BDCDД` |
| `Section 124_기출 따라잡기_문제3.java` / `문제23.java` | 오버라이딩된 재귀 함수 | `2` / `13` |

---

### 추상 클래스 / 인터페이스

| 파일 | 핵심 개념 | 정답 |
|------|-----------|------|
| `02 Java 문제 - 예제1.java` | abstract + 생성자에서 look() | `Chicken is animal / Zoo` |
| `326 Java의 활용 기출체크1.java` | abstract + 오버로딩 | `Vehicle name : Spark` |
| `문제44.java` | interface implements + 홀짝 합산 | `25, 20` |

---

### 예외 처리

| 파일 | 핵심 개념 | 정답 |
|------|-----------|------|
| `문제35.java` | try-catch-finally 흐름 | `출력1출력5` |
| `Section 127_기출 따라잡기_문제2.java` | throw + catch 순서 | `101` |
| `Section 127_기출 따라잡기_문제3.java` | 람다 + 예외 처리 | `19` |

---

### enum / 고급 기능

| 파일 | 핵심 개념 | 정답 |
|------|-----------|------|
| `문제37.java` / `문제35.java(enum)` | enum values() + name() | `AB` |
| `문제31.java` | Thread + Runnable | (실행 중 출력) |
| `문제39.java` / `문제47.java` | 제네릭 + 오버로딩 선택 | `B0` |
| `문제45.java` | 재귀 + boolean 배열 | `dcba` |

---

### 종합 응용

| 파일 | 핵심 개념 | 정답 |
|------|-----------|------|
| `문제22.java` / `문제49.java` | 싱글톤 패턴 | `4` / `3` |
| `문제32.java` | static + 오버라이딩 + 복잡한 초기화 순서 | (복잡) |
| `문제 33.java` / `문제30.java` | 객체 배열 swap (참조 주의) | `3a3b3` |
| `문제33.java(Rectangle)` | 상속 + super(a,a) | `100` |
| `문제48.java` | equals + == 혼합 | 주의 필요 |

---

## 파일별 상세 풀이

### [문제10.java] — 진법 변환

```java
int a = 035;    // 8진수: 3×8 + 5 = 29
int b = 0x35;   // 16진수: 3×16 + 5 = 53
int c = 35;     // 10진수: 35
```
> **출력:** `29 / 53 / 35`

---

### [318 기출체크1.java] — for + 누적합

```java
for (j=0, i=0; i<=5; i++) {
    j += i;            // j: 0,1,3,6,10,15
    System.out.print(i);
    if (i==5) { print("="); print(j); }
    else print("+");
}
```
> **출력:** `0+1+2+3+4+5=15`

---

### [323 기출체크1.java] — 객체 참조 전달

```java
A m = new A();
m.a = 100;
func1(m);      // m.a *= 10 → m.a = 1000
m.b = m.a;     // m.b = 1000
func2(m);      // m.a += m.b → m.a = 2000
```
> **출력:** `2000`  
> **포인트:** 객체는 참조(주소)로 전달 → 함수 내에서 원본 필드 변경됨

---

### [323 기출체크2.java] — static 변수

```java
int a = 10;
Static.b = a;           // b = 10
Static st = new Static();
System.out.println(Static.b++);  // 10 출력, b→11
System.out.println(st.b);        // 11 (같은 변수)
System.out.println(a);           // 10
System.out.print(st.a);          // 20 (인스턴스 변수)
```
> **출력:** `10 / 11 / 10 / 20`

---

### [Section 124 기출_문제1.java] — 업캐스팅 + 오버라이딩

```java
Parent pa = new Child();   // 참조: Parent, 실체: Child
pa.show();                 // 오버라이딩된 Child.show() 실행
```
> **출력:** `child`

---

### [03 Java 문제2.java] — 생성자 호출 순서

```java
ClassB cal = new ClassB();
// 1. ClassB() → super() → ClassA() 실행
// 2. ClassA() 내에서 this.prn() → ClassB.prn() (오버라이딩) → 'E' 출력
// 3. ClassA() 완료 후 'A'는 이미 출력됨... 순서:
// A → (prn() → E) → D → 7
```
> **출력:** `AED7`

---

### [문제35.java] — 예외 처리

```java
try {
    System.out.print(5/0);   // ArithmeticException 발생
} catch (ArithmeticException e) {
    System.out.print("출력1");  // 여기서 처리
} finally {
    System.out.print("출력5");  // 항상 실행
}
```
> **출력:** `출력1출력5`

---

### [문제 20.java] — == vs equals

```java
String str1 = "Programming";       // 리터럴 풀
String str2 = "Programming";       // 같은 리터럴 풀 주소
String str3 = new String("Programming");  // 새 주소 생성

str1 == str2      → true   // 같은 주소
str1 == str3      → false  // 다른 주소
str1.equals(str3) → true   // 내용 같음
str2.equals(str3) → true   // 내용 같음
```

---

### [문제37.java] — enum

```java
enum Tri { A("A"), B("AB"), C("ABC"); }

Tri.A.name()          // "A"
Tri.A.name().length() // 1
Tri.values()[1]       // B (인덱스 1)
B.code()              // "AB"
```
> **출력:** `AB`

---

### [문제22.java] — 싱글톤

```java
// get()은 항상 같은 _inst 반환
Connection conn1 = Connection.get();  // 생성
conn1.count();   // count=1
Connection conn2 = Connection.get();  // 동일 인스턴스
conn2.count();   // count=2
Connection conn3 = Connection.get();  // 동일 인스턴스
conn3.count();   // count=3
conn1.count();   // count=4
System.out.print(conn1.getCount());   // 4
```
> **출력:** `4`

---

### [문제 33.java (BO 배열)] — 객체 배열 swap

```java
BO a=new BO(1), b=new BO(2), c=new BO(3);
BO[] arr = {a, b, c};
BO t = arr[0];      // t→a(v=1)
arr[0] = arr[2];    // arr[0]→c(v=3)
arr[2] = t;         // arr[2]→a(v=1)
arr[1].v = arr[0].v;  // b.v = c.v = 3
// a.v=1, b.v=3, c.v=3
System.out.println(a.v + "a" + b.v + "b" + c.v);
```
> **출력:** `3a3b3`  
> **포인트:** `arr[0]=arr[2]`는 배열 참조를 바꾸지만 `c` 객체의 `v`는 그대로 3

---

## 오류가 있는 파일 주의사항

| 파일 | 오류 내용 |
|------|-----------|
| `기출 따라잡기_문제1.java` | `i- -` 사이에 공백 → `i--` 로 해야 컴파일됨 |
| `319 break와 continue 기출체크2.java` | Java 파일인데 C 코드가 들어있음 (잘못된 파일) |

---

## 핵심 암기 사항

```
업캐스팅    : Parent p = new Child() → 오버라이딩된 Child 메소드 실행
== vs equals: == 주소 비교, equals() 내용 비교
static      : 클래스 공유, 클래스명.변수로 접근
생성자 순서 : Child() → super() → Parent() → 나머지 Child
fall-through: switch에서 break 없으면 아래 case 계속 실행
finally     : 예외 여부 관계없이 항상 실행
싱글톤      : 하나의 인스턴스만 공유
```

---

*정보처리기사 실기 대비 — 10장 Java 학습 가이드*
