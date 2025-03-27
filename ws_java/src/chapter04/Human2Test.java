package chapter04;

import chapter04_vo.Human2;

public class Human2Test {

	public void cntManWoman(Human2[] humans) {
		int cnt_m = 0;
		int cnt_f = 0;
		
		for(int i = 0; i < 10; i++) {
			if(humans[i].getGender() == 'M') {
				cnt_m += 1;
			}
			else {
				cnt_f += 1;
			}
		}
		System.out.println("남자 : " + cnt_m + "명, 여자 : " +  cnt_f + "명");
	}
	
	public static void main(String[] args) {
		Human2[] humans = new Human2[10];
		
		Human2 h1 = new Human2('M');
		Human2 h2 = new Human2('F');
		Human2 h3 = new Human2('F');
		Human2 h4 = new Human2('M');
		Human2 h5 = new Human2('F');
		Human2 h6 = new Human2('M');
		Human2 h7 = new Human2('M');
		Human2 h8 = new Human2('F');
		Human2 h9 = new Human2('F');
		Human2 h10 = new Human2('F');
		
		
		humans[0] = h1;
		humans[1] = h2;
		humans[2] = h3;
		humans[3] = h4;
		humans[4] = h5;
		humans[5] = h6;
		humans[6] = h7;
		humans[7] = h8;
		humans[8] = h9;
		humans[9] = h10;

		for(int i = 0; i < 10; i++) {
			if(humans[i].getId() == 4) {
				System.out.println("고유 번호가 4번인 사람의 성별은 " + (char)humans[i].getGender() +"입니다.");
			}
		}
		Human2Test st = new Human2Test();
		st.cntManWoman(humans);
	}
}
