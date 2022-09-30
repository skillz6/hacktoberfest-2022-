package main

import (
	"fmt"
	"os"
	"strings"
)

func main() {
	sortFilesAccordingExt()
}
func sortFilesAccordingExt() {
	
	files, _ := os.ReadDir(".")
	createFolders()

	for _, file := range files {
		if file.Type().IsRegular() {
			name := file.Name()
			ext := name[strings.LastIndex(name, "."):]
			if isCompressed(ext) {
				moveFile(name, "Compressed")
			} else if isAudio(ext) {
				moveFile(name, "Media")
			} else if isImage(ext) {
				moveFile(name, "Images")
			} else if isDocument(ext) {
				moveFile(name, "Documents")
			} else if isProgram(ext) {
				moveFile(name, "Programs")
			} else if isVideo(ext) {
				moveFile(name, "Media")
			} else {
				moveFile(name, "Others")
			}
		}
	}
	removeEmptyFolders()
}

func createFolders() {
	var folderType = []string{
		"Documents",
		"Images",
		"Media",
		"Compressed",
		"Programs",
		"Others",
	}
	for _, folder := range folderType {
		os.Mkdir(folder, 0777)
	}

}
func moveFile(filename string, folder string) {

	currentPath, _ := os.Getwd()
	from := currentPath + "/" + filename
	to := currentPath + "/" + folder + "/" + filename
	os.Rename(from, to)

}

func removeEmptyFolders() {

	files, err := os.ReadDir(".")
	if err != nil {
		fmt.Println(err)
	}
	for _, file := range files {

		size, _ := getSizeOfFolder(file.Name())
		if err != nil {
			return
		}
		if size == 0 {
			os.Remove(file.Name())

		}

	}

}

func getSizeOfFolder(name string) (int64, error) {

	currentPath, _ := os.Getwd()

	os.Chdir("./" + name)
	files, err := os.ReadDir(".")
	if err != nil {
		fmt.Println(err)
		return 0, err
	}
	var size int64
	for _, file := range files {
		info, e := file.Info()
		if e != nil {
			fmt.Println(e)
		}
		size += info.Size()
	}
	os.Chdir(currentPath)
	return size, err

}
func isProgram(name string) bool {

	programExt := map[string]bool{
		".exe":    true,
		".msi":    true,
		".apk":    true,
		".bat":    true,
		".bin":    true,
		".cgi":    true,
		".pl":     true,
		".com":    true,
		".gadget": true,
		".jar":    true,
		".wsf":    true,
		".msp":    true,
		".msu":    true,
		".py":     true,
		".sh":     true,
		".vb":     true,
		".vbs":    true,
		".c":      true,
		".class":  true,
		".cpp":    true,
		".cs":     true,
		".h":      true,
		".java":   true,
		".php":    true,
		".ps1":    true,
		".psm1":   true,
		".rb":     true,
		".swift":  true,
		".go":     true,
		".war":    true,
		".ear":    true,
		".sar":    true,
		".xap":    true,
		".html":   true,
		".htm":    true,
		".xhtml":  true,
		".asp":    true,
		".aspx":   true,
		".cer":    true,
		".cfm":    true,
		".csr":    true,
		".css":    true,
		".dcr":    true,
		".der":    true,
		".dhtml":  true,
		".dll":    true,
		".dmg":    true,
		".dot":    true,
		".dotx":   true,
		".js":     true,
		".jsp":    true,
		".key":    true,
		".lnk":    true,
		".mdb":    true,
		".pem":    true,
		".pfx":    true,
		".prf":    true,
		".ps":     true,
		".reg":    true,
		".rss":    true,
		".scr":    true,
		".sct":    true,
		".shb":    true,
		".shtml":  true,
		".soap":   true,
		".stm":    true,
		".mod":    true,
		".dart":   true,
		".kt":     true,
		".json":   true,
		".lock":   true,
		".log":    true,
		".md":     true,
		".pyc":    true,
		".pyo":    true,
		".r":      true,
		".rdb":    true,
		".rds":    true,
		".rmd":    true,
		".rproj":  true,
		".rpy":    true,
		".rsh":    true,
		".sas":    true,
	}

	return programExt[name]

}

func isAudio(name string) bool {

	audioExt := map[string]bool{
		".aac":   true,
		".aa":    true,
		".aax":   true,
		".act":   true,
		".aiff":  true,
		".amr":   true,
		".ape":   true,
		".au":    true,
		".awb":   true,
		".dct":   true,
		".dss":   true,
		".dvf":   true,
		".flac":  true,
		".gsm":   true,
		".iklax": true,
		".ivs":   true,
		".m4a":   true,
		".m4b":   true,
		".m4p":   true,
		".mmf":   true,
		".mp3":   true,
		".mpc":   true,
		".msv":   true,
		".nmf":   true,
	}
	return audioExt[name]
}

func isCompressed(name string) bool {

	compressedExt := map[string]bool{
		".7z":     true,
		".arj":    true,
		".deb":    true,
		".pkg":    true,
		".rar":    true,
		".rpm":    true,
		".tar.gz": true,
		".z":      true,
		".zip":    true,
	}

	return compressedExt[name]
}

func isDocument(name string) bool {

	documentExt := map[string]bool{
		".doc":   true,
		".docx":  true,
		".pdf":   true,
		".xls":   true,
		".xlsx":  true,
		".ppt":   true,
		".pptx":  true,
		".odt":   true,
		".ods":   true,
		".odp":   true,
		".txt":   true,
		".rtf":   true,
		".tex":   true,
		".wks":   true,
		".wps":   true,
		".wpd":   true,
		".csv":   true,
		".xml":   true,
		".html":  true,
		".htm":   true,
		".xhtml": true,
		".epub":  true,
		".md":    true,
	}

	return documentExt[name]
}

func isVideo(name string) bool {

	videoExt := map[string]bool{
		".mp4":  true,
		".mkv":  true,
		".webm": true,
		".flv":  true,
		".vob":  true,
		".ogv":  true,
		".ogg":  true,
		".drc":  true,
		".gifv": true,
		".mng":  true,
		".avi":  true,
	}

	return videoExt[name]
}

func isImage(name string) bool {

	imageExt := map[string]bool{
		".jpg":  true,
		".png":  true,
		".gif":  true,
		".jpeg": true,
		".svg":  true,
		".bmp":  true,
		".tiff": true,
		".psd":  true,
		".raw":  true,
		".heif": true,
		".indd": true,
		".ai":   true,
		".eps":  true,
		".ps":   true,
	}

	return imageExt[name]
}
