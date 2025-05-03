package net.java_school.controller;

import java.io.File;
import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

import java.io.IOException;

import java.util.Iterator;
import java.util.List;
import java.util.ArrayList;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import net.java_school.board.AttachFile;
import net.java_school.commons.WebContants;

@RestController
@RequestMapping("files")
public class FileController {

	@PostMapping
	public void upload(@RequestParam(name="attach") MultipartFile attach) throws IOException {
		if (!attach.isEmpty()) {
			String filename = attach.getOriginalFilename();
			File dir = new File(WebContants.FILE_DIR.value());
			if (!dir.exists()) dir.mkdirs();
			Path path = Paths.get(WebContants.FILE_DIR.value());
			try (InputStream inputStream = attach.getInputStream()) {
				Files.copy(inputStream, path.resolve(attach.getOriginalFilename()),
						StandardCopyOption.REPLACE_EXISTING);
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
	
	@DeleteMapping(value="{filename:.+}")
	public void del(@PathVariable(name="filename") String filename) {
		File file = new File(WebContants.FILE_DIR.value() + filename);
		file.delete();
	}

}