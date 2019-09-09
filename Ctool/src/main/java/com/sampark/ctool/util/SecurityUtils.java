package com.sampark.ctool.util;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class SecurityUtils {
	
	private static final Logger logger = LoggerFactory.getLogger(SecurityUtils.class);

	public static String getAllUserTypes() {
		List<String> list = new ArrayList<String>();
//		for (RoleDetail role : roles) {
//			if (role.getOperatorId() == 0 && role.getAsmtManage()) {
//				list.add(role.getRoleName());
//			}
//		}
		return getAccessString(list);
	}

	private static String getAccessString(List<String> roles) {
		StringBuffer accessString = new StringBuffer("");
		for (String role : roles) {
			if (!accessString.toString().isEmpty()) {
				accessString.append(" or ");
			}
			accessString.append("hasRole('").append(role).append("')");
		}
		String result = accessString.toString().isEmpty() ? "hasRole('NO_ROLE')" : accessString.toString();
		logger.debug("getAccessString() >> " + result);
		return result;
	}

}
