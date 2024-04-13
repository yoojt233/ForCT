package 뒤에있는큰수찾기

import (
	"bufio"
	"fmt"
	"os"
)

type Stack []interface{}

func (s *Stack) isEmpty() bool {
	return len(*s) == 0
}

func (s *Stack) isNotEmpty() bool {
	return len(*s) > 0
}

func (s *Stack) push(data interface{}) {
	*s = append(*s, data)
}

func (s *Stack) pop() interface{} {
	if s.isEmpty() {
		return nil
	}

	top := len(*s) - 1
	res := (*s)[top]
	*s = (*s)[:top]

	return res
}

func (s *Stack) peek() interface{} {
	if s.isEmpty() {
		return nil
	}

	return (*s)[len(*s)-1]
}

var (
	out = bufio.NewWriter(os.Stdout)
)

func main() {
	defer out.Flush()

	numbers := []int{2, 3, 3, 5}
	for _, v := range solution(numbers) {
		fmt.Fprint(out, v)
		out.WriteString(" ")
	}
}

func solution(numbers []int) []int {
	res := make([]int, len(numbers))
	var stack Stack

	for i := len(numbers) - 1; i >= 0; i-- {
		for stack.isNotEmpty() {
			v, _ := stack.peek().(int)

			if v > numbers[i] {
				res[i] = v
				break
			}
			stack.pop()
		}

		if stack.isEmpty() {
			res[i] = -1
		}

		stack.push(numbers[i])
	}

	return res
}
