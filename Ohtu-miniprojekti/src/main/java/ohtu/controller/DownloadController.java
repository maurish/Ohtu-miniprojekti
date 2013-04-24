/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ohtu.controller;

import ohtu.service.BibtexService;
import ohtu.service.ReferenceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 *
 * @author annisall
 */
@Controller
public class DownloadController {

    @Autowired
    BibtexService bibtex;
    @Autowired
    ReferenceService references;

    private ResponseEntity<byte[]> fileDownload(String content) {
        byte[] bytes = content.getBytes();
        HttpHeaders headers = new HttpHeaders();
        headers.setContentLength(bytes.length);
        headers.set("Content-Disposition", "attachment; filename=\"list" + System.currentTimeMillis() + ".BIB\"");
        headers.setContentType(MediaType.parseMediaType("text/plain"));
        return new ResponseEntity<byte[]>(bytes, headers, HttpStatus.OK);
    }

    @RequestMapping(value = "downloadIds/{id}")
    public ResponseEntity<byte[]> downloadAttachmentByIds(@PathVariable("id") Long... ids) {
        String content = bibtex.generateString(references.findByIds(ids));
        return fileDownload(content);
    }

    @RequestMapping(value = "downloadBibtex", method = RequestMethod.GET)
    public ResponseEntity<byte[]> downloadAttachment() {
        String content = bibtex.generateString(references.listAll());
        return fileDownload(content);
    }
}
