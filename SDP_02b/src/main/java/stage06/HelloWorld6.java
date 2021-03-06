package stage06;


/**
 * Using a Spring Factory instead of our homebuilt factory
 * 
 */
import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.support.DefaultListableBeanFactory;
import org.springframework.beans.factory.support.PropertiesBeanDefinitionReader;



public class HelloWorld6 {

	public static void main(String[] args) throws Exception {
		
		BeanFactory myBeanfactory = getMyBeanFactory();
		
		MessageProvider mp = (MessageProvider)myBeanfactory.getBean("provider");
		MessageRenderer mr = (MessageRenderer) myBeanfactory.getBean("renderer");
		
		mr.setMessageProvider(mp);
		mr.render();

	}
	
	// Default bean Factory
	// the def reader obj connects the factory to the file 
	public static BeanFactory getMyBeanFactory() throws Exception{
		
		// Config the Dependency File
		Properties props = new Properties();
		File beanFile = new File("src/main/resources/bean.properties");
		System.out.println("Does the File Exist: " + beanFile.exists());
		props.load(new FileInputStream(beanFile)); // load the props file
		
		// Make a Default Factory
		DefaultListableBeanFactory factory = new DefaultListableBeanFactory();  
		
		// Make a Definition Reader that connects to the factory (Wiring)
		PropertiesBeanDefinitionReader defReader = new PropertiesBeanDefinitionReader(factory);
		
		// NOW Connect the Definition Reader to the Dependency File (Wiring)
		defReader.registerBeanDefinitions(props);
		
		// return the factory
		return factory;  
			
	}

}
