package main

import (
	"bufio"
	"fmt"
	"os"
)

var dp = [30][30]int{}

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	var n int
	fmt.Fscan(reader, &n)

	for i := 0; i < n; i++ {
		var left, right int
		fmt.Fscan(reader, &right, &left)
		fmt.Fprintln(writer, combo(left, right))
	}
}

func combo(left, right int) int {
	if dp[left][right] == 0 {
		if left == right || right == 0 {
			dp[left][right] = 1
		} else {
			dp[left][right] = combo(left-1, right-1) + combo(left-1, right)
		}
	}
	return dp[left][right]
}
