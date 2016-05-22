package spring_boot;

import java.util.Map;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@EnableAutoConfiguration
public class Hello {
	
	private String myAppId="appId";
	private String myAppSecret="appSecret";

	@RequestMapping("/webhook")
	public String home(@RequestHeader Map<String, String> header, @RequestBody String contentBody) {
		if(WebHookUtil.checkAuth(myAppId, myAppSecret, contentBody, header)){
			System.out.println("���յ�һ���Ϸ����ͣ�����Ϊ�� "+contentBody);
			//�������͵��߼�д������
			//.....
		}else{
			System.out.println("���յ�һ���Ƿ�����");
		}
		
		return "ok";
	}

	public static void main(String[] args) {
		SpringApplication.run(Hello.class, args);
	}
}
