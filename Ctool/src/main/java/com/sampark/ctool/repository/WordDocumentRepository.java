package com.sampark.ctool.repository;

import java.util.List;

import com.sampark.ctool.entity.WordDocument;

public interface WordDocumentRepository {


	public Boolean saveWordDocuments(WordDocument wordDocuments);

	public Boolean saveWordDocuments(List<WordDocument> wordDocuments);
	public List<WordDocument> wordDocumentsList();
}
