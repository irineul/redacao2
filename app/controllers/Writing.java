package controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import models.WritingModel;
import play.mvc.Controller;

public class Writing extends Controller {

    public static void index() {
    	List<WritingModel> writings = WritingModel.findAll();
    	System.out.println("$$$$$$$$$$$$$$$$"+writings.size());
        render(writings);
    }
    
    
    public static void save() {
    	String title = params.get("title", String.class);
    	File writingFile = params.get("writingFile", File.class);
    	WritingModel w= new WritingModel();
    	w.setTitle(title);
    	w.setWritingFile(writingFile);
    	w.setUploadDate(new Date());
    	w.setScore(0);
    	w.save();
        index();
    }

}