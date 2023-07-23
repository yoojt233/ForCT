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

func main() {
	defer out.Flush()

	var n, w, L int
	fmt.Fscanln(in, &n, &w, &L)

	temp, _ := in.ReadString('\n')
	temp = strings.TrimSpace(temp)

	trucks := strings.Split(temp, " ")
	run := make([]bool, n)
	bridge := make([]int, w)
	total := 0

	time := 0
	cur := 0
	for !run[n-1] {
		time++
		total -= bridge[0]
		bridge = bridge[1:]

		truck, _ := strconv.Atoi(trucks[cur])
		if total+truck <= L {
			total += truck
			run[cur] = true
			cur++
			bridge = append(bridge, truck)
		} else {
			bridge = append(bridge, 0)
		}
	}
	out.WriteString(strconv.Itoa(time + w))
}
