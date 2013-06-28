package models;

import java.io.File;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Transient;

import play.db.jpa.Model;

@Entity(name="WRITINGS")
public class WritingModel extends Model{

	@Column(name="TITLE")
	private String title;
	
	@Column(name="SCORE")
	private int score;
	
	@Column(name="ID_DOCUMENT")
	private Long documentId;
	
	@Transient
	private DocumentoModel document;
	
	@Column(name="UPLOAD_DATE")
	private Date uploadDate;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}

	public Long getDocumentId() {
		return documentId;
	}

	public void setDocumentId(Long documentId) {
		this.documentId = documentId;
	}

	public DocumentoModel getDocument() {
		return document;
	}

	public void setDocument(DocumentoModel document) {
		this.document = document;
	}
}
