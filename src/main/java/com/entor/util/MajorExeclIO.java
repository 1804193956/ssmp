package com.entor.util;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.entor.entity.Major;

import jxl.Cell;
import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class MajorExeclIO {
	public static void excelExport(List<Major> list, String path) {
		WritableWorkbook book = null;
		try {
			// 创建一个Excel文件对象
			book = Workbook.createWorkbook(new File(path));
			// 创建Excel第一个选项卡对象
			WritableSheet sheet = book.createSheet("major", 0);
			// 设置表头，第一行内容
			// Label参数说明：第一个是列，第二个是行，第三个是要写入的数据值，索引值都是从0开始
			Label label1 = new Label(0, 0, "专业名称");// 对应为第1列第1行的数据
			Label label2 = new Label(1, 0, "专业负责人");// 对应为第2列第1行的数据
			Label label3 = new Label(2, 0, "专业描述");// 对应为第3列第1行的数据
			Label label4 = new Label(3, 0, "专业创建日期");// 对应为第4列第1行的数据
			// 添加单元格到选项卡中
			sheet.addCell(label1);
			sheet.addCell(label2);
			sheet.addCell(label3);
			sheet.addCell(label4);
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
			// 遍历集合并添加数据到行，每行对应一个对象
			for (int i = 0; i < list.size(); i++) {
				Major major = list.get(i);
				// 表头占据第一行，所以下面行数是索引值+1
				// 跟上面添加表头一样添加单元格数据，这里为了方便直接使用链式编程
				sheet.addCell(new Label(0, i + 1, major.getName()));
				sheet.addCell(new Label(1, i + 1, major.getManager()));
				sheet.addCell(new Label(2, i + 1, major.getRemark()));
				sheet.addCell(new Label(3, i + 1, sdf.format(major.getBeginDate())));
			}
			// 写入数据到目标文件
			book.write();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭
				book.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	public static List<Major> excelImport(String path) {
		List<Major> list = new ArrayList<>();
		Workbook book = null;
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
		try {
			// 获取Excel对象
			book = book.getWorkbook(new File(path));
			// 获取Excel第一个选项卡对象
			Sheet sheet = book.getSheet(0);
			// 遍历选项卡，第一行是表头，所以索引数-1
			for (int i = 0; i < sheet.getRows() - 1; i++) {
				Major major = new Major();
				// 获取第一列第二行单元格对象
				Cell cell = sheet.getCell(0, i + 1);
				major.setName(cell.getContents());
				// 获取第二行其他数据
				major.setManager(sheet.getCell(1, i + 1).getContents());
				major.setRemark(sheet.getCell(2, i + 1).getContents());
				major.setBeginDate(sdf.parse(sheet.getCell(3, i + 1).getContents()));
				System.out.println(sheet.getCell(3, i + 1).getContents());
				list.add(major);
			}
			// 返回导入的数据集合
			return list;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			try {
				// 关闭
				book.close();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
		return null;
	}
}
