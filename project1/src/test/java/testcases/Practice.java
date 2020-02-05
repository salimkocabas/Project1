package testcases;

import java.io.FileNotFoundException;

import com.utils.Constants;
import com.utils.IOfromMOfiles;

public class Practice {

	public static void main(String[] args) {
		IOfromMOfiles.openExcel(Constants.XLPATH, "Config");
		String a=IOfromMOfiles.getCellData(1, 0);
		System.out.println(a);
		
		try {
			IOfromMOfiles.writetoExcel(Constants.XLPATH, "TestResults", 1, 1, "Baner");
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

	}

}
