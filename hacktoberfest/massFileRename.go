package main

import (
	"fmt"
	"os"
	"regexp"
	"strconv"
	"strings"
)

func main() {

	listArg := os.Args[1:]
	renameTo := ""

	for _, args := range listArg {
		renameTo += "_" + args
	}
	renameTo = renameTo[1:]

	if checkVaildFileName(renameTo) {

		files, err := os.ReadDir(".")
		path, _ := os.Getwd()

		if err != nil {
			fmt.Println(err)
		}
		count := 0
		for _, file := range files {
			if file.Type().IsRegular() {

				oldPath := path + "\\" + file.Name()
				lastIndex := strings.LastIndex(file.Name(), ".")
				if lastIndex == -1 {
					newPath := path + "\\" + renameTo + "_" + strconv.Itoa(count)
					os.Rename(oldPath, newPath)

				} else {

					extension := file.Name()[lastIndex:]
					newPath := path + "\\" + renameTo + "_" + strconv.Itoa(count) + extension
					os.Rename(oldPath, newPath)

				}

				count++
			}
		}
	}

}

func checkVaildFileName(fileName string) bool {
	regex := `^([a-zA-Z0-9\s\._-]+)$`
	match, _ := regexp.MatchString(regex, fileName)

	return match
}
