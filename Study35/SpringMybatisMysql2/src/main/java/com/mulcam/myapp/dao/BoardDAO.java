package com.mulcam.myapp.dao;

import java.util.List;

import com.mulcam.myapp.vo.BoardVO;

public interface BoardDAO {
	//�۵��
	public int boardWriteOk(BoardVO vo);
	//�۸��
	public List<BoardVO> boardList();
	//�ۼ���
	public BoardVO boardView(int no);
	//��ȸ�� ����
	public void hitCount(int no);
	//�ۼ���
	public int boardEditOk(BoardVO vo);
	//�ۻ���
	public int boardDel(int no, String userid);
}
