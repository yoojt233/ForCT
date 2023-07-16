package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
)

func dfs(cur int, lists [][]int, visited []int) {
	visited[cur-1] = order
	order++
	for _, next := range lists[cur] {
		if visited[next-1] == 0 {
			dfs(next, lists, visited)
		}
	}
}

var order = 1

func main() {
	reader := bufio.NewReader(os.Stdin)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	var n, m, r int
	fmt.Fscanf(reader, "%d %d %d\n", &n, &m, &r)

	lists := make([][]int, n+1)
	for i := 0; i < m; i++ {
		var op, ed int
		fmt.Fscanf(reader, "%d %d\n", &op, &ed)
		lists[op] = append(lists[op], ed)
		lists[ed] = append(lists[ed], op)
	}

	for i := 1; i <= n; i++ {
		sort.Ints(lists[i])
	}

	visited := make([]int, n)
	dfs(r, lists, visited)
	for _, v := range visited {
		fmt.Fprintln(writer, v)
	}
}
