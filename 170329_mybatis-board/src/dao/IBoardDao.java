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
	
	// �Խñ� ���
	public int insertBoard(HashMap<String, Object> params);
	
	// �Խñ� ����
	public int updateBoard(HashMap<String, Object> params);
	
	// �Խñ� ����
	public int deleteBoard(int num);
	
	// �Խñ� ���� ��ȸ
	public HashMap<String, Object> selecctBoardInfo(int num);
	
	// �Խñ� ����Ʈ ��ȸ
	public List<HashMap<String, Object>> selectBoardList(HashMap<String, Object> params);
	
	// �Խñ� �� ���� ��ȸ
	public int getBoardTotal();
	
}