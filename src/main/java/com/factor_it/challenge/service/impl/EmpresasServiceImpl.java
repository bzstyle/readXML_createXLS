package com.factor_it.challenge.service.impl;

import com.factor_it.challenge.dto.EmpresasDto;
import com.factor_it.challenge.model.Empresa;
import com.factor_it.challenge.model.Movimiento;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;

import java.io.*;
import java.util.List;

@Service
public class EmpresasServiceImpl {



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

    public ByteArrayInputStream ReadXmlEmpresas() throws IOException , Exception{

        Workbook workbook = new HSSFWorkbook();


        File file = new File("src/main/resources/Examen-FIT.xml");
        XmlMapper xmlMapper = new XmlMapper();
        String xml = inputStreamToString(new FileInputStream(file));

        EmpresasDto value = xmlMapper.readValue(xml, EmpresasDto.class);

        ByteArrayOutputStream out = new ByteArrayOutputStream();

        Sheet hojaEmpresa = workbook.createSheet("empresas");
        Sheet hojaMovimiento = workbook.createSheet("movimientos");

        List<Empresa> empresas = value.getEmpresa();

        String[] columnaEmpr = {"NroContrato","Cuit","Denominacion","Domicilio","CodigoPostal","FechaDesdeNov",
                                        "FechaHastaNov","Organizador","Productor","Ciiu"};

        String[] columnaMovi = {"SaldoCtaCte","Tipo","CodigoMovimiento","Concepto","Importe"};


        Row rowE = hojaEmpresa.createRow(0);
        Row rowM = hojaMovimiento.createRow(0);

                for (int i =0 ; i< columnaEmpr.length; i++ ){
                    Cell cell = rowE.createCell(i);
                    cell.setCellValue(columnaEmpr[i]);
                }
                for (int i =0 ; i< columnaMovi.length; i++ ){
                    Cell cell = rowM.createCell(i);
                    cell.setCellValue(columnaMovi[i]);
                }

            int a=1;
            for(Empresa empresa : empresas){
                int i = 0;
                List<Movimiento> movimientos = empresa.getMovimientos();
                Movimiento movimiento = movimientos.get(0);

                rowE = hojaEmpresa.createRow(a);
                rowE.createCell(i).setCellValue(empresa.getNroContrato());
                i++;
                rowE.createCell(i).setCellValue(empresa.getCuit());
                i++;
                rowE.createCell(i).setCellValue(empresa.getDenominacion());
                i++;
                rowE.createCell(i).setCellValue(empresa.getDomicilio());
                i++;
                rowE.createCell(i).setCellValue(empresa.getCodigoPostal());
                i++;
                rowE.createCell(i).setCellValue(empresa.getFechaDesdeNov());
                i++;
                rowE.createCell(i).setCellValue(empresa.getFechaHastaNov());
                i++;
                rowE.createCell(i).setCellValue(empresa.getOrganizador());
                i++;
                rowE.createCell(i).setCellValue(empresa.getProductor());
                i++;
                rowE.createCell(i).setCellValue(empresa.getCiiu());
                i=0;

                rowM = hojaMovimiento.createRow(a);
                rowM.createCell(i).setCellValue(movimiento.getSaldoCtaCte());
                i++;
                rowM.createCell(i).setCellValue(movimiento.getTipo());
                i++;
                rowM.createCell(i).setCellValue(movimiento.getCodigoMovimiento());
                i++;
                rowM.createCell(i).setCellValue(movimiento.getConcepto());
                i++;
                rowM.createCell(i).setCellValue(movimiento.getImporte());
                a++;

        }

        workbook.write(out);
        workbook.close();

                return new ByteArrayInputStream(out.toByteArray());
    }






}
