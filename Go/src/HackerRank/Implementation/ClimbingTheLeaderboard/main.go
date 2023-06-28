package main

import (
	"bufio"
	"fmt"
	"io"
	"os"
	"sort"
	"strconv"
	"strings"
)

func add(set map[int32]struct{}, v int32) map[int32]struct{} {
	set[v] = struct{}{}
	return set
}

func contain(set map[int32]struct{}, v int32) bool {
	_, res := set[v]
	return res
}

func BinarySearch(arr []int32, score int32) int32 {
	left := 0
	right := len(arr) - 1
	mid := 0
	var last int32

	for left <= right {
		mid = (left + right) / 2
		last = int32(arr[mid])
		if last > score {
			left = mid + 1
		} else if last == score {
			return int32(mid)
		} else {
			right = mid - 1
		}
	}

	if score < last {
		return int32(mid + 1)
	} else {
		return int32(mid)
	}
}

type foo []int32

func (f foo) Len() int {
	return len(f)
}

func (f foo) Less(i, j int) bool {
	return f[i] > f[j]
}

func (f foo) Swap(i, j int) {
	f[i], f[j] = f[j], f[i]
}

func climbingLeaderboard(ranked []int32, player []int32) []int32 {
	set := make(map[int32]struct{})
	temp := foo{}
	for _, v := range ranked {
		if !contain(set, v) {
			add(set, v)
			temp = append(temp, v)
		}
	}

	sort.Sort(temp)
	var ans []int32
	for _, score := range player {
		ans = append(ans, BinarySearch(temp, score)+1)
	}
	return ans
}

func main() {
	reader := bufio.NewReaderSize(os.Stdin, 16*1024*1024)
	writer := bufio.NewWriter(os.Stdout)
	defer writer.Flush()

	rankedCount, err := strconv.ParseInt(strings.TrimSpace(readLine(reader)), 10, 64)
	checkError(err)

	rankedTemp := strings.Split(strings.TrimSpace(readLine(reader)), " ")

	var ranked []int32

	for i := 0; i < int(rankedCount); i++ {
		rankedItemTemp, err := strconv.ParseInt(rankedTemp[i], 10, 64)
		checkError(err)
		rankedItem := int32(rankedItemTemp)
		ranked = append(ranked, rankedItem)
	}

	playerCount, err := strconv.ParseInt(strings.TrimSpace(readLine(reader)), 10, 64)
	checkError(err)

	playerTemp := strings.Split(strings.TrimSpace(readLine(reader)), " ")

	var player []int32

	for i := 0; i < int(playerCount); i++ {
		playerItemTemp, err := strconv.ParseInt(playerTemp[i], 10, 64)
		checkError(err)
		playerItem := int32(playerItemTemp)
		player = append(player, playerItem)
	}

	result := climbingLeaderboard(ranked, player)
	for _, i := range result {
		fmt.Fprintln(writer, i)
	}
}

func readLine(reader *bufio.Reader) string {
	str, _, err := reader.ReadLine()
	if err == io.EOF {
		return ""
	}

	return strings.TrimRight(string(str), "\r\n")
}

func checkError(err error) {
	if err != nil {
		panic(err)
	}
}
