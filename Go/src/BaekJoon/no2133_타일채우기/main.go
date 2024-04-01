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

	var n int
	fmt.Fscanln(in, &n)

	dp := []int{1, 0, 3}
	for i := 3; i <= n; i++ {
		if i&1 == 1 {
			dp = append(dp, 0)
		} else {
			dp = append(dp, dp[i-2]*3)
			for x := i - 4; x >= 0; x -= 2 {
				dp[i] += dp[x] * 2
			}
		}
	}

	fmt.Fprint(out, dp[n])
}
