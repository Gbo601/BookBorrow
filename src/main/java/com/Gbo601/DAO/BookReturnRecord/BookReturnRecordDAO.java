package com.Gbo601.DAO.BookReturnRecord;
/**
 * 
 * @Description
 * @author xieyunlei Email:2451983737@qq.com
 * @verson
 * @date 2021年5月14日上午10:35:33
 *
 */

import com.Gbo601.Model.BookReturnRecord;


import java.sql.Connection;
import java.sql.Date;
import java.util.List;


public interface BookReturnRecordDAO {
	/**
	 * 归还书
	 * @param conn
	 * @param book
	 */
	void insert(Connection conn, BookReturnRecord bookReturnRecord);
	/**
	 * 删除用户借书信息
	 * @param conn
	 * @param id
	 */
	void delete(Connection conn,BookReturnRecord id);
	/**
	 * 修改用户借书信息
	 * @param conn
	 * @param bookReturnRecord
	 */
	void update(Connection conn,BookReturnRecord bookReturnRecord);
	/**
	 * 查找用户借书信息
	 * @param conn
	 * @param id
	 * @return
	 */
	BookReturnRecord getBookReturnRecordUerID(Connection conn,BookReturnRecord id);
	/**
	 * 
	 * @Description 查询表中的所有记录构成集合
	 * @author xieyunlei Email:2451983737@qq.com
	 * @verson 
	 * @date 2021年5月14日上午9:42:48
	 *
	 */
	List<BookReturnRecord> getAll(Connection conn);
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
