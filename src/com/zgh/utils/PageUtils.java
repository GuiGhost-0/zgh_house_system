package com.zgh.utils;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javax.servlet.http.HttpServletRequest;

import com.zgh.common.Constants;


/**
* @Title: PageUtils.java
* @Description: 分页工具类
* @author admin
* @version V1.0
*/
public class PageUtils {
	/**
	 * 
	 * @Description: 构造分页参数
	 * @param request
	 * @return
	 */
	public static Map<String, Object> getPageParams(HttpServletRequest request) {
		int pageSize = Constants.PAGE_SIZE_DEFAULT;
		int currPage = 1; //默认是第一页
		String currentPage = request.getParameter("current"); //当前页

		//构造分页参数
		Map<String, Object> param = new ConcurrentHashMap<String, Object>();
		//如果页面没有传递分页参数current，那就直接返回param对象，不做分页处理
		if(SystemStringUtils.isEmpty(currentPage)){
			return param;
		}

		if (!SystemStringUtils.isEmpty(currentPage)) {
			currPage = NumberUtil.getIntegerValue(currentPage, 1);
		}
		
		String currentPageSize = request.getParameter("limit");//当前显示多少条记录数
		if(!SystemStringUtils.isEmpty(currentPageSize)) {
			pageSize = NumberUtil.getIntegerValue(currentPageSize, pageSize);
		}

		//分页参数赋值
		param.put("currPage", currPage);
		param.put("pageSize", pageSize);
		param.put("start", (currPage - 1) * pageSize);
		return param;
	}
}
