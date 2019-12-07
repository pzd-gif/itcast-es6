package com.zs.lianxi.controller;

import java.io.File;
import java.io.IOException;
import java.lang.annotation.Retention;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.github.pagehelper.StringUtil;
import com.mysql.fabric.xmlrpc.base.Array;
import com.zs.lianxi.domain.TDriver;
import com.zs.lianxi.domain.TDriverType;
import com.zs.lianxi.domain.Tcar;
import com.zs.lianxi.service.ITCarService;
import com.zs.lianxi.service.ITDriverService;
import com.zs.lianxi.service.ITDriverTypeService;
import com.zs.lianxi.vo.ResultVo;

import ch.qos.logback.core.subst.Token.Type;

@Controller
public class TDriverController {

	@Autowired
	private ITDriverService driverService;
	
	@Autowired
	private ITDriverTypeService driverTypeService;
	
	@Autowired
	private ITCarService itCarService;
	
	//注册页面展示
	@RequestMapping("/toRag")
	public ModelAndView zc(){
		ModelAndView view = new ModelAndView("register");
		TDriver driver = new TDriver();
		List<TDriverType> list = driverTypeService.list();
		view.addObject("driver", driver);
		view.addObject("list", list);
		return view;
	}
	
	//注册
	@RequestMapping("/reg")
	@ResponseBody
	public ResultVo userReg(TDriver driver){
		ResultVo vo = new ResultVo();
		driver.setCreated(new Date());
		boolean b = driverService.save(driver);
		vo.setStatus(b == true ?1:0);
		vo.setMessage(b == true ? "注册成功" : "注册失败");
		return vo;
	}
	
	//登录页面展示
		@RequestMapping("/toLogin")
		public ModelAndView dl(){
			ModelAndView view = new ModelAndView("login");
			TDriver driver = new TDriver();
			view.addObject("driver", driver);
			return view;
		}
		//登录
		@RequestMapping("/login")
		public ModelAndView userLogin(TDriver driver,HttpSession session){
			ModelAndView view = new ModelAndView("redirect:list");
			List<TDriver> drivers  = driverService.list(new QueryWrapper<TDriver>
			().eq("phone", driver.getPhone()).eq(
					"password", driver.getPassword()));
			/*if (StringUtil.isEmpty(drivers )) {
				System.out.println("登录失败，查无此人");
				view.setViewName("toLogin");
				return view;
			}*/
			session.setAttribute("userInfo", drivers.get(0));
			return view;
		}
		//准驾车型列表
		@RequestMapping("/list")
		public ModelAndView getCarsVyUser(HttpSession session){
			ModelAndView view = new ModelAndView("car-list");
			TDriver driver = (TDriver) session.getAttribute("userInfo");
			TDriverType type = driverTypeService.getIncliudeByCode
			(new QueryWrapper<TDriverType>().
					eq("t-driver-id", driver.getId()));
			String codes = type.getInclude() + "," + type.getCode();
			List<String> asList = Arrays.asList(codes.split(","));
			List<Tcar> cars = itCarService.list(new QueryWrapper<Tcar>().
					in("car-type", asList));
			
			view.addObject("driver", driver);
			view.addObject("cars", cars);
			return view;
		}
		//发布车辆页面
		@RequestMapping("/toPublish")
		public ModelAndView clym(){
			ModelAndView view = new ModelAndView("car");
			Tcar tcar = new Tcar();
			List<TDriverType> list = driverTypeService.list();
			view.addObject("tcar", tcar);
			view.addObject("list", list);
			return view;
		}
		//车辆发布
		@RequestMapping("/Publish")
		@ResponseBody
		public ResultVo publishTcar(MultipartFile file,
				Tcar tcar,HttpSession session){
			ResultVo resultVo = new ResultVo();
			if(!file.isEmpty()){
				String filename = file.getOriginalFilename();
				String substring = filename.substring(filename.lastIndexOf("."));
				String uploadName = UUID.randomUUID().toString() + substring;
				String uploadDir = session.getServletContext().getRealPath("/")+"/upload/";
			File f = new File(uploadDir);
			if(!f.exists()){
				f.mkdir();
			}
			f = new File(uploadDir + uploadName);
			try {
				file.transferTo(f);
			} catch (IllegalStateException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			tcar.setPicUrl("/upload/" + uploadName);
			}
			else{
				tcar.setPicUrl("");
			}
			tcar.setCreated(new Date());
			boolean b = itCarService.save(tcar);
			resultVo.setStatus(b == true ? 1 :0 );
			resultVo.setMessage(b == true ? "发布成功" : "发布失败");
			return resultVo;
		}
}
