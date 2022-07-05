package inheritance;
//extend : Ŭ������ ��ӹ��� �� (1���� ��Ӱ���)
public class Sedan extends Car {
	String color = "Red";
	public Sedan() {
		System.out.println("Sedan()������ �޼ҵ�");
	}
	public Sedan(String color) {
		// ����Ŭ������ ������ �޼ҵ忡�� ����Ŭ������ �����ڸ޼ҵ� ȣ��
		// �ݵ�� ù��° ���๮���� ����ؾ� �Ѵ�.
		super("Lightblue", "�ҷ���"); // this ()
		//this.color = color;
		//����Ŭ���� ����Ŭ������ ���� ��������� �����Ҷ�
		//����Ŭ������ ��������� �����Ѵ�.
		super.color = color;
		System.out.println(this.color +","+ super.color);
	}
	//override : �������, ��Ӱ��迡�� ����Ŭ������ �޼ҵ带 ������
	public void speedUp() {
		speed += 10;
		if(speed>=200) speed = 200;
	}
	public void speedUp(int lbl) {
		speed +=lbl;
		if(speed>=200) speed = 200;
	}
	public static void main(String a[] ) {
		// ��Ӱ��迡�� ������ �޼ҵ� ����Ŭ������ �����ڰ� ���� ����ȴ�.
		Sedan s = new Sedan();
		System.out.println("color="+ s.color);
		s.speedUp();
		System.out.println("speed="+s.speed);
		//////////////
		Sedan ss = new Sedan("Blue");
		System.out.println("Sedan.color->"+ ss.color);
	}

}
