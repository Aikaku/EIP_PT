# 파이썬 문법 총정리 (정보처리기사 실기 대비)

---

## 1. 변수와 자료형

### 1-1. 변수 선언 및 다중 할당

```python
a = 10
x, y = 100, 200      # 다중 할당
a, b = 2, 3
i, hap = 0, 0
```

### 1-2. 기본 자료형

| 자료형 | 예시 | 설명 |
|--------|------|------|
| int | `a = 10` | 정수 |
| float | `b = 100.0` | 실수 |
| str | `s = "hello"` | 문자열 |
| bool | `True`, `False` | 불리언 |

```python
# type() 함수로 자료형 확인
type(100)     # <class 'int'>
type(100.0)   # <class 'float'>
type("hello") # <class 'str'>
type((1,2))   # <class 'tuple'>
```

---

## 2. 연산자

### 2-1. 산술 연산자

```python
a + b    # 덧셈
a - b    # 뺄셈
a * b    # 곱셈
a / b    # 나눗셈 (실수 결과)
a // b   # 정수 나눗셈 (몫)
a % b    # 나머지
a ** b   # 거듭제곱
```

### 2-2. 복합 대입 연산자

```python
a += 1   # a = a + 1
a -= 1
a *= 3
a /= 3
```

### 2-3. 비교 연산자

```python
x == y   # 같다
x != y   # 다르다
x >= y   # 크거나 같다
x <= y   # 작거나 같다
x > y
x < y
```

> **출력 예시 (문제 01.py)**
> ```python
> x, y = 100, 200
> print(x == y)   # False
> ```

### 2-4. 비트 연산자

```python
a & b    # AND (비트 단위)
a | b    # OR
a ^ b    # XOR
a >> n   # 오른쪽 시프트 (÷2^n)
a << n   # 왼쪽 시프트 (×2^n)
```

> **출력 예시 (문제13.py)**
> ```python
> a, b = 2, 3
> c = a & b    # 010 & 011 = 010 → 2
> print(c)     # 2
> ```

> **출력 예시 (332 Range 기출체크1.py)**
> ```python
> a = 100
> result = 0
> for i in range(1, 3):
>     result = a >> i    # 100>>1=50, 100>>2=25
>     result = result + 1
> print(result)          # 26
> ```

---

## 3. 문자열 (String)

### 3-1. 인덱싱과 슬라이싱

```python
s = "REMEMBER NOVEMBER"

s[0]       # 'R'        (0번째 문자)
s[-1]      # 'R'        (뒤에서 1번째)
s[0:3]     # 'REM'      (0~2번 인덱스)
s[12:16]   # 'OVEM'     (12~15번 인덱스)
s[:3]      # 'REM'      (처음~2번)
s[-3:]     # 'BER'      (뒤에서 3번째~끝)
s[::2]     # 짝수 인덱스만 (2칸씩 건너뜀)
s[1::2]    # 홀수 인덱스만
```

> **슬라이스 공식:** `문자열[시작:끝:간격]` — 끝 인덱스는 **포함 안 됨**

### 3-2. 문자열 포맷팅

```python
# % 포맷팅
"과일명 : %s" % "apple"
"R AND %s" % "STR"

# f-string (권장)
name = "Python"
f"언어: {name}"
f'ab{cnt(str, p1)} ca{cnt(str, p2)}'
```

### 3-3. 문자열 메소드

```python
s.split('-')     # 구분자로 분리 → 리스트 반환
s.split(' ')     # 공백으로 분리
len(s)           # 문자열 길이
```

> **출력 예시 (328 기출체크2.py)**
> ```python
> a = "REMEMBER NOVEMBER"
> b = a[0:3] + a[12:16]   # "REM" + "OVEM" = "REMOVEM"
> c = "R AND %s" % "STR"  # "R AND STR"
> print(b + c)             # REMOVEMR AND STR
> ```

---

## 4. 리스트 (List)

### 4-1. 리스트 기본

```python
a = [1, 2, 3, 4, 5]
a[0]        # 1 (인덱스 접근)
a[-1]       # 5 (뒤에서 첫 번째)
a[1:-3:]    # 슬라이싱
```

### 4-2. 리스트 메소드

```python
a.append(x)       # 끝에 요소 추가
a.remove('def456')# 해당 값 제거 (첫 번째만)
len(a)            # 리스트 길이
sum(a)            # 합계
```

### 4-3. 리스트 슬라이싱

```python
lst = [1, 2, 3, 4, 5, 6]
lst[::2]     # [1, 3, 5]  (짝수 인덱스)
lst[1::2]    # [2, 4, 6]  (홀수 인덱스)
lst[-i-1]    # 뒤에서 i+1번째
```

### 4-4. 중첩 리스트

```python
lol = [[1, 2, 3], [4, 5], [6, 7, 8, 9]]
lol[0]      # [1, 2, 3]
lol[2][1]   # 7
```

### 4-5. 리스트 컴프리헨션

```python
nodes = [Node(i) for i in li]   # 리스트 컴프리헨션
```

---

## 5. 튜플 (Tuple)

```python
t = (100, 200)    # 소괄호 사용
type(t)           # <class 'tuple'>
```

- 리스트와 유사하나 **수정 불가**
- `type()` 비교 시 `type((1,2))`로 확인

---

## 6. 세트 (Set)

### 6-1. 세트 생성 및 기본 연산

```python
asia = {'한국', '중국', '일본'}   # 중복 없음, 순서 없음
```

### 6-2. 세트 메소드

```python
asia.add('베트남')              # 요소 추가 (이미 있으면 무시)
asia.remove('일본')             # 요소 제거
asia.update({'홍콩', '태국'})   # 여러 요소 추가 (합집합)
```

### 6-3. 집합 연산

```python
s1 & s2    # 교집합 (intersection)
s1 | s2    # 합집합 (union)
s1 - s2    # 차집합
```

> **주의:** 세트는 순서가 없어 `print()` 결과 순서가 매번 다를 수 있음

---

## 7. 딕셔너리 (Dictionary)

### 7-1. 딕셔너리 기본

```python
result = {}                     # 빈 딕셔너리
result[index] = (list_sum, list_len)  # 키-값 추가
```

### 7-2. 딕셔너리 컴프리헨션

```python
lst = [1, 2, 3]
dst = {i: i * 2 for i in lst}   # {1:2, 2:4, 3:6}
```

### 7-3. 딕셔너리 메소드

```python
dst.values()    # 값 목록 반환
set(dst.values())   # 값을 세트로 변환
```

---

## 8. 제어문

### 8-1. if / elif / else

```python
if x == 10:
    # 실행
elif x == 50:
    # 실행
else:
    # 실행
```

### 8-2. for 루프

```python
# range() 사용
for i in range(1, 11):    # 1~10
    hap += i

for i in range(1, 3):     # 1, 2
    result = a >> i

# 리스트 순회
for i in a:
    print(i)

# 중첩 for
for sub in lol:
    for item in sub:
        print(item, end=' ')
    print()
```

### 8-3. while 루프

```python
while True:       # 무한루프
    i += 1
    hap += i
    if i >= 100:
        break

while 1:          # 1도 True로 동작 (무한루프)
    ...
```

### 8-4. break / continue

```python
break      # 루프 즉시 탈출
continue   # 현재 반복 건너뛰고 다음으로
```

> **출력 예시 (문제12.py)**
> ```python
> a = sum = 0
> while a < 10:
>     a += 1
>     if a % 2 == 1:
>         continue     # 홀수면 skip
>     sum += a         # 짝수만 더함
> print(sum)           # 2+4+6+8+10 = 30
> ```

---

## 9. 함수 (Function)

### 9-1. 기본 함수

```python
def func_name(매개변수):
    # 실행
    return 결과값
```

### 9-2. 기본값 매개변수 (Default Parameter)

```python
def func(num1, num2=2):    # num2 기본값 2
    print('a =', num1, 'b =', num2)

func(20)      # a = 20 b = 2
func(20, 5)   # a = 20 b = 5
```

### 9-3. 반환값 활용

```python
def calc(x, y):
    x *= 3
    y /= 3
    print(x, y)
    return x        # x만 반환

a, b = 3, 12
a = calc(a, b)      # 반환값을 a에 재할당
print(a, b)         # b는 원본 유지 (값 전달)
```

> **핵심:** 파이썬 함수는 **값(value) 전달** — 함수 안에서 매개변수를 바꿔도 원본 변수에 영향 없음 (리스트는 예외)

### 9-4. 재귀 함수

```python
def calc(node, level=0):
    if node is None:
        return 0
    return (node.value if level % 2 == 1 else 0) + sum(calc(n, level + 1) for n in node.children)
```

### 9-5. 리스트를 매개변수로 받을 때

```python
def func(lst):
    for i in range(len(lst) // 2):
        lst[i], lst[-i-1] = lst[-i-1], lst[i]   # 리스트 원소 교환 (swap)

lst = [1, 2, 3, 4, 5, 6]
func(lst)   # 리스트는 참조 전달 → 원본이 바뀜
```

---

## 10. 람다 (Lambda)

```python
# 기본 형태
lambda 매개변수 : 표현식

# 예시
lambda num : num + 100

# map()과 함께 사용
a = [1, 2, 3, 4, 5]
a = list(map(lambda num: num + 100, a))
# [101, 102, 103, 104, 105]
```

| 함수 | 설명 |
|------|------|
| `map(함수, 이터러블)` | 각 요소에 함수 적용 |
| `list(map(...))` | map 결과를 리스트로 변환 |

---

## 11. 클래스 (Class)

### 11-1. 클래스 기본 구조

```python
class 클래스명:
    클래스변수 = 값          # 모든 인스턴스가 공유

    def __init__(self, 매개변수):    # 생성자
        self.인스턴스변수 = 매개변수

    def 메소드명(self):
        return self.인스턴스변수
```

### 11-2. 클래스 사용 예시

```python
class Cls:
    x, y = 10, 20       # 클래스 변수

    def chg(self):
        temp = self.x
        self.x = self.y
        self.y = temp    # x, y 값 교환

a = Cls()               # 인스턴스 생성
print(a.x, a.y)         # 10 20
a.chg()
print(a.x, a.y)         # 20 10
```

### 11-3. self vs sel (시험 주의)

```python
class FourCal:
    def setdata(sel, fir, sec):    # self 대신 sel 사용 가능 (관례만 다름)
        sel.fir = fir
        sel.sec = sec
    def add(sel):
        return sel.fir + sel.sec
```

> **주의:** `self` 는 관례적인 이름이며 다른 이름(`sel` 등)도 동작함. 첫 번째 매개변수가 인스턴스를 받음.

### 11-4. 클래스 없이 함수만 사용

```python
def func(num1, num2=2):
    print('a =', num1, 'b =', num2)
```

---

## 12. 내장 함수 정리

| 함수 | 설명 | 예시 |
|------|------|------|
| `print()` | 출력 | `print(a, b, sep=',', end=' ')` |
| `input()` | 사용자 입력 | `x = input("입력: ")` |
| `range(n)` | 0~n-1 정수 생성 | `range(1, 11)` → 1~10 |
| `len()` | 길이 반환 | `len([1,2,3])` → 3 |
| `sum()` | 합계 | `sum([1,2,3])` → 6 |
| `type()` | 자료형 반환 | `type(100)` → int |
| `list()` | 리스트 변환 | `list(map(...))` |
| `set()` | 세트 변환 | `set([1,1,2])` → {1,2} |
| `map()` | 각 요소에 함수 적용 | `map(lambda x: x+1, a)` |
| `enumerate()` | (인덱스, 값) 쌍 반환 | `enumerate(data)` |

### print() 옵션

```python
print(a, b, sep=',')     # 구분자 지정 (기본: 공백)
print(i, end=' ')        # 줄바꿈 대신 공백 (기본: '\n')
```

---

## 13. enumerate()

```python
data = [[3,5,2], [4,5,1], [4,4,1]]
for index, lis in enumerate(data):
    # index: 0, 1, 2 ...
    # lis: 각 내부 리스트
    list_sum = sum(lis)
    list_len = len(lis)
    result[index] = (list_sum, list_len)
```

---

## 14. 자주 나오는 패턴 정리

### 패턴 1 - 리스트 뒤집기 (swap)
```python
lst[i], lst[-i-1] = lst[-i-1], lst[i]
```

### 패턴 2 - 누적 합계
```python
hap = 0
for i in range(1, 101):
    hap += i
# 1+2+...+100 = 5050
```

### 패턴 3 - 짝수만 합산
```python
sum = 0
for a in range(1, 11):
    if a % 2 == 0:
        sum += a
```

### 패턴 4 - 문자열 슬라이싱으로 문자 추출
```python
a = ['Seoul', 'Kyeonggi', 'Incheon']
for i in a:
    result += i[0]    # 각 단어의 첫 글자
    result += i[1]    # 각 단어의 두 번째 글자
```

### 패턴 5 - map + lambda로 리스트 일괄 변환
```python
a = list(map(lambda num: num + 100, a))
```

### 패턴 6 - type() 비교
```python
if type(value) == type(100):       # 정수형인지 확인
    return 100
elif type(value) == type(""):      # 문자열인지 확인
    return len(value)
else:
    return 20
```

---

## 15. 시험 출제 포인트 요약

| 개념 | 핵심 포인트 |
|------|------------|
| 슬라이싱 | 끝 인덱스 미포함, 음수 인덱스 |
| 비트연산 | `>>` 오른쪽 시프트 = ÷2, `&` AND |
| 세트 | 중복 없음, 순서 없음, add/remove/update |
| 람다 | `lambda 변수: 표현식` |
| 클래스 | self는 인스턴스 자신, 관례적 이름 |
| 함수 전달 | 기본형은 값 전달, 리스트는 참조 전달 |
| range | `range(시작, 끝)` — 끝 미포함 |
| print sep/end | `sep=','` 구분자, `end=' '` 끝 문자 |

---

*정보처리기사 실기 대비 — 10장 Python 문법 총정리*
