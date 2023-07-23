package main

import (
	"bufio"
	"fmt"
	"os"
)

type Deque struct {
	elems []int
	len   int
}

func (dq *Deque) PushBack(elem int) {
	dq.elems = append(dq.elems, elem)
	dq.len++
}

func (dq *Deque) PopFirst() int {
	value := dq.elems[0]
	dq.elems = dq.elems[1:]
	dq.len--
	return value
}

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	var n int
	fmt.Fscanln(reader, &n)

	ans := make([]int, n)
	dq := Deque{}
	for i := 0; i < n; i++ {
		dq.PushBack(i)
	}

	num := 1
	for dq.len > 0 {
		for i := 0; i < num; i++ {
			dq.PushBack(dq.PopFirst())
		}
		ans[dq.PopFirst()] = num
		num++
	}

	for i := range ans {
		fmt.Fprintf(writer, "%d ", ans[i])
	}
}
