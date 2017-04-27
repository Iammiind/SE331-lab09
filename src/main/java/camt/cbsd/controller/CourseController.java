package camt.cbsd.controller;

import camt.cbsd.entity.Course;
import camt.cbsd.services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import javax.ws.rs.ext.Provider;
import java.util.List;

/**
 * Created by Dto on 16-Apr-17.
 */
@Controller
@Path("/course")
public class CourseController {

    CourseService courseService;

    @Autowired
    public void setCourseService(CourseService courseService) {
        this.courseService = courseService;
    }

   @GET
   @Produces(MediaType.APPLICATION_JSON)
    public Response list() {
        return Response.ok(courseService.list()).build();
    }


    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response add(Course course) {
        courseService.add(course);
        return Response.ok(course).build();

    }
}
