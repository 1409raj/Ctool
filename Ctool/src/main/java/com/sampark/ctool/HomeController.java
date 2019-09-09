package com.sampark.ctool;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sampark.ctool.object.MenuItem;
import com.sampark.ctool.util.CommonUtils;



 /* Handles requests for the application home page.
 */
@Controller
@EnableScheduling
public class HomeController {

	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
    private static ResourceBundle messages = ResourceBundle.getBundle("messages");
   
    
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.debug("[home] Welcome home! The client locale is {}.", locale);
		try {
		
//			auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "home", READ));
		} catch (Exception e) {
			return loginPage();
		}
//		Role role = CommonUtils.getCurrentUserRole();
//		if (role.getRoleId() < 0 || role.getOperatorId() < 0) {
//			return "redirect:/logoutnonschool";
//		}
		Date date = CommonUtils.getCurrentTime();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		String formattedDate = dateFormat.format(date);
		model.addAttribute("serverTime", formattedDate);
		model.addAttribute("userName", CommonUtils.getCurrentUserName());
		model.addAttribute("userRoleName", CommonUtils.getCurrentUserRole());
//		model.addAttribute("appVersion", DatabaseUtils.getApplicationVersion());
		logger.debug("model attributes >> " + model);
		
		return "home";
	}
	
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginPage() {
		
//		// Check if user is already logged in, redirect to home page
//		try {
//			String loggedUser = CommonUtils.getCurrentUserName();
//			if (loggedUser != null) {
////				if (CommonUtils.isCurrentUserschoolUser()) {
//					logger.debug("[login] Logged user [" + loggedUser + "] is trying to login again, redirecting to home page...");
//					return "redirect:/";
////				} else {
////					logger.debug("[login] Logged user [" + loggedUser + "] is not an school user, redirecting to login page...");
////				}
//			}
//		} catch (Exception e) {
//			logger.debug("[login] New user request, redirecting to login page...");
//		}
		return "Ctool/pages/login/login";
	}

	@RequestMapping(value = "/accessDenied", method = RequestMethod.GET)
	public String accessDeniedPage(ModelMap model) {
		logger.debug("[Access_Denied] page shown to user > [" + CommonUtils.getCurrentUserName() + "]");
//		auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "accessDenied", ALERT));
		model.addAttribute("user", CommonUtils.getCurrentUserName());
		return "Ctool/accessDenied";
	}

	@RequestMapping(value="/logouttrack", method = RequestMethod.GET)
	public String logoutPage (HttpServletRequest request, HttpServletResponse response) {
		try {
			logMessage("logoutschool", "Logging out school user... ");
//			auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "logout", READ));
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (auth != null){    
				new SecurityContextLogoutHandler().logout(request, response, auth);
			}
		} catch (Exception e) {
			logger.error("[logoutschool] Exception while logging out school user... " + e);
		}
		return "redirect:/login?logouttrack";
	}

	@RequestMapping(value="/logoutCtool", method = RequestMethod.GET)
	public String logoutNonSchoolPage (HttpServletRequest request, HttpServletResponse response) {
		try {
			
			logMessage("logoutnonschool", "Logging out non-school user... ");
//			auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "logoutnonschool", ALERT));
			Authentication auth = SecurityContextHolder.getContext().getAuthentication();
			if (auth != null){    
				new SecurityContextLogoutHandler().logout(request, response, auth);
			}
		} catch (Exception e) {
			logger.error("[logoutCtool] Exception while logging out non-Ctool user... " + e);
		}
		return "redirect:/login?out";
	}
	
	@RequestMapping(value = "/get-menu-items", method = RequestMethod.GET)
	@ResponseBody
	public MenuItem[] getMenuItems(Locale locale, Model model) {
		logMessage("get-menu-items", "");
//		auditUserAction(new UserAction(CommonUtils.getCurrentUserName(),0. "get-menu-items", READ));
		List<MenuItem> menuItem = new ArrayList<MenuItem>();
		CommonUtils.getCurrentUserRole();
		if (CommonUtils.isCurrentUserAdmin()) {
			//menuItem.add(new MenuItem("home", "#/main", "glyphicon glyphicon-th", messages.getString("menu.dashboard")));
//			menuItem.add(new MenuItem("", "", "fa fa-gears","Configuration",
//					new MenuItem[] {
//					new MenuItem("view Configuration", "#/viewconfiguration","fa fa-eye", "View Configuration"),
//					new MenuItem("Add Configuration", "#/config","fa fa-user-plus", "Add Configuration")}));
			
			/*
			 * menuItem.add(new MenuItem("view Employee", "#/viewemployee",
			 * "glyphicon glyphicon-th", "View Employee")); menuItem.add(new
			 * MenuItem("Add Employee", "#/employee_bulk",
			 * "fa fa-user-plus","Add Employee")); menuItem.add(new
			 * MenuItem("Promotion List", "#/employee_list",
			 * "fa fa-users","Promotion List")); menuItem.add(new MenuItem("PDF List",
			 * "#/viewGeneratedPDf", "fa fa-file-pdf-o","PDF List"));
			 */	
			
		//	menuItem.add(new MenuItem("home", "#/main", "fa fa-home text-green","Home"));
			  menuItem.add(new MenuItem("", "", "fa fa-users text-green", "Employee", new
			  MenuItem[] { new MenuItem("view Employee",
			  "#/viewemployee","notika-icon notika-support", "View Employee"),new MenuItem("All Details",
					  "#/details","notika-icon notika-support", "All Details"), new
			  MenuItem("Add Employee", "#/employee_bulk","fa fa-user-plus",
			  "Add Employee"), new MenuItem("Employee Promotion List",
			  "#/employee_list","fa fa-users", "Promotion List"), new MenuItem("PDF List",
			  "#/viewGeneratedPDf","fa fa-file-pdf-o text-red", "PDF List")}));
			 
			
			  menuItem.add(new MenuItem("", "", "fa fa-gears text-green","Designation", new
			  MenuItem[] { new MenuItem("view Designation", "#/viewSlab","fa fa-eye",
					"View Designation")/*
								 * , new MenuItem("Add Configuration", "#/addSlab","fa fa-user-plus",
								 * "Add Slab")
								 */}));
			 
			
		
			
			menuItem.add(new MenuItem("", "", "fa fa-gears text-green","Variable RoofTop(40%)",
					new MenuItem[] {
					new MenuItem("Add Variable", "#/addVariablerooftop","fa fa-user-plus", "Add & View Variable")}));
			
			menuItem.add(new MenuItem("", "", "fa fa-gears text-green","Emp Variable RoofTop (60%)",
					new MenuItem[] {
					new MenuItem("Add Variable", "#/addEmpVariableroofTop","fa fa-user-plus", "Add & View Variable")}));
			
			
			
			menuItem.add(new MenuItem("", "", "fa fa-gears text-green","Variable Non RoofTop (33%)",
					new MenuItem[] {
					new MenuItem("Add Variable", "#/addVariablenonrooftop33","fa fa-user-plus", "Add & View Variable")}));
			
			menuItem.add(new MenuItem("", "", "fa fa-gears text-green","Emp Variable Non RoofTop (67%)",
					new MenuItem[] {
					new MenuItem("Add Variable", "#/addVariablenonrooftop","fa fa-user-plus", "Add & View Variable")}));
			
			menuItem.add(new MenuItem("", "", "fa fa-gears text-green","% increment w.r.t  PMS rating",
					new MenuItem[] {
							/*
							 * new MenuItem("View Variable", "#/viewincVariable","fa fa-eye ",
							 * "View Increment W.R.T Variable"),
							 */
					new MenuItem("Add Variable", "#/addincVariable","fa fa-user-plus", "Add & View Increment W.R.T Variable")}));
		} 
		MenuItem list[] = new MenuItem[menuItem.size()];
		list = menuItem.toArray(list);
		logMessage("get-menu-items", "output size > " + list.length);
		return list;
	}
	
	@RequestMapping(value = "/index", method = RequestMethod.GET)
	public String index() {

		return "Ctool/pages/index/index";
	}
	
	@RequestMapping(value = "/main", method = RequestMethod.GET)
	public String dashboard() {
		logMessage("main", "");
//		auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "dashboard", READ));
		return "Ctool/pages/dashboard/main";
	}
	
	@RequestMapping(value = "/user", method = RequestMethod.GET)
	public String user() {

		return "Ctool/pages/module/user";
	}
	
	@RequestMapping(value = "/client", method = RequestMethod.GET)
	public String showModal(Locale locale, Model model) {
		return "Ctool/pages/module/client";
	}
	
	
	@RequestMapping(value = "/employee_bulk", method = RequestMethod.GET)
	public String clientBulk(Locale locale, Model model) {
		return "Ctool/pages/module/employee_bulk";
	}
	
	@RequestMapping(value = "/config", method = RequestMethod.GET)
	public String configBulk(Locale locale, Model model) {
		return "Ctool/pages/module/config_bulk";
	}
	@RequestMapping(value = "/viewVariablenonrooftop", method = RequestMethod.GET)
	public String slabVariable(Locale locale, Model model) {
		return "Ctool/pages/module/viewRatingVariableNonRooftop";
	}
	
	@RequestMapping(value = "/addVariablenonrooftop", method = RequestMethod.GET)
	public String addVariable(Locale locale, Model model) {
		return "Ctool/pages/module/AddRatingVariableNonRooftop";
	}
	
	@RequestMapping(value = "/addEmpVariableroofTop", method = RequestMethod.GET)
	public String addEmpVariableroofTop(Locale locale, Model model) {
		return "Ctool/pages/module/AddEmpVariableroofTop";
	}
	
	
	
	@RequestMapping(value = "/addVariablerooftop", method = RequestMethod.GET)
	public String addrooftopVariable(Locale locale, Model model) {
		return "Ctool/pages/module/AddRatingVariableRooftop40";
	}
	
	
	@RequestMapping(value = "/viewVariablenonrooftop33", method = RequestMethod.GET)
	public String slabVariable33(Locale locale, Model model) {
		return "Ctool/pages/module/viewRatingVariableNonRooftop33";
	}
	
	@RequestMapping(value = "/addVariablenonrooftop33", method = RequestMethod.GET)
	public String addVariable33(Locale locale, Model model) {
		return "Ctool/pages/module/AddRatingVariableNonRooftop33";
	}
	
	
	@RequestMapping(value = "/editVariable", method = RequestMethod.GET)
	public String editVariable(Locale locale, Model model) {
		return "Ctool/pages/module/AddRatingVariable";
	}
	
	

	@RequestMapping(value = "/editincVariable", method = RequestMethod.GET)
	public String editincVariable(Locale locale, Model model) {
		return "Ctool/pages/module/editincVariable";
	}
	
	
	
	@RequestMapping(value = "/view_client", method = RequestMethod.GET)
	public String viewClient(Locale locale, Model model) {
		return "Ctool/pages/module/view_client";
	}
	
	
	
	@RequestMapping(value = "/meeting", method = RequestMethod.GET)
	public String meeting() {

		return "Ctool/pages/module/meeting";
	}
	
	@RequestMapping(value = "/view_meeting", method = RequestMethod.GET)
	public String viewMeeting() {

		return "Ctool/pages/module/view_meeting";
	}
	
	@RequestMapping(value = "/addincVariable", method = RequestMethod.GET)
	public String addincVariable() {

		return "Ctool/pages/module/addincVariable";
	}
	
	@RequestMapping(value = "/viewincVariable", method = RequestMethod.GET)
	public String viewincVariable() {

		return "Ctool/pages/module/viewincVariable";
	}
	
	
	@RequestMapping(value = "/employee", method = RequestMethod.GET)
	public String employee(Locale locale, Model model) {
		logMessage("employee", "");
		
		return "Ctool/pages/module/Employee";
}
	
	@RequestMapping(value = "/details", method = RequestMethod.GET)
	public String details(Locale locale, Model model) {
		logMessage("employee", "");
		
		return "Ctool/pages/module/Alldetails";
}
	
	
	@RequestMapping(value = "/employeeFinalCalculation", method = RequestMethod.GET)
	public String employeeFinalCalculation(Locale locale, Model model) {
		logMessage("employeeFinalCalculation", "");
		
		return "Ctool/pages/module/employeeFinalCalculation";
}
	
	@RequestMapping(value = "/viewemployee", method = RequestMethod.GET)
	public String bulkSms(Locale locale, Model model) {
		logMessage("viewemployee", "");
		
		return "Ctool/pages/module/viewemployee";
}
	

	
	@RequestMapping(value = "/configuration", method = RequestMethod.GET)
	public String configuration(Locale locale, Model model) {
		logMessage("configuration", "");
		
		return "Ctool/pages/module/Configuration";
}

	@RequestMapping(value = "/viewconfiguration", method = RequestMethod.GET)
	public String viewconfiguration(Locale locale, Model model) {
		logMessage("viewconfiguration", "");
		
		return "Ctool/pages/module/viewconfiguration";
}
	
	@RequestMapping(value = "/add_inventory", method = RequestMethod.GET)
	public String addInventory(Locale locale, Model model) {
		logMessage("add_inventory", "");
		
		return "Ctool/pages/module/AddInventory";
}
	
	@RequestMapping(value = "/view_inventory", method = RequestMethod.GET)
	public String viewinventory(Locale locale, Model model) {
		model.addAttribute("userRoleName", CommonUtils.getCurrentUserRole());
		return "Ctool/pages/module/view_inventory";
	}
	
	
	@RequestMapping(value = "/view_inventory_em", method = RequestMethod.GET)
	public String viewInventoryEmployee(Locale locale, Model model) {
		model.addAttribute("userRoleName", CommonUtils.getCurrentUserRole());
		return "Ctool/pages/module/view_inventory_employee";
	}
	
	
	@RequestMapping(value = "/view_mail", method = RequestMethod.GET)
	public String viewMail(Locale locale, Model model) {
	
		return "Ctool/pages/module/view_mail";
	}
	
	@RequestMapping(value = "/enquiry", method = RequestMethod.GET)
	public String enquiry(Locale locale, Model model) {
		logMessage("enquiry", "");
		
		return "Ctool/pages/module/enquiry";
}
	
	
	
	@RequestMapping(value = "/project", method = RequestMethod.GET)
	public String project(Locale locale, Model model) {
		logMessage("project", "");
		
		return "Ctool/pages/module/AddProject";
}
	
	@RequestMapping(value = "/view_project", method = RequestMethod.GET)
	public String viewProjects(Locale locale, Model model) {
		logMessage("project", "");
		
		return "Ctool/pages/module/view_projects";
}
	
	
	@RequestMapping(value = "/commercial", method = RequestMethod.GET)
	public String addCommercial(Locale locale, Model model) {
		logMessage("commercial", "");
		
		return "Ctool/pages/module/AddCommercialProperty";
}
	
	@RequestMapping(value = "/view_commercial", method = RequestMethod.GET)
	public String viewCommercial(Locale locale, Model model) {
		logMessage("project", "");
		
		return "Ctool/pages/module/view_commercial";
}
	
	
	@RequestMapping(value = "/residential", method = RequestMethod.GET)
	public String addResidential(Locale locale, Model model) {
		logMessage("commercial", "");
		
		return "Ctool/pages/module/AddResidentialProperty";
}
	
	@RequestMapping(value = "/view_residential", method = RequestMethod.GET)
	public String viewResidential(Locale locale, Model model) {
		logMessage("project", "");
		
		return "Ctool/pages/module/view_residential";
}
	
	@RequestMapping(value = "/campaign", method = RequestMethod.GET)
	public String addCampaign(Locale locale, Model model) {
		logMessage("project", "");
		
		return "Ctool/pages/module/AddCampaign";
}

	@RequestMapping(value = "/template", method = RequestMethod.GET)
	public String createTemplate(Locale locale, Model model) {
		logMessage("template", "");
		
		return "Ctool/pages/module/CreateTemplate";
}
	
	@RequestMapping(value = "/employee_list", method = RequestMethod.GET)
	public String employeeList(Locale locale, Model model) {
		return "Ctool/pages/module/employee_promition_list";
	}
	
	
	@RequestMapping(value = "/viewGeneratedPDf", method = RequestMethod.GET)
	public String viewGeneratedPDf(Locale locale, Model model) {
		return "Ctool/pages/module/viewGeneratedPDf";
	}
	
	@RequestMapping(value = "/addSlab", method = RequestMethod.GET)
	public String addSlab(Locale locale, Model model) {
		return "Ctool/pages/module/addSlab";
	}
	
	@RequestMapping(value = "/viewSlab", method = RequestMethod.GET)
	public String viewSlab(Locale locale, Model model) {
		return "Ctool/pages/module/viewslab";
	}
	
	@RequestMapping(value="/access/denied", method = RequestMethod.GET)
	public String accessDenied()
	{
		return "Ctool/pages/module/accessdenied";
	}
	
	
//	@RequestMapping(value = "/get-projects-for-employee", method = RequestMethod.POST)
//	@ResponseBody
//	public Project[] getProjectsForEmployee(@RequestBody RequestObject request) {
//		logMessage("get-projects-for-employee", "");
//		auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "get-projects-for-employee", READ));
//		List<Project> list = DatabaseUtils.getProjectsForEmployeeId(request.getEmployeeId(), request.getDate());
//		Project array[] = new Project[list.size()];
//		array = list.toArray(array);
//		logMessage("get-projects-for-employee", "output size > " + array.length);
//		return array;
//	}
//
//	@RequestMapping(value = "/get-tasks", method = RequestMethod.GET)
//	@ResponseBody
//	public Task[] getTasks(Locale locale, Model model) {
//		logMessage("get-tasks", "");
//		auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "get-tasks", READ));
//		List<Task> list = DatabaseUtils.getTasks();
//		Task array[] = new Task[list.size()];
//		array = list.toArray(array);
//		logMessage("get-tasks", "output size > " + array.length);
//		return array;
//	}
//	
	@RequestMapping(value = "/unit", method = RequestMethod.GET)
	public String unit(Locale locale, Model model) {
		logMessage("unit", "");
		return "school/pages/unit/unit-list";
	}
//	
//	@RequestMapping(value = "/superuser/list-unit", method = RequestMethod.GET)
//	@ResponseBody
//	public ResponseObject listUnit(Locale locale, Model model) {
//		logMessage("list-unit", "");
//		auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "list-unit", READ));
//		return DatabaseUtils.getAllUnits(false);
//	}
//	
//	@RequestMapping(value = "/superuser/list-unit-with-detail", method = RequestMethod.GET)
//	@ResponseBody
//	public ResponseObject listUnitWithDetail(Locale locale, Model model) {
//		logMessage("list-unit-with-detail", "");
//		auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "list-unit-with-detail", READ));
//		return DatabaseUtils.getAllUnits(true);
//	}
//
//	@RequestMapping(value = "/add-unit", method = RequestMethod.GET)
//	public String addUnit(Locale locale, Model model) {
//		logMessage("add-unit", "");
//		auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "add-unit", WRITE));
//		return "apms/pages/unit/add-unit";
//	}
//	
//	@RequestMapping(value = "/modify-unit", method = RequestMethod.GET)
//	public String modifyUnit(Locale locale, Model model) {
//		logMessage("modify-unit", "");
//		auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "modify-unit", WRITE));
//		return "apms/pages/unit/modify-unit";
//	}
//	
//	@RequestMapping(value = "/superuser/save-unit", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseObject saveUnit(@RequestBody Unit unit) {
//		logMessage("save-unit", "input > " + unit);
//		auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "save-unit", WRITE));
//		return DatabaseUtils.saveUnit(unit);
//	}
//	
//	@RequestMapping(value = "/superuser/delete-unit", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseObject deleteUnit(@RequestBody int unitId) {
//		logMessage("delete-unit", "input > " + unitId);
//		auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "delete-unit", DELETE));
//		return DatabaseUtils.deleteUnit(unitId);
//	}
//	
//	@RequestMapping(value = "/contact", method = RequestMethod.GET)
//	public String contact(Locale locale, Model model) {
//		logMessage("contact", "");
//		auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "contact", READ));
//		return "apms/pages/contact/contact-list";
//	}
//	
//	@RequestMapping(value = "/superuser/list-contact-with-detail", method = RequestMethod.GET)
//	@ResponseBody
//	public ResponseObject listContactWithDetail(Locale locale, Model model) {
//		logMessage("list-contact-with-detail", "");
//		auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "list-contact-with-detail", READ));
//		return DatabaseUtils.getAllContacts(true);
//	}
//	
//	@RequestMapping(value = "/superuser/list-contact", method = RequestMethod.GET)
//	@ResponseBody
//	public ResponseObject listContact(Locale locale, Model model) {
//		logMessage("list-contact", "");
//		auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "list-contact", READ));
//		return DatabaseUtils.getAllContacts(false);
//	}
//
//	@RequestMapping(value = "/add-contact", method = RequestMethod.GET)
//	public String addContact(Locale locale, Model model) {
//		logMessage("add-contact", "");
//		auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "add-contact", WRITE));
//		return "apms/pages/contact/add-contact";
//	}
//	
//	@RequestMapping(value = "/modify-contact", method = RequestMethod.GET)
//	public String modifyContact(Locale locale, Model model) {
//		logMessage("modify-contact", "");
//		auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "modify-contact", WRITE));
//		return "apms/pages/contact/modify-contact";
//	}
//	
//	@RequestMapping(value = "/superuser/save-contact", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseObject saveContact(@RequestBody Contact contact) {
//		logMessage("save-contact", "input > " + contact);
//		auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "save-contact", WRITE));
//		return DatabaseUtils.saveContact(contact);
//	}
//	
//	@RequestMapping(value = "/superuser/delete-contact", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseObject deleteContact(@RequestBody int contactId) {
//		logMessage("delete-contact", "input > " + contactId);
//		auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "delete-contact", DELETE));
//		return DatabaseUtils.deleteContact(contactId);
//	}
//	
//	@RequestMapping(value = "/client", method = RequestMethod.GET)
//	public String client(Locale locale, Model model) {
//		logMessage("client", "");
//		auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "client", READ));
//		return "apms/pages/client/client-list";
//	}
//	
//	@RequestMapping(value = "/superuser/list-client-with-detail", method = RequestMethod.GET)
//	@ResponseBody
//	public ResponseObject listClientWithDetail(Locale locale, Model model) {
//		logMessage("list-client-with-detail", "");
//		auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "list-client-with-detail", READ));
//		return DatabaseUtils.getAllClients(true);
//	}
//	
//	@RequestMapping(value = "/superuser/list-client", method = RequestMethod.GET)
//	@ResponseBody
//	public ResponseObject listClient(Locale locale, Model model) {
//		logMessage("list-client", "");
//		auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "list-client", READ));
//		return DatabaseUtils.getAllClients(false);
//	}
//
//	@RequestMapping(value = "/add-client", method = RequestMethod.GET)
//	public String addClient(Locale locale, Model model) {
//		logMessage("add-client", "");
//		auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "add-client", WRITE));
//		return "apms/pages/client/add-client";
//	}
//	
//	@RequestMapping(value = "/modify-client", method = RequestMethod.GET)
//	public String modifyClient(Locale locale, Model model) {
//		logMessage("modify-client", "");
//		auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "modify-client", WRITE));
//		return "apms/pages/client/modify-client";
//	}
//	
//	@RequestMapping(value = "/superuser/save-client", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseObject saveClient(@RequestBody Client client) {
//		logMessage("save-client", "input > " + client);
//		auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "save-client", WRITE));
//		return DatabaseUtils.saveClient(client);
//	}
//	
//	@RequestMapping(value = "/superuser/delete-client", method = RequestMethod.POST)
//	@ResponseBody
//	public ResponseObject deleteClient(@RequestBody int clientId) {
//		logMessage("delete-client", "input > " + clientId);
//		auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "delete-client", DELETE));
//		return DatabaseUtils.deleteClient(clientId);
//	}
//	
//	@RequestMapping(value = "/project", method = RequestMethod.GET)
//	public String project(Locale locale, Model model) {
//		logMessage("project", "");
//		auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "project", READ));
//		return "apms/pages/project/project-list";
//	}
//	
//	
//
//	@RequestMapping(value = "/timesheet", method = RequestMethod.GET)
//	public String timesheet(Locale locale, Model model) {
//		logMessage("timesheet", "");
//		auditUserAction(new UserAction(CommonUtils.getCurrentUserName(), "timesheet", READ));
//		return "apms/pages/timesheet/timesheet";
//	}
//	
//	private void auditUserAction(UserAction userAction) {
//		DatabaseUtils.auditUserAction(userAction);
//	}
//	
	private void logMessage(String action, String data) {
		try {
			logger.debug("[" + action + "] by [" + CommonUtils.getCurrentUserName() + "] " + data);
		} catch (Exception e) {
			logger.debug("Exception while logging action [" + action + "] message [" + data);
		}
	}
		
}