package com.student.management.system.web;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.student.management.system.service.CourseService;
import com.student.management.system.service.entity.Course;

@Controller
@RequestMapping("courses")
public class CourseController {

	@Autowired
	private CourseService courseService;
	
	@RequestMapping(value = "/page")
	public String coursePage(Model model) {
		return prepareCourseListForReview(model);
	}
	
	@RequestMapping(value = "/list", method = RequestMethod.POST, consumes = {"application/json"}, produces = {"application/json; charset=utf-8"})
	public @ResponseBody List<Course> courseList(@RequestBody Map<String,String> searchCriteria) {
		return getCourseByCriteria(searchCriteria);
	}
	
	@RequestMapping(value = "/list/csv", method = RequestMethod.POST, produces = {"text/csv; charset=utf-8"})
	public void courseListCsv(HttpServletResponse response, @RequestBody Map<String,String> searchCriteria) throws IOException {
        
        response.setContentType("text/csv");
		String csvFileName = "courselist.csv";
		response.setHeader("Content-disposition", "attachment;filename="+csvFileName);
 
		List<Course> courses = getCourseByCriteria(searchCriteria);
		
		ArrayList<String> rows = new ArrayList<String>();
		
		rows.add("id,coursename,startTime,endTime,location"); //"id", "coursename", "startTime", "endTime", "location" 
		rows.add("\n");
 
		for (Course course : courses) {
			rows.add(course.getId()+",");
			rows.add(course.getCoursename()+",");
			rows.add(course.getStartTimeFormatted()+",");
			rows.add(course.getEndTimeFormatted()+",");
			rows.add(course.getLocation());
			rows.add("\n");
		}
		
		Iterator<String> iter = rows.iterator();
		while (iter.hasNext()) {
			String outputString = (String) iter.next();
			response.getOutputStream().print(outputString);
		}
 
		response.getOutputStream().flush();
		
	}
	
	private List<Course> getCourseByCriteria(Map<String,String> searchCriteria) {
		DateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		
		List<Course> tmpList = new ArrayList<Course>();
		if (!searchCriteria.get("dateFrom").isEmpty() && !searchCriteria.get("dateTo").isEmpty() && searchCriteria.get("order").isEmpty()) {
			try {
				Date startTime = format.parse(searchCriteria.get("dateFrom"));
				Date endTime = format.parse(searchCriteria.get("dateTo"));
				tmpList = courseService.getCoursesByTime(startTime, endTime);
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else if (!searchCriteria.get("dateFrom").isEmpty() && !searchCriteria.get("dateTo").isEmpty() && !searchCriteria.get("order").isEmpty()) {
			try {
				Date startTime = format.parse(searchCriteria.get("dateFrom"));
				Date endTime = format.parse(searchCriteria.get("dateTo"));
				tmpList = courseService.getCoursesByTimeWithOrder(startTime, endTime, searchCriteria.get("order"));
			} catch (ParseException e) {
				e.printStackTrace();
			}
		} else {
			tmpList = courseService.getAllCourses();
		}
		return tmpList;
	}
	
	private String prepareCourseListForReview(Model model) {
		return "course/coursePage";
	}
}
