# C언어 문법 총정리 (정보처리기사 실기 대비)

---

## 1. 기본 구조 및 헤더

```c
#include <stdio.h>    // printf, scanf, putchar, gets
#include <stdlib.h>   // malloc, free
#include <string.h>   // strlen, strcpy 등
#include <ctype.h>    // isupper, islower, isdigit

int main() {
    // 코드
    return 0;
}
```

---

## 2. 기본 입출력

### 2-1. 출력 (printf)

```c
printf("%d\n", 정수);
printf("%s\n", 문자열);
printf("%c\n", 문자);
printf("%d %d %d\n", a, b, c);
```

| 서식 지정자 | 의미 |
|------------|------|
| `%d` | 10진 정수 |
| `%o` | 8진 정수 |
| `%x` | 16진 정수 |
| `%s` | 문자열 |
| `%c` | 문자 1개 |
| `%f` | 실수 |
| `\n` | 줄바꿈 |

### 2-2. 입력 (scanf)

```c
scanf("%d", &a);          // 정수 입력 (&로 주소 전달)
scanf("%d %d", &i, &j);  // 여러 값 입력
scanf("%o#%x", &i, &j);  // 8진수#16진수 형식
```

### 2-3. 문자 출력

```c
putchar(문자);           // 문자 1개 출력 (= printf("%c", ...))
```

---

## 3. 변수와 자료형

```c
int a = 10;
char c = 'A';
float f = 3.14;
double d = 3.14;
char str[] = "hello";
```

### 진법 표현 (시험 출제)

```c
int j = 024;    // 8진수 (0으로 시작) → 20
int k = 24;     // 10진수 → 24
int L = 0x24;   // 16진수 (0x로 시작) → 36
// hap = 20 + 24 + 36 = 80
```

---

## 4. 연산자

### 4-1. 산술 / 복합 대입

```c
a + b  /  a - b  /  a * b  /  a / b  /  a % b
a += 1;  i /= j;  k %= j;
```

### 4-2. 증감 연산자

```c
++a   // 먼저 증가 후 사용 (전위)
a++   // 먼저 사용 후 증가 (후위)
```

> **출력 예시 (기출 따라잡기_문제4.c)**
> ```c
> result = a < b ? b++ : --c;
> // a(100) < b(200) 참 → b++ : result=200, b=201
> // 출력: 200, 201, 300
> ```

### 4-3. 삼항 연산자

```c
조건 ? 참일_때 : 거짓일_때
z = y % 3 < 3 ? 2 : 1;
```

### 4-4. 비트 연산자

```c
a & b    // AND
a | b    // OR
a ^ b    // XOR
a >> n   // 오른쪽 시프트 (÷2^n)
a << n   // 왼쪽 시프트 (×2^n)
~a       // NOT
```

### 4-5. 논리 연산자

```c
a && b   // AND (단락 평가)
a || b   // OR  (단락 평가)
!a       // NOT
```

### 4-6. 연산자 우선순위

```
단항(++, --, !) > *(곱셈) > +- > 시프트 > 비교 >
비트AND(&) > 비트XOR(^) > 비트OR(|) > 논리AND(&&) > 논리OR(||) > 삼항 > 대입
```

> **출력 예시 (316 기출체크1.c)**
> ```c
> z = y % 3 < 3 ? 2 : 1;   // 4%3=1, 1<3 참 → z=2
> z = z & z >> 1;            // z>>1=1, z&1=0 → z=0
> z = x > 5 && z <= 3 ? z*x : z/x;  // 7>5 && 0<=3 → z*x=0
> // 출력: 0
> ```

---

## 5. 제어문

### 5-1. if / else

```c
if (조건) {
    // 실행
} else if (조건) {
    // 실행
} else {
    // 실행
}
```

### 5-2. switch / case (fall-through 주의)

```c
switch (변수) {
case 3: c = 0;    // break 없으면 아래로 계속
case 4: c += 3;
case 5: c -= 10;
default: c--;
}
```

> **출력 예시 (317 기출체크1.c)**
> ```c
> int c = 1;
> switch(3) {
>     case 3: c = 0;    // c=0
>     case 4: c += 3;   // c=3
>     case 5: c -= 10;  // c=-7
>     default: c--;     // c=-8
> }
> // 출력: -8
> ```

### 5-3. for

```c
for (int i = 0; i < 5; i++) { ... }
for (int i = 0, j = len-1; i < j; i++, j--) { ... }  // 다중 초기화
```

### 5-4. while / do-while

```c
while (조건) { ... }

do {
    // 최소 1회 실행
} while (조건);
```

### 5-5. break / continue

```c
break;      // 루프/switch 즉시 탈출
continue;   // 현재 반복 건너뜀
```

---

## 6. 배열

### 6-1. 1차원 배열

```c
int a[5] = {1, 2, 3, 4, 5};
int a[] = {85, 75, 50, 100, 95};   // 크기 자동
a[i]          // i번째 원소
sizeof(a)/sizeof(a[0])   // 배열 원소 개수
```

### 6-2. 2차원 배열

```c
int arr[3][3] = {1,2,3,4,5,6,7,8,9};   // 순서대로 채워짐
arr[i][j]    // i행 j열
```

### 6-3. 포인터와 배열

```c
int* p = arr;
*(p + i) == p[i] == arr[i]   // 모두 같음
```

---

## 7. 포인터 (Pointer)

### 7-1. 기본 개념

```c
int a = 50;
int *b = &a;   // b는 a의 주소를 저장

*b             // b가 가리키는 값 (= a)
*b = *b + 20;  // a = 70
```

### 7-2. 포인터와 문자열

```c
char *p = "KOREA";
printf("%s\n", p);      // "KOREA"      (p부터 끝까지)
printf("%s\n", p + 3);  // "EA"         (p+3부터 끝까지)
printf("%c\n", *p);     // 'K'          (p가 가리키는 문자)
printf("%c\n", *(p+3)); // 'E'          (p+3이 가리키는 문자)
printf("%c\n", *p + 2); // 'M'          (K의 ASCII + 2)
```

### 7-3. 이중 포인터

```c
int a = 12, b = 24, c = 36;
int* array[3] = {&a, &b, &c};
printf("%d", *array[1] + **array + 1);
// *array[1] = b = 24
// **array = *array[0] = a = 12
// 출력: 37
```

### 7-4. 포인터 연산

```c
int ary[3];
*(ary + 0) = 1;         // ary[0] = 1
ary[1] = *(ary+0) + 2;  // ary[1] = 3
ary[2] = *ary + 3;      // *ary = ary[0] = 1 → ary[2] = 4
// 합계: 1+3+4 = 8
```

---

## 8. 구조체 (Structure)

### 8-1. 구조체 정의 및 사용

```c
struct insa {
    char name[10];
    int age;
};

struct insa a[] = {"Kim", 28, "Lee", 38, "Park", 42};
struct insa* p = a;
p++;              // 다음 구조체로 이동
p->name           // 포인터로 멤버 접근 (= (*p).name)
p->age
```

### 8-2. 구조체 포인터 연산

```c
struct jsu* p = &st[0];
(p + 1)->hab = (p + 1)->os + (p + 2)->db;
// p+1은 st[1], p+2는 st[2]
```

### 8-3. typedef

```c
typedef struct Data {
    int value;
    struct Data *next;
} Data;

Data* new_node = (Data*)malloc(sizeof(Data));
```

---

## 9. 함수

### 9-1. 기본 구조

```c
int add(int a, int b) {
    return a + b;
}
```

### 9-2. 포인터 매개변수 (값 변경 목적)

```c
void swap(int* a, int idx1, int idx2) {
    int t = a[idx1];
    a[idx1] = a[idx2];
    a[idx2] = t;
}
swap(a, j, j+1);   // 배열을 포인터로 전달
```

> **핵심:** 함수에서 원본 값을 바꾸려면 포인터(주소)로 전달해야 함

### 9-3. 재귀 함수

```c
int func(int a) {
    if (a <= 1) return 1;       // 종료 조건
    return a * func(a - 1);     // 재귀 호출 (팩토리얼)
}
```

### 9-4. static 변수 (함수 내)

```c
int func() {
    static int x = 0;   // 함수 호출 간 값 유지
    x += 2;
    return x;
}
// 첫 호출: x=2, 두번째: x=4, 세번째: x=6, 네번째: x=8
// 합계: 2+4+6+8 = 20
```

### 9-5. 함수 포인터

```c
int (*pf)(int);   // int를 받고 int를 반환하는 함수 포인터
pf = factorial;
pf(3);            // factorial(3) 호출
```

---

## 10. 동적 메모리 할당

```c
#include <stdlib.h>

int* arr = (int*)malloc(sizeof(int) * 5);   // 할당
free(arr);                                    // 해제

// 2D 배열
int** arr = (int**)malloc(sizeof(int*) * rows);
for (int i = 0; i < rows; i++)
    arr[i] = (int*)malloc(sizeof(int) * cols);
// 해제 시 역순
for (int i = 0; i < rows; i++) free(arr[i]);
free(arr);
```

---

## 11. 연결 리스트

```c
typedef struct Data {
    int value;
    struct Data *next;   // 다음 노드 포인터
} Data;

// 삽입 (앞에 추가)
Data* insert(Data* head, int value) {
    Data* new_node = (Data*)malloc(sizeof(Data));
    new_node->value = value;
    new_node->next = head;
    return new_node;
}

// 순회
for (curr = head; curr != NULL; curr = curr->next)
    printf("%d", curr->value);
```

---

## 12. 스택 / 큐

### 스택 (LIFO)
```c
int isWhat[MAX_SIZE];
int point = -1;

void into(int num) { isWhat[++point] = num; }   // push
int take() { return isWhat[point--]; }           // pop (뒤에서)
```

### 큐 (FIFO)
```c
typedef struct {
    int a[SIZE];
    int front, rear;
} Queue;

void enq(Queue* q, int val) {
    q->a[q->rear] = val;
    q->rear = (q->rear + 1) % SIZE;  // 원형 큐
}
int deq(Queue* q) {
    int val = q->a[q->front];
    q->front = (q->front + 1) % SIZE;
    return val;
}
```

---

## 13. 문자열 / ctype.h

```c
int len = strlen(str);    // 문자열 길이

// ctype.h 함수
isupper(c)    // 대문자인지
islower(c)    // 소문자인지
isdigit(c)    // 숫자인지

// 대소문자 변환 패턴
result[i] = (p[i] - 'A' + 5) % 25 + 'A';   // 대문자 시프트
result[i] = (p[i] - 'a' + 10) % 26 + 'a';  // 소문자 시프트
result[i] = (p[i] - '0' + 3) % 10 + '0';   // 숫자 시프트
```

---

## 14. 전처리기

```c
#include <stdio.h>        // 헤더 파일 포함
#define MAX_SIZE 10       // 상수 정의 (세미콜론 없음)
#define SIZE 3
```

---

## 15. 자주 나오는 패턴

### 패턴 1 — 버블 정렬
```c
for (int i = 0; i < len - 1; i++)
    for (int j = 0; j < len - 1 - i; j++)
        if (a[j] > a[j+1]) {
            temp = a[j]; a[j] = a[j+1]; a[j+1] = temp;
        }
```

### 패턴 2 — 선택 정렬 (do-while)
```c
do {
    int j = i + 1;
    do {
        if (E[i] > E[j]) { swap; }
        j++;
    } while (j < n);
    i++;
} while (i < n - 1);
```

### 패턴 3 — 숫자 자릿수 분리
```c
int m = 4620;
int a = m / 1000;          // 1000원 단위
int b = m % 1000 / 500;    // 500원 단위
int c = m % 500 / 100;     // 100원 단위
int d = m % 100 / 10;      // 10원 단위
```

### 패턴 4 — 숫자 뒤집기
```c
while (number != 0) {
    result = result * 10 + number % 10;
    number = number / 10;
}
```

### 패턴 5 — 소수 판별
```c
int isPrime(int number) {
    for (int i = 2; i < number; i++)
        if (number % i == 0) return 0;
    return 1;
}
```

### 패턴 6 — 완전수 판별
```c
int isPerfectNum(int num) {
    int sum = 0;
    for (int i = 1; i < num; i++)
        if (num % i == 0) sum += i;
    return (num == sum) ? 1 : 0;
}
```

### 패턴 7 — 문자열 역순
```c
for (int i = 0, j = len-1; i < j; i++, j--) {
    char ch = str[i];
    str[i] = str[j];
    str[j] = ch;
}
```

---

## 16. 시험 출제 포인트

| 개념 | 핵심 포인트 |
|------|------------|
| 진법 표현 | `0`으로 시작 → 8진수, `0x` → 16진수 |
| 포인터 | `*p` 역참조, `&a` 주소, `p->m` 구조체 멤버 |
| 배열·포인터 | `a[i] == *(a+i)` 동일 |
| switch fall-through | `break` 없으면 아래 case 모두 실행 |
| 전위·후위 증감 | `++a` 증가 후 사용, `a++` 사용 후 증가 |
| static 변수 | 함수 내 선언 시 호출 간 값 유지 |
| 구조체 포인터 | `->` 연산자로 멤버 접근 |
| 동적 할당 | `malloc`으로 할당, `free`로 해제 |
| 재귀 함수 | 반드시 종료 조건 확인 |
| 연결 리스트 | head → node → NULL 구조 |

---

*정보처리기사 실기 대비 — 10장 C언어 문법 총정리*
