package cn.redwings.copyfile;

import java.io.File;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CopyFile {

	public static void getAllFileName(String path) {
		// ArrayList<String> files = new ArrayList<String>();
		//boolean flag = false;
		File file = new File(path);

		File[] tempList = file.listFiles();
		String str3 = "H:\\修模输出1\\Tile_";
		Pattern pattern = null;
		Matcher matcher = null;
		File file1 = null;
		for (int i = 0; i < tempList.length; i++) {

			String s1 = tempList[i].getName();
			System.out.println(s1);
			String str2 = "";
			if (s1 != null && !"".equals(s1)) {
				pattern = Pattern.compile("\\d+");
				matcher = pattern.matcher(s1);
				while (matcher.find()) {
					str2 = matcher.group(0);
					break;
				}			
			}
			//String suffix = s1.substring(s1.lastIndexOf("."));
			
			file1 = new File(str3 + str2);
			if (!file1.exists()) {// 判断文件夹是否创建，没有创建则创建新文件夹
				file1.mkdirs();
			}

			if (tempList[i].renameTo(new File(str3 + str2 + "\\"+s1))) {
				System.out.println("File is moved successful!");
			} else {
				System.out.println("File is failed to move!");
			}

		}
		return;
	}

}
