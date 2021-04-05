package com.spring.test.controller;

import java.io.File;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.spring.test.entity.ExhibitonInfo;
import com.spring.test.entity.FileInfo;
import com.spring.test.repository.ExhibitonInfoRepository;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class ExhibitonInfoController {

	@Autowired
	private ExhibitonInfoRepository eiRepo;
	private final static String ROOT = "C:\\simstudy\\workspace\\aws-sb\\src\\main\\webapp\\resources\\";
	
	@PostMapping("/exhibition")
	public @ResponseBody int insert(ExhibitonInfo ei) throws Exception {
		log.info("ei=>{}",ei);
		FileInfo fileInfo = ei.getFileInfo();
		String fiName = fileInfo.getFiFile().getOriginalFilename();
		if(fiName==null) {
			throw new Exception("파일은 필수 항목입니다!");
		}
		int idx = fiName.lastIndexOf(".");
		String extName = fiName.substring(idx);
		String path = ROOT + System.nanoTime() + extName;
		fileInfo.setFiName(fiName);
		fileInfo.setFiPath(path);

		eiRepo.save(ei);
		File f = new File(path);
		fileInfo.getFiFile().transferTo(f);
		log.info("fileInfo=>{}", fileInfo);	
		return ei.getEiNum();
	}
}