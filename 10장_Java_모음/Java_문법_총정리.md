# Java 문법 총정리 (정보처리기사 실기 대비)

---

## 1. 기본 입출력

### 1-1. 출력

```java
System.out.print("줄바꿈 없음");
System.out.println("줄바꿈 있음");
System.out.printf("%d %s\n", 정수, 문자열);   // C 스타일 포맷
```

| 서식 지정자 | 의미 |
|------------|------|
| `%d` | 정수 |
| `%s` | 문자열 |
| `%c` | 문자 |
| `%f` | 실수 |
| `\n` | 줄바꿈 |

### 1-2. 입력 (Scanner)

```java
import java.util.Scanner;

Scanner scan = new Scanner(System.in);
int a = scan.nextInt();       // 정수 입력
String s = scan.next();       // 문자열 입력
scan.close();
```

---

## 2. 변수와 자료형

```java
int a = 10;
double d = 3.14;
char c = 'A';
String s = "hello";
boolean b = true;
```

### 진법 표현 (시험 출제)

```java
int a = 035;     // 8진수 (0으로 시작) → 29
int b = 0x35;    // 16진수 (0x로 시작) → 53
int c = 35;      // 10진수 → 35
```

---

## 3. 연산자

### 3-1. 산술 / 복합 대입

```java
a + b  /  a - b  /  a * b  /  a / b  /  a % b
a += 1;  a -= 1;  a *= 3;
```

### 3-2. 증감 연산자 (전위 vs 후위)

```java
++a   // 먼저 증가 후 사용
a++   // 먼저 사용 후 증가
--a   // 먼저 감소 후 사용
a--   // 먼저 사용 후 감소
```

> **출력 예시 (문제11.java)**
> ```java
> j = 10; k = 20; L = 30;
> result = j < k ? k++ : --L;
> // j < k 가 true → k++(k를 쓰고 나서 증가) → result=20, k=21
> // 출력: 20 21 30
> ```

### 3-3. 삼항 연산자

```java
조건 ? 참일_때_값 : 거짓일_때_값
(num >= 0) ? "positive" : "negative"
```

### 3-4. 비트 / 논리 연산자

```java
a & b    // 비트 AND (단락 없음)
a | b    // 비트 OR  (단락 없음)
a ^ b    // 비트 XOR
a && b   // 논리 AND (단락 평가)
a || b   // 논리 OR  (단락 평가)
!a       // 논리 NOT
a >> n   // 오른쪽 시프트
```

> **주의:** `&`, `|` 는 비트 연산이지만 조건식에서도 사용 가능 — 양쪽 모두 평가함

### 3-5. 연산자 우선순위 (높음 → 낮음)

```
단항(++, --, !) > 산술(*, /, %) > 산술(+, -) > 시프트(>>, <<)
> 비교(<, >, <=, >=) > 동등(==, !=) > 비트AND(&) > 비트XOR(^)
> 비트OR(|) > 논리AND(&&) > 논리OR(||) > 삼항(?:) > 대입(=, +=...)
```

---

## 4. 배열

### 4-1. 1차원 배열

```java
int a[] = new int[8];          // 선언 (0으로 초기화)
int a[] = {1, 2, 3, 4, 5};    // 선언 + 초기화
int[] arr = new int[]{1,2,3};  // 명시적 초기화

a.length    // 배열 길이
```

### 4-2. 2차원 배열

```java
int ary[][] = new int[3][5];
int aa[][] = {{45,50,75}, {89}};   // 가변 배열 가능

aa[0].length   // 3 (첫 번째 행의 길이)
aa[1].length   // 1 (두 번째 행의 길이)
```

### 4-3. for-each 루프

```java
for (int p : x) {   // x 배열의 각 요소를 p에
    System.out.print(p);
}
```

---

## 5. 문자열 (String)

```java
String str = "ITISTESTSTRING";
str.length()          // 문자열 길이
str.charAt(i)         // i번째 문자
str.split("T")        // "T"를 기준으로 분리 → String 배열
str.equals(other)     // 내용 비교 (== 는 주소 비교)
```

> **`==` vs `equals()` 차이 (시험 출제)**
> ```java
> String str1 = "Programming";
> String str2 = "Programming";      // 리터럴: 같은 주소
> String str3 = new String("Programming");  // new: 다른 주소
>
> str1 == str2      // true  (같은 리터럴 풀)
> str1 == str3      // false (new로 별도 생성)
> str1.equals(str3) // true  (내용 같음)
> ```

---

## 6. 제어문

### 6-1. if / else

```java
if (조건) {
    // 실행
} else if (조건) {
    // 실행
} else {
    // 실행
}
```

### 6-2. switch / case

```java
switch (변수) {
    case 1:
        // break 없으면 아래 case로 fall-through
    case 2:
        // 실행
        break;
    default:
        // 기본
}
```

> **fall-through 주의:** `break`가 없으면 다음 case로 계속 실행됨

### 6-3. for

```java
for (int i = 0; i < 5; i++) { ... }
for (int j = 0, i = 0; i <= 5; i++) { ... }  // 초기화 여러 개
```

### 6-4. while / do-while

```java
while (조건) { ... }

do {
    // 최소 1회 실행
} while (조건);
```

### 6-5. break / continue

```java
break;      // 루프/switch 탈출
continue;   // 현재 반복 건너뜀
```

---

## 7. 함수 (메소드)

### 7-1. 기본 구조

```java
반환형 메소드명(매개변수) {
    return 값;
}

static int add(int x, int y) {
    return x + y;
}
```

### 7-2. static 메소드

```java
public static void main(String[] args) { }   // 진입점
static void func1(A m) { ... }               // 클래스 메소드
```

### 7-3. 재귀 함수

```java
int compute(int num) {
    if (num <= 1) return num;          // 종료 조건
    return compute(num - 1) + compute(num - 2);  // 재귀 호출
}
```

### 7-4. 메소드 오버로딩

```java
void print(Integer a) { ... }
void print(Object a) { ... }
void print(Number a) { ... }
// 같은 이름, 다른 매개변수 타입 → 오버로딩
```

---

## 8. 클래스 (Class)

### 8-1. 기본 구조

```java
class 클래스명 {
    int 인스턴스변수;           // 객체마다 독립
    static int 클래스변수;      // 모든 객체가 공유

    클래스명(int a) {          // 생성자
        this.인스턴스변수 = a;
    }

    void 메소드() { ... }
}
```

### 8-2. this

```java
this.a = a;         // 인스턴스 변수 접근
this.메소드();      // 현재 객체의 메소드 호출
```

### 8-3. static 변수

```java
class Static {
    public int a = 20;    // 인스턴스 변수
    static int b = 0;     // 클래스 변수 (공유)
}

Static.b = 10;            // 클래스명으로 직접 접근
Static st = new Static();
st.b;                     // 인스턴스로도 접근 가능 (같은 변수)
```

> **출력 예시 (323 기출체크2.java)**
> ```java
> int a = 10;
> Static.b = a;           // b = 10
> Static st = new Static();
> System.out.println(Static.b++);  // 10 출력 후 b=11
> System.out.println(st.b);        // 11 (같은 변수)
> System.out.println(a);           // 10
> System.out.print(st.a);          // 20 (인스턴스 변수)
> ```

---

## 9. 상속 (Inheritance)

### 9-1. 기본 상속

```java
class Parent {
    void show() { System.out.println("parent"); }
}
class Child extends Parent {
    void show() { System.out.println("child"); }   // 오버라이딩
}

Parent pa = new Child();   // 업캐스팅
pa.show();                 // "child" → 오버라이딩된 메소드 호출
```

> **다형성 핵심:** 참조 타입은 `Parent`지만 실제 객체가 `Child`면 → `Child`의 오버라이딩 메소드 실행

### 9-2. super

```java
class Child extends Parent {
    Child(int a) {
        super(a);          // 부모 생성자 호출
        super.display();   // 부모 메소드 호출
    }
}
```

### 9-3. 생성자 호출 순서

```java
ClassB b = new ClassB();
// 1. ClassB 생성자 → super() → ClassA 생성자 실행
// 2. ClassA 생성자 내 this.prn() → 오버라이딩된 ClassB.prn() 실행
// 3. ClassA 생성자 완료 후 ClassB 나머지 실행
```

> **출력 예시 (03 Java 문제2.java)**
> ```
> A → E → D → 7
> ```

---

## 10. 추상 클래스 (Abstract Class)

```java
abstract class Animal {
    String a = " is animal";
    abstract void look();          // 추상 메소드 (구현 없음)
    void show() {
        System.out.println("Zoo"); // 일반 메소드 (구현 있음)
    }
}
class Chicken extends Animal {
    void look() {                  // 반드시 구현
        System.out.println("Chicken" + a);
    }
}
```

- 추상 클래스는 `new`로 직접 생성 불가
- 자식 클래스에서 추상 메소드 반드시 구현

---

## 11. 인터페이스 (Interface)

```java
interface Number {
    int sum(int[] a, boolean odd);   // 추상 메소드 (구현 없음)
}
class OENumber implements Number {
    public int sum(int[] a, boolean odd) {
        // 반드시 구현
    }
}
```

| 구분 | abstract class | interface |
|------|---------------|-----------|
| 다중 상속 | 불가 | 가능 (implements 여러 개) |
| 메소드 | 일반+추상 | 추상 메소드만 (Java 8 이후 default 가능) |
| 변수 | 일반 변수 | 상수만 (public static final) |

---

## 12. 예외 처리 (Exception)

```java
try {
    // 예외 발생 가능 코드
    System.out.print(a / b);          // b=0이면 ArithmeticException
} catch (ArithmeticException e) {
    System.out.print("출력1");        // 해당 예외 처리
} catch (Exception e) {
    System.out.print("출력4");        // 모든 예외 처리 (마지막)
} finally {
    System.out.print("출력5");        // 항상 실행
}
```

### 주요 예외 클래스

| 예외 | 발생 상황 |
|------|-----------|
| `ArithmeticException` | 0으로 나누기 |
| `ArrayIndexOutOfBoundsException` | 배열 범위 초과 |
| `NullPointerException` | null 참조 |
| `NumberFormatException` | 숫자 변환 실패 |

### throws / throw

```java
static void func() throws Exception {
    throw new NullPointerException();  // 예외 강제 발생
}
```

---

## 13. enum (열거형)

```java
enum Tri {
    A("A"), B("AB"), C("ABC");
    private String code;
    Tri(String code) { this.code = code; }
    public String code() { return code; }
}

Tri.values()          // 모든 열거 상수 배열 반환
Tri.A.name()          // "A" (상수 이름 문자열)
Tri.A.name().length() // 1
Tri.values()[1]       // B (인덱스 1)
```

---

## 14. 람다식 (Lambda)

```java
// 인터페이스 F의 구현을 람다로
F f = (x) -> {
    if (x > 2) throw new Exception();
    return x * 2;
};

// 단순 표현
(int n) -> n + 9
```

---

## 15. 제네릭 (Generics)

```java
public static class Collection<T> {
    T value;
    public Collection(T t) { value = t; }
    public void print() {
        new Printer().print(value);   // T 타입으로 호출
    }
}
new Collection<>(0)   // T = Integer (박싱)
```

---

## 16. 자주 나오는 패턴

### 패턴 1 — 배열 정렬 순위 계산
```java
// 각 원소보다 큰 원소 수 세기 → 순위
result[i] = 1;
for (int j = 0; j < 5; j++)
    if (arr[i] < arr[j]) result[i]++;
```

### 패턴 2 — 10진수 → 2진수 변환
```java
while (n > 0) {
    a[i++] = n % 2;   // 나머지 저장
    n /= 2;
}
// 역순 출력
for (i = 7; i >= 0; i--) System.out.print(a[i]);
```

### 패턴 3 — 싱글톤 패턴
```java
class Connection {
    private static Connection _inst = null;
    public static Connection get() {
        if (_inst == null) _inst = new Connection();
        return _inst;   // 항상 같은 인스턴스 반환
    }
}
```

### 패턴 4 — 객체 배열 swap
```java
BO[] arr = {a, b, c};
BO t = arr[0];
arr[0] = arr[2];
arr[2] = t;
arr[1].v = arr[0].v;  // 배열 swap 후 참조가 가리키는 원본도 바뀜
```

---

## 17. 시험 출제 포인트

| 개념 | 핵심 포인트 |
|------|------------|
| `==` vs `equals()` | `==`은 주소 비교, `equals()`는 내용 비교 |
| 업캐스팅 | `Parent p = new Child()` → 오버라이딩 메소드 실행 |
| static | 모든 인스턴스가 공유, 클래스명으로 접근 |
| 생성자 순서 | 자식 생성자 → super() → 부모 생성자 실행 |
| fall-through | switch의 break 없으면 다음 case 계속 실행 |
| 후위 증감 | `k++` → 현재 값 사용 후 증가 |
| 추상 클래스 | 직접 new 불가, 자식이 추상 메소드 구현 |
| 예외 처리 | finally는 항상 실행 |

---

*정보처리기사 실기 대비 — 10장 Java 문법 총정리*
