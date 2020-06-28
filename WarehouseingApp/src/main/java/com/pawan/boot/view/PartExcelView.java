package com.pawan.boot.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.pawan.boot.model.Part;
@Component
public class PartExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		@SuppressWarnings("unchecked")
		List<Part> list = (List<Part>) model.get("list");

		Sheet sheet = workbook.createSheet("partsheet");
		setHeader(sheet);
		setBody(sheet,list);

	}

	private void setBody(Sheet sheet, List<Part> list) {
		int rowNum=1;


		for(Part part:list) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(part.getId());
			row.createCell(1).setCellValue(part.getPartCode());
			row.createCell(2).setCellValue(part.getPartWdth());
			row.createCell(3).setCellValue(part.getPartLen());
			row.createCell(4).setCellValue(part.getPartHgh());
			row.createCell(5).setCellValue(part.getBaseCost());
			row.createCell(6).setCellValue(part.getBaseCurr());
			row.createCell(7).setCellValue(part.getDescription());

		}


	}

	private void setHeader(Sheet sheet) {
		Row row=sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("CODE");
		row.createCell(2).setCellValue("WIDTH");
		row.createCell(3).setCellValue("LENGTH");
		row.createCell(4).setCellValue("HEIGHT");
		row.createCell(5).setCellValue("BASE COST");
		row.createCell(6).setCellValue("BASE CURRENECY");
		row.createCell(7).setCellValue("DESCRIPTION");

	}
}
