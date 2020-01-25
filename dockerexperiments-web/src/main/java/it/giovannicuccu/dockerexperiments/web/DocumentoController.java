package it.giovannicuccu.dockerexperiments.web;

import it.giovannicuccu.dockerexperiments.model.Documento;
import it.giovannicuccu.dockerexperiments.repository.DocumentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@Controller
public class DocumentoController {

    @Autowired
    private DocumentoRepository documentoRepository;


    @PostMapping("insertdocumento")
    public void insertDocumento(@RequestBody Documento documento, HttpServletResponse response) {
        documentoRepository.insertDocumento(documento);
    }

    @GetMapping("loadalldocumenti")
    @ResponseBody
    public List<Documento> loadAllDocumenti() {
        return documentoRepository.loadAllDocumenti();
    }
}
