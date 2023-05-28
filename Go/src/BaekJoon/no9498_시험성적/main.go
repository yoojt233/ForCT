package main

import (
	"fmt"
)

func main() {
	var score int
	fmt.Scanf("%d", &score)

	switch {
	case score >= 90:
		fmt.Print("A")
	case score >= 80:
		fmt.Print("B")
	case score >= 70:
		fmt.Print("C")
	case score >= 60:
		fmt.Print("D")
	default:
		fmt.Print("F")
	}
}
