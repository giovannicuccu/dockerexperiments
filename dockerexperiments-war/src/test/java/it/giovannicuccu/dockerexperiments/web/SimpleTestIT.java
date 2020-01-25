package it.giovannicuccu.dockerexperiments.web;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import it.giovannicuccu.dockerexperiments.model.Documento;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.List;

public class SimpleTestIT {
    private static final Logger logger= LoggerFactory.getLogger(SimpleTestIT.class.getName());

    private ObjectMapper mapper=new ObjectMapper();
    @Test
    public void testLoadAll() throws Exception {
        RestTemplate restTemplate=new RestTemplate();
        ResponseEntity<String> responseEntity=restTemplate.getForEntity("http://localhost:8080/dockerexperiments/docker/loadalldocumenti/",String.class);
        logger.debug("response={}",responseEntity.getBody());
        List<Documento> documenti=mapper.readValue(responseEntity.getBody(), new TypeReference<List<Documento>>() {});
        Assert.assertEquals(0, documenti.size());
    }

    @Test
    public void testInsert() throws Exception {
        Documento documento=new Documento();
        documento.setId(1L);
        documento.setDescrizione("primo");
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<String> request =
                new HttpEntity<String>(mapper.writeValueAsString(documento), headers);

        RestTemplate restTemplate=new RestTemplate();
        restTemplate.postForEntity("http://localhost:8080/dockerexperiments/docker/insertdocumento/", request, String.class);
        ResponseEntity<String> responseEntity=restTemplate.getForEntity("http://localhost:8080/dockerexperiments/docker/loadalldocumenti/",String.class);
        List<Documento> documenti=mapper.readValue(responseEntity.getBody(), new TypeReference<List<Documento>>() {});
        Assert.assertEquals(1, documenti.size());
    }
}
