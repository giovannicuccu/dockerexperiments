package it.giovannicuccu.dockerexperiments.repository;

import it.giovannicuccu.dockerexperiments.dao.DocumentoDao;
import it.giovannicuccu.dockerexperiments.model.Documento;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public class DocumentoRepository {

    private static Logger logger= LoggerFactory.getLogger(DocumentoRepository.class.getName());

    private DocumentoDao documentoDao;

    public void insertDocumento(Documento documento) {

        logger.debug("inserting documento {}", documento);
        documentoDao.insert(documento);
    }

    public List<Documento> loadAllDocumenti() {
        return documentoDao.loadAll();
    }

    public DocumentoDao getDocumentoDao() {
        return documentoDao;
    }

    public void setDocumentoDao(DocumentoDao documentoDao) {
        this.documentoDao = documentoDao;
    }
}
