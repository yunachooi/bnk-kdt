package com.example.ai_rag.config;

import java.util.List;

import org.springframework.ai.document.Document;
import org.springframework.ai.reader.ExtractedTextFormatter;
import org.springframework.ai.reader.pdf.PagePdfDocumentReader;
import org.springframework.ai.reader.pdf.config.PdfDocumentReaderConfig;
import org.springframework.ai.transformer.splitter.TokenTextSplitter;
import org.springframework.ai.vectorstore.VectorStore;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.Resource;

import jakarta.annotation.PostConstruct;

@Configuration
public class DataLoader {
	//PDF 문서 준비
	@Value ("classpath:/pdf/상품개요.pdf")
	private Resource pdfResource;
	//임베딩 후 저장할 저장소
	@Autowired
	private VectorStore vectorStore;
	//임베딩
	@PostConstruct
	public void init() {
		PdfDocumentReaderConfig config = PdfDocumentReaderConfig.builder()
				.withPageTopMargin(0)
				.withPageExtractedTextFormatter(
						ExtractedTextFormatter.builder()
							.withNumberOfTopTextLinesToDelete(0) //추출된 텍스트 그대로 유지
							.build()
				)
				.withPagesPerDocument(1) //페이지 별로 분할
				.build();
	
		//.. 문서 로드
		PagePdfDocumentReader pdfReader = new PagePdfDocumentReader(pdfResource, config);
		List<Document> documents = pdfReader.get();
		//.. 문서 분할
		TokenTextSplitter splitter = new TokenTextSplitter(1000, 400, 10, 5000, true);
														//청크크기 중첩 최소  최대  문장 끝 구분자 유지
		List<Document> chunks = splitter.apply(documents);
		//.. 임베딩
		vectorStore.accept(chunks); //청크화 된 Document들을 벡터로 변환하여 저장소
		//.. 저장
		System.out.println("문서 저장 완료!");
	}
}
