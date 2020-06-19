package com.pawan.boot.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.pawan.boot.model.Uom;

public class UomExcelView extends AbstractXlsView {

	@Override
	public void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		@SuppressWarnings("unchecked")
		List<Uom> list = (List<Uom>) model.get("list");
		Sheet sheet = workbook.createSheet("uomsheet");
		setHeader(sheet);
		setBody(sheet, list);

	}

	public void setHeader(Sheet sheet) {

		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("TYPE");
		row.createCell(2).setCellValue("MODEL");
		row.createCell(3).setCellValue("DESCRIPTION");
	}

	public void setBody(Sheet sheet, List<Uom> list) {

		int rowNum = 1;
		for (Uom uom : list) {
			Row row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(uom.getId());
			row.createCell(1).setCellValue(uom.getUmoType());
			row.createCell(2).setCellValue(uom.getUomModel());
			row.createCell(3).setCellValue(uom.getDescription());
		}

	}
}
