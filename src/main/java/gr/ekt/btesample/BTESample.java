package gr.ekt.btesample;

import org.springframework.context.support.FileSystemXmlApplicationContext;

import gr.ekt.bte.core.TransformationEngine;
import gr.ekt.bte.core.TransformationSpec;
import gr.ekt.bte.exceptions.BadTransformationSpec;


/**
 * Hello world!
 *
 */
public class BTESample 
{
    public static void main( String[] args )
    {
    	String confFile = args[0]; 
		
    	FileSystemXmlApplicationContext context = new FileSystemXmlApplicationContext(confFile);
		
		TransformationEngine te = (TransformationEngine) context.getBean("transformationEngine");
			
		try {
			TransformationSpec tspec = (TransformationSpec) context.getBean("transformationSpec");
			te.transform(tspec);
		} catch (BadTransformationSpec e) {
			e.printStackTrace();
		} finally {
		    if (context != null)
		    	context.close();
		}

    }
}
