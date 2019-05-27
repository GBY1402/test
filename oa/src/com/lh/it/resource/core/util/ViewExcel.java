package com.lh.it.resource.core.util;

import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFDataFormat;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.Cell;
import org.springframework.web.servlet.view.document.AbstractExcelView;

import com.lh.it.resource.core.entity.Employee;
/**
 * 员工信息导出Excel模板
 * @author hejie
 *
 */
public class ViewExcel extends AbstractExcelView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			HSSFWorkbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		Iterable<Employee> object = (Iterable<Employee>) model.get("list");
		String excelName = "用户信息.xls";
		/**
		 * 判断浏览器类型,处理文件名乱码
		 */
		if (request.getHeader("User-Agent").toLowerCase().indexOf("firefox") > 0)
			excelName = new String(excelName.getBytes("UTF-8"), "ISO8859-1");// firefox浏览器
		else if (request.getHeader("User-Agent").toUpperCase().indexOf("MSIE") > 0)
			excelName = URLEncoder.encode(excelName, "UTF-8");// IE浏览器
		else if(request.getHeader("User-Agent").toUpperCase().indexOf("CHROME") > 0)
			excelName = URLEncoder.encode(excelName, "UTF-8"); //google

		// 设置response方式,使执行此controller时候自动出现下载页面,而非直接使用excel打开
		response.setContentType("APPLICATION/OCTET-STREAM;charset=UTF-8");
		response.setHeader("Content-Disposition", "attachment; filename="
				+ excelName);

		// 产生Excel表头
		HSSFSheet sheet = workbook.createSheet("员工信息表");
		HSSFRow header = sheet.createRow(0); // 第0行

		// 产生标题列
		header.createCell(0).setCellValue("工号");
		header.createCell(1).setCellValue("姓名");
		header.createCell(2).setCellValue("性别");
		header.createCell(3).setCellValue("合同编号 ");
		header.createCell(4).setCellValue("合同开始时间");
		header.createCell(5).setCellValue("合同终止时间");
		header.createCell(6).setCellValue("年龄");
		header.createCell(7).setCellValue("部门");
		header.createCell(8).setCellValue("岗位");
		header.createCell(9).setCellValue("技能");
		header.createCell(10).setCellValue("学历");
		header.createCell(11).setCellValue("入职时间");
		header.createCell(12).setCellValue("是否转正");
		header.createCell(13).setCellValue("转正时间");
		header.createCell(14).setCellValue("年假");
		header.createCell(15).setCellValue("联系方式");
		header.createCell(16).setCellValue("身份证号");
		header.createCell(17).setCellValue("毕业院校");
		header.createCell(18).setCellValue("出生年月");
		header.createCell(19).setCellValue("婚姻状况");
		header.createCell(20).setCellValue("户口所在地");
		header.createCell(21).setCellValue("家庭地址");
		header.createCell(22).setCellValue("紧急联络人");
		header.createCell(23).setCellValue("紧急联络人电话");
		header.createCell(24).setCellValue("招聘渠道");
		header.createCell(25).setCellValue("状态");
		HSSFCellStyle cellStyle = workbook.createCellStyle();
		cellStyle.setDataFormat(HSSFDataFormat.getBuiltinFormat("mm/dd/yyyy"));
		// 填充数据
		int rowNum = 1;
		for (Iterator iter = object.iterator(); iter.hasNext();) {
			Employee element = (Employee) iter.next();
			HSSFRow row = sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(element.getJobnum());
			row.createCell(1).setCellValue(element.getName());
			row.createCell(2).setCellValue(element.getSex() == null ? "" : (element.getSex()==1?"男":"女"));
			row.createCell(3).setCellValue(element.getContractid());// 合同编号
			row.createCell(4).setCellValue(element.getContractstarttime()!=null?(DateUtils.formatDate(element.getContractstarttime()) + ""):"");
			row.getCell(4).setCellStyle(cellStyle);
			row.createCell(5).setCellValue(element.getContractendtime()!=null?(DateUtils.formatDate(element.getContractendtime()) + ""):"");
			row.getCell(5).setCellStyle(cellStyle);
			row.createCell(6).setCellValue(element.getAge() == null ? "" : element.getAge() + "");
			row.createCell(7).setCellValue(element.getOrganization().getName() == null ? "" : element.getOrganization().getName() + "");
			row.createCell(8).setCellValue(element.getJob());
			row.createCell(9).setCellValue(element.getSkill());// 技能
			row.createCell(10).setCellValue(element.getEducationColl().getInfo());// 学历
			row.createCell(11).setCellValue(element.getEntrytime()!=null?(DateUtils.formatDate(element.getEntrytime()) + ""):"");// 入职时间
			row.getCell(11).setCellStyle(cellStyle);
			row.createCell(12).setCellValue(element.getIsorregular() == null ? "" : (element.getIsorregular()==1?"是":"否"));// 是否转正
			row.createCell(13).setCellValue(element.getRegulartime()!=null?(DateUtils.formatDate(element.getRegulartime()) + ""):"");// 转正时间
			row.getCell(13).setCellStyle(cellStyle);
			row.createCell(14).setCellValue(element.getIsyearleave() == null ? "" : (element.getIsyearleave()==1?"有":"无"));// 年假
			row.createCell(15).setCellValue(element.getPhone());
			row.createCell(16).setCellValue(element.getCardid());
			row.createCell(17).setCellValue(element.getToschool());
			row.createCell(18).setCellValue(element.getBirthday()!=null?(DateUtils.formatDate(element.getBirthday())+ ""):"");
			row.getCell(18).setCellStyle(cellStyle);
			row.createCell(19).setCellValue(element.getMaritalstatus() == null ? "" : (element.getMaritalstatus()==1?"未婚":"已婚"));// 婚姻状况
			row.createCell(20).setCellValue(element.getDomicileplace());// 户口所在地
			row.createCell(21).setCellValue(element.getHomeaddress());
			row.createCell(22).setCellValue(element.getEmergencyContact());// 紧急联络人
			row.createCell(23).setCellValue(element.getEmergencyContactphone());
			row.createCell(24).setCellValue(element.getRecruitmentChannel().getInfo());
			row.createCell(25).setCellValue(element.getStateType().getInfo());
		}

		// 列总和计算
		// HSSFRow row = sheet.createRow(rowNum);
		// row.createCell( 0).setCellValue("TOTAL:");
		// String formual = "SUM(D2:D" + rowNum + ")"; //
		// D2到D[rowNum]单元格起(count数据)
		// row.createCell( 3).setCellFormula(formual);
	}

}
