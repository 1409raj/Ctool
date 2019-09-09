package com.sampark.ctool;

public class CtoolConstanats {

	
public static final String INPUT_OPTION_ALL = "ALL";
	
	public static final String DATE_FORMAT = "dd/MM/yyyy";
	public static final String TIME_FORMAT = "HH24:mi:ss";
	public static final String TIME_FORMAT_JAVA = "HH:mm:ss";
	
	public static final String USER_EMPLOYEE = "EMPLOYEE";
	public static final String USER_HR = "HRUSER";
	public static final String USER_SUPER = "SUPERUSER";
	public static final String USER_TRAINEE = "TRAINEE";
	public static final String USER_ADMIN = "ADMIN";
	public static final String USER_DEALER = "DEALER";
	public static final String USER_SUPERVISOR = "SUPERVISOR";
	public static final String USER_GUEST = "GUEST";
	public static final String USER_CONTACT = "CONTACT";
	public static final String USER_CLIENT = "CLIENT";
	
	public static final Integer STATUS_ACTIVE = 1;
	public static final int STATUS_DEACTIVE = 0;
	public static final int STATUS_DELETED = -1;
	public static final String success="success";
	public static final String fail="fail";
	
	public static final String onetimepwd="Please do not share this password with anyone.your one time password is:-";
	
	
	
	public static final String folder_base="/home/appsrv/ctool/"; 
	
	//public static final String folder_base="F:/home/appsrv/ctool/"; 
	
	
	public static String templateDesign="<table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"600\"><tr><td align=\"center\" bgcolor=\"white\" style=\"padding: 0px 0 0px 0;\"><img src=\"~`~URL~`~\" alt=\"Template Image\" width=\"100%\" height=\"230\" style=\"display: block;\"></td></tr><tr><td style=\"padding: 20px 0 30px 0;\"><table align=\"center\" border=\"0\" cellpadding=\"0\" cellspacing=\"0\" width=\"550\"><tr><td style=\"padding: 10px 0 10px 0;font-size:36px;\">~`~TITLE~`~</td></tr><tr><td style=\"padding: 20px 0 30px 0;font-size:24px;text-decoration:underline;\">~`~TITLEDESCRIPTION~`~</td></tr><tr><tr><td style=\"padding: 10px 0 10px 0;\">~`~signature~`~</td></tr></table></td></tr></table>";

	public static  final String server_url="http://103.240.91.180:8080/Ctool/";
	
	public static final Integer docGenerated=1;
	public static final Integer docNotGenerated=0;
	
	
	
	
	
	
	
	
//	public static final String project_image=folder_base+"Ctool/project/";
//	
//	public static final String residential_image=folder_base+"Ctool/residential/";
//	
//	public static final String commercial_image=folder_base+"Ctool/commercial/";
//	
//	public static final String campaign=folder_base+"Ctool/campaign/";
//	
//	public static final String server_url="http://95.216.153.174:8080/Ctool/";
	//public static final String server_url="http://localhost:8090/Ctool/";

	public static final  String DOC_BASE_PATH ="/home/hero/ctool/documents/";
	public static final  String BASE_URL = "https://pms-hfe.com/PMS";
	public static final  String BLANK_DOC = "/ctool/document?document=null&folder=document";
}
