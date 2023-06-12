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
}

func (q *Queue) Push(v int) {
	q.Elems = append(q.Elems, v)
	q.Len++
}

func (q *Queue) Pop() int {
	if q.Len == 0 {
		return -1
	}

	temp := q.Elems[0]
	q.Elems = q.Elems[1:]
	q.Len--
	return temp
}

func (q *Queue) Size() int {
	return q.Len
}

func (q *Queue) Empty() int {
	if q.Len == 0 {
		return 1
	}
	return 0
}

func (q *Queue) Front() int {
	if q.Len == 0 {
		return -1
	}
	return q.Elems[0]
}

func (q *Queue) Back() int {
	if q.Len == 0 {
		return -1
	}
	return q.Elems[q.Len-1]
}

var (
	in  = bufio.NewReader(os.Stdin)
	out = bufio.NewWriter(os.Stdout)
)

func main() {
	defer out.Flush()

	var n int
	fmt.Fscanln(in, &n)

	q := Queue{}
	for n > 0 {
		temp, _ := in.ReadString('\n')
		temp = strings.TrimSpace(temp)
		cmd := strings.Split(temp, " ")

		switch cmd[0] {
		case "push":
			num, _ := strconv.Atoi(cmd[1])
			q.Push(num)
		case "pop":
			out.WriteString(strconv.Itoa(q.Pop()))
			out.WriteString("\n")
		case "size":
			out.WriteString(strconv.Itoa(q.Size()))
			out.WriteString("\n")
		case "empty":
			out.WriteString(strconv.Itoa(q.Empty()))
			out.WriteString("\n")
		case "front":
			out.WriteString(strconv.Itoa(q.Front()))
			out.WriteString("\n")
		case "back":
			out.WriteString(strconv.Itoa(q.Back()))
			out.WriteString("\n")
		}
		n--
	}
}
