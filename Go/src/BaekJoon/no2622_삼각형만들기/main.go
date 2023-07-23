package main

import (
	"bufio"
	"fmt"
	"os"
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	var n int
	fmt.Fscanln(reader, &n)

	ans := 0
	for i := 1; i <= n/3; i++ {
		for j := i; j <= (n-i)/2; j++ {
			if i+j > n-i-j {
				ans++
			}
		}
	}
	fmt.Fprint(writer, ans)
}
