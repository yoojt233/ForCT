package main

import (
	"bufio"
	"fmt"
	"os"
	"sort"
	"strconv"
	"strings"
)

var (
	in  = bufio.NewReader(os.Stdin)
	out = bufio.NewWriter(os.Stdout)
)

func main() {
	defer out.Flush()

	var n int
	fmt.Fscanln(in, &n)

	input, _ := in.ReadString('\n')
	input = strings.TrimSpace(input)
	temp := strings.Fields(input)

	abils := make([]int, 2*n)
	for i := 0; i < 2*n; i++ {
		abils[i], _ = strconv.Atoi(temp[i])
	}

	sort.Ints(abils)
	last := 2*n - 1
	ans := abils[0] + abils[last]
	for i := 1; i < n; i++ {
		x := abils[i] + abils[last-i]
		if x < ans {
			ans = x
		}
	}
	out.WriteString(strconv.Itoa(ans))
}
