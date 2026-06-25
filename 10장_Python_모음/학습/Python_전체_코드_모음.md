# Python 전체 코드 모음

> 총 34개 파일을 주제별로 분류 정리

---

## 목차

1. [기본 출력 / 비교 연산자](#1-기본-출력--비교-연산자)
2. [비트 연산자](#2-비트-연산자)
3. [반복문 (for / while)](#3-반복문-for--while)
4. [문자열 & 슬라이싱](#4-문자열--슬라이싱)
5. [리스트 (2차원 포함)](#5-리스트-2차원-포함)
6. [세트 & 딕셔너리](#6-세트--딕셔너리)
7. [함수 (def)](#7-함수-def)
8. [람다 & map](#8-람다--map)
9. [클래스](#9-클래스)
10. [기출 따라잡기](#10-기출-따라잡기)
11. [고급 문제 (트리 / 문자열 탐색)](#11-고급-문제-트리--문자열-탐색)

---

## 1. 기본 출력 / 비교 연산자

### 문제 01 — 비교 연산자 결과
```python
x, y = 100, 200
print(x==y)
```
> **출력:** `False`

**포인트:** `==`는 값을 비교. 100과 200은 다르므로 False.

---

### 문제 24 — 입력값 분리
```python
x, y = input("x, y의 값을 공백으로 구분하여 입력 : ").split(' ')
print("x의 값 :", x)
print("y의 값 :", y)
```
> **출력 예시 (입력: `3 5`):**
> ```
> x의 값 : 3
> y의 값 : 5
> ```

**포인트:** `split(' ')`으로 공백 기준 분리 후 각각 변수에 대입.

---

## 2. 비트 연산자

### 문제 13 — AND 비트 연산
```python
a, b = 2, 3
c = a & b
print(c)
```
> **출력:** `2`

**풀이:**
```
a = 2 → 이진수 010
b = 3 → 이진수 011
a & b → 010 (둘 다 1인 자리만 1)
010 = 2
```

---

### 332 — Range + 비트 시프트
```python
a = 100
result = 0
for i in range(1, 3):
    result = a >> i
    result = result + 1
print(result)
```
> **출력:** `26`

**풀이:**
```
i=1: result = 100 >> 1 = 50,  result = 50+1 = 51
i=2: result = 100 >> 2 = 25,  result = 25+1 = 26
최종: 26
```

**포인트:** `>>` 오른쪽 시프트 = 2로 나눔. 매 반복마다 result가 덮어쓰여짐.

---

## 3. 반복문 (for / while)

### 문제 15 — for + range, 마지막 i 값
```python
hap = 0
for i in range(1, 11):
    hap += i
print(i, hap)
```
> **출력:** `10 55`

**포인트:** 루프가 끝난 뒤 `i`는 마지막 값인 10. `hap`은 1~10 합계 = 55.

---

### 문제 26 / 문제 27 — while + break (1~100 합계)
```python
i, hap = 0, 0
while 1:      # while True: 와 동일
    i += 1
    hap += i
    if i >= 100:
        break
print(hap)
```
> **출력:** `5050`

**포인트:** `while 1`은 `while True`와 완전히 동일. `i >= 100`이 되면 break로 탈출.

---

### 문제 12 — while + continue (짝수 합)
```python
a = sum = 0
while a < 10:
    a += 1
    if a % 2 == 1:
        continue
    sum += a
print(sum)
```
> **출력:** `30`

**풀이:**
```
a=1: 홀수 → continue (건너뜀)
a=2: 짝수 → sum=2
a=3: 홀수 → continue
a=4: 짝수 → sum=6
a=5: 홀수 → continue
a=6: 짝수 → sum=12
a=7: 홀수 → continue
a=8: 짝수 → sum=20
a=9: 홀수 → continue
a=10: 짝수 → sum=30  (while 조건 a<10 체크 전에 sum에 더해짐)
```

**주의:** `a=10`일 때 `a < 10`은 False지만, 그 전에 이미 `a += 1`이 실행되어 sum에 더해진 후 while 조건 체크.  
→ 실제로는 `a += 1`로 10이 된 시점에 while 재진입 시 `a < 10`이 False가 되므로 종료. sum=30.

---

## 4. 문자열 & 슬라이싱

### 문제 25 — 문자열 슬라이싱 조합
```python
a = "engineer information programming"
b = a[:3]       # "eng"
c = a[4:6]      # "ne"
d = a[29:]      # "ing"
e = b + c + d
print(e)
```
> **출력:** `engneing`

**인덱스 확인:**
```
e n g i n e e r   i  n  f  o  r  m  a  t  i  o  n     p  r  o  g  r  a  m  m  i  n  g
0 1 2 3 4 5 6 7 8 9 10 11 12 13 14 15 16 17 18 19 20 21 22 23 24 25 26 27 28 29 30 31
```
- `a[:3]` = "eng" (0,1,2)
- `a[4:6]` = "ne" (4,5)
- `a[29:]` = "ing" (29,30,31)

---

### 328 기출체크2 — 슬라이싱 + % 포맷팅
```python
a = "REMEMBER NOVEMBER"
b = a[0:3] + a[12:16]
c = "R AND %s" % "STR"
print(b + c)
```
> **출력:** `REMEMBE R AND STR`

**풀이:**
```
"REMEMBER NOVEMBER"
 R  E  M  E  M  B  E  R     N  O  V  E  M  B  E  R
 0  1  2  3  4  5  6  7  8  9 10 11 12 13 14 15 16

a[0:3]  = "REM"
a[12:16] = "EMBE"
b = "REM" + "EMBE" = "REMEMBE"
c = "R AND STR"
b+c = "REMEMBE R AND STR"
```

---

### 333 — 슬라이싱 (앞 3글자 + 뒤 3글자)
```python
String = input("7문자 이상 문자열을 입력하시오 :")
m = String[0:3] + String[-3:]
print(m)
```
> **출력 예시 (입력: `abcdefgh`):** `abcfgh`

**포인트:** `[-3:]`은 뒤에서 3글자.

---

### 327 기출체크1 — 각 단어의 두 번째 글자 모으기
```python
a = ['Seoul', 'Kyeonggi', 'Incheon', 'Daejeon', 'Daegu', 'Pusan']
str01 = 'S'
for i in a:
    str01 = str01 + i[1]
print(str01)
```
> **출력:** `Seynaau`

**풀이:**
```
'S' + e(Seoul[1]) + y(Kyeonggi[1]) + n(Incheon[1]) + a(Daejeon[1]) + a(Daegu[1]) + u(Pusan[1])
= "Seynaau"
```

---

## 5. 리스트 (2차원 포함)

### 문제 03 / 문제 36 — 2차원 리스트 접근
```python
lol = [[1, 2, 3], [4, 5], [6, 7, 8, 9]]
print(lol[0])
print(lol[2][1])
for sub in lol:
    for item in sub:
        print(item, end=' ')
    print()
```
> **출력:**
> ```
> [1, 2, 3]
> 7
> 1 2 3 
> 4 5 
> 6 7 8 9 
> ```

**포인트:**
- `lol[0]` → 첫 번째 행 전체 `[1, 2, 3]`
- `lol[2][1]` → 세 번째 행의 두 번째 원소 = 7
- 이중 for 루프로 각 원소 출력, 행 끝에 빈 `print()`로 줄바꿈

---

## 6. 세트 & 딕셔너리

### 328 기출체크1 — 세트 메소드 총정리
```python
asia = {'한국', '중국', '일본'}
asia.add('베트남')
asia.add('중국')       # 중복 → 무시
asia.remove('일본')
asia.update({'한국', '홍콩', '태국'})
print(asia)
```
> **출력:** `{'한국', '중국', '베트남', '홍콩', '태국'}` (순서 불규칙)

**세트 메소드 정리:**

| 메소드 | 설명 |
|--------|------|
| `.add(x)` | 원소 하나 추가, 중복이면 무시 |
| `.remove(x)` | 원소 삭제, 없으면 오류 |
| `.update({...})` | 여러 원소 한번에 추가 |

---

### 328 활용2 — 세트 + 반복 출력
```python
a = {'apple', 'lemon', 'banana'}
a.update({'kiwi', 'banana'})   # banana는 중복이므로 무시
a.remove('lemon')
a.add('apple')                  # 중복 → 무시
for i in a:
    print("과일명 : %s" % i)
```
> **출력 예시 (순서 불규칙):**
> ```
> 과일명 : apple
> 과일명 : banana
> 과일명 : kiwi
> ```

---

### 335 — 딕셔너리 컴프리헨션 + 세트 교집합
```python
lst = [1, 2, 3]
dst = {i: i * 2 for i in lst}  # {1:2, 2:4, 3:6}
s = set(dst.values())           # {2, 4, 6}
lst[0] = 99                     # lst 변경 (dst에는 영향 없음)
dst[2] = 7                      # dst[2] → 7로 변경
s.add(99)                       # s = {2, 4, 6, 99}
print(len(s & set(dst.values())))
```
> **출력:** `2`

**풀이:**
```
dst.values() = [2, 7, 6]       → set = {2, 7, 6}
s = {2, 4, 6, 99}
교집합(s & {2,7,6}) = {2, 6}
len({2, 6}) = 2
```

---

### Section 125 기출2 — enumerate + 딕셔너리 (버그 있음)
```python
data = [
    [3, 5, 2, 4, 1],
    [4, 5, 1],
    [4, 4, 1, 5, 4],
    [4, 5]
]
result = {}
for index, lis in enumerate(data):
    list_sum = sum(lis)
    list_len = len(lis)
    result[index] = (list_sum, list_len)
print(resultf)    # ← 오타! resultf → result 이어야 함
```
> **오류:** `NameError: name 'resultf' is not defined`

**수정 후 출력:**
```python
print(result)
# {0: (15, 5), 1: (10, 3), 2: (18, 5), 3: (9, 2)}
```

**포인트:** `enumerate()`는 `(인덱스, 값)` 쌍을 반환.

---

## 7. 함수 (def)

### 02 잠깐만요 / 331 클래스없는 — 함수와 지역변수
```python
def calc(x, y):
    x *= 3
    y /= 3
    print(x, y)
    return x

a, b = 3, 12
a = calc(a, b)
print(a, b)
```
> **출력:**
> ```
> 9 4.0
> 9 12
> ```

**풀이:**
```
calc(3, 12) 호출
  x = 3 * 3 = 9
  y = 12 / 3 = 4.0  (/ 는 항상 float)
  print(9, 4.0)
  return 9
a = 9  (반환값 대입)
b는 변화 없음 (함수 내에서 바뀐 y는 지역변수)
print(9, 12)
```

---

### 331 기출체크1 — 기본값 매개변수
```python
def func(num1, num2=2):
    print('a =', num1, 'b =', num2)

func(20)
```
> **출력:** `a = 20 b = 2`

**포인트:** `num2=2`는 기본값. `func(20)` 처럼 하나만 전달하면 `num2`는 2가 됨.

---

### 기출 따라잡기 문제2 — type() 비교
```python
def func(value):
    if type(value) == type(100):
        return 100
    elif type(value) == type(""):
        return len(value)
    else:
        return 20

a = "100.0"
b = 100.0
c = (100, 200)
print(func(a) + func(b) + func(c))
```
> **출력:** `45`

**풀이:**
```
a = "100.0"  → type은 str  → len("100.0") = 5
b = 100.0    → type은 float (int 아님!) → else → 20
c = (100,200) → type은 tuple → else → 20
5 + 20 + 20 = 45
```

**핵심:** `type(100)`은 `int`. `100.0`은 `float`이므로 int 조건 불일치 → else.

---

## 8. 람다 & map

### 329 기출체크1 — lambda + map 기본
```python
a = [1, 2, 3, 4, 5]
a = list(map(lambda num: num + 100, a))
print(a)
```
> **출력:** `[101, 102, 103, 104, 105]`

**포인트:**
- `lambda num: num + 100` → 각 원소에 100을 더하는 함수
- `map(함수, 리스트)` → 리스트의 모든 원소에 함수 적용
- `list(...)` → map 결과를 리스트로 변환

---

### 01 예제 — if/elif/else + lambda + map
```python
a = [1, 2, 3, 4, 5]
x = 100
if x == 10:
    a = list(map(lambda num: num + 10, a))
elif x == 50:
    a = list(map(lambda num: num + 50, a))
else:
    a = list(map(lambda num: num + 100, a))
print(a)
```
> **출력:** `[101, 102, 103, 104, 105]`

**풀이:** x=100은 10도 50도 아니므로 else 실행 → 각 원소에 100 더함.

---

## 9. 클래스

### 02 예제 / 330 클래스 — 클래스 변수와 메소드
```python
class Cls:
    x, y = 10, 20
    def chg(self):
        temp = self.x
        self.x = self.y
        self.y = temp

a = Cls()
print(a.x, a.y)
a.chg()
print(a.x, a.y)
```
> **출력:**
> ```
> 10 20
> 20 10
> ```

**포인트:** `chg()`는 x와 y를 서로 교환. `temp`에 임시 저장 후 swap.

---

### 330 기출체크1 — 클래스 메소드 (self 명 자유)
```python
class FourCal:
    def setdata(sel, fir, sec):   # self 대신 sel 사용 (이름은 자유)
        sel.fir = fir
        sel.sec = sec
    def add(sel):
        result = sel.fir + sel.sec
        return result

a = FourCal()
a.setdata(4, 2)
print(a.add())
```
> **출력:** `6`

**포인트:** 첫 번째 매개변수 이름은 `self`가 관례지만 `sel` 등 아무 이름이나 가능. 인스턴스를 가리키는 역할은 동일.

---

### 기출 따라잡기 문제5 — 클래스 변수 + 첫 글자 모으기
```python
class CharClass:
    a = ['Seoul', 'Kyeongi', 'Inchon', 'Daejeon', 'Daegu', 'Pusan']

myVar = CharClass()
str01 = ' '
for i in myVar.a:
    str01 = str01 + i[0]
print(str01)
```
> **출력:** ` SKIDDP`  (맨 앞에 공백 있음)

**풀이:**
```
' ' + 'S' + 'K' + 'I' + 'D' + 'D' + 'P' = ' SKIDDP'
```

**327 기출체크1과 차이점:**
- 327: `str01 = 'S'`로 시작, `i[1]` (두 번째 글자)
- 기출5: `str01 = ' '`로 시작, `i[0]` (첫 번째 글자)

---

## 10. 기출 따라잡기

### 기출 따라잡기 문제1 — 리스트 뒤집기 + 슬라이싱 합
```python
def func(lst):
    for i in range(len(lst) // 2):
        lst[i], lst[-i-1] = lst[-i-1], lst[i]

lst = [1, 2, 3, 4, 5, 6]
func(lst)
print(sum(lst[::2]) - sum(lst[1::2]))
```
> **출력:** `3`

**풀이:**
```
뒤집기 과정:
i=0: lst[0] ↔ lst[-1] → 1↔6 → [6,2,3,4,5,1]
i=1: lst[1] ↔ lst[-2] → 2↔5 → [6,5,3,4,2,1]
i=2: lst[2] ↔ lst[-3] → 3↔4 → [6,5,4,3,2,1]

lst[::2]  = [6,4,2]  → sum=12  (인덱스 0,2,4)
lst[1::2] = [5,3,1]  → sum=9   (인덱스 1,3,5)
12 - 9 = 3
```

---

### 327 활용1 — 입력받아 리스트 조작
```python
x, y = input('입력 :').split('-')
a = ['abc123', 'def456', 'ghi789']
a.append(x)
a.append(y)
a.remove('def456')
print(a[1][-3:], a[2][:-3], sep=',')
for i in range(3, 6):
    print(i, end=' ')
```
> **출력 예시 (입력: `jkl-mno`):**
> ```
> 789,ghi,
> 3 4 5 
> ```

---

## 11. 고급 문제 (트리 / 문자열 탐색)

### 문제 34 — 트리 구조 + 재귀 (홀수 레벨 합)

#### ⚠️ 버그 버전 (`문제 34.py`) — `return`이 for 루프 안에 있음
```python
class Node:
    def __init__(self, value):
        self.value = value
        self.children = []

def tree(li):
    nodes = [Node(i) for i in li]
    for i in range(1, len(li)):
        nodes[(i - 1) // 2].children.append(nodes[i])
        return nodes[0]      # ← for 루프 안에 들여쓰기! 첫 반복 후 바로 리턴
```
> **출력:** `5`

---

#### ✅ 정상 버전 (`문제34.py`) — `return`이 for 루프 밖에 있음
```python
class Node:
    def __init__(self, value):
        self.value = value
        self.children = []

def tree(li):
    nodes = [Node(i) for i in li]
    for i in range(1, len(li)):
        nodes[(i - 1) // 2].children.append(nodes[i])
    return nodes[0]           # ← for 루프 밖, 완전한 트리 완성 후 리턴

def calc(node, level=0):
    if node is None:
        return 0
    return (node.value if level % 2 == 1 else 0) + sum(calc(n, level + 1) for n in node.children)

li = [3, 5, 8, 12, 15, 18, 21]
root = tree(li)
print(calc(root))
```
> **출력:** `13`

**트리 구조:**
```
         3 (level 0 → 포함 안 함)
       /   \
      5     8  (level 1 → 포함)
     / \   / \
   12  15 18  21  (level 2 → 포함 안 함)

결과: 5 + 8 = 13
```

---

### 문제 46 — 문자열에서 패턴 등장 횟수 세기

#### ⚠️ 버그 버전 (`문제 38.py`) — `return`이 for 루프 안에 있음
```python
def cnt(str, p):
    result = 0
    for i in range(len(str)):
        sub = str[i:i+len(p)]
        if sub == p:
            result += 1
        return result     # ← 루프 첫 반복 후 바로 리턴!
```
> **출력:** `ab0 ca1`  
> (cnt(str, "ca")는 첫 번째 sub="ab"가 "ca"와 달라 result=0 리턴)

---

#### ✅ 정상 버전 (`문제46.py`) — `return`이 for 루프 밖에 있음
```python
def cnt(str, p):
    result = 0
    for i in range(len(str)):
        sub = str[i:i+len(p)]
        if sub == p:
            result += 1
    return result         # ← 루프 완료 후 리턴

str = "abdcabcabca"
p1 = "ca"
p2 = "ab"
print(f'ab{cnt(str, p1)} ca{cnt(str, p2)}')
```
> **출력:** `ab3 ca3`

**풀이 (p1="ca" 카운트):**
```
"abdcabcabca"
 a b d c a b c a b c a
 0 1 2 3 4 5 6 7 8 9 10

i=3: str[3:5]="ca" ✓ → result=1
i=6: str[6:8]="ca" ✓ → result=2
i=9: str[9:11]="ca" ✓ → result=3
최종 cnt(str, "ca") = 3
```

---

## 빠른 참조표

| 파일명 | 핵심 개념 | 출력 |
|--------|-----------|------|
| 문제 01 | 비교 연산자 | `False` |
| 문제 13 | 비트 AND | `2` |
| 문제 15 | for 루프 후 i 값 | `10 55` |
| 문제 26/27 | while + break, 1~100 합 | `5050` |
| 문제 12 | while + continue, 짝수 합 | `30` |
| 문제 25 | 문자열 슬라이싱 조합 | `engneing` |
| 328 기출2 | 슬라이싱 + % 포맷팅 | `REMEMBE R AND STR` |
| 327 기출1 | 각 단어 두 번째 글자 | `Seynaau` |
| 문제 03/36 | 2차원 리스트 | `[1,2,3]` / `7` |
| 328 기출1 | 세트 메소드 | set 결과 |
| 335 | 딕셔너리 + 세트 교집합 | `2` |
| 329 기출1 | lambda + map | `[101~105]` |
| 01 예제 | if/elif + lambda | `[101~105]` |
| 330 기출1 | 클래스 add 메소드 | `6` |
| 331 기출1 | 기본값 매개변수 | `a = 20 b = 2` |
| 기출2 | type() 비교 | `45` |
| 기출1 | 리스트 뒤집기 + 슬라이싱 | `3` |
| 332 | 비트 시프트 | `26` |
| 문제34 | 트리 재귀 (정상) | `13` |
| 문제 34 | 트리 재귀 (버그) | `5` |
| 문제46 | 패턴 카운트 (정상) | `ab3 ca3` |
| 문제 38 | 패턴 카운트 (버그) | `ab0 ca1` |

---

## 자주 나오는 함정 정리

### 1. 들여쓰기로 결정되는 `return` 위치
```python
# 잘못된 예 — return이 for 루프 안에
for i in range(10):
    result += 1
    return result    # 첫 번째 반복 후 바로 리턴!

# 올바른 예 — return이 for 루프 밖에
for i in range(10):
    result += 1
return result        # 루프 전체 완료 후 리턴
```

### 2. `/` vs `//` 나눗셈
```python
12 / 3   # 4.0  (항상 float)
12 // 3  # 4    (int, 몫만)
```

### 3. 세트는 순서가 없다
```python
s = {1, 2, 3}
# 출력 시 {1, 2, 3} 또는 {3, 1, 2} 등 순서 불규칙
```

### 4. `type()` 비교에서 float ≠ int
```python
type(100)   # <class 'int'>
type(100.0) # <class 'float'>  ← 다름!
```

### 5. 문자열은 함수 안에서 바꿔도 원본 불변
```python
def func(x, y):
    x *= 3   # 지역변수 x만 바뀜
    y /= 3   # 지역변수 y만 바뀜
a, b = 3, 12
func(a, b)
# a, b는 여전히 3, 12
```
