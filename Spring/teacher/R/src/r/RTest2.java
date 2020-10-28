package r;

import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.RList;
import org.rosuda.REngine.Rserve.RConnection;
import org.rosuda.REngine.Rserve.RserveException;

public class RTest2 {

	public static void main(String[] args) throws REXPMismatchException {
		RConnection rconn = null;
		int arg = 20;
		try {
//			기본은 6311포트
			rconn = new RConnection("127.0.0.1");
			rconn.setStringEncoding("utf8");
			rconn.eval("source('C:/R/day04/f2.R',encoding='UTF-8')");
			REXP rexp = rconn.eval("func1("+arg+")");
			//get data as data frame
			RList rlist = rexp.asList();
			//get data of column
			String s1[] = rlist.at("x").asStrings();
			int i1 [] = rlist.at("y").asIntegers();
			
			for (int i=0;i<s1.length;i++) {
				System.out.println(s1[i]+ " "+i1[i]);
			}
		} catch (RserveException e) {
			e.printStackTrace();
		}
		System.out.println("Connection Complete !");
		
		rconn.close();
	}

}
