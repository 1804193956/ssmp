package com.entor.util;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.alibaba.excel.metadata.BaseRowModel;
import com.alibaba.excel.support.ExcelTypeEnum;

public class ExeclIO {
	
	/**
	 * 	根据模型类 创建Excel文件方法
	 * @param request	获取文件
	 * @param cla		模板对象Class
	 * @param data		模板对象集合数据源
	 * @param fileName	用于指定文件名（null按时间生成文件名）
	 * @return			返回Excel文件对象
	 * @throws IOException
	 */
	public static File createExcel(HttpServletRequest request,Class<? extends BaseRowModel> cla,List<? extends BaseRowModel> data,String fileName) throws IOException {
		if(fileName == null) {
			// 文件格式化
			SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMddHHmmssS");
			int r = (int) (Math.random() * 1000);
			fileName = sdf.format(new Date()) + r + ".xls";
		}
		// 获取服务器文件存放路径
		String path = request.getServletContext().getRealPath("/upload/");
		// 下载文件对象
		File file = new File(path, fileName);
		OutputStream out  = new FileOutputStream(file);
		EasyExcelUtil.writeExcelWithModel(out, data, cla,ExcelTypeEnum.XLS);
		return file;
	}

	/**
	 * 
	 * @param request	用于获取文件存放路径
	 * @param cla		模型类CLass
	 * @param data		数据源
	 * @return
	 * @throws IOException
	 */
	public static ResponseEntity<byte[]> downloadExcel(HttpServletRequest request,Class<? extends BaseRowModel> cla, List<? extends BaseRowModel> data,String fileName) throws IOException {
		File file = ExeclIO.createExcel(request, cla, data,fileName);
		// 把文件放到字节数组中(缺点是不能下载大的文件,因为字节存放在内存中)
		byte[] b = FileUtils.readFileToByteArray(file);
		// 设置头部信息
		HttpHeaders headers = new HttpHeaders();
		// 设置下载框和解决中文乱码问题
		headers.setContentDispositionFormData("attachment", URLEncoder.encode(file.getName(), "utf-8"));
		// 设置文件类型
		headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
		return new ResponseEntity<byte[]>(b, headers, HttpStatus.CREATED);
	}
	
	/**
	 * 
	 * @param <E>
	 * @param partFile	上传文件对象
	 * @param cla		模型类Class
	 * @param request	用于动态获取文件存放路径
	 * @return			返回模型类List集合
	 * @throws IOException
	 */
	public static <E> List<E> readExcel(MultipartFile partFile,Class<? extends BaseRowModel> cla, HttpServletRequest request) throws IOException{
		String path = request.getServletContext().getRealPath("/upload/");
		String fileName = partFile.getOriginalFilename();
		File file = new File(path, fileName);
		System.out.println(file.getPath());
		partFile.transferTo(file);
		InputStream is = new FileInputStream(file);
		return EasyExcelUtil.readExcelWithModel(is, cla, ExcelTypeEnum.XLS);
	}
}
