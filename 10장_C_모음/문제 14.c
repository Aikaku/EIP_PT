#include <stdio.h>
main() {
	int c = 0;
	for (int i = 1; i <= 2023; i++)
		if (i % 4 == 0)
			c++;
	printf("%d", c);
}