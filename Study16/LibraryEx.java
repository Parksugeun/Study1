package mysql_jdbc;
import java.util.List;
import java.util.Scanner;

import BookDAO;
import BookStart;
import BookVO;


public class LibraryEx {
	Scanner scan = new Scanner(System.in);
	BookDAO dao = new BookDAO();
	public LibraryEx() {
		start();
	}
public void start() {
		
		do {
			try {
			String menu = menuShow();
			if(menu.equals("1")) {//ȸ�����
				bookList();
			}else if(menu.equals("2")) {//ȸ�����
				bookAdd();
			}else if(menu.equals("3")) {//ȸ������
				bookEdit();
			}else if(menu.equals("4")) {//ȸ������
				bookDel();
			}else if(menu.equals("5")) {//����
				bookClose();
			}else if(menu.equals("6")) {
				bookSearch();
			}
			}catch(Exception e) {
				System.out.println("�߸��������� �ԷµǾ����ϴ�.");
			}
		}while(true);
	}
	//
	public void bookSearch() {
		System.out.print("�˻���->");
		String searchword = scan.nextLine();
		
		//List<EmpVO> list = dao.empSelect(searchword);
		//���
			System.out.println(searchword);
		bookPrint(dao.bookSelect(searchword));
	}
	//ȸ�����
		public void bookList() {
			//ȸ�� ��� DB���� ������ �� �ִ� �޼ҵ带 ȣ��
			//EmpDAO dao = EmpDAO.getInstance();
			//EmpDAO dao = new EmpDAO();
			String searchWord = null;
			
			//List<EmpVO> list = dao.empSelect(searchWord);
			bookPrint(dao.bookSelect(searchWord));
			
			
		}
	//������
		public void bookPrint(List<BookVO> list) {
			for(int i=0; i<list.size(); i++) {
				BookVO vo = list.get(i);
				System.out.printf("%6d %12s %10s %16s %20s\n", vo.getBookno(), vo.getBookName(), vo.getBookwriter(), vo.getPublisher(), vo.getBookdate());
		}
	}
	//ȸ������ ����
	public void bookDel() {
		System.out.print("������ ȸ����ȣ->");
		String bookno = scan.nextLine();
		//EmpDAO dao = new EmpDAO();
		int result = Integer.parseInt(dao.bookDelete(bookno));
		if(result >0) {
			System.out.println(bookno+"ȸ���� �����Ǿ����ϴ�..");
		}else {
			System.out.println(bookno+"ȸ�� ���� �����Ͽ����ϴ�.");
		}
	}
	public void bookAdd() {
		//ȸ����ȣ, �̸�, �μ���, ����ó, �̸���
		//�Է¹��� �����͸� VO�����ϱ� ���ؼ� ��ü�� ����
		BookVO vo = new BookVO();
		System.out.print("ȸ����ȣ->");
		vo.setBookno(scan.nextLine());
		System.out.print("�̸�->");
		vo.setBookName(scan.nextLine());
		System.out.print("�μ���->");
		vo.setBookwriter(scan.nextLine());
		System.out.print("����ó->");
		vo.setPublisher(scan.nextLine());
		System.out.print("�̸���");
		vo.setBookdate(scan.nextLine());
		
		//EmpDAO dao = new EmpDAO();
		int cnt = dao.bookInsert(vo);
		if(cnt>0) {
			System.out.println(vo.getBookName()+"�� ȸ����ϵǾ����ϴ�.");
		}else {
			System.out.println("ȸ����Ͻ����Ͽ����ϴ�.");
		}
	}
	//ȸ������ ����
	public void bookEdit() {
		BookVO vo = new BookVO();
		System.out.print("������ ȸ����ȣ->");
		vo.setBookno(scan.nextLine());
		
		//������ �׸�
		System.out.print("������ �׸���[1.����ó, 2.�μ���, 3.�̸���]");
		String editField = scan.nextLine();
		if(editField.equals("1")) {
			vo.setFieldName("publisher");
			System.out.print("������ ����ó->");
		}else if(editField.equals("2")) {
			vo.setFieldName("depart");
			System.out.print("������ �μ���->");
		}
		vo.setPublisher(scan.nextLine());
		
		//EmpDAO dao = EmpDAO.getInstance();
		int cnt = dao.bookUpdate(vo);
		if(cnt>0) {
			System.out.println(vo.getPublisher()+"���� �����Ǿ����ϴ�.");
		}else {
			System.out.println("���������Ͽ����ϴ�.");
		}
	}
	
	//����
	public void bookClose() {
		System.exit(0);
	}
	//�޴�
	public String menuShow() {
		System.out.print("�޴�[1.ȸ�����, 2.ȸ�����, 3.ȸ������, 4.ȸ������, 5.����, 6.�˻�]->");
		return scan.nextLine();
	}
	public static void main(String[] args) {
		new BookStart();
}
}