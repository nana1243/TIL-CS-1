package polymorphism;

import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.GenericApplicationContext;

public class TVuser {

	public static void main(String[] args) {
		
		SonySpeaker speaker = new SonySpeaker();

		TV samsungtv = new SamsungTV(speaker);
		TV lgtv = new LgTV();
		
		
		samsungtv.powerOn();
		samsungtv.volumeOn();
		lgtv.powerOff();

		GenericApplicationContext context = new GenericApplicationContext();
		new XmlBeanDefinitionReader(context).loadBeanDefinitions("applicationContext.xml");
		context.refresh();		
		// initmethod�� tv��� ��ü�� �����ɶ� �ҷ����� �Լ�
		
		TV tv = (TV) context.getBean("lgtv");
		tv.powerOff();		
		context.close();

	}

}