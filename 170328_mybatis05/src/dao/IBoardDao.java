package dao;

import java.util.HashMap;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

/**
 * <pre>
 * DB�� �����ϱ� ���� �������̽�
 * </pre>
 * 
 * @version 1.0, 2019/05/01
 *
 */
public interface IBoardDao {
	
	public int insertBoard(HashMap<String, Object> params);                              // (INSERT) �Խñ� ���
	public int updateBoard(HashMap<String, Object> params);                              // (UPDATE) �Խñ� ����
	public int deleteBoard(int num);                                                     // (DELETE) �Խñ� ����
	public HashMap<String, Object> selecctBoardInfo(int num);                            // (SELECT) �Խñ� ���� ��ȸ
	public List<HashMap<String, Object>> selectBoardList();                              // (SELECT) �Խñ� ����Ʈ ��ȸ
	public List<HashMap<String, Object>> selectBySearch(HashMap<String, Object> params); // (SELECT) ���� �Ǵ� ���� �˻�
	public List<HashMap<String, Object>> selectByMultiKeyword(List<String> params);      // (SELECT) ���� ���� Ű����� ���� �˻�
	
}