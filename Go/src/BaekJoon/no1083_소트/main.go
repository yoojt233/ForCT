package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

var (
	in   = bufio.NewReader(os.Stdin)
	out  = bufio.NewWriter(os.Stdout)
	n, x int
	nums []int
)

func main() {
	defer out.Flush()

	fmt.Fscanln(in, &n)

	input, _ := in.ReadString('\n')
	input = strings.TrimSpace(input)
	temp := strings.Split(input, " ")
	for _, v := range temp {
		num, _ := strconv.Atoi(v)
		nums = append(nums, num)
	}

	fmt.Fscanln(in, &x)

	solve()
	for _, v := range nums {
		fmt.Fprint(out, v)
		out.WriteString(" ")
	}
}

func solve() {
	for i := 0; i < n; i++ {
		ed := n - 1
		if i+x < n {
			ed = i + x
		}

		idx := find(i, ed)
		for j := idx; j > i; j-- {
			nums[j], nums[j-1] = nums[j-1], nums[j]
			x--

			if x == 0 {
				return
			}
		}
	}
}

func find(op, ed int) int {
	res, value := op, nums[op]
	for i := op + 1; i <= ed; i++ {
		if nums[i] > value {
			res = i
			value = nums[i]
		}
	}

	return res
}
