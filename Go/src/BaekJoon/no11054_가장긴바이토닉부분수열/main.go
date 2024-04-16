package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

var (
	in  = bufio.NewReader(os.Stdin)
	out = bufio.NewWriter(os.Stdout)
)

func SAtoIA(data []string) []int {
	res := make([]int, len(data))
	for i, v := range data {
		res[i], _ = strconv.Atoi(v)
	}
	return res
}

func max(a int, b int) int {
	if a > b {
		return a
	} else {
		return b
	}
}

func solve(n int, input []int) int {
	cnt := make([][]int, 2)
	for i := range cnt {
		cnt[i] = make([]int, n)
	}

	for i := 0; i < n; i++ {
		cnt[0][i] = 1
		for j := 0; j < i; j++ {
			if input[i] > input[j] {
				cnt[0][i] = max(cnt[0][i], cnt[0][j]+1)
			}
		}
	}

	for i := n - 1; i >= 0; i-- {
		cnt[1][i] = 1
		for j := n - 1; j > i; j-- {
			if input[i] > input[j] {
				cnt[1][i] = max(cnt[1][i], cnt[1][j]+1)
			}
		}
	}

	res := 0
	for i := 0; i < n; i++ {
		res = max(res, cnt[0][i]+cnt[1][i]-1)
	}
	return res
}

func main() {
	defer out.Flush()

	var n int
	fmt.Fscanln(in, &n)

	temp, _ := in.ReadString('\n')
	input := SAtoIA(strings.Fields(temp))

	fmt.Fprintln(out, solve(n, input))
}
