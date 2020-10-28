package r;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class RTest3 {

	public static void main(String[] args) throws REXPMismatchException {
		RConnection rconn = null;
		int arg = 20;
		try {
//			기본은 6311포트
			rconn = new RConnection("127.0.0.1");
			rconn.setStringEncoding("utf8");
			rconn.eval("source('C:/R/day04/stchart.r',encoding='UTF-8')");
			REXP rexp = rconn.eval("draw_graph()");

		} catch (RserveException e) {
			e.printStackTrace();
		}
		System.out.println("Graph Created!");
		
		rconn.close();
	}

}
