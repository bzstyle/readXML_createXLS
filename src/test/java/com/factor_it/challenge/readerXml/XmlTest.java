package com.factor_it.challenge.readerXml;


import com.factor_it.challenge.dto.EmpresasDto;
import com.factor_it.challenge.model.*;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;  //jackson data format para leer archivo xml u otros
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.io.*;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@ExtendWith(SpringExtension.class)
@SpringBootTest
@ActiveProfiles("test")
class XmlTest {



    public String inputStreamToString(InputStream is) throws IOException {
        StringBuilder sb = new StringBuilder();
        String line;
        BufferedReader br = new BufferedReader(new InputStreamReader(is));
        while ((line = br.readLine()) != null) {
            sb.append(line);
        }
        br.close();
        return sb.toString();
    }



    @Test
    public void ReadXmlEmpresas() throws IOException {

        File file = new File("src/main/resources/Examen-FIT.xml");
        XmlMapper xmlMapper = new XmlMapper();
        String xml = inputStreamToString(new FileInputStream(file));

        EmpresasDto value = xmlMapper.readValue(xml, EmpresasDto.class);

        value.getEmpresa();



    }
}