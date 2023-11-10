package main

import (
	"bufio"
	"fmt"
	"os"
)

type set map[int]struct{}

func (s set) add(elem int) {
	s[elem] = struct{}{}
}

var (
	in       = bufio.NewReader(os.Stdin)
	out      = bufio.NewWriter(os.Stdout)
	graph    [][]set
	visited  []bool
	standard int
	high     int
)

func main() {
	defer out.Flush()
	var n, m int
	fmt.Fscanln(in, &n, &m)

	graph = make([][]set, 2)
	for i := 0; i < 2; i++ {
		graph[i] = make([]set, n)
		for j := 0; j < n; j++ {
			graph[i][j] = make(set)
		}
	}

	for i := 0; i < m; i++ {
		var heavy, light int
		fmt.Fscanln(in, &heavy, &light)
		graph[0][light-1].add(heavy - 1)
		graph[1][heavy-1].add(light - 1)
	}

	ans := 0
	standard = n / 2
	visited = make([]bool, n)
	for i := 0; i < n; i++ {
		clear()
		if dfs(i, 0) {
			ans++
			continue
		}

		clear()
		if dfs(i, 1) {
			ans++
		}
	}
	fmt.Fprint(out, ans)
}

func clear() {
	for i, _ := range visited {
		visited[i] = false
	}
	high = 0
}

func dfs(cur, idx int) bool {
	visited[cur] = true
	for next := range graph[idx][cur] {
		if !visited[next] {
			high++
			dfs(next, idx)
		}
	}
	return high > standard
}
