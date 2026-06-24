# Java 문법 총정리 (정보처리기사 실기 대비)

> 코드를 처음 보는 사람도 이해할 수 있도록 모든 개념을 쉽게 풀어 설명합니다.

---

## 1. 기본 입출력

### 출력하기

```java
System.out.print("안녕");       // 줄바꿈 없이 출력
System.out.println("안녕");     // 출력 후 줄바꿈 (엔터)
System.out.printf("%d\n", 10); // 형식 지정 출력 (C언어 스타일)
```

**서식 지정자 — 어떤 자리에 어떤 값을 넣을지:**

| 서식 지정자 | 의미 | 예시 |
|------------|------|------|
| `%d` | 정수 자리 | `printf("%d", 10)` → `10` |
| `%s` | 문자열 자리 | `printf("%s", "hi")` → `hi` |
| `%c` | 문자 1개 | `printf("%c", 'A')` → `A` |
| `\n` | 줄바꿈 | `"hello\n"` → hello 후 엔터 |

**출력 방식 비교:**
```java
System.out.print("a");    // a  (줄바꿈 없음)
System.out.println("b");  // b  (줄바꿈 있음)
System.out.print("c");    // c
// 결과: ab
//       c
```

### 입력받기 (Scanner)

```java
import java.util.Scanner;   // 맨 위에 이 줄 필요

Scanner scan = new Scanner(System.in);
int a = scan.nextInt();     // 정수 입력받기
String s = scan.next();     // 문자열 입력받기
scan.close();               // 다 쓴 후 닫기
```

---

## 2. 변수와 자료형

> 변수는 값을 담는 **이름표 붙은 상자**입니다.

```java
int a = 10;          // 정수 상자
double d = 3.14;     // 실수 상자
char c = 'A';        // 문자 1개 상자 (작은따옴표!)
String s = "hello";  // 문자열 상자 (큰따옴표)
boolean b = true;    // 참/거짓 상자
```

### 진법 표현 — 숫자 앞에 붙는 기호의 의미 (시험 단골)

```java
int a = 035;    // 앞에 0만 붙으면 → 8진수  → 3×8+5 = 29
int b = 0x35;   // 앞에 0x 붙으면  → 16진수 → 3×16+5 = 53
int c = 35;     // 아무것도 없으면 → 10진수 → 35
```

**외우는 법:** `0` 하나 → 8진수, `0x` → 16진수

---

## 3. 연산자

### 3-1. 산술 연산자

```java
10 + 3   // 13
10 - 3   // 7
10 * 3   // 30
10 / 3   // 3  (정수끼리 나누면 몫만)
10 % 3   // 1  (나머지)
```

> **주의:** Java에서 `int / int` 는 소수점을 버립니다.
> `10 / 3 = 3` (3.33이 아님!)

### 3-2. 증감 연산자 — 1 더하거나 빼기

```java
int a = 5;

// 전위(앞에): 먼저 바꾸고 사용
++a;   // a를 먼저 6으로 바꾼 뒤 사용 → a = 6
--a;   // a를 먼저 5로 바꾼 뒤 사용 → a = 5

// 후위(뒤에): 먼저 사용하고 나서 바꿈
a++;   // 현재 a 값(5) 먼저 사용, 그 다음 6으로 바꿈
a--;   // 현재 a 값(6) 먼저 사용, 그 다음 5로 바꿈
```

**시험 핵심 예시:**
```java
int j = 10, k = 20, L = 30;
int result = j < k ? k++ : --L;
// ① j < k → 10 < 20 → 참(true)
// ② 참이므로 k++ 실행 → result = 20 (현재 k 값 먼저 사용)
// ③ 그 다음 k가 21이 됨
// 결과: result=20, k=21, L=30 그대로
```

### 3-3. 삼항 연산자 — if-else를 한 줄로

```java
// 형식: 조건 ? 참일_때 : 거짓일_때
int num = 5;
String result = (num >= 0) ? "positive" : "negative";
// num이 0 이상이므로 "positive"
```

### 3-4. 논리 / 비트 연산자

```java
// 논리 연산자 (단락 평가 — 앞에서 결과가 나오면 뒤는 안 봄)
true && false   // false  (AND: 둘 다 참이어야)
true || false   // true   (OR:  하나만 참이어도)
!true           // false  (NOT)

// 비트 연산자 (단락 평가 없음 — 양쪽 모두 계산)
a & b           // AND (비트 단위)
a | b           // OR  (비트 단위)
a ^ b           // XOR (비트 단위, 다를 때 1)
```

> **`&&` vs `&` 차이:**
> - `&&` : 앞이 false면 뒤는 계산 안 함
> - `&`  : 항상 양쪽 다 계산함
> 시험에서 `&`, `|` 단독으로 조건식에 쓰이면 **둘 다 계산**한다고 기억!

---

## 4. 배열

> 배열은 **같은 자료형의 값을 여러 개 줄지어 담는 것**입니다.
> 인덱스는 **0번**부터 시작합니다.

### 4-1. 1차원 배열

```java
// 방법 1: 크기만 정하기 (값은 자동으로 0)
int a[] = new int[5];      // [0, 0, 0, 0, 0]

// 방법 2: 값과 함께 선언
int a[] = {1, 2, 3, 4, 5};

a[0]       // 1  (첫 번째)
a[4]       // 5  (마지막)
a.length   // 5  (배열 길이)
```

### 4-2. 2차원 배열 — 표(행렬)처럼 생긴 배열

```java
int ary[][] = new int[3][5];   // 3행 5열
int aa[][] = {{45,50,75}, {89}};  // 행마다 크기 다를 수 있음

aa[0].length   // 3  (0행의 길이)
aa[1].length   // 1  (1행의 길이)
aa[0][1]       // 50 (0행 1번)
```

### 4-3. for-each — 배열을 처음부터 끝까지 순서대로 꺼내기

```java
int[] x = {1, 2, 3, 4, 5};
for (int p : x) {    // x에서 하나씩 꺼내 p에 담음
    System.out.print(p + " ");   // 1 2 3 4 5
}
```

---

## 5. 문자열 (String)

### 주요 메소드

```java
String str = "ITISTESTSTRING";

str.length()      // 14  (글자 수)
str.charAt(0)     // 'I' (0번째 문자)
str.charAt(3)     // 'S' (3번째 문자)
str.split("T")    // ["I", "IS", "ES", "S", "RING"]  T로 나누기
str.equals("abc") // false (내용 비교)
```

### `==` vs `equals()` — 시험 단골 출제!

> `==` 은 **주소(위치)** 가 같은지 비교합니다.
> `equals()` 는 **내용(글자)** 이 같은지 비교합니다.

```java
String str1 = "Programming";             // 문자열 풀에 저장
String str2 = "Programming";             // 풀에 이미 있어서 같은 주소 사용
String str3 = new String("Programming"); // new → 새 공간에 따로 저장

str1 == str2      // true  ✅ (같은 주소를 가리킴)
str1 == str3      // false ❌ (new로 새 공간 만들었으니 주소 다름)
str1.equals(str3) // true  ✅ (글자 내용은 같음)
```

**기억법:** `==`은 집 주소, `equals()`는 집 내용물 비교

---

## 6. 제어문

### 6-1. if / else

```java
if (조건1) {
    // 조건1이 참일 때
} else if (조건2) {
    // 조건1은 거짓, 조건2가 참일 때
} else {
    // 모두 거짓일 때
}
```

### 6-2. switch / case — 값에 따라 분기

> **fall-through 주의:** `break`가 없으면 아래 case로 계속 내려갑니다!

```java
int x = 3;
switch (x) {
    case 1:
        System.out.println("하나");
        break;   // break 있음 → case 1만 실행
    case 2:
        System.out.println("둘");
        // break 없음 → case 3으로 그대로 내려감!
    case 3:
        System.out.println("셋");
        break;
    default:
        System.out.println("기타");
}
// x=3 이므로 "셋" 출력
```

**fall-through 예시 (break 없을 때):**
```java
int c = 1;
switch (3) {
    case 3: c = 0;    // c=0, break 없음 → 계속
    case 4: c += 3;   // c=3, break 없음 → 계속
    case 5: c -= 10;  // c=-7, break 없음 → 계속
    default: c--;     // c=-8
}
// 출력: -8
```

### 6-3. for / while

```java
// for: 횟수가 정해져 있을 때
for (int i = 0; i < 5; i++) {
    System.out.print(i);   // 0 1 2 3 4
}

// while: 조건이 참인 동안 반복
int a = 0;
while (a < 5) {
    a++;
}
```

---

## 7. 메소드 (함수)

> 메소드는 **자주 쓰는 코드에 이름을 붙여 묶어놓은 것**입니다.

### 7-1. 기본 구조

```java
// 반환형  메소드이름  (매개변수)
static int add(int x, int y) {
    return x + y;   // 결과를 돌려줌
}

// 사용
int result = add(3, 5);   // result = 8
```

### 7-2. static 메소드

> `static`이 붙으면 **객체를 만들지 않아도 바로 사용**할 수 있습니다.

```java
public static void main(String[] args) { }  // main도 static!
static void func1(A m) { m.a *= 10; }      // 클래스 메소드
```

### 7-3. 재귀 함수 — 스스로를 다시 부르는 함수

> 재귀 함수는 자기 자신을 호출합니다. 반드시 **멈추는 조건**이 있어야 합니다.

```java
int compute(int num) {
    if (num <= 1) return num;   // ← 여기서 멈춤! (없으면 무한루프)
    return compute(num - 1) + compute(num - 2);   // 자기 자신 호출
}
// compute(4)
// = compute(3) + compute(2)
// = (compute(2)+compute(1)) + (compute(1)+compute(0))
// = (1+1) + (1+0) = 3
```

### 7-4. 오버로딩 — 같은 이름, 다른 입력

```java
// 이름은 같지만 받는 타입이 다름 → 오버로딩
void print(Integer a) { System.out.print("A" + a); }
void print(Object a)  { System.out.print("B" + a); }
void print(Number a)  { System.out.print("C" + a); }

// 어떤 타입으로 들어오느냐에 따라 다른 메소드가 실행됨
```

---

## 8. 클래스 (Class)

> 클래스는 **설계도**, 인스턴스(객체)는 설계도로 만든 **실제 물건**입니다.
> 예: 붕어빵 틀(클래스) → 실제 붕어빵(인스턴스)

### 8-1. 기본 구조

```java
class Dog {
    String name;       // 인스턴스 변수 (강아지마다 다른 이름)
    static int count;  // 클래스 변수 (모든 강아지가 공유하는 카운터)

    Dog(String name) {       // 생성자 (new Dog() 할 때 실행)
        this.name = name;    // this.name = 이 객체의 name
    }

    void bark() {
        System.out.println(name + " 멍!");
    }
}

Dog d = new Dog("초코");   // 객체 생성
d.bark();                  // 초코 멍!
```

### 8-2. this — "나 자신"을 가리키는 키워드

```java
class Example {
    int a;

    Example(int a) {
        this.a = a;   // this.a = 인스턴스 변수
                      // a      = 매개변수
        // 둘 다 이름이 a라서 this.로 구분!
    }
}
```

### 8-3. static 변수 — 모든 객체가 공유하는 변수

```java
class Static {
    public int a = 20;    // 인스턴스 변수 (객체마다 따로)
    static int b = 0;     // 클래스 변수 (모두가 같은 것 공유)
}

// 사용 방법
Static.b = 10;            // 클래스 이름으로 직접 접근
Static st = new Static();
st.b = 20;                // 인스턴스로도 접근 가능 (같은 변수!)
```

**단계별 추적 예시:**
```java
int a = 10;
Static.b = a;                     // b = 10
Static st = new Static();
System.out.println(Static.b++);   // 10 출력, 그 다음 b가 11로 증가
System.out.println(st.b);         // 11  (같은 변수이므로 11)
System.out.println(a);            // 10  (a는 그대로)
System.out.print(st.a);           // 20  (인스턴스 변수)
```

---

## 9. 상속 (Inheritance)

> 상속은 **부모 클래스의 기능을 물려받는 것**입니다.
> `extends` 키워드를 사용합니다.

### 9-1. 기본 상속 + 오버라이딩

```java
class Parent {
    void show() { System.out.println("parent"); }
}
class Child extends Parent {
    void show() { System.out.println("child"); }  // 오버라이딩: 덮어쓰기
}

Parent pa = new Child();  // 업캐스팅: Parent 타입으로 Child 객체를 담음
pa.show();                // "child" 출력!
```

**왜 "child"가 출력될까요?**
> `pa`의 겉모습(타입)은 `Parent`지만, 실제로 담긴 것은 `Child`입니다.
> Java는 **실제 객체**의 메소드를 실행합니다. 이를 **다형성**이라고 합니다.

### 9-2. super — 부모에게 접근하기

```java
class Child extends Parent {
    Child(int a) {
        super(a);          // 부모 생성자 호출 (반드시 첫 줄에!)
        super.display();   // 부모의 display() 메소드 호출
    }
}
```

### 9-3. 생성자 호출 순서 — 시험 단골!

> 자식 객체를 만들면: **자식 생성자 → (자동으로) 부모 생성자 → 나머지 자식**

```java
class ClassA {
    ClassA() {
        System.out.print('A');  // ② 출력
        this.prn();             // ③ prn() 호출 → 오버라이딩된 ClassB.prn() 실행!
    }
    void prn() { System.out.print('B'); }
}
class ClassB extends ClassA {
    ClassB() {
        super();                // ① ClassA() 먼저 실행
        System.out.print('D'); // ④ 출력
    }
    void prn() { System.out.print('E'); }  // ClassA.prn() 오버라이딩
}

ClassB cal = new ClassB();
cal.prn(7);   // ⑤ 출력
// 순서: A → E → D → 7
```

---

## 10. 추상 클래스 (Abstract Class)

> 추상 클래스는 **미완성 설계도**입니다.
> 직접 객체를 만들 수 없고, 반드시 자식이 완성해야 합니다.

```java
abstract class Animal {
    abstract void look();   // 추상 메소드: 내용 없음, 자식이 반드시 구현해야 함
    void show() {           // 일반 메소드: 내용 있음, 그대로 사용 가능
        System.out.println("Zoo");
    }
}

class Chicken extends Animal {
    void look() {   // 반드시 구현!
        System.out.println("Chicken is animal");
    }
}

// Animal a = new Animal();  ← 오류! 추상 클래스는 직접 생성 불가
Animal a = new Chicken();    // ✅ 자식 클래스로 생성 가능
a.show();   // "Zoo"
```

---

## 11. 인터페이스 (Interface)

> 인터페이스는 **약속서**입니다.
> "이 인터페이스를 구현하면 반드시 이런 기능을 만들어야 해"라고 강제합니다.

```java
interface Number {
    int sum(int[] a, boolean odd);   // 이것을 반드시 구현하라!
}

class OENumber implements Number {
    public int sum(int[] a, boolean odd) {
        // 반드시 구현해야 함
        int result = 0;
        for (int i = 0; i < a.length; i++) {
            if (odd && a[i] % 2 != 0)        result += a[i]; // 홀수 합
            else if (!odd && a[i] % 2 == 0)  result += a[i]; // 짝수 합
        }
        return result;
    }
}
```

| 구분 | 추상 클래스 | 인터페이스 |
|------|------------|-----------|
| 사용 키워드 | `abstract class` | `interface` |
| 상속/구현 | `extends` (1개만) | `implements` (여러 개 가능) |
| 메소드 | 일반 + 추상 섞을 수 있음 | 기본적으로 추상만 |

---

## 12. 예외 처리 (Exception)

> 예외는 **프로그램 실행 중 발생하는 오류**입니다.
> try-catch로 오류가 나도 프로그램이 죽지 않게 처리합니다.

```java
try {
    int result = 5 / 0;            // ← 여기서 0으로 나누기 오류 발생!
    System.out.print("정상실행");  // 오류가 나면 이 줄은 실행 안 됨
} catch (ArithmeticException e) {  // 0으로 나누기 오류를 잡음
    System.out.print("출력1");     // 오류 처리
} catch (Exception e) {            // 그 외 모든 오류 (마지막에 넣어야 함)
    System.out.print("출력4");
} finally {
    System.out.print("출력5");     // 오류 여부와 상관없이 항상 실행!
}
// 출력: 출력1출력5
```

**finally는 무조건 실행된다는 게 핵심입니다!**

### 주요 예외 종류

| 예외 이름 | 언제 발생? |
|-----------|-----------|
| `ArithmeticException` | 숫자를 0으로 나눌 때 |
| `ArrayIndexOutOfBoundsException` | 배열 범위를 벗어날 때 |
| `NullPointerException` | null인 변수를 사용할 때 |
| `NumberFormatException` | 숫자 변환 실패 시 |

---

## 13. enum (열거형)

> enum은 **정해진 값들의 목록**입니다.
> 예: 요일(월화수목금토일), 계절(봄여름가을겨울)

```java
enum Tri {
    A("A"), B("AB"), C("ABC");   // A=0번, B=1번, C=2번

    private String code;
    Tri(String code) { this.code = code; }
    public String code() { return code; }
}

Tri.values()            // [A, B, C] 배열
Tri.A.name()            // "A" (상수 이름을 문자열로)
Tri.A.name().length()   // 1  ("A"의 길이)
Tri.values()[1]         // B  (1번 인덱스)
Tri.values()[1].code()  // "AB"

// 문제 풀이:
Tri t = Tri.values()[Tri.A.name().length()];
//                   ↑ "A".length() = 1
// = Tri.values()[1] = B
// t.code() = "AB"
```

---

## 14. 람다식 (Lambda)

> 람다식은 **이름 없는 한 줄짜리 함수**입니다.
> 인터페이스를 구현할 때 짧게 쓸 수 있습니다.

```java
// 형식: (매개변수) -> { 실행내용 }
(x) -> {
    if (x > 2) throw new Exception();
    return x * 2;
}

// 한 줄이면 더 짧게
(int n) -> n + 9   // n을 받아서 n+9를 반환
```

---

## 15. 자주 나오는 패턴

### 패턴 1 — 배열 순위 계산

```java
// 각 원소보다 큰 원소 수를 세서 순위 결정
int[] arr = {77, 32, 10, 99, 50};
int[] result = new int[5];

for (int i = 0; i < 5; i++) {
    result[i] = 1;                   // 기본 순위 1위로 시작
    for (int j = 0; j < 5; j++) {
        if (arr[i] < arr[j])         // 나보다 큰 게 있으면
            result[i]++;             // 순위 1 낮아짐
    }
}
// arr[0]=77 → 99보다 작으므로 2위 → result[0]=2
```

### 패턴 2 — 싱글톤 패턴 (하나만 만들기)

```java
class Connection {
    private static Connection _inst = null;  // 하나만 저장

    public static Connection get() {
        if (_inst == null) {
            _inst = new Connection();  // 처음에만 만들고
        }
        return _inst;                  // 항상 같은 것 반환
    }
}

Connection a = Connection.get();
Connection b = Connection.get();
// a와 b는 같은 객체를 가리킴!
```

---

## 16. 시험 출제 포인트 요약

| 개념 | 핵심 포인트 | 예시 결과 |
|------|------------|---------|
| `==` vs `equals()` | `==`은 주소, `equals()`는 내용 | 리터럴 `==` true, `new` `==` false |
| 업캐스팅 | `Parent p = new Child()` → Child 메소드 실행 | `pa.show()` → "child" |
| fall-through | switch에서 break 없으면 계속 내려감 | case 3부터 default까지 전부 실행 |
| static 변수 | 모든 객체가 공유 | `st.b`와 `Static.b` 같은 변수 |
| 생성자 순서 | 자식 생성자 → 부모 생성자 → 나머지 | AED7 |
| 후위 증감 | `k++` → 현재값 사용 후 증가 | result=k값, 그 다음 k+1 |
| finally | 항상 실행 | 예외 발생해도 finally 실행 |

---

*정보처리기사 실기 대비 — 10장 Java 문법 총정리*
