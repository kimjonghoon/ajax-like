package net.java_school.controller;

import java.io.File;
import java.io.IOException;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import net.java_school.board.AttachFile;
import net.java_school.commons.WebContants;

@RestController
@RequestMapping("/files")
public class FileController {

	@PostMapping
	public void upload(MultipartHttpServletRequest req) throws IOException {
		Iterator<String> iterator = req.getFileNames();

		while (iterator.hasNext()) {
			MultipartFile file = req.getFile((String) iterator.next());

			if (file.getSize() > 0) {
				String filename = file.getOriginalFilename();
				file.transferTo(new File(WebContants.FILE_DIR.value() + filename));
			}
		}
	}

	@GetMapping
	public List<AttachFile> getFilenames() {
		List<AttachFile> attachFiles = new ArrayList<AttachFile>();

		File f = new File(WebContants.FILE_DIR.value());
		File[] files = f.listFiles();

		for (File file : files) {
			if (file.isFile()) {
				AttachFile attachFile = new AttachFile();
				attachFile.setFilename(file.getName());
				attachFile.setDeletable(true);
				attachFiles.add(attachFile);
			}
		}

		return attachFiles;

	}
	
	@DeleteMapping(value="/{filename:.+}")
	public void del(@PathVariable String filename) {
		File file = new File(WebContants.FILE_DIR.value() + filename);
		file.delete();
	}

}