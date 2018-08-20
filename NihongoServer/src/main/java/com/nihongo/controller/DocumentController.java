package com.nihongo.controller;

import static com.nihongo.support.util.EntityUtil.castToDocumentObject;
import static com.nihongo.support.util.EntityUtil.transferObjectTo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.nihongo.data.entity.other.transfer.SearchData;
import com.nihongo.data.entity.questiondocument.Document;
import com.nihongo.dto.httpdto.request.DocumentSearchRequest;
import com.nihongo.dto.httpdto.request.InsertDocumentRequest;
import com.nihongo.dto.httpdto.request.UpdateDocumentRequest;
import com.nihongo.dto.httpdto.response.GetDocumentResponse;
import com.nihongo.dto.httpdto.response.InsertDocumentResponse;
import com.nihongo.dto.httpdto.response.UpdateDocumentResponse;
import com.nihongo.exception.AbstractNihongoException;
import com.nihongo.service.data.DocumentService;
import com.nihongo.support.constant.API;
import com.nihongo.support.constant.ResponseCode;

/**
 * 
 * @author DoanhNV Jul 8, 2018 11:04:21 AM
 */
@RestController
@CrossOrigin
@RequestMapping(value = API.DOCUMENT.ROOT)
public class DocumentController {
	
	@Autowired
	private DocumentService documentService;

	@PostMapping(value = API.DOCUMENT.CREATE)
	@ResponseBody
	public InsertDocumentResponse create(@RequestBody InsertDocumentRequest request) {
		InsertDocumentResponse response = new InsertDocumentResponse();
		try {
			Document document = new Document();
			transferObjectTo(request, document);
			String documentId = documentService.insert(document);
			response.setInsertDocumentResponse(ResponseCode.SUCCESS, documentId);
		} catch (AbstractNihongoException e) {
			response.setCodeAndMessage(e.getCode(), e.getMessage());
		} catch (Exception e) {
			response.setCode(ResponseCode.SYSTEM_ERROR);
		}
		return response;
	}
	
	@GetMapping(value = API.DOCUMENT.GET_BY_ID)
	@ResponseBody
	public GetDocumentResponse get(@PathVariable String id) {
		GetDocumentResponse response =  new GetDocumentResponse();
		try {
			Document document = (Document) documentService.getById(id);
			response.setResponseData(ResponseCode.SUCCESS, document);
		} catch (AbstractNihongoException e) {
			response.setCodeAndMessage(e.getCode(), e.getMessage());
		} catch (Exception e) {
			response.setCode(ResponseCode.SYSTEM_ERROR);
		}
		return response;
	}
	
	@PostMapping(value = API.DOCUMENT.SEARCH)
	@ResponseBody
	public DocumentSearchResponse search(@RequestBody DocumentSearchRequest request) {
		DocumentSearchResponse response = new DocumentSearchResponse();
		try {
			SearchData documentData = documentService.search(request);
			List<Document> documents = castToDocumentObject(documentData.getDatas());
			response.setResponseData(ResponseCode.SUCCESS, documentData.getTotal(), documents);
		} catch (AbstractNihongoException e) {
			response.setCodeAndMessage(e.getCode(), e.getMessage());
		} catch (Exception e) {
			e.printStackTrace();
			response.setCode(ResponseCode.SYSTEM_ERROR);
		}
		return response;
	}
	

	@PutMapping(value = API.DOCUMENT.UPDATE)
	@ResponseBody
	public UpdateDocumentResponse update(@RequestBody UpdateDocumentRequest request) {
		UpdateDocumentResponse response = new UpdateDocumentResponse();
		try {
			Document document = new Document();
			transferObjectTo(request, document);
			documentService.update(document);
			response.setCode(ResponseCode.SUCCESS);
		} catch (AbstractNihongoException e) {
			response.setCodeAndMessage(e.getCode(), e.getMessage());
		} catch (Exception e) {
			response.setCode(ResponseCode.SYSTEM_ERROR);
		}
		return response;
	}
}
