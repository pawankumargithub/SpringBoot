package com.pawan.boot.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsView;

import com.pawan.boot.model.OrderMethod;

public class OrderMethodExcelView extends AbstractXlsView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		@SuppressWarnings("unchecked")
		List<OrderMethod> list = (List<OrderMethod>) model.get("list");
		Sheet sheet = workbook.createSheet("ordermethod");
		setHead(sheet);
		setBody(sheet, list);

	}

	public void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("MODE");
		row.createCell(2).setCellValue("CODE");
		row.createCell(3).setCellValue("TYPE");
		row.createCell(4).setCellValue("ACCEPT");
		row.createCell(5).setCellValue("DESCRIPTION");

	}

	public void setBody(Sheet sheet, List<OrderMethod> list) {
		int rowCount = 1;
		for (OrderMethod orderMethod : list) {
			Row row = sheet.createRow(rowCount++);
			row.createCell(0).setCellValue(orderMethod.getId());
			row.createCell(1).setCellValue(orderMethod.getOrderMode());
			row.createCell(2).setCellValue(orderMethod.getOrderCode());
			row.createCell(3).setCellValue(orderMethod.getOrderType());
			row.createCell(4).setCellValue(orderMethod.getOrderAccept().toString());
			row.createCell(5).setCellValue(orderMethod.getDescription());
		}

	}
}
