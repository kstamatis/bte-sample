package gr.ekt.btesample;

import java.util.Date;

import org.springframework.context.support.ClassPathXmlApplicationContext;

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
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext(confFile);

		TransformationEngine te = (TransformationEngine) context.getBean("transformationEngine");
			
		try {
			TransformationSpec tspec = (TransformationSpec) context.getBean("transformationSpec");
			te.transform(tspec);
		} catch (BadTransformationSpec e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }
}
