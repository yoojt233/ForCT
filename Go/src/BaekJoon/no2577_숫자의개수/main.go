package main

import (
	"fmt"
)

func main() {
	var a, b, c int
	fmt.Scan(&a, &b, &c)
	total := a * b * c

	cnt := [10]int{}
	for total > 0 {
		x := total % 10
		cnt[x] += 1
		total /= 10
	}

	for i := range cnt {
		fmt.Printf("%d\n", cnt[i])
	}
}
