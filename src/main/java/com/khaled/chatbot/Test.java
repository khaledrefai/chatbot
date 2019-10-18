package com.khaled.chatbot;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.List;

import com.mayabot.mynlp.fasttext.*;

public class Test {
 
	private String loadUsingClassMethod()  {
		try {
	    ClassLoader classLoader = getClass().getClassLoader();
	    //URL resource = classLoader.getResource("lid.176.bin");
	    Path resource = Paths.get("D:\\fasttextmodels\\cc.ar.300.vec");
	    System.out.println(resource);
	      return resource.toString();
		}catch (Exception e) {
			e.printStackTrace();
			return "";
		}
	}
	
		
	public static void main(String[] args) throws Exception {
		Test t = new  Test();
		FastText fastText = FastText.loadFasttextBinModel(t.loadUsingClassMethod()) ;
		//FastText quantizerFastText = FastText.quantize(fastText,2,false);

				List<FloatStringPair> predict = fastText.predict(Arrays.asList("السلام عليكم".split(" ")), 1);

   for( FloatStringPair s : predict)
	   System.out.println(s);
   System.out.println("------------------------");
  
   					predict = fastText.predict(Arrays.asList("hello".split(" ")), 1);

	   for( FloatStringPair s : predict)
		   System.out.println(s);
	   

	}

}
