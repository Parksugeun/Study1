package InnerClass;

public class MethodInnerClass {
	int age = 25;
	public MethodInnerClass(){
		
	}
	public void start() {
		String tel = "010-7896-8547";
		//����Ŭ���� 
		class InnerTest{
			int num = 100;
			String name="�������";
			InnerTest() {}
			InnerTest(int num, String name){
				this.num = num;
				this.name = name;
			}
			void print() {
				System.out.println(num + "->"+ name);
				System.out.println("����="+ age);
				System.out.println("����ó="+ tel);
				//System.out.println("�ּ�="+addr);//Ŭ������ ���ǵ� ������ ���� ���� �Ұ�
			}
		}
		String addr = "�������� ���ǵ���";
		////////////////////
		InnerTest it = new InnerTest(500,"�̼���");
		it.print();
	}
	public static void main(String[] args) {
		MethodInnerClass mic = new MethodInnerClass();
		mic.start();

	}

}
