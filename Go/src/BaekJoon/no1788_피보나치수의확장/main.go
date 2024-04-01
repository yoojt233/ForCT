package main

import (
	"bufio"
	"fmt"
	"os"
)

var (
	in  = bufio.NewReader(os.Stdin)
	out = bufio.NewWriter(os.Stdout)
)

func main() {
	defer out.Flush()

	var temp int
	fmt.Fscanln(in, &temp)

	var n int
	if temp < 0 {
		n = -temp
	} else {
		n = temp
	}

	dp := make([]int, n+1)
	if n > 0 {
		dp[1] = 1
	}

	for i := 2; i <= n; i++ {
		dp[i] = (dp[i-1] + dp[i-2]) % 1_000_000_000
	}

	if temp == 0 {
		fmt.Fprintln(out, 0)
	} else if temp > 0 || temp%2 != 0 {
		fmt.Fprintln(out, 1)
	} else {
		fmt.Fprintln(out, -1)
	}
	fmt.Fprint(out, dp[n])
}
