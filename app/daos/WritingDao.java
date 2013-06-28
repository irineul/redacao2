package daos;

import java.util.List;

import models.DocumentoModel;
import models.UserModel;
import models.WritingModel;

public class WritingDao {

	public static WritingDao self;
	
	private WritingDao(){}
	
	public static WritingDao getInstance(){
		if (self == null) {
			self = new WritingDao();
		}
		return self;
	}
	
	public List<WritingModel> findAllWritings(UserModel user) {
		
		//TODO: fazer query por usuario
		List<WritingModel> writings = WritingModel.findAll();
		for(WritingModel wm : writings){
			DocumentoModel dm = DocumentoModel.findById(wm.getDocumentId());
			wm.setDocument(dm);
		}
		return writings;
	}

	
}
