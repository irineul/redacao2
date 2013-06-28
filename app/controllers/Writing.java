package controllers;

import helpers.GeneralHelper;

import java.io.File;
import java.io.FileInputStream;
import java.util.Date;
import java.util.List;

import models.DocumentoModel;
import models.UserModel;
import models.WritingModel;
import play.libs.MimeTypes;
import play.modules.s3blobs.S3Blob;
import play.mvc.Controller;
import daos.WritingDao;

public class Writing extends Controller {

    public static void index() {
    	UserModel user = GeneralHelper.getInstance().getCurrentUser();
    	List<WritingModel> writings =WritingDao.getInstance().findAllWritings(user);
        render(writings);
    }
    
    public static void downloadFile(long id)
	  {
	    DocumentoModel doc = DocumentoModel.findById(id);
	    notFoundIfNull(doc);
	    response.setContentTypeIfNotSet(doc.file.type());
	    renderBinary(doc.file.get());
	  }
    
    public static void save() {
    	
    	try{
	    	String title = params.get("title", String.class);
	    	File file = params.get("writingFile", File.class);
	    	
	    	DocumentoModel dm = new DocumentoModel();
	    	dm.comment=file.getName();
	    	S3Blob s3File = new S3Blob();
	        s3File.set(new FileInputStream(file), MimeTypes.getContentType(file.getName()));
	    	dm.file = s3File;
	    	dm.save();
	    	
	    	WritingModel w= new WritingModel();
	    	w.setDocumentId(dm.getId());
	    	w.setTitle(title);
	    	w.setUploadDate(new Date());
	    	w.setScore(0);
	    	w.save();
    	} catch(Exception e) {
    		e.printStackTrace();
    	}
        index();
    }

}