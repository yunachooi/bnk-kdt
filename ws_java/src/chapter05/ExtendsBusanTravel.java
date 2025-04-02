package chapter05;

import chapter05_vo.Bus;
import chapter05_vo.Train;
import chapter05_vo.Transportation;

public class ExtendsBusanTravel {

	public static void main(String[] args) {
		/* BusanTravel bt = new BusanTravel();
		
		//콘솔에 버스를 타고 부산여행을 간 결과로 '부산행 버스에 몸을 싣고...'가 출력되게 하시오.
		bt.goBusan(new Bus());
		//콘솔에 버스를 타고 부산여행을 간 결과로 '부산행 기차에 몸을 싣고...'가 출력되게 하시오.
		bt.goBusan(new Train());*/
		
		Bus bus = new Bus();
		Train train = new Train();
		
		Transportation t = new Transportation();
		t.goBusan(bus);
		t.goBusan(train);
	}

}
