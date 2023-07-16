package main

import (
	"bufio"
	"fmt"
	"os"
)

func calc(nums [5]int) int {
	v := 0
	for i := 0; i < 3; i++ {
		for j := i + 1; j < 4; j++ {
			for k := j + 1; k < 5; k++ {
				sum := nums[i] + nums[j] + nums[k]
				if sum%10 > v {
					v = sum % 10
				}
			}
		}

	}
	return v
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	var n int
	fmt.Fscanln(reader, &n)

	ans := 0
	lim := 0
	for i := 1; i <= n; i++ {
		nums := [5]int{}
		for j := 0; j < 5; j++ {
			fmt.Fscan(reader, &nums[j])
		}
		res := calc(nums)
		if res >= lim {
			ans = i
			lim = res
		}
	}
	fmt.Fprint(writer, ans)
}
