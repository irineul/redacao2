package models;

import java.io.File;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;

import play.db.jpa.Model;

@Entity(name="WRITINGS")
public class WritingModel extends Model{

	@Column(name="TITLE")
	private String title;
	
	@Column(name="SCORE")
	private int score;
	
	@Column(name="FILE")
	private File writingFile;
	
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

	public File getWritingFile() {
		return writingFile;
	}

	public void setWritingFile(File writingFile) {
		this.writingFile = writingFile;
	}

	public Date getUploadDate() {
		return uploadDate;
	}

	public void setUploadDate(Date uploadDate) {
		this.uploadDate = uploadDate;
	}
	
}
