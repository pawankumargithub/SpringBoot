package com.pawan.boot.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.pawan.boot.model.WhUserType;

public class WhUserTypeExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		
	@SuppressWarnings("unchecked")
	List<WhUserType> list=	(List<WhUserType>) model.get("list");
	 
	      Sheet sheet=workbook.createSheet("whusertype");
	      setHead(sheet);
	      setBody(sheet,list);
	}

	

	



	private void setHead(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("USER TYPE");
		row.createCell(2).setCellValue("USER CODE");
		row.createCell(3).setCellValue("USER FOR");
		row.createCell(4).setCellValue("USER MAIL");
		row.createCell(5).setCellValue("USER CONTACT");
		row.createCell(6).setCellValue("USER ID");
		row.createCell(7).setCellValue("ID NUMBER");
		
	}
	private void setBody(Sheet sheet, List<WhUserType> list) {
		int rowCount=1;
		
		for (WhUserType whUserType : list) {
			
			Row row=sheet.createRow(rowCount++);
			row.createCell(0).setCellValue(whUserType.getId());
			row.createCell(1).setCellValue(whUserType.getUserType());
			row.createCell(2).setCellValue(whUserType.getUserCode());
			row.createCell(3).setCellValue(whUserType.getUserFor());
			row.createCell(4).setCellValue(whUserType.getUserEmail());
			row.createCell(5).setCellValue(whUserType.getUserContact());
			row.createCell(6).setCellValue(whUserType.getUserIdType());
			row.createCell(7).setCellValue(whUserType.getIdNumber());
		}
		
	}
	
}
