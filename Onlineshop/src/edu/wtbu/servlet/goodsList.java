package edu.wtbu.servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSON;

import edu.wtbu.dao.GoodsDao;
import edu.wtbu.pojo.Goods;
import edu.wtbu.pojo.Result;

/**
 * Servlet implementation class goodsList
 */
@WebServlet("/goodsList")
public class goodsList extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public goodsList() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.setContentType("text/html;charset=utf8");
		String email = request.getParameter("email");
		Result result = new Result("fail", null);
		if(email==null||email.equals("")) {
			result.setData("��¼��ϢʧЧ�����¼�����ԣ�");
			response.getWriter().append(JSON.toJSONString(result));
			return;
		}
		ArrayList<Goods> list = GoodsDao.getGoodsList();
		result.setData(list);
		result.setFlag("success");
		response.getWriter().append(JSON.toJSONString(result));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
