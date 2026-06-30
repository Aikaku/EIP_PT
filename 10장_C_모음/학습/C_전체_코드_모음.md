# C 전체 코드 모음 - 정보처리기사 실기

---

## 목차

1. [기본 입출력 (printf/scanf)](#1-기본-입출력-printfscanf)
2. [연산자 / 진법](#2-연산자--진법)
3. [제어문 (for/while/switch)](#3-제어문-forwhileswitch)
4. [배열](#4-배열)
5. [포인터](#5-포인터)
6. [구조체](#6-구조체)
7. [사용자 정의 함수 / 재귀](#7-사용자-정의-함수--재귀)
8. [동적 메모리 / 연결리스트 / 스택 / 큐](#8-동적-메모리--연결리스트--스택--큐)
9. [정렬 / 기타](#9-정렬--기타)
10. [기출 따라잡기](#10-기출-따라잡기)
11. [정답 모음](#11-정답-모음)
12. [풀이 & 포인트 모음](#12-풀이--포인트-모음)

---

## 1. 기본 입출력 (printf/scanf)

### 문제 01 — 02 C문제 - 예제1.c

```c
#include <stdio.h>
main()
{
	int i, j, k;
	scanf("%d %d", &i, &j);
	k = i + j;
	printf("%d\n", k);
}
```

> (동일 코드: `310 데이터 입출력 - C언어.c`)

---

### 문제 02 — 310 데이터 입출력 - C언어 예상체크1.c

```c
#include <stdio.h>
main() {
	int i, j;
	scanf("%o#%x", &i, &j);
	printf("%d %d", i, j);
}
```

---

### 문제 03 — 문제 09.c

```c
#include <stdio.h>

main() {
	int m = 4620;
	int a = m / 1000;
	int b = m % 1000 / 500;
	int c = m % 500 / 100;
	int d = m % 100 / 10;
	printf("1000원의 개수 : %d\n", a);
	printf("500원의 개수 : %d\n", b);
	printf("100원의 개수 : %d\n", c);
	printf("10원의 개수 : %d\n", d);
}
```

> (동일 코드: `문제 05.c`)

---

### 문제 04 — 문제 10.c

```c
#include <stdio.h>
#include <ctype.h>

int main( ) {
	char *p = "It is 8";
	char result[100];
	int i;
	for(i = 0; p[i] != '\0'; i++) {
		if(isupper(p[i]))
			result[i] = (p[i] - 'A'+ 5) % 25 + 'A';
		else if(islower(p[i]))
			result[i] = (p[i] - 'a'+ 10) % 26 + 'a';
		else if(isdigit(p[i]))
			result[i] = (p[i] - '0'+ 3) % 10 + '0';
		else if(!(isupper(p[i]) || islower(p[i]) || isdigit(p[i])))
			result[i] = p[i];
	}
	result[i] = '\0';
	printf("변환된 문자열 : %s\n", result);
	return 0;
}
```

> (동일 코드: `문제 37.c`, `문제40.c`)

---

## 2. 연산자 / 진법

### 문제 05 — Section 118_기출 따라잡기_문제2.c

```c
#include <stdio.h>
main()
{
	int i = 10, j = 10, k = 30;
	i /= j;
	j -= i;
	k %= j;
	printf("%d, %d, %d\n", i, j, k);
}
```

---

### 문제 06 — Section 118_기출 따라잡기_문제6.c

```c
#include <stdio.h>
main()
{
	int j = 024, k = 24, L = 0x24, hap;
	hap = j + k + L;
	printf("%d, %d, %d, %d\n", j, k, L, hap);
}
```

---

### 문제 07 — 316 연산자 우선순위 기출체크1.c

```c
#include <stdio.h>
int main( ) {
	int x = 7, y = 4, z;
	z = y % 3 < 3 ? 2 : 1;
	z = z & z >> 1;
	z = x > 5 && z <= 3 ? z * x : z / x;
	printf("%d", z);
	return 0;
}
```

---

### 문제 08 — 기출 따라잡기_문제4.c

```c
#include <stdio.h>
main( )
{
	int result, a = 100, b = 200, c = 300;
	result = a < b ? b++ : --c;
	printf("%d, %d, %d\n", result, b, c);
}
```

---

### 문제 09 — 기출 따라잡기_문제10.c

```c
#include <stdio.h>
main()
{
	int a = 5, b = 10, c = 15, d = 30, result;
	result = a * 3 + b > d || c - b / a <= d && 1;
	printf("%d\n", result);
}
```

---

### 문제 10 — Section 119_기출 따라잡기_문제3.c

```c
#include <stdio.h>
#include <stdlib.h>
main(int argc, char *argv[]) {
	int v1 = 0;
	int v2 = 35;
	int v3 = 29;
	if (v1 > v2 ? v2 : v1)
		v2 = v2 << 2;
	else
		v3 = v3 << 2;
	printf("%d", v2 + v3);
	return 0;
}
```

> (동일 코드: `문제 08.c`)

---

## 3. 제어문 (for/while/switch)

### 문제 11 — 317 제어문 - C언어 기출체크1.c

```c
#include <stdio.h>
main( ) {
	int c = 1;
	switch (3) {
	case 1: c += 3;
	case 2: c++;
	case 3: c = 0;
	case 4: c += 3;
	case 5: c -= 10;
	default: c--;
	}
	printf("%d", c);
}
```

> (동일 코드: `기출 따라잡기_문제5.c`)

---

### 문제 12 — 317 제어문 - C언어 기출체크2.c

```c
#include <stdio.h>
int main(void) {
	char str[ ] = "REPUBLICOFKOREA";
	int a = 0;
	while (str[a] != '\0')
		++a;
	putchar(str[a-2]);
	return 0;
}
```

---

### 문제 13 — 317 제어문 - C언어.c

```c
#include <stdio.h>
main() {
	int score[] = { 86, 53, 95, 76, 61 };
	char grade;
	char str[] = "Rank";
	for (int i = 0; i < 5; i++) {
		switch (score[i] / 10) {
		case 10:
		case 9:
			grade = 'A';
			break;
		case 8:
			grade = 'B';
			break;
		case 7:
			grade = 'C';
			break;
		default: grade = 'F';
		}
		if (grade != 'F')
			printf( "%d is %c %s\n", i + 1, grade, str);
	}
}
```

---

### 문제 14 — 문제 12.c

```c
#include <stdio.h>
main() {
	int n[] = { 73, 95, 82 };
	int sum = 0;
	for (int i = 0; i < 3; i++)
		sum += n[i];
	switch (sum / 30) {
		case 10:
		case 9: printf("A");
		case 8: printf("B");
		case 7:
		case 6: printf("C");
		default: printf("D");
	}
}
```

---

### 문제 15 — 문제 14.c

```c
#include <stdio.h>
main() {
	int c = 0;
	for (int i = 1; i <= 2023; i++)
		if (i % 4 == 0)
			c++;
	printf("%d", c);
}
```

---

### 문제 16 — 기출 따라잡기_문제6.c

```c
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

---

### 문제 17 — 기출 따라잡기_문제7.c

```c
#include <stdio.h>
main() {
	int s, el = 0;
	for (int i = 6; i <= 30; i++) {
		s = 0;
		for (int j = 1; j <= i / 2; j++)
			if (i % j == 0)
				s = s + j;
		if (s == i)
			el++;
	}
	printf("%d", el);
}
```

---

### 문제 18 — 기출 따라잡기_문제13.c

```c
#include <stdio.h>
int main() {
	int number = 1234;
	int div = 10, result = 0;
	while (number != 0) {
		result = result * div;
		result = result + number % div;
		number = number / div;
	}
	printf("%d", result);
}
```

---

### 문제 19 — 문제 19.c

```c
#include <stdio.h>
int isPerfectNum(int num) {
	int sum = 0;
	for (int i = 1; i < num; i++) {
		if (num % i == 0)
			sum += i;
	}
	if (num == sum) return 1;
	else return 0;
}

main() {
	int r = 0;
	for (int i = 1; i <= 100; i++)
		if (isPerfectNum(i))
			r += i;
	printf("%d", r);
}
```

---

### 문제 20 — 문제41.c

```c
#include <stdio.h>
void swap(int a, int b) {
	int t = a;
	a = b;
	b = t;
}
int main( ) {
	int a = 11;
	int b = 19;
	swap(a, b);
	switch(a) {
		case 1:
			b += 1;
		case 11:
			b += 2;
		deafult:
			b += 3;
			break;
	}
	printf("%d", a-b);
}
```

---

## 4. 배열

### 문제 21 — 문제 11.c

```c
#include <stdio.h>
main() {
	int n[] = { 5, 4, 3, 2, 1 };
	for (int i = 0; i < 5; i++)
		printf("%d", n[(i+1)%5]);
}
```

> (동일 코드: `기출 따라잡기_문제11.c`)

---

### 문제 22 — 문제8.c

```c
#include <stdio.h>
int main( ) {
	int arr[3][3] = {1, 2, 3, 4, 5, 6, 7, 8, 9};
	int* parr[2] = {arr[1], arr[2]};
	printf("%d", parr[1][1] + *(parr[1]+2) + **parr);
}
```

---

### 문제 23 — Section 120_기출 따라잡기_문제4.c

```c
#include <stdio.h>
int main( ) {
	int a[4] = { 0, 2, 4, 8 };
	int b[3];
	int* p;
	int sum = 0;
	for (int i = 1; i < 4; i++) {
		p = a + i;
		b[i - 1] = *p - a[i - 1];
		sum = sum + b[i - 1] + a[i];
	}
	printf("%d", sum);
}
```

---

### 문제 24 — 문제 13.c

```c
#include <stdio.h>
main() {
	int E[] = { 64, 25, 12, 22, 11 };
	int n = sizeof(E) / sizeof(E[0]);
	int i = 0;
	do {
		int j = i + 1;
		do {
			if (E[i] > E[j]) {
			int tmp = E[i];
			E[i] = E[j];
			E[j] = tmp;
			}
			j++;
		} while (j < n);
		i++;
	} while (i < n - 1);
	for (int i = 0; i <= 4; i++)
		printf("%d ", E[i]);
}
```

---

## 5. 포인터

### 문제 25 — 320 포인터 - C언어 기출체크1.c

```c
#include <stdio.h>
int main() {
	int ary[3];
	int s = 0;
	*(ary + 0) = 1;
	ary[1] = *(ary + 0) + 2;
	ary[2] = *ary + 3;
	for (int i = 0; i < 3; i++)
		s = s + ary[i];
	printf("%d", s);
}
```

---

### 문제 26 — 320 포인터 - C언어 기출체크2.c

```c
#include <stdio.h>
main() {
	char* a = "qwer";
	char* b = "qwtety";
	for (int i = 0; a[i] != '\0'; i++)
		for (int j = 0; b[j] != '\0'; j++)
			if (a[i] == b[j])
				printf("%c", a[i]);
}
```

---

### 문제 27 — 320 포인터 - C언어.c

```c
#include <stdio.h>
main() {
	int a = 50;
	int *b = &a;
	*b = *b + 20;
	printf("%d, %d\n", a, *b);
	char *s;
	s = "gilbut";
	for (int i = 0; i < 6; i += 2) {
		printf("%c, ", s[i]);
		printf("%c, ", *(s + i));
		printf("%s\n", s + i);
	}
}
```

---

### 문제 28 — Section 120_기출 따라잡기_문제1.c

```c
#include <stdio.h>
main() {
	char *p = "KOREA";
	printf("%s\n", p);
	printf("%s\n", p + 3);
	printf("%c\n", *p);
	printf("%c\n", *(p + 3));
	printf("%c\n", *p + 2);
}
```

---

### 문제 29 — Section 120_기출 따라잡기_문제3.c

```c
#include <stdio.h>
int main() {
	int* array[3];
	int a = 12, b = 24, c = 36;
	array[0] = &a;
	array[1] = &b;
	array[2] = &c;
	printf("%d", *array[1] + **array + 1);
}
```

---

### 문제 30 — 문제 15.c

```c
#include <stdio.h>
main() {
	char* p = "KOREA";
	printf("1. %s\n", p);
	printf("2. %s\n", p + 1);
	printf("3. %c\n", *p);
	printf("4. %c\n", *(p + 3));
	printf("5. %c\n", *p + 4);
}
```

---

### 문제 31 — 기출 따라잡기_문제3.c

```c
#include <stdio.h>

struct dat {
	int x;
	int y;
};

int main( ) {
	struct dat a[] = {{1, 2}, {3, 4}, {5, 6}};
	struct dat* ptr = a;
	struct dat** pptr = &ptr;
	(*pptr)[1] = (*pptr)[2];
	printf("%d 그리고 %d", a[1].x, a[1].y);
	return 0;
}
```

---

### 문제 32 — 기출 따라잡기_문제8.c

```c
#include <stdio.h>
void func(int** arr, int size) {
	for(int i = 0; i < size; i++) {
		*(*arr + i) = (*(*arr + i) + i) % size;
	}
}
int main( ){
	int arr[] = {3, 1, 4, 1, 5};
	int* p = arr;
	int** pp = &p;
	int num = 6;
	func(pp, 5);
	num = arr[2];
	printf("%d", num);
	return 0;
}
```

---

### 문제 33 — 문제42.c

```c
#include <stdio.h>
void func(char *d, char *s) {
	while (*s) {
		*d = *s;
		d++;
		s++;
	}
	*d = '\0';
}
int main( ) {
	char* str1 = "first";
	char str2[50] = "teststring";
	int result = 0;
	func(str2, str1);
	for (int i = 0; str2[i] != '\0'; i++) {
		result += i;
	}
	printf("%d\n", result);
	return 0;
}
```

---

## 6. 구조체

### 문제 34 — 321 구조체 - C언어 기출체크1.c

```c
#include <stdio.h>
main( ) {
	struct insa {
		char name[10];
		int age;
	} a[ ] = { "Kim", 28, "Lee", 38, "Park", 42, "Choi", 31 };
	struct insa* p;
	p = a;
	p++;
	printf("%s\n", p->name);
	printf("%d\n", p->age);
}
```

> (동일 코드: `기출 따라잡기_문제1.c`)

---

### 문제 35 — 321 구조체 - C언어 기출체크2.c

```c
#include <stdio.h>
struct A {
	int n;
	int g;
};
main( ) {
	struct A st[2];
	for (int i = 0; i < 2; i++) {
		st[i].n = i;
		st[i].g = i + 1;
	}
	printf("%d", st[0].n + st[1].g);
}
```

---

### 문제 36 — 321 구조체 - C언어.c / 02 C 문제 - 예제1.c

```c
#include <stdio.h>
struct jsu {
	char nae[12];
	int os, db, hab, hhab;
};
int main() {
	struct jsu st[3] = { {"데이터1", 95, 88}, {"데이터2", 84, 91},
						{"데이터3", 86, 75} };
	struct jsu* p;
	p = &st[0];
	(p + 1)->hab = (p + 1)->os + (p + 2)->db;
	(p + 1)->hhab = (p + 1)->hab + p->os + p->db;
	printf("%d", (p + 1)->hab + (p + 1)->hhab);
}
```

> (동일 코드: `02 C 문제 - 예제1.c`)

---

### 문제 37 — 문제 16.c

```c
#include <stdio.h>
struct Test { 
    int i;
    const char *g;
};

int main( ) { 
    struct Test test[ ] = {{1, "AB"}, {2, "DC"}, {3, "EB"}}; 
    struct Test *p = &test[1]; 
    printf("%s", p->g + (p->i - 1)); 
    return 0;
}
```

> (동일 코드: `문제20.c`)

---

### 문제 38 — 문제22.c

```c
#include <stdio.h>

typedef struct student {
	char* name;
	int score[3];
} Student;

int dec(int enc) {
	return enc & 0xA5;
}

int sum(Student* p) {
	return dec(p->score[0]) + dec(p->score[1]) + dec(p->score[2]);
}

int main( ) {
	Student s[2] = { "Kim", {0xA0, 0xA5, 0xDB}, "Lee", {0xA0, 0xED, 0x81} };
	Student* p = s;
	int result = 0;
	for (int i = 0; i < 2; i++) {
		result += sum(&s[i]);
	}
	printf("%d", result);
	return 0;
}
```

---

### 문제 39 — 문제19.c

```c
#include <stdio.h>
int r1() {
	return 4;
}
int r10() {
	return (30 + r1());
}
int r100() {
	return (200 + r10());
}
int main() {
	printf("%d\n", r100());
	return 0;
}
```

---

## 7. 사용자 정의 함수 / 재귀

### 문제 40 — 322 사용자 정의 함수 - C언어.c

```c
#include <stdio.h>
int factorial(int n);
main() {
	int (*pf)(int);
	pf = factorial;
	printf("%d", pf(3));
}
int factorial(int n) {
	if (n <= 1)
		return 1;
	else
		return n * factorial(n - 1);
}
```

---

### 문제 41 — 322 사용자 정의 함수 - C언어 기출체크2.c

```c
#include <stdio.h>
int func(int a) {
	if (a <= 1) return 1;
	return a * func(a - 1);
}

int main() {
	int a;
	scanf("%d", &a);
	printf("%d", func(a));
}
```

> (동일 코드: `문제 28.c`)

---

### 문제 42 — Section 122_기출 따라잡기_문제5.c

```c
#include <stdio.h>
int func( ) {
	static int x = 0;
	x += 2;
	return x;
}
int main( ) {
	int x = 0;
	int sum= 0;
	for(int i = 0; i < 4; i++) {
		x++;
		sum += func( );
	}
	printf("%d", sum);
	return 0;
}
```

---

### 문제 43 — Section 122_기출 따라잡기_문제7.c

```c
#include <stdio.h>
main() {
	int res = mp(2, 10);
	printf("%d", res);
}
int mp(int base, int exp) {
	int res = 1;
	for (int i = 0; i < exp; i++)
		res *= base;
	return res;
}
```

---

### 문제 44 — Section 122_기출 따라잡기_문제2.c

```c
#include <stdio.h>
#include <string.h>
void inverse(char *str, int len) {
	for(int i = 0, j = len - 1; i < j; i++, j--) {
		char ch = str[i];
		str[i] = str[j];
		str[j] = ch;
	}
}
int main() {
	char str[100] = "ABCDEFGH";
	int len = strlen(str);
	inverse(str, len);
	for(int i = 1; i < len; i += 2) {
		printf("%c", str[i]);
	}
	return 0;
}
```

> (동일 코드: `문제 17.c`)

---

### 문제 45 — Section 122_기출 따라잡기_문제6.c

```c
#include <stdio.h>
int isPrime(int number) {
	for (int i = 2; i < number; i++)
		if (number % i == 0) return 0;
	return 1;
}
int main() {
	int number = 13195;
	int max_div = 0;
	for (int i = 2; i < number; i++)
		if (isPrime(i) == 1 && number % i == 0) max_div = i;
	printf("%d", max_div);
}
```

> (동일 코드: `문제 30.c`)

---

### 문제 46 — 322 사용자 정의 함수 - C언어 기출체크1.c

```c
#include <stdio.h>
void swap(int* a, int idx1, int idx2) {
	int t = a[idx1];
	a[idx1] = a[idx2];
	a[idx2] = t;
}

void Usort(int* a, int len) {
	for (int i = 0; i < len - 1; i++)
		for (int j = 0; j < len - 1 - i; j++)
			if (a[j] > a[j + 1])
				swap(a, j, j + 1);
}

main() {
	int a[] = { 85, 75, 50, 100, 95 };
	int nx = 5;
	Usort(a, nx);
}
```

---

### 문제 47 — 문제18.c

```c
#include <stdio.h>
struct Node {
	int value;
	struct Node* next;
};
void func(struct Node* node){
	while(node != NULL && node -> next != NULL) {
		int t = node -> value;
		node -> value = node -> next -> value;
		node -> next -> value = t;
		node = node -> next -> next;
	}
}
int main( ) {
	struct Node n1 = {1, NULL};
	struct Node n2 = {2, NULL};
	struct Node n3 = {3, NULL};
	n1.next = &n3;
	n3.next = &n2;
	func(&n1);
	struct Node* current = &n1;
	while(current != NULL){
		printf("%d", current -> value);
		current = current -> next;
	}
	return 0;
}
```

---

## 8. 동적 메모리 / 연결리스트 / 스택 / 큐

### 문제 48 — 문제 06.c

```c
#include <stdio.h> 
#include <stdlib.h> 
typedef struct Data { 
    int value; struct Data *next;
} Data;

Data* insert(Data* head, int value) { 
    Data* new_node = (Data*)malloc(sizeof(Data)); 
    new_node -> value = value; new_node -> next = head; return new_node;
}

Data* reconnect(Data* head, int value) { 
    if (head == NULL || head -> value == value) return head; 
    Data *prev = NULL, *curr = head; 
    while (curr != NULL && curr -> value != value) { 
        prev = curr; curr = curr -> next; 
    } 
    if (curr != NULL && prev != NULL) { 
        prev -> next = curr -> next; curr -> next = head; head = curr; 
    } 
    return head;
}

int main( ) { 
        Data *head = NULL, *curr; 
        for (int i = 1; i <= 5; i++) 
            head = insert(head, i); 
        head = reconnect(head, 3);
        for (curr = head; curr != NULL; curr = curr -> next) 
            printf("%d", curr->value); 
        return 0; 
}
```

> (동일 코드: `문제23.c`)

---

### 문제 49 — 문제25.c

```c
#include <stdio.h>
#include <stdlib.h>
struct node {
	int p;
	struct node* n;
};
int main( ) {
	struct node a = {1, NULL};
	struct node b = {2, NULL};
	struct node c = {3, NULL};
	a.n = &b; b.n = &c; c.n = NULL;
	c.n = &a; a.n = &b; b.n = NULL;
	struct node* head = &c;
	printf("%d %d %d", head -> p, head -> n -> p, head -> n -> n -> p);
	return 0;
}
```

---

### 문제 50 — 문제26.c

```c
#include <stdio.h>
#define SIZE 3

typedef struct {
	int a[SIZE];
	int front;
	int rear;
} Queue;

void enq(Queue* q, int val) {
	q -> a[q -> rear] = val;
	q -> rear = (q -> rear + 1) % SIZE;
}

int deq(Queue* q) {
	int val = q -> a[q -> front];
	q -> front = (q -> front + 1) % SIZE;
	return val;
}

int main( ) {
	Queue q = {{0}, 0, 0};
	enq(&q, 1);
	enq(&q, 2);
	deq(&q);
	enq(&q, 3);
	printf("%d 그리고 %d", deq(&q), deq(&q));
	return 0;
}
```

---

### 문제 51 — 문제29.c (연결리스트 스택)

```c
#include <stdio.h>
#include <stdlib.h>

struct node {
	char c;
	struct node* p;
};

struct node* func(char* s) {
	struct node* h = NULL, *n;
	while(*s) {
		n = malloc(sizeof(struct node));
		n -> c = *s++;
		n -> p = h;
		h = n;
	}
	return h;
}

int main( ) {
	struct node* n = func("BEST");
	while(n) {
		putchar(n -> c);
		struct node* t = n;
		n = n -> p;
		free(t);
	}
		return 0;
}
```

---

### 문제 52 — 문제 29.c (스택 구현)

```c
#include <stdio.h>
#define MAX_SIZE 10

int isWhat[MAX_SIZE];
int point = -1;

int isEmpty() {
	if (point == -1) return 1;
	return 0;
}

int isFull() {
	if (point == 10) return 1;
	return 0;
}

void into(int num) {
	if (isFull() == 1) printf("Full");
	else isWhat[++point] = num;
}

int take() {
	if (isEmpty() == 1) printf("Empty");
	else return isWhat[point--];
	return 0;
}

main() {
	into(5); into(2);
	while (!isEmpty()) {
		printf("%d", take());
		into(4); into(1); printf("%d", take());
		into(3); printf("%d", take()); printf("%d", take());
		into(6); printf("%d", take()); printf("%d", take());
	}
}
```

---

### 문제 53 — Section 122_기출 따라잡기_문제3.c

```c
#include <stdio.h>
char n[30];
char* getname() {
	printf("이름 입력 : ");
	gets(n);
	return n;
}

main() {
	char* n1 = getname();
	char* n2 = getname();
	char* n3 = getname();
	printf("%s\n", n1);
	printf("%s\n", n2);
	printf("%s\n", n3);
}
```

---

## 9. 정렬 / 기타

### 문제 54 — Section 122_기출 따라잡기_문제1.c

```c
#include <stdio.h>
void align(int a[]) {
	int temp;
	for (int i = 0; i < 4; i++)
		for (int j = 0; j < 4 - i; j++)
			if (a[j] > a[j+1]) {
				temp = a[j];
				a[j] = a[j+1];
				a[j+1] = temp;
			}
}
main() {
	int a[] = { 85, 75, 50, 100, 95 };
	align(a);
	for (int i = 0; i < 5; i++)
		printf("%d ", a[i]);
}
```

---

### 문제 55 — 문제 21.c

```c
#include <stdio.h>
#include <stdlib.h>
void set(int** arr, int* data, int rows, int cols) {
	for (int i = 0; i < rows * cols; ++i) {
		arr[((i + 1) / rows) % rows][(i + 1) % cols] = data[i];
	}
}
int main( ) {
	int rows = 3, cols = 3, sum = 0;
	int data[] = {5, 2, 7, 4, 1, 8, 3, 6, 9};
	int** arr;
	arr = (int**) malloc(sizeof(int*) * rows);
	for (int i = 0; i < cols; i++) {
		arr[i] = (int*) malloc(sizeof(int) * cols);
	}
	set(arr, data, rows, cols);
	for (int i = 0; i < rows * cols; i++) {
		sum += arr[i / rows][i % cols] * (i % 2 == 0 ? 1 : -1);
	}
	for(int i = 0; i < rows; i++) {
		free(arr[i]);
	}
	free(arr);
	printf("%d", sum);
}
```

> (동일 코드: `문제 06.c` 속 set 함수 패턴 / `문제 10 - 동일 아님`)  
> 실질적으로 동일한 코드: `문제 06.c (문제번호 구분 주의)` — 여기서의 `문제 06.c`는 연결리스트 코드이고, 이 `문제 21.c`는 2차원 동적 배열 코드임. 독립 파일.

---

### 문제 56 — 문제 32.c

```c
#include <stdio.h>
main( ) {
	int field[4][4] = { {0,1,0,1}, {0,0,0,1}, {1,1,1,0}, {0,1,1,1} };
	int mines[4][4] = { {0,0,0,0}, {0,0,0,0}, {0,0,0,0}, {0,0,0,0} };
	int w = 4, h = 4;
	for (int y = 0; y < h; y++) {
		for (int x = 0; x < w; x++) {
			if (field[y][x] == 0) continue;
			for (int j = y - 1; j <= y + 1; j++) {
				for (int i = x - 1; i <= x + 1; i++) {
					if (chkover(w, h, j, i) == 1)
						mines[j][i] += 1;
				}
			}
		}
	}
}

int chkover(int w, int h, int j, int i) {
	if (i >= 0 && i < w && j >= 0 && j < h) return 1;
	return 0;
}
```

> (동일 코드: `문제50.c`)

---

### 문제 57 — 기출 따라잡기_문제9.c

```c
#include <stdio.h>
main() {
	int m = 4620;
	int a = m / 1000;
	int b = m % 1000 / 500;
	int c = m % 500 / 100;
	int d = m % 100 / 10;
	printf("1000원의 개수 : %d\n", a);
	printf("500원의 개수 : %d\n", b);
	printf("100원의 개수 : %d\n", c);
	printf("10원의 개수 : %d\n", d);
}
```

> (동일 코드: `문제 05.c`, `문제 09.c`)

---

## 10. 기출 따라잡기

### 문제 58 — 03 Java 문제 - 예제1.c (Java 코드)

```c
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

> 참고: 이 파일은 Java 코드임 (.c 확장자이나 실제는 Java)

---

---

## 11. 정답 모음

### 빠른 정답 표

| 문제 번호 | 원본 파일명 | 출력값 |
|-----------|-------------|--------|
| 문제 01 | 02 C문제 - 예제1.c | 입력 의존 |
| 문제 02 | 310 데이터 입출력 - C언어 예상체크1.c | 입력 의존 |
| 문제 03 | 문제 09.c | 멀티라인 (아래 참조) |
| 문제 04 | 문제 10.c | `변환된 문자열 : Nd sc 1` |
| 문제 05 | Section 118_기출 따라잡기_문제2.c | `1, 9, 3` |
| 문제 06 | Section 118_기출 따라잡기_문제6.c | `20, 24, 36, 80` |
| 문제 07 | 316 연산자 우선순위 기출체크1.c | `0` |
| 문제 08 | 기출 따라잡기_문제4.c | `200, 201, 300` |
| 문제 09 | 기출 따라잡기_문제10.c | `1` |
| 문제 10 | Section 119_기출 따라잡기_문제3.c | `151` |
| 문제 11 | 317 제어문 - C언어 기출체크1.c | `-8` |
| 문제 12 | 317 제어문 - C언어 기출체크2.c | `E` |
| 문제 13 | 317 제어문 - C언어.c | 멀티라인 (아래 참조) |
| 문제 14 | 문제 12.c | `BCD` |
| 문제 15 | 문제 14.c | `505` |
| 문제 16 | 기출 따라잡기_문제6.c | `46` |
| 문제 17 | 기출 따라잡기_문제7.c | `2` |
| 문제 18 | 기출 따라잡기_문제13.c | `4321` |
| 문제 19 | 문제 19.c | `34` |
| 문제 20 | 문제41.c | `-13` |
| 문제 21 | 문제 11.c | `45312` |
| 문제 22 | 문제8.c | `21` |
| 문제 23 | Section 120_기출 따라잡기_문제4.c | `22` |
| 문제 24 | 문제 13.c | `11 12 22 25 64 ` |
| 문제 25 | 320 포인터 - C언어 기출체크1.c | `8` |
| 문제 26 | 320 포인터 - C언어 기출체크2.c | `qwe` |
| 문제 27 | 320 포인터 - C언어.c | 멀티라인 (아래 참조) |
| 문제 28 | Section 120_기출 따라잡기_문제1.c | 멀티라인 (아래 참조) |
| 문제 29 | Section 120_기출 따라잡기_문제3.c | `37` |
| 문제 30 | 문제 15.c | 멀티라인 (아래 참조) |
| 문제 31 | 기출 따라잡기_문제3.c | `5 그리고 6` |
| 문제 32 | 기출 따라잡기_문제8.c | `1` |
| 문제 33 | 문제42.c | `10` |
| 문제 34 | 321 구조체 - C언어 기출체크1.c | `Lee` / `38` |
| 문제 35 | 321 구조체 - C언어 기출체크2.c | `2` |
| 문제 36 | 321 구조체 - C언어.c (= 02 C 문제 예제1) | `501` |
| 문제 37 | 문제 16.c | `C` |
| 문제 38 | 문제22.c | `908` |
| 문제 39 | 문제19.c | `234` |
| 문제 40 | 322 사용자 정의 함수 - C언어.c | `6` |
| 문제 41 | 322 사용자 정의 함수 - C언어 기출체크2.c | 입력 의존 |
| 문제 42 | Section 122_기출 따라잡기_문제5.c | `20` |
| 문제 43 | Section 122_기출 따라잡기_문제7.c | `1024` |
| 문제 44 | Section 122_기출 따라잡기_문제2.c | `GECA` |
| 문제 45 | Section 122_기출 따라잡기_문제6.c | `29` |
| 문제 46 | 322 사용자 정의 함수 - C언어 기출체크1.c | 출력 없음 (정렬만 수행) |
| 문제 47 | 문제18.c | `312` |
| 문제 48 | 문제 06.c | `35421` |
| 문제 49 | 문제25.c | `3 1 2` |
| 문제 50 | 문제26.c | `2 그리고 3` |
| 문제 51 | 문제29.c (연결리스트 스택) | `TSEB` |
| 문제 52 | 문제 29.c (스택 구현) | `213465` |
| 문제 53 | Section 122_기출 따라잡기_문제3.c | 입력 의존 (전역 배열 덮어쓰기) |
| 문제 54 | Section 122_기출 따라잡기_문제1.c | `50 75 85 95 100 ` |
| 문제 55 | 문제 21.c | `13` |
| 문제 56 | 문제 32.c | 출력 없음 (mines 배열에 결과 저장, printf 없음) |
| 문제 57 | 기출 따라잡기_문제9.c | 멀티라인 (아래 참조) |
| 문제 58 | 03 Java 문제 - 예제1.c | 입력 의존 (Java 코드) |

---

### 멀티라인 출력 상세

**문제 13 — 317 제어문 - C언어.c**
```
1 is B Rank
3 is A Rank
4 is C Rank
```
(score[0]=86→B, score[1]=53→F(skip), score[2]=95→A, score[3]=76→C, score[4]=61→F(skip))

---

**문제 27 — 320 포인터 - C언어.c**
```
70, 70
g, g, gilbut
l, l, lbut
u, u, ut
```

---

**문제 28 — Section 120_기출 따라잡기_문제1.c**
```
KOREA
EA
K
E
M
```
(*p = 'K', ASCII 75. 'K'+2 = 'M')

---

**문제 03 / 문제 57 — 문제 09.c / 기출 따라잡기_문제9.c**
```
1000원의 개수 : 4
500원의 개수 : 1
100원의 개수 : 1
10원의 개수 : 2
```

---

**문제 30 — 문제 15.c**
```
1. KOREA
2. OREA
3. K
4. E
5. O
```
(*p = 'K', ASCII 75. 'K'+4 = 'O')

---

**문제 52 — 문제 29.c (스택)**
```
213465
```
(자세한 추적은 풀이 섹션 참조)

---

**문제 55 — 문제21.c (동적 2차원 배열)**

set 함수로 data 배열 내용을 arr에 배치하고 합산:

i=0부터 8까지, arr[((i+1)/3)%3][(i+1)%3] = data[i]

| i | (i+1)/3 % 3 | (i+1)%3 | arr 위치 | data[i] |
|---|---|---|---|---|
| 0 | 0 | 1 | [0][1] | 5 |
| 1 | 0 | 2 | [0][2] | 2 |
| 2 | 1 | 0 | [1][0] | 7 |
| 3 | 1 | 1 | [1][1] | 4 |
| 4 | 1 | 2 | [1][2] | 1 |
| 5 | 2 | 0 | [2][0] | 8 |
| 6 | 2 | 1 | [2][1] | 3 |
| 7 | 2 | 2 | [2][2] | 6 |
| 8 | 0 | 0 | [0][0] | 9 |

arr:
```
[9][5][2]
[7][4][1]
[8][3][6]
```

sum = Σ arr[i/3][i%3] * (i%2==0 ? 1 : -1) for i=0..8

| i | arr[i/3][i%3] | 부호 | 기여 |
|---|---|---|---|
| 0 | arr[0][0]=9 | +1 | +9 |
| 1 | arr[0][1]=5 | -1 | -5 |
| 2 | arr[0][2]=2 | +1 | +2 |
| 3 | arr[1][0]=7 | -1 | -7 |
| 4 | arr[1][1]=4 | +1 | +4 |
| 5 | arr[1][2]=1 | -1 | -1 |
| 6 | arr[2][0]=8 | +1 | +8 |
| 7 | arr[2][1]=3 | -1 | -3 |
| 8 | arr[2][2]=6 | +1 | +6 |

sum = 9-5+2-7+4-1+8-3+6 = **13**

출력: `13`

---

## 12. 풀이 & 포인트 모음

---

### 문제 07 — 316 연산자 우선순위 기출체크1.c — 출력: `0`

**단계별 추적**
```
x=7, y=4, z 미초기화

1단계: z = y % 3 < 3 ? 2 : 1
  y % 3 = 4 % 3 = 1
  1 < 3 → true
  z = 2

2단계: z = z & z >> 1
  >> 가 & 보다 우선순위 높음
  z >> 1 = 2 >> 1 = 1
  z & 1 = 2 & 1 = 10(2) & 01(2) = 0
  z = 0

3단계: z = x > 5 && z <= 3 ? z * x : z / x
  x > 5 → 7 > 5 → true
  z <= 3 → 0 <= 3 → true
  true && true → true
  z * x = 0 * 7 = 0
  z = 0
```

**핵심 포인트:** `>>` 비트 시프트 연산자는 `&` 비트AND보다 우선순위 높음. `z & z>>1`은 `z & (z>>1)`로 계산됨.

---

### 문제 11 — 317 제어문 - C언어 기출체크1.c — 출력: `-8`

**단계별 추적**
```
c = 1, switch(3) 실행
case 3: c = 0       → c = 0  (break 없음, fall-through)
case 4: c += 3      → c = 3  (break 없음, fall-through)
case 5: c -= 10     → c = -7 (break 없음, fall-through)
default: c--        → c = -8
```

**핵심 포인트:** switch-case에서 `break` 없으면 fall-through 발생. case 3에서 시작해 default까지 모두 실행됨.

---

### 문제 12 — 317 제어문 - C언어 기출체크2.c — 출력: `E`

**단계별 추적**
```
str = "REPUBLICOFKOREA" (길이 15)
while 루프로 a를 증가: a = 15 (null 문자 위치)
str[a-2] = str[13] = 'E'
R(0)E(1)P(2)U(3)B(4)L(5)I(6)C(7)O(8)F(9)K(10)O(11)R(12)E(13)A(14)
```

**핵심 포인트:** while 루프가 끝나면 a는 문자열 길이(null 위치). str[a-2]는 끝에서 두 번째 문자.

---

### 문제 13 — 317 제어문 - C언어.c — 멀티라인 출력

**단계별 추적**
```
score = {86, 53, 95, 76, 61}
i=0: 86/10=8 → case 8 → grade='B', printf("1 is B Rank\n")
i=1: 53/10=5 → default → grade='F', 출력 안 함
i=2: 95/10=9 → case 9 → grade='A', printf("3 is A Rank\n")
i=3: 76/10=7 → case 7 → grade='C', printf("4 is C Rank\n")
i=4: 61/10=6 → default → grade='F', 출력 안 함
```

---

### 문제 25 — 320 포인터 - C언어 기출체크1.c — 출력: `8`

**단계별 추적**
```
ary[0] = 1  (*(ary+0) = 1)
ary[1] = *(ary+0) + 2 = 1 + 2 = 3
ary[2] = *ary + 3 = ary[0] + 3 = 1 + 3 = 4
s = 0 + 1 + 3 + 4 = 8
```

**핵심 포인트:** `*(ary+0)` == `ary[0]` == `*ary` 모두 같은 의미.

---

### 문제 26 — 320 포인터 - C언어 기출체크2.c — 출력: `qwe`

**단계별 추적**
```
a = "qwer", b = "qwtety"
i=0, a[0]='q': j 순회 → b[0]='q' 일치 → 출력 'q'
i=1, a[1]='w': j 순회 → b[1]='w' 일치 → 출력 'w'
i=2, a[2]='e': j 순회 → b[0]='q', b[1]='w', b[2]='t', b[3]='e' → 일치 → 출력 'e'
i=3, a[3]='r': b에 'r' 없음 → 출력 없음
```

출력: `qwe`

---

### 문제 27 — 320 포인터 - C언어.c — 멀티라인 출력

**단계별 추적**
```
a = 50, b = &a
*b = *b + 20 → a = 70, *b = 70
printf("%d, %d\n", a, *b) → "70, 70"

s = "gilbut"
i=0: printf("%c, ", s[0])='g', printf("%c, ", *(s+0))='g', printf("%s\n", s+0)="gilbut"
i=2: printf("%c, ", s[2])='l', printf("%c, ", *(s+2))='l', printf("%s\n", s+2)="lbut"
i=4: printf("%c, ", s[4])='u', printf("%c, ", *(s+4))='u', printf("%s\n", s+4)="ut"
```

출력:
```
70, 70
g, g, gilbut
l, l, lbut
u, u, ut
```

---

### 문제 34 — 321 구조체 - C언어 기출체크1.c — 출력: `Lee\n38`

**단계별 추적**
```
a[] = {{"Kim",28}, {"Lee",38}, {"Park",42}, {"Choi",31}}
p = a (→ &a[0], p는 "Kim",28)
p++ (→ &a[1], p는 "Lee",38)
printf("%s\n", p->name) → "Lee"
printf("%d\n", p->age) → "38"
```

---

### 문제 35 — 321 구조체 - C언어 기출체크2.c — 출력: `2`

**단계별 추적**
```
i=0: st[0].n=0, st[0].g=1
i=1: st[1].n=1, st[1].g=2
printf("%d", st[0].n + st[1].g) = 0 + 2 = 2
```

---

### 문제 36 — 321 구조체 - C언어.c — 출력: `501`

**단계별 추적**
```
st[0]: nae="데이터1", os=95, db=88, hab=0, hhab=0
st[1]: nae="데이터2", os=84, db=91, hab=0, hhab=0
st[2]: nae="데이터3", os=86, db=75, hab=0, hhab=0
p = &st[0]

(p+1)->hab  = (p+1)->os + (p+2)->db = 84 + 75 = 159
(p+1)->hhab = (p+1)->hab + p->os + p->db = 159 + 95 + 88 = 342
printf: 159 + 342 = 501
```

**핵심 포인트:** p+1은 st[1], p+2는 st[2]. 구조체 배열에서 포인터 연산으로 각 멤버에 접근.

---

### 문제 40 — 322 사용자 정의 함수 - C언어.c — 출력: `6`

**단계별 추적**
```
pf = factorial (함수 포인터)
pf(3) = factorial(3)
  factorial(3) = 3 * factorial(2)
  factorial(2) = 2 * factorial(1)
  factorial(1) = 1 (base case)
  = 2 * 1 = 2
  = 3 * 2 = 6
```

---

### 문제 05 — Section 118_기출 따라잡기_문제2.c — 출력: `1, 9, 3`

**단계별 추적**
```
i=10, j=10, k=30
i /= j → i = 10/10 = 1
j -= i → j = 10 - 1 = 9
k %= j → k = 30 % 9 = 3
printf → "1, 9, 3"
```

---

### 문제 06 — Section 118_기출 따라잡기_문제6.c — 출력: `20, 24, 36, 80`

**단계별 추적**
```
024 = 8진수 → 10진수: 2*8 + 4 = 20
24 = 십진수 = 24
0x24 = 16진수 → 10진수: 2*16 + 4 = 36
hap = 20 + 24 + 36 = 80
```

---

### 문제 10 — Section 119_기출 따라잡기_문제3.c — 출력: `151`

**단계별 추적**
```
v1=0, v2=35, v3=29
if (v1 > v2 ? v2 : v1)
  v1 > v2 → 0 > 35 → false → 조건식 결과: v1 = 0
if (0) → false
else: v3 = v3 << 2 = 29 << 2 = 29 * 4 = 116
printf: v2 + v3 = 35 + 116 = 151
```

---

### 문제 28 — Section 120_기출 따라잡기_문제1.c — 멀티라인 출력

**단계별 추적**
```
p = "KOREA"
printf("%s\n", p)     → "KOREA"
printf("%s\n", p+3)   → "EA"  (p+3은 'E'부터 시작)
printf("%c\n", *p)    → "K"
printf("%c\n", *(p+3)) → "E"
printf("%c\n", *p+2)  → 'K' + 2 = ASCII 75+2=77 = 'M'
```

---

### 문제 29 — Section 120_기출 따라잡기_문제3.c — 출력: `37`

**단계별 추적**
```
a=12, b=24, c=36
array[0]=&a, array[1]=&b, array[2]=&c
*array[1] = b = 24
**array = *array[0] = a = 12
printf: 24 + 12 + 1 = 37
```

---

### 문제 23 — Section 120_기출 따라잡기_문제4.c — 출력: `22`

**단계별 추적**
```
a = {0, 2, 4, 8}, b[3], sum=0
i=1: p=a+1 → *p=2, b[0]=*p-a[0]=2-0=2, sum=0+b[0]+a[1]=0+2+2=4
i=2: p=a+2 → *p=4, b[1]=*p-a[1]=4-2=2, sum=4+b[1]+a[2]=4+2+4=10
i=3: p=a+3 → *p=8, b[2]=*p-a[2]=8-4=4, sum=10+b[2]+a[3]=10+4+8=22
```

**핵심 포인트:** `sum = sum + b[i-1] + a[i]` 즉 차이값과 원래값을 둘 다 더함.

---

### 문제 54 — Section 122_기출 따라잡기_문제1.c — 출력: `50 75 85 95 100 `

**단계별 추적**
```
a = {85, 75, 50, 100, 95}
버블정렬 (i=0..3, j=0..3-i까지)
i=0: {75,50,85,95,100}
i=1: {50,75,85,95,100}
i=2: 변화 없음
i=3: 변화 없음
결과: {50, 75, 85, 95, 100}
```

---

### 문제 44 — Section 122_기출 따라잡기_문제2.c — 출력: `GECA`

**단계별 추적**
```
str = "ABCDEFGH" (len=8)
inverse 후: "HGFEDCBA"
i=1부터 2씩: i=1,3,5,7
str[1]='G', str[3]='E', str[5]='C', str[7]='A'
출력: "GECA"
```

---

### 문제 42 — Section 122_기출 따라잡기_문제5.c — 출력: `20`

**단계별 추적**
```
static x는 함수 호출 간 유지됨
i=0: x(main)=1, func() → static_x=2, return 2, sum=2
i=1: x(main)=2, func() → static_x=4, return 4, sum=6
i=2: x(main)=3, func() → static_x=6, return 6, sum=12
i=3: x(main)=4, func() → static_x=8, return 8, sum=20
```

---

### 문제 45 — Section 122_기출 따라잡기_문제6.c — 출력: `29`

**단계별 추적**
```
13195의 소인수 중 가장 큰 수 찾기
13195 = 5 × 7 × 13 × 29
isPrime 체크하며 순서대로: 5, 7, 13, 29
max_div 갱신 순서: 5→7→13→29
최종 max_div = 29
```

---

### 문제 43 — Section 122_기출 따라잡기_문제7.c — 출력: `1024`

**단계별 추적**
```
mp(2, 10): res=1, for i=0..9: res *= 2
res = 2^10 = 1024
```

---

### 문제 31 — 기출 따라잡기_문제3.c — 출력: `5 그리고 6`

**단계별 추적**
```
a[] = {{1,2},{3,4},{5,6}}
ptr = a (→ &a[0])
pptr = &ptr

(*pptr)[1] = (*pptr)[2]
  *pptr = ptr = a (포인터 자체)
  (*pptr)[1] = a[1], (*pptr)[2] = a[2]
  a[1] = a[2] → a[1].x=5, a[1].y=6
  
printf: a[1].x=5, a[1].y=6 → "5 그리고 6"
```

---

### 문제 08 — 기출 따라잡기_문제4.c — 출력: `200, 201, 300`

**단계별 추적**
```
a=100, b=200, c=300
a < b → 100 < 200 → true
result = b++ (후위증가, result에 b의 현재값 대입 후 b 증가)
result = 200
b = 201, c = 300 (변경 없음)
```

---

### 문제 16 — 기출 따라잡기_문제6.c — 출력: `46`

**단계별 추적**
```
input = 101110 (2진수를 10진수로 변환)
di=1, sum=0

input=101110: 0*1=0, di=2, input=10111
input=10111:  1*2=2, di=4, input=1011
input=1011:   1*4=4, di=8, input=101
input=101:    1*8=8, di=16, input=10
input=10:     0*16=0, di=32, input=1
input=1:      1*32=32, di=64, input=0
input=0: break

sum = 0+2+4+8+0+32 = 46
```

---

### 문제 17 — 기출 따라잡기_문제7.c — 출력: `2`

**단계별 추적**
```
완전수(자신을 제외한 약수의 합 = 자신)를 6~30에서 찾아 개수 셈
6: 약수 1+2+3=6 → 완전수 ✓ (el=1)
28: 약수 1+2+4+7+14=28 → 완전수 ✓ (el=2)
기타 숫자: 완전수 아님
el = 2
```

**핵심 포인트:** j는 i/2까지만 검사 (자신의 절반까지). 6~30 범위의 완전수는 6과 28 두 개.

---

### 문제 32 — 기출 따라잡기_문제8.c — 출력: `1`

**단계별 추적**
```
arr = {3, 1, 4, 1, 5}
func(pp, 5) 실행:
  i=0: *(*arr+0) = (arr[0]+0)%5 = (3+0)%5 = 3
  i=1: *(*arr+1) = (arr[1]+1)%5 = (1+1)%5 = 2
  i=2: *(*arr+2) = (arr[2]+2)%5 = (4+2)%5 = 1
  i=3: *(*arr+3) = (arr[3]+3)%5 = (1+3)%5 = 4
  i=4: *(*arr+4) = (arr[4]+4)%5 = (5+4)%5 = 4

arr = {3, 2, 1, 4, 4}
num = arr[2] = 1
```

---

### 문제 09 — 기출 따라잡기_문제10.c — 출력: `1`

**단계별 추적**
```
a=5, b=10, c=15, d=30
result = a*3+b > d || c-b/a <= d && 1
연산자 우선순위: *, /, %, +, -, >, <, &&, ||

a*3 = 15
a*3+b = 25
25 > d → 25 > 30 → false (좌변)

b/a = 10/5 = 2
c - b/a = 15-2 = 13
13 <= d → 13 <= 30 → true
true && 1 → true (우변)

false || true → true → 1
```

---

### 문제 18 — 기출 따라잡기_문제13.c — 출력: `4321`

**단계별 추적**
```
number=1234, div=10, result=0

반복1: result=0*10=0, result=0+(1234%10)=0+4=4, number=1234/10=123
반복2: result=4*10=40, result=40+(123%10)=40+3=43, number=123/10=12
반복3: result=43*10=430, result=430+(12%10)=430+2=432, number=12/10=1
반복4: result=432*10=4320, result=4320+(1%10)=4320+1=4321, number=1/10=0
종료: number=0 → while 종료
```

---

### 문제 04 — 문제 10.c — 출력: `변환된 문자열 : Nd sc 1`

**단계별 추적**
```
p = "It is 8"
각 문자 변환:
'I' → isupper → ('I'-'A'+5)%25+'A' = (8+5)%25+65 = 13+65 = 78 = 'N'
't' → islower → ('t'-'a'+10)%26+'a' = (19+10)%26+97 = 3+97 = 100 = 'd'
' ' → 특수문자 → ' '
'i' → islower → ('i'-'a'+10)%26+'a' = (8+10)%26+97 = 18+97 = 115 = 's'
's' → islower → ('s'-'a'+10)%26+'a' = (18+10)%26+97 = 2+97 = 99 = 'c'
' ' → ' '
'8' → isdigit → ('8'-'0'+3)%10+'0' = (8+3)%10+48 = 1+48 = 49 = '1'

결과: "Nd sc 1"
출력: "변환된 문자열 : Nd sc 1"
```

**핵심 포인트:** 대문자는 %25 (A+25=Z 넘어감 방지), 소문자는 %26. 숫자는 %10.

---

### 문제 14 — 문제 12.c — 출력: `BCD`

**단계별 추적**
```
n = {73, 95, 82}
sum = 73+95+82 = 250
sum/30 = 250/30 = 8 (정수 나눗셈)
switch(8):
case 8: printf("B")  ← break 없음
case 7:              ← 해당 케이스 없으나 fall-through 계속
case 6: printf("C")  ← break 없음
default: printf("D")
결과: "BCD"
```

---

### 문제 24 — 문제 13.c — 출력: `11 12 22 25 64 `

**단계별 추적**
```
E = {64, 25, 12, 22, 11}, n=5
선택정렬 방식의 do-while
i=0: j=1..4에서 E[0]=64와 비교, 더 작은 것 발견시 즉시 swap
  j=1: 64>25 → swap → {25,64,12,22,11}
  j=2: 25>12 → swap → {12,64,25,22,11}  아니, i=0 고정
  
재확인: 이 정렬은 E[i]와 E[j]를 비교해 즉시 swap하는 방식
  
i=0, j=1: E[0]=64 > E[1]=25 → swap → {25,64,12,22,11}
i=0, j=2: E[0]=25 > E[2]=12 → swap → {12,64,25,22,11}
i=0, j=3: E[0]=12 > E[3]=22 → no
i=0, j=4: E[0]=12 > E[4]=11 → swap → {11,64,25,22,12}

i=1, j=2: E[1]=64 > E[2]=25 → swap → {11,25,64,22,12}
i=1, j=3: E[1]=25 > E[3]=22 → swap → {11,22,64,25,12}
i=1, j=4: E[1]=22 > E[4]=12 → swap → {11,12,64,25,22}

i=2, j=3: E[2]=64 > E[3]=25 → swap → {11,12,25,64,22}
i=2, j=4: E[2]=25 > E[4]=22 → swap → {11,12,22,64,25}

i=3, j=4: E[3]=64 > E[4]=25 → swap → {11,12,22,25,64}

결과: {11, 12, 22, 25, 64}
```

---

### 문제 15 — 문제 14.c — 출력: `505`

**단계별 추적**
```
1~2023 중 4의 배수 개수
2023 / 4 = 505.75 → 정수: 505
```

---

### 문제 30 — 문제 15.c — 멀티라인 출력

**단계별 추적**
```
p = "KOREA"
1. printf("1. %s\n", p) → "1. KOREA"
2. printf("2. %s\n", p+1) → "2. OREA"
3. printf("3. %c\n", *p) → "3. K"
4. printf("4. %c\n", *(p+3)) → "4. E"
5. printf("5. %c\n", *p+4) → 'K'+4 = 75+4=79='O' → "5. O"
```

---

### 문제 37 — 문제 16.c — 출력: `C`

**단계별 추적**
```
test = {{1,"AB"}, {2,"DC"}, {3,"EB"}}
p = &test[1] → p->i=2, p->g="DC"
p->g + (p->i - 1) = "DC" + (2-1) = "DC" + 1 = "C"
printf("%s", "C") → "C"
```

---

### 문제 19 — 문제 19.c — 출력: `34`

**단계별 추적**
```
1~100에서 완전수의 합
완전수: 6, 28, 496(>100이므로 제외)
r = 6 + 28 = 34
```

---

### 문제 47 — 문제18.c — 출력: `312`

**단계별 추적**
```
n1={1,NULL}, n2={2,NULL}, n3={3,NULL}
n1.next = &n3 → 연결: n1→n3→NULL
n3.next = &n2 → 연결: n1→n3→n2→NULL

func(&n1):
  node=n1: t=n1.value=1, n1.value=n3.value=3, n3.value=1
  node=n1.next.next = n3.next = n2(NULL아님이지만 n2.next=NULL)
  node=n2: t=n2.value=2, n2.value=NULL... → n2.next는 NULL이므로 루프 종료

실제 노드 상태:
  n1.value=3, n1.next=&n3
  n3.value=1, n3.next=&n2
  n2.value=2, n2.next=NULL

순회: n1(3) → n3(1) → n2(2)
출력: "312"
```

---

### 문제 39 — 문제19.c — 출력: `234`

**단계별 추적**
```
r1() = 4
r10() = 30 + r1() = 30 + 4 = 34
r100() = 200 + r10() = 200 + 34 = 234
printf → "234"
```

---

### 문제 38 — 문제22.c — 출력: `908`

**단계별 추적**
```
dec(enc) = enc & 0xA5 (= 165 = 10100101)

s[0] = "Kim", score = {0xA0, 0xA5, 0xDB}
  0xA0(160) & 0xA5(165): 10100000 & 10100101 = 10100000 = 160
  0xA5(165) & 0xA5(165): 10100101 & 10100101 = 10100101 = 165
  0xDB(219) & 0xA5(165): 11011011 & 10100101 = 10000001 = 129
  sum1 = 160 + 165 + 129 = 454

s[1] = "Lee", score = {0xA0, 0xED, 0x81}
  0xA0(160) & 0xA5(165) = 160
  0xED(237) & 0xA5(165): 11101101 & 10100101 = 10100101 = 165
  0x81(129) & 0xA5(165): 10000001 & 10100101 = 10000001 = 129
  sum2 = 160 + 165 + 129 = 454

result = 454 + 454 = 908
```

**핵심 포인트:** `&` 비트AND 연산. 마스킹(masking) 패턴. int 배열에 hex 리터럴 저장시 양수 그대로.

---

### 문제 48 — 문제 06.c (연결리스트) — 출력: `35421`

**단계별 추적**
```
insert는 head에 새 노드를 prepend(앞에 추가)
i=1: head → 1→NULL
i=2: head → 2→1→NULL
i=3: head → 3→2→1→NULL
i=4: head → 4→3→2→1→NULL
i=5: head → 5→4→3→2→1→NULL

reconnect(head, 3): value=3인 노드를 head로 이동
  초기: 5→4→3→2→1→NULL
  순회: prev=NULL,curr=5 → prev=5,curr=4 → prev=4,curr=3 (값 찾음)
  
  prev(4)->next = curr(3)->next = 2  → 4→2
  curr(3)->next = head = 5           → 3→5
  head = curr = 3
  
  결과: 3→5→4→2→1→NULL
출력: "35421"
```

**핵심 포인트:** reconnect는 특정 값을 가진 노드를 헤드로 이동시키는 함수. insert는 스택처럼 앞에 삽입.

---

### 문제 49 — 문제25.c — 출력: `3 1 2`

**단계별 추적**
```
a={1,NULL}, b={2,NULL}, c={3,NULL}
첫 줄: a.n=&b, b.n=&c, c.n=NULL → a→b→c→NULL
둘째 줄: c.n=&a, a.n=&b, b.n=NULL → (순서대로 실행)
  c.n = &a → c→a
  a.n = &b → a→b (변화 없음)
  b.n = NULL → b→NULL
  
최종 연결: c→a→b→NULL (c.n=&a, a.n=&b, b.n=NULL)
head = &c

head->p = c.p = 3
head->n->p = a.p = 1
head->n->n->p = b.p = 2
출력: "3 1 2"
```

---

### 문제 50 — 문제26.c — 출력: `2 그리고 3`

**단계별 추적**
```
Queue SIZE=3, a[3], front=0, rear=0
enq(1): a[0]=1, rear=1
enq(2): a[1]=2, rear=2
deq(): val=a[0]=1, front=1, return 1
enq(3): a[2]=3, rear=(2+1)%3=0
printf("%d 그리고 %d", deq(), deq())

참고: printf 인자 평가 순서는 구현 정의이나 보통 오른쪽에서 왼쪽
먼저 두 번째 deq 호출: val=a[1]=2, front=2, return 2
그 다음 첫 번째 deq 호출: val=a[2]=3, front=(2+1)%3=0, return 3
printf("%d 그리고 %d", 3, 2) → "3 그리고 2"

...하지만 C 표준에서 함수 인자 평가 순서는 비특정(unspecified). 
보통 구현에 따라 다를 수 있으므로, 일반적으로 왼쪽→오른쪽으로 보면:
첫 번째 deq: val=a[front=1]=2, front=2, return 2
두 번째 deq: val=a[front=2]=3, front=0, return 3
출력: "2 그리고 3"
```

**핵심 포인트:** `printf` 내 함수 호출 순서는 컴파일러 의존. 보통 왼쪽부터 실행시 `2 그리고 3`.

---

### 문제 51 — 문제29.c (연결리스트 스택) — 출력: `TSEB`

**단계별 추적**
```
func("BEST"):
  s="BEST"
  's'='B': n->c='B', n->p=NULL, h=n(B)
  's'='E': n->c='E', n->p=B, h=n(E)
  's'='S': n->c='S', n->p=E, h=n(S)
  's'='T': n->c='T', n->p=S, h=n(T)
  return h(T)

순회: T→S→E→B→NULL
putchar: T, S, E, B
출력: "TSEB"
```

---

### 문제 52 — 문제 29.c (스택 구현) — 출력: `213465`

**단계별 추적**
```
스택: isWhat[], point=-1 (LIFO)
초기: into(5)→[5], into(2)→[5,2], point=1

while(!isEmpty()): point=1≠-1 → true
  take(): return isWhat[1]=2, point=0 → printf "2"  스택:[5]
  into(4): isWhat[1]=4, point=1  스택:[5,4]
  into(1): isWhat[2]=1, point=2  스택:[5,4,1]
  take(): return isWhat[2]=1, point=1 → printf "1"  스택:[5,4]
  into(3): isWhat[2]=3, point=2  스택:[5,4,3]
  take(): return isWhat[2]=3, point=1 → printf "3"  스택:[5,4]
  take(): return isWhat[1]=4, point=0 → printf "4"  스택:[5]
  into(6): isWhat[1]=6, point=1  스택:[5,6]
  take(): return isWhat[1]=6, point=0 → printf "6"  스택:[5]
  take(): return isWhat[0]=5, point=-1 → printf "5"  스택:[]

while(!isEmpty()): point=-1 → isEmpty=true → 종료

출력: "213465"
```

**핵심 포인트:** into는 push(++point 후 저장), take는 pop(point-- 후 반환). while 한 바퀴에 스택이 완전히 소모됨.

---

### 문제 20 — 문제41.c — 출력: `-13`

**단계별 추적**
```
a=11, b=19
swap(a, b): 값 복사 전달 → main의 a,b 변화 없음 (a=11, b=19 유지)

switch(a): a=11 → case 11 매칭
case 11: b += 2 → b=21
deafult(오타): b += 3 → b=24  (deafult는 레이블로 처리됨, break 없어 fall-through)
break

printf: a-b = 11-24 = -13
```

**핵심 포인트:** `deafult`는 `default`의 오타이지만 단순 레이블로 처리되어 case 11 fall-through로 실행됨. swap은 값 전달이므로 main 변수 변경 없음.

---

### 문제 33 — 문제42.c — 출력: `10`

**단계별 추적**
```
str1="first" (길이5), str2="teststring"
func(str2, str1): str2에 str1 복사
  str2 = "first\0" (5글자 + null)

for i=0..4 (str2[5]='\0'에서 종료):
  result += 0+1+2+3+4 = 10
출력: "10"
```

---

### 문제 22 — 문제8.c — 출력: `21`

**단계별 추적**
```
arr[3][3] = {1,2,3, 4,5,6, 7,8,9}
  arr[0]={1,2,3}, arr[1]={4,5,6}, arr[2]={7,8,9}

parr[0] = arr[1] → {4,5,6}
parr[1] = arr[2] → {7,8,9}

parr[1][1]    = arr[2][1] = 8
*(parr[1]+2)  = parr[1][2] = arr[2][2] = 9
**parr        = *parr[0] = parr[0][0] = arr[1][0] = 4

printf: 8 + 9 + 4 = 21
```

**핵심 포인트:** `**parr`은 parr[0]이 가리키는 배열의 첫 번째 요소. `*(parr[1]+2)`는 `parr[1][2]`와 동일.

---

### 문제 55 — 문제21.c — 출력: `13`

풀이는 정답 모음 표의 상세 섹션 참조.

---

### 문제 48 — 문제 06.c (연결리스트) 추가 참조

풀이는 문제23.c와 동일 (동일 코드).

---

*참고: `문제 46 — 322 사용자 정의 함수 - C언어 기출체크1.c` (Usort)와 `문제 56 — 문제 32.c` (mines 배열 계산)는 printf 없이 종료되어 출력이 없습니다.*

*`문제 58 — 03 Java 문제 - 예제1.c`는 Java 코드이므로 입력에 따라 결과가 달라지는 입력 의존 코드입니다.*
