package com.songhwa.insulin.config;

import org.apache.hc.client5.http.classic.HttpClient;
import org.apache.hc.client5.http.impl.classic.HttpClientBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.http.converter.ByteArrayHttpMessageConverter;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.web.client.RestTemplate;

@Configuration
public class RestTemplateConfig {
	
	@Bean
  public RestTemplate restTemplate() {
    HttpComponentsClientHttpRequestFactory httpRequestFactory = new HttpComponentsClientHttpRequestFactory();
    httpRequestFactory.setConnectTimeout(2000);
    //httpRequestFactory.setReadTimeout(30000);
    HttpClient httpClient = HttpClientBuilder.create().build();
    httpRequestFactory.setHttpClient(httpClient);

    RestTemplate restTemplate = new RestTemplate(httpRequestFactory);
    restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
    restTemplate.getMessageConverters().add(new ByteArrayHttpMessageConverter());
    
    return restTemplate;
  }
}
