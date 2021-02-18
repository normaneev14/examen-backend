/**
 * 
 */
package com.examen.backend.utils;

/**
 * 
 * @author Norman
 *
 */
public class RestConstants {

	/**
	 * Private constructor
	 */
	private RestConstants() {
		// Private Constructor
	}

	/**
	 * PAHT api
	 */
	public static final String PATH_API = "api";

	// ---------------Employee--------------------

	/**
	 * Path para peticiones Employee
	 */
	public static final String PATH_EMPLOYEE = "employee";
	/**
	 * Path para peticiones Employee-ALL
	 */
	public static final String PATH_EMPLOYEE_ALL = "employee-all";

	/**
	 * Path para peticiones Employee por id
	 */
	public static final String PATH_EMPLOYEE_ID = "employee/{id}";

	// ---------------Jobs--------------------

	/**
	 * Path para peticiones Jobs
	 */
	public static final String PATH_JOBS = "jobs";
	/**
	 * Path para peticiones jobs-ALL
	 */
	public static final String PATH_JOBS_ALL = "jobs-all";

	/**
	 * Path para peticiones jobs por id
	 */
	public static final String PATH_JOBS_ID = "jobs/{id}";

	// ---------------Employee-worked-hours--------------------

	/**
	 * Path para peticiones employee hours
	 */
	public static final String PATH_EMPLOYEE_HOURS = "employee-hours";
	/**
	 * Path para peticiones employee hours-ALL
	 */
	public static final String PATH_EMPLOYEE_HOURS_ALL = "employee-hours-all";

	/**
	 * Path para peticiones employee hours por id
	 */
	public static final String PATH_EMPLOYEE_HOURS_ID = "employee-hours/{id}";

	// ---------------Genders--------------------

	/**
	 * Path para peticiones genders
	 */
	public static final String PATH_GENDERS = "genders";
	/**
	 * Path para peticiones genders-ALL
	 */
	public static final String PATH_GENDERS_ALL = "genders-all";

	/**
	 * Path para peticiones genders por id
	 */
	public static final String PATH_GENDERS_ID = "genders/{id}";

}
