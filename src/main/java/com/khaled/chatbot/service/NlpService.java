package com.khaled.chatbot.service;

import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Service;

import com.mayabot.mynlp.fasttext.FastText;
import com.mayabot.mynlp.fasttext.FloatStringPair;

@Service
public class NlpService {
	
	

	public int get_text_lang(String txt) {
		if(txt != null) {
		    ClassLoader classLoader = getClass().getClassLoader();
		    URL resource = classLoader.getResource("lid.176.bin");
		  //  Path resource = Paths.get("D:\\fasttextmodels\\lid.176.bin");
	 
		try {
			FastText fastText = FastText.loadFasttextBinModel(resource.getPath()) ;
			List<FloatStringPair> predict = fastText.predict(Arrays.asList(txt.split(",")), 1);
 			if(predict.get(0).second.contains("ar")) {
			return 1;	
			}
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		}
	return 0;
	}

}
