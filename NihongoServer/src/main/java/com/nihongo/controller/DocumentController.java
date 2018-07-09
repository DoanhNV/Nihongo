package com.nihongo.controller;

import static com.nihongo.support.util.EntityUtil.transferObjectTo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nihongo.data.entity.questiondocument.Document;
import com.nihongo.dto.httpdto.request.InsertDocumentRequest;
import com.nihongo.dto.httpdto.response.InsertDocumentResponse;
import com.nihongo.exception.AbstractNihongoException;
import com.nihongo.service.DocumentService;
import com.nihongo.support.constant.ResponseCode;

/**
 * 
 * @author DoanhNV Jul 8, 2018 11:04:21 AM
 */
@RestController
@RequestMapping(value = "/document")
public class DocumentController {
	
	@Autowired
	private DocumentService documentService;
	
	@PostMapping(value = "/create")
	@ResponseBody
	public InsertDocumentResponse create(@RequestBody InsertDocumentRequest request) {
		InsertDocumentResponse response = new InsertDocumentResponse();
		try {
			Document document = new Document();
			transferObjectTo(request, document);
			documentService.insert(document);
			response.setCode(ResponseCode.SUCCESS);
		} catch (AbstractNihongoException e) {
			response.setCodeAndMessage(e.getCode(), e.getMessage());
		} catch (Exception e) {
			response.setCode(ResponseCode.SYSTEM_ERROR);
		}
		return response;
	}
}
