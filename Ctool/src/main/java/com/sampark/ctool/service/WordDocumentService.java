package com.sampark.ctool.service;

import java.util.List;

import com.sampark.ctool.entity.WordDocument;
import com.sampark.ctool.object.ResponseObject;

public interface WordDocumentService {

	public List<WordDocument> wordDocumentsList();
	public ResponseObject saveWordDocuments(WordDocument wordDocument);

	public ResponseObject saveWordDocuments(List<WordDocument> wordDocument);
}
