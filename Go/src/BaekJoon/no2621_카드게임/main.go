package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	var colors map[string]int
	colors = make(map[string]int)
	numbers := [10]int{}
	nums := []int{}
	max := 0
	for i := 0; i < 5; i++ {
		var color string
		var number int
		fmt.Fscanln(reader, &color, &number)
		colors[color]++
		numbers[number]++

		nums = append(nums, number)
		if number > max {
			max = number
		}
	}

	flush := false
	for _, value := range colors {
		if value == 5 {
			flush = true
		}
		break
	}

	var onepair, twopair, triple, fourcard int
	for i := range numbers {
		switch numbers[i] {
		case 2:
			if onepair == 0 {
				onepair = i
			} else {
				twopair = i
			}
		case 3:
			triple = i
		case 4:
			fourcard = i
		default:
			continue
		}
	}

	straight := true
	sort.Ints(nums)
	if len(nums) != 5 {
		straight = false
	} else {
		for i := 0; i < 4; i++ {
			if nums[i]+1 != nums[i+1] {
				straight = false
				break
			}
		}
	}

	ans := 0
	if flush && straight {
		ans = 900 + max
	} else if fourcard != 0 {
		ans = 800 + fourcard
	} else if triple != 0 && onepair != 0 {
		ans = 700 + onepair + (triple * 10)
	} else if flush {
		ans = 600 + max
	} else if straight {
		ans = 500 + max
	} else if triple != 0 {
		ans = 400 + triple
	} else if twopair != 0 {
		if onepair > twopair {
			onepair, twopair = twopair, onepair
		}
		ans = 300 + onepair + (twopair * 10)
	} else if onepair != 0 {
		ans = 200 + onepair
	} else {
		ans = 100 + max
	}
	fmt.Fprint(writer, ans)
}
