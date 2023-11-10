package main

import (
	"bufio"
	"fmt"
	"os"
	"strings"
)

var (
	in  = bufio.NewReader(os.Stdin)
	out = bufio.NewWriter(os.Stdout)
)

func main() {
	defer out.Flush()
	n, _ := in.ReadString('\n')
	n = strings.TrimSpace(n)

	var ans string
	switch n {
	case "M":
		ans = "MatKor"
	case "W":
		ans = "WiCys"
	case "C":
		ans = "CyKor"
	case "A":
		ans = "AlKor"
	case "$":
		ans = "$clear"
	}

	fmt.Fprintln(out, ans)
}
