package main

import (
	"bufio"
	"fmt"
	"os"
	"strconv"
	"strings"
)

type Queue struct {
	Elems []int
	Len   int
	Real  int
	Total int
}

func (q *Queue) Push(v int) {
	q.Len++
	q.Total += v
	q.Elems = append(q.Elems, v)

	if v != 0 {
		q.Real++
	}
}

func (q *Queue) Peek() int {
	if q.Len == 0 {
		return 0
	}
	return q.Elems[0]
}

func (q *Queue) Poll() int {
	if q.Len == 0 {
		return 0
	}

	q.Len--
	v := q.Elems[0]
	q.Total -= v
	q.Elems = q.Elems[1:]

	if v != 0 {
		q.Real--
	}
	return v
}

func (q *Queue) IsEmpty() bool {
	return q.Len == 0
}

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
	x := strings.Split(temp, " ")

	wait := Queue{}
	bridge := Queue{}
	for i := 0; i < w; i++ {
		bridge.Push(0)
	}

	for i := 0; i < n; i++ {
		truck, _ := strconv.Atoi(x[i])
		wait.Push(truck)
	}

	time := 0
	for !wait.IsEmpty() {
		time++
		bridge.Poll()

		if bridge.Real < w && bridge.Total+wait.Peek() <= L {
			bridge.Push(wait.Poll())
		} else {
			bridge.Push(0)
		}
	}

	out.WriteString(strconv.Itoa(time + w))
}
