package cn.blake.util;

public class DemoT {
    public static void main(String[] args) throws Exception {
    	String password = "123456";
		String pass = "CFDA7C24A51F4FAE9C131C73FC2E797719612D303775FE7CC0AD091D";
		String s1 = MyMD5Util.getEncryptedPwd(password);
		boolean flag = MyMD5Util.validPassword(password, pass);
		System.out.println("1:"+flag);
		flag = MyMD5Util.validPassword(password, s1);
		System.out.println("2:"+flag);
		System.out.println(MyMD5Util.getEncryptedPwd(password));
	}
}
