package com.Gbo601.DAO.BookDAO;

import com.Gbo601.Model.Book;


import java.sql.Connection;
import java.util.List;

/**
 * 
 * @Description
 * @author xieyunlei Email:2451983737@qq.com
 * @verson
 * @date 2021年5月14日上午9:42:48
 *
 */
public interface BookDAO {
	/**
	 * 
	 * @Description 添加书
	 * @author xieyunlei Email:2451983737@qq.com
	 * @verson
	 * @date 2021年5月14日上午9:42:48
	 *
	 */
	void insert(Connection conn, Book book);
	/**
	 * 
	 * @Description 根据书名删除书
	 * @author xieyunlei Email:2451983737@qq.com
	 * @verson
	 * @date 2021年5月14日上午9:42:48
	 *
	 */
	void delete(Connection conn,String book_name);
	/**
	 *  
	 * @Description 根据书编号修改书的信息
	 * @author xieyunlei Email:2451983737@qq.com
	 * @verson 
	 * @date 2021年5月14日上午9:42:48
	 *
	 */
	void update(Connection conn,Book book);
	/**
	* @Description: 修改图书库存
	* @Input: Connection，Book
	* @Return: void
	* @Author: Gbo601
	* @Date Created in 2021-5-15 11:39
	*/
	void updateStock(Connection conn,Book book);
	/**
	* @Description: 获取当前书的库存
	* @Input: Connection,String
	* @Return: int
	* @Author: Gbo601
	* @Date Created in 2021-5-14 12:05
	*/
	int getStock(Connection conn,String  book_id);
	/**
	 * 
	 * @Description 根据书编号查找书
	 * @author xieyunlei Email:2451983737@qq.com
	 * @verson 
	 * @date 2021年5月14日上午9:42:48
	 *
	 */
	Book getBookByName(Connection conn,String book_name);
	/**
	 * 
	 * @Description 查询表中的所有记录构成集合
	 * @author xieyunlei Email:2451983737@qq.com
	 * @verson 
	 * @date 2021年5月14日上午9:42:48
	 *
	 */
	List<Book> getAll(Connection conn);
	/**
	 * 
	 * @Description 返回数据表中的数据条目数
	 * @author xieyunlei Email:2451983737@qq.com
	 * @verson 
	 * @date 2021年5月14日上午9:42:48
	 *
	 */
	Long getCount(Connection conn);
}
